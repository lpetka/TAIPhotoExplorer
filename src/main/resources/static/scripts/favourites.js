$(document).ready(function () {
    getUserFavourites();
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

function appendImages(data) {
    $.each(data, function (index, item) {
        if(item.type != null) {
            var itemToAdd = '<div class="imageContainer"><input type="hidden" id="id" value="' + item.id + '"/><img class="img-thumbnail" src="' + item.link + '" /></div>';
            $('#imagesList').append(itemToAdd);
        }
    })
}