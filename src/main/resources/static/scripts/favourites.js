$(document).ready(function () {
    getUserFavourites();

    $('#removeFromFavouritesButton').click(function () {
        removeImageFromFavourites($('#imageId').text());
    });
});

$(document).on('click','.imageContainer',function(e){
    getImageDataById($(this).find('#id').val());
});

function getUserFavourites() {
    $.ajax({
        type: "GET",
        headers: {
            "access_token" : JSON.parse(sessionStorage.getItem("myParams")).access_token,
            "account_username": JSON.parse(sessionStorage.getItem("myParams")).account_username
        },
        contentType: 'application/json',
        dataType: 'json',
        url: "/user/favourites",
        success: function (result) {
            appendImages(result.data)
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

function removeImageFromFavourites(id) {
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
            removeImage(result.response, id);
        }
    });
}

function removeImage(state, id) {
    if(state == 'unfavorited') {
        $(':input').filter(function () {
            return this.value == id;
        }).parent().remove();
        $('#imageModal').modal('toggle');
    }
}

function appendImages(data) {
    $.each(data, function (index, item) {
        if(item.type != null) {
            var itemToAdd = '<div class="imageContainer"><input type="hidden" id="id" value="' + item.id + '"/><img class="img-thumbnail" src="' + item.link + '" /></div>';
            $('#imagesList').append(itemToAdd);
        }
    })
}

function parseDetail(detail) {
    if(detail == null)
        return 'N/A';
    return detail;
}

function displayImageDetails(imageDetails) {
    var table = $('#imageDetailsTable');
    table.find('#imageId').text(parseDetail(imageDetails.id));
    table.find('#imageViews').text(parseDetail(imageDetails.views));
    table.find('#imageTitle').text(parseDetail(imageDetails.title));
    table.find('#imageNsfw').text(parseDetail(imageDetails.nsfw) ? 'Yes' : 'No');
    table.find('#imageDescription').text(parseDetail(imageDetails.description));
    table.find('#imageType').text(parseDetail(imageDetails.type));
    table.find('#imageWidth').text(parseDetail(imageDetails.width));
    table.find('#imageLink').text(parseDetail(imageDetails.link));
    table.find('#imageHeight').text(parseDetail(imageDetails.height));
    table.find('#imageSize').text(parseDetail(imageDetails.size));

    table.find('#imageDetailsImage').empty();
    var imageToAdd = '<a href="'+imageDetails.link+'"><img class ="img-thumbnail" src="'+imageDetails.link+'"/></a>';
    table.find('#imageDetailsImage').append(imageToAdd);

    $('#imageModal').modal('toggle');
}