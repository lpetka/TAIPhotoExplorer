$(document).ready(function () {
    var params = {}, queryString = location.hash.substring(1),
        regex = /([^&=]+)=([^&]*)/g, m;
    while (m = regex.exec(queryString)) {
        params[decodeURIComponent(m[1])] = decodeURIComponent(m[2]);
    }
    if(!(!!localStorage.getItem("myParams")))
        localStorage.setItem("myParams", JSON.stringify(params))

});