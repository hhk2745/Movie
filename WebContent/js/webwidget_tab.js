(function(a){
    a.fn.webwidget_tab=function(p){
        var p=p||{};
        var s_w_p=p&&p.window_padding?p.window_padding:"5";
        var s_h_t_c=p&&p.head_text_color?p.head_text_color:"blue";
        var s_h_c_t_c=p&&p.head_current_text_color?p.head_current_text_color:"black";
        var dom=a(this);
        s_w_p += "px";
        
        if(dom.find("ul").length==0||dom.find("li").length==0){
            dom.append("Require content");
            return null;
        }
        begin();
        function begin(){
            dom.children(".tabBody").children("ul").children("li").children("p").css("padding",s_w_p);
            dom.children(".tabContainer").children(".tabHead").children("li").children("a").css("color",s_h_t_c);
            dom.children(".tabBody").children("ul").children("li").hide();
            dom.children(".tabBody").children("ul").children("li").eq(0).show();
            dom.children(".tabContainer").children(".tabHead").children("li").children("a").click(function(){
                var current = dom.children(".tabContainer").children(".tabHead").children("li").index($(this).parent());
                dom.children(".tabContainer").children(".tabHead").children("li").children("a").css("color",s_h_t_c);
                dom.children(".tabContainer").children(".tabHead").children("li").removeClass("currentBtn")
                dom.children(".tabContainer").children(".tabHead").children("li").eq(current).children("a").css("color",s_h_c_t_c);
                dom.children(".tabContainer").children(".tabHead").children("li").eq(current).addClass("currentBtn");
                dom.children(".tabBody").children("ul").children("li").hide();
                dom.children(".tabBody").children("ul").children("li").eq(current).show();
            });
        }
    }
})(jQuery);