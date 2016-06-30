$(document).ready(function () {
    parseUrl();
    getImagesFromPage(0, 0, 0);

    $('#imageVoteButton').click(function () {
        $('.imgVote').removeClass('active');
        if($('#voteState').val() == 'up') {
            $('.imgVote:nth-of-type(1)').addClass('active');
        } else {
            $('.imgVote:nth-of-type(2)').addClass('active');
        }
    });
    
    $('#imageVoteButton').popover({
        html: true,
        content: function () {
            return $('#popoverContent').html();
        }
    });

    $('#loadMoreButton').click(function () {
        var pageDetails = $('#pageNumber').val().split('/');
        getImagesFromPage(
            parseInt(pageDetails[0]),
            parseInt(pageDetails[1]),
            parseInt(pageDetails[2])
        );
    });

    $('#toggleFavourite').click(function () {
        toggleFavourites($('#imageId').text());
    });

});

$(document).on('click','.imageContainer',function(e){
    getImageDataById($(this).find('#id').val());
});

$(document).on('click','.imgVote',function(e){
    $(this).parent().find('.imgVote').removeClass('active');
    imageVote($(this).find('.state').val(), $('#voteState').val(), $(this));
});

$('html').on('click', function(e) {
    if (!$(e.target).parents('#imageVoteButton').length > 0 && typeof $(e.target).data('original-title') == 'undefined' && !$(e.target).parents().is('.popover.in')) {
        $('#imageVoteButton').popover('hide');
    }
});

function parseUrl() {
    var params = {}, queryString = location.hash.substring(1),
        regex = /([^&=]+)=([^&]*)/g, m;
    while (m = regex.exec(queryString)) {
        params[decodeURIComponent(m[1])] = decodeURIComponent(m[2]);
    }
    if(!!params["access_token"] && !!params["account_id"] && !!params["expires_in"] && !!params["account_username"]
        && !!params["token_type"] && !!params["refresh_token"]) {
        console.log("tu");
        sessionStorage.setItem("myParams", JSON.stringify(params));
        if (!(!!sessionStorage.getItem("myParams"))) {
            $.ajax({
                type: "POST",
                contentType: 'application/json',
                dataType: 'json',
                url: "/user/credentials",
                data: sessionStorage.getItem("myParams"),
                success: function (result) {
                }
            });
        }
    }
}

function getImagesFromPage(pageNumber, photosQuantity, maxPhotos) {
    if(photosQuantity >= maxPhotos) {
        pageNumber = pageNumber + 1;
        photosQuantity = 0;
    }
    $.ajax({
        type: "POST",
        headers: {
            "access_token" : JSON.parse(sessionStorage.getItem("myParams")).access_token,
            "account_username": JSON.parse(sessionStorage.getItem("myParams")).account_username
        },
        contentType: 'application/json',
        dataType: 'json',
        url: "/public/gallery",
        data: JSON.stringify(pageNumber),
        success: function (result) {
            appendImages(result.data, pageNumber, photosQuantity, result.data.length)
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
        url: "/image/gallerydetails",
        data: id,
        success: function (result) {
            displayImageDetails(result);
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

function imageVote(nextState, currentState, buttonClicked) {
    if(nextState == '')
        nextState = currentState;
    $.ajax({
        type: "POST",
        headers: {
            "access_token" : JSON.parse(sessionStorage.getItem("myParams")).access_token,
            "account_username": JSON.parse(sessionStorage.getItem("myParams")).account_username
        },
        contentType: 'application/json',
        dataType: 'json',
        url: "/image/vote",
        data: JSON.stringify({id : $('#imageId').text(), vote : nextState}),
        success: function (result) {
            setButtons(result.vote, currentState, buttonClicked);
        }
    });
}

function setButtons(nextState, currentState, buttonClicked) {
    $('#voteState').val(nextState);
    buttonClicked.addClass('active');
    setVoteButton(nextState);
}

function appendImages(data, pageNumber, photosQuantity, maxPhotos) {
    if(data.length != 0) {
        photosQuantity = photosQuantity+20;
        $('#pageNumber').val(pageNumber+'/'+photosQuantity+'/'+maxPhotos);
    }
    $.each(data, function (index, item) {
        if(item.type != null && index >= photosQuantity - 20 && index < photosQuantity) {
            var itemToAdd = '<div class="imageContainer"><input type="hidden" id="id" value="' + item.id + '"/><img class="img-thumbnail" src="' + item.link + '" /></div>';
            $(itemToAdd).insertBefore('#buttonPanel');
        }
    })
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

function setVoteButton(state) {
    var toggleVoteButton = $('#imageVoteButton').find('#buttonVoteIcon');
    if(state == 'up') {
        $('#buttonVoteText').text('You like it');
        toggleVoteButton.removeClass();
        toggleVoteButton.addClass('glyphicon glyphicon-thumbs-up');
    } else if(state == 'down') {
        $('#buttonVoteText').text('You don\'t like it');
        toggleVoteButton.removeClass();
        toggleVoteButton.addClass('glyphicon glyphicon-thumbs-down');
    } else {
        $('#buttonVoteText').text('You are neutral');
        toggleVoteButton.removeClass();
        toggleVoteButton.addClass('glyphicon glyphicon-asterisk');
    }
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
    table.find('#imageUploader').text(parseDetail(imageDetails.account_url));
    table.find('#imageDescription').text(parseDetail(imageDetails.description));
    table.find('#imageSection').text(parseDetail(imageDetails.section));
    table.find('#imageWidth').text(parseDetail(imageDetails.width));
    table.find('#imageLink').text(parseDetail(imageDetails.link));
    table.find('#imageHeight').text(parseDetail(imageDetails.height));
    table.find('#imageSize').text(parseDetail(imageDetails.size));

    if(imageDetails.favorite == true) {
        setFavouritesButton('favorited');
    } else {
        setFavouritesButton('unfavorited')
    }

    table.find('#imageDetailsImage').empty();
    var imageToAdd = '<a href="'+imageDetails.link+'"><img class ="img-thumbnail" src="'+imageDetails.link+'"/></a>';
    table.find('#imageDetailsImage').append(imageToAdd);

    setVoteButton(imageDetails.vote);
    $('#voteState').val(imageDetails.vote);

    $('#imageModal').modal('toggle');
}