$(document).ready(function () {
    getImagesFromPage(0);


    $('#loadMoreButton').click(function () {
        getImagesFromPage(parseInt($('#pageNumber').val()) + 1);
    });

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

function appendImages(data, pageNumber) {
    if(data.length != 0)
        $('#pageNumber').val(pageNumber);
    $.each(data, function (index, item) {
        var item = '<div class="imageContainer"><input type="hidden" id="id" value="'+item.id+'"/><img class="userImage img-thumbnail" src="'+item.link+'" /></div>';
        $(item).insertBefore('#loadMoreButton')
    })
}
