$(document).ready(function () {
    parseUrl();
    getImagesFromPage(0, 0, 0);

    $('#loadMoreButton').click(function () {
        var pageDetails = $('#pageNumber').val().split('/');
        getImagesFromPage(
            parseInt(pageDetails[0]),
            parseInt(pageDetails[1]),
            parseInt(pageDetails[2])
        );
    });

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