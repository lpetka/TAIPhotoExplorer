$(document).ready(function () {
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

});