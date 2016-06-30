$(document).ready(function () {
    getImagesFromPage(0);

    $('#loadMoreButton').click(function () {
        getImagesFromPage(parseInt($('#pageNumber').val()) + 1);
    });

    $('#deleteImageButton').click(function () {
        removeUserImage($('#imageId').text());
    });

    $('#addImageButton').click(function () {
        $('#addModal').modal('toggle');
    });

    $('#uploadImage').click(function () {
        uploadImagefromUrl($('#imageUrl').val())
    });

    $('#toggleFavourite').click(function () {
        toggleFavourites($('#imageId').text());
    });
});

$(document).on('click','.imageContainer',function(e){
    getImageDataById($(this).find('#id').val());
});

function getImagesFromPage(pageNumber) {
    $.ajax({
        type: "POST",
        headers: {
            "access_token" : JSON.parse(sessionStorage.getItem("myParams")).access_token,
            "account_username": JSON.parse(sessionStorage.getItem("myParams")).account_username
        },
        contentType: 'application/json',
        dataType: 'json',
        url: "/user/gallery",
        data: JSON.stringify(pageNumber),
        success: function (result) {
            appendImages(result.data, pageNumber)
        }
    });
}

function getImageDataById(id) {
    $.ajax({
        type: "POST",
        headers: {
            "access_token" : JSON.parse(sessionStorage.getItem("myParams")).access_token,
            "account_username": JSON.parse(sessionStorage.getItem("myParams")).account_username
        },
        contentType: 'application/json',
        dataType: 'json',
        url: "/image/details",
        data: id,
        success: function (result) {
            displayImageDetails(result);
        }
    });
}

function removeUserImage(id) {
    $.ajax({
        type: "POST",
        headers: {
            "access_token" : JSON.parse(sessionStorage.getItem("myParams")).access_token,
            "account_username": JSON.parse(sessionStorage.getItem("myParams")).account_username
        },
        contentType: 'application/json',
        dataType: 'json',
        url: "/image/remove",
        data: id,
        success: function (result) {
            removeImage(result)
        }
    });
}

function uploadImagefromUrl(url) {
    $.ajax({
        type: "POST",
        headers: {
            "access_token" : JSON.parse(sessionStorage.getItem("myParams")).access_token,
            "account_username": JSON.parse(sessionStorage.getItem("myParams")).account_username
        },
        contentType: 'application/json',
        dataType: 'json',
        url: "/image/upload",
        data: url,
        success: function (result) {
            uploadImage(result)
        }
    });
}

function toggleFavourites(id) {
    $.ajax({
        type: "POST",
        headers: {
            "access_token" : JSON.parse(sessionStorage.getItem("myParams")).access_token,
            "account_username": JSON.parse(sessionStorage.getItem("myParams")).account_username
        },
        contentType: 'application/json',
        dataType: 'json',
        url: "/image/togglefavourite",
        data: id,
        success: function (result) {
            setFavouritesButton(result.response);
        }
    });
}

function uploadImage(imageData) {
    if(!!imageData) {
        location.reload()
    } else {
        alert("Error occured during upload... Please try again later.")
    }
}

function removeImage(imageId) {
    if(imageId != null) {
        $(':input').filter(function () {
            return this.value == imageId.response;
        }).parent().remove();
        $('#imageModal').modal('toggle');
    } else {
        alert("Error occured during removing image...\nPlease try again later.")
    }
}

function appendImages(data, pageNumber) {
    if(data.length != 0)
        $('#pageNumber').val(pageNumber);
    $.each(data, function (index, item) {
        var itemToAdd = '<div class="imageContainer"><input type="hidden" id="id" value="'+item.id+'"/><img class="img-thumbnail" src="'+item.link+'" /></div>';
        $(itemToAdd).insertBefore('#buttonPanel');
    })
}

function parseDetail(detail) {
    if(detail == null)
        return 'N/A';
    return detail;
}

function setFavouritesButton(state) {
    var toggleFavouriteButton = $('#toggleFavourite').find('#buttonFavouritesIcon');
    if(state == 'favorited') {
        $('#buttonFavouritesText').text('Remove from favourites');
        toggleFavouriteButton.removeClass();
        toggleFavouriteButton.addClass('glyphicon glyphicon-star-empty');
    } else {
        $('#buttonFavouritesText').text('Add to favourites');
        toggleFavouriteButton.removeClass();
        toggleFavouriteButton.addClass('glyphicon glyphicon-star');
    }
}

function displayImageDetails(imageDetails) {
    var table = $('#imageDetailsTable');
    table.find('#imageId').text(parseDetail(imageDetails.id));
    table.find('#imageViews').text(parseDetail(imageDetails.views));
    table.find('#imageTitle').text(parseDetail(imageDetails.title));
    table.find('#imageName').text(parseDetail(imageDetails.name));
    table.find('#imageDescription').text(parseDetail(imageDetails.description));
    table.find('#imageSection').text(parseDetail(imageDetails.section));
    table.find('#imageWidth').text(parseDetail(imageDetails.width));
    table.find('#imageLink').text(parseDetail(imageDetails.link));
    table.find('#imageHeight').text(parseDetail(imageDetails.height));
    table.find('#imageSize').text(parseDetail(imageDetails.size));
    table.find('#imageType').text(parseDetail(imageDetails.type));

    if(imageDetails.favorite == true) {
        setFavouritesButton('favorited');
    } else {
        setFavouritesButton('unfavorited')
    }

    table.find('#imageDetailsImage').empty();
    var imageToAdd = '<a href="'+imageDetails.link+'"><img class ="img-thumbnail" src="'+imageDetails.link+'"/></a>';
    table.find('#imageDetailsImage').append(imageToAdd);

    $('#imageModal').modal('toggle');
}
