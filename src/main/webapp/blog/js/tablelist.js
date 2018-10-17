function setDiv(item){
    var div="<div class=\"blogs\" data-scroll-reveal=\"enter bottom over 1s\" >\n"
        + "<h3 class=\"blogtitle\"><a href=\""
        +item.url
        +"\" target=\"_blank\">"
        +item.title
        +"</a></h3>\n"
        + "<span class=\"blogpic\"><a href=\""
        +item.uri
        +"\" title=\""
        +"><img src="
        +item.imageuri
        +"\"</a></span>\n"
        + "<p class=\"blogtext\">"
        +item.content
        +"</p>\n" +
        "<div class=\"bloginfo\">\n" +
        "<ul>\n" +
        "<li class=\"author\"><a href=\""
        +item.url
        +"\">Lsy</a></li>\n" +
        "<li class=\"lmname\"><a href=\""
        +item.url
        +"\">学无止境</a></li>\n" +
        "<li class=\"timer\">"
        +item.releasedate
        +"</li>\n" +
        "<li class=\"view\"><span>"
        +item.clickhit
        +"</span>已阅读</li>\n" +
        "<li class=\"like\">"
        +item.replyhit
        +"/li>\n" +
        "</ul>\n" +
        "</div>\n" +
        "</div>"
    ;
    return div
}


