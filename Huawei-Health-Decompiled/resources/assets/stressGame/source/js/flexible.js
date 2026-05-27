(function () {
    var dpr, rem, scale, temp, clientWidth;
    var docEl = document.documentElement;
    var fontEl = document.createElement('style');
    var metaEl = document.querySelector('meta[name="viewport"]');
    dpr = window.devicePixelRatio || 1;//window.devicesPixelRadio = 物理像素 / dips(device-independent pixels)设备独立像素 ppi(Pixel Per Inch)
    //dpr兼容处理
    var arr = [2, 2.5, 2.75, 3, 3.5, 4];
    for (var i = 0; i < arr.length; i++) {
        if (dpr == arr[i]) {
            temp = arr[i];
            break;
        }
    }
    dpr = temp || 1;
    scale = 1 / dpr;
    clientWidth = docEl.clientWidth;
    if (dpr > 1) {
        /width=([^,]+).*/.exec(metaEl.content);
        var width = RegExp["\x241"];
        if (width == "device-width") {
            dpr = 1;
            metaEl.setAttribute('content', 'width=' + clientWidth + ',initial-scale=' + 1 + ',maximum-scale=' + 1 + ',minimum-scale=' + 1 + ',user-scalable=no');
        } else {
            if (parseInt(width) != $("html")[0].offsetWidth) {
                dpr = 1;
                metaEl.setAttribute('content', 'width=' + clientWidth + ',initial-scale=' + 1 + ',maximum-scale=' + 1 + ',minimum-scale=' + 1 + ',user-scalable=no');
            }
        }
        if (clientWidth != screen.width) {
            dpr = 1;
            metaEl.setAttribute('content', 'width=' + clientWidth + ',initial-scale=' + 1 + ',maximum-scale=' + 1 + ',minimum-scale=' + 1 + ',user-scalable=no');
        }
    }
    // 设置1rem所对应的大小
    rem =docEl.clientWidth * dpr / 10;
    docEl.setAttribute('data-dpr', dpr);
    // 动态写入样式
    docEl.firstElementChild.appendChild(fontEl);
    var recalc = function () {
      printInfo('resize happen')
      rem =docEl.clientWidth * dpr / 10;
          fontEl.innerHTML = 'html{font-size:' + rem + 'px!important;}';
    }
    window.addEventListener('orientationchange' in window ? 'orientationchange' : 'resize', recalc, false)
    document.addEventListener('DOMContentLoaded', recalc, false)
    fontEl.innerHTML = 'html{font-size:' + rem + 'px!important;}';
    // 给js调用的，某一dpr下rem和px之间的转换函数
    window.rem2px = function (v) {
        v = parseFloat(v);
        return v * rem;
    };
    window.px2rem = function (v) {
        v = parseFloat(v);
        return v / rem;
    };
    window.dpr = dpr;
    window.rem = rem;
}())