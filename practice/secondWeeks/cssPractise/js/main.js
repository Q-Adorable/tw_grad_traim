autodivheight();
function autodivheight(){ //函数：获取尺寸
    //获取浏览器窗口高度
    var winHeight=0;
    var winWidth=0;
    if (window.innerHeight) {
        winHeight = window.innerHeight;
    }
    else if ((document.body) && (document.body.clientHeight)) {
        winHeight = document.body.clientHeight;
    }
    //通过深入Document内部对body进行检测，获取浏览器窗口高度
    if (document.documentElement && document.documentElement.clientHeight) {
        winHeight = document.documentElement.clientHeight;
    }
    //DIV高度为浏览器窗口的高度
    document.getElementById("left").style.height=winHeight+"px";
    document.getElementById("right").style.height=winHeight+"px";

    if(window.innerWidth){
        winWidth=window.innerWidth;
    }
    else if((document.body)&&(document.body.clientWidth)) {
        winWidth = document.body.clientWidth;
    }
    if(document.documentElement && document.documentElement.clientWidth) {
        winWidth = document.documentElement.clientWidth;
    }
    document.getElementById("left").style.width=(winWidth-200)+"px";
    console.log("0000000");
}
window.onresize=autodivheight; //浏览器窗口发生变化时同时变化DIV高度