/* 
 * @amyzhu
 *  */	
 /*左右切换*/
;(function($){
    var Observer = function(){
        var todo = {}, self = this;
        self.on = function(eventName,callback){
            if( !todo[eventName] ){
                todo[eventName] = [];
            }
            todo[eventName].push(callback);
        }
        self.clearQuery = function(eventName){
            if( todo[eventName] ){
                todo[eventName] = [];
            }
        }
        self.trigger = function(eventName,arg){
            var r;
            var _arg = arg||[];
            for( var i = 0; todo[eventName] && i < todo[eventName].length; i++ ){
                r = todo[eventName][i].apply(self.trigger, _arg );
                if( r === false ){
                    break;
                }
            }
            return r;
        }
    }
    var defortOptions = {
        showN:1,    //展示个数
        actN:1,     //滚屏个数
        aTime:200   //滚屏时间
    }

    var Scroller = function(dom,opts){
        var op = $.extend({},defortOptions,opts),
            self = this;
        Observer.apply(self);

        var _ul = dom.find('ul'),
            _lis = _ul.children('li'),
            _span = parseInt( _lis.eq(0).outerWidth(true) )*op.actN*(-1),
            ing = false;

        //set css
        if( _lis.length <= op.showN ){
            if(op.btnNext){
                op.btnNext.hide();
            }
            if(op.btnPrev){
                op.btnPrev.hide();
            }
            return;
        }
        if( _lis.length < op.showN + op.actN ){
            _ul.append(_lis.clone());
            _lis = _ul.children('li');
        }
        
        //set fn
        var shiftToRight = function(){
            for( var i=0; i<op.actN; i++ ){
                _ul.append( _ul.children('li').eq(0));
            }
            _ul.css({
                'margin-left':0
            });
        }
        var shiftToLeft = function(){
            for( var i=0; i<op.actN; i++ ){
                _ul.prepend( _ul.children('li').last() );
            }
            _ul.css({
                'margin-left': _span
            });
        }
        self.ul = _ul;
        self.next = function(){
            if(ing){
                return;
            }
            ing = true;
            var arg = arguments;
            self.trigger('breforeaction',arg);
            self.trigger('beforenext',arg);
            _ul.animate({
                'margin-left':_span
            },op.aTime,function(){
                shiftToRight();
                self.trigger('afteraction',arg);
                self.trigger('gonext',arg);
                ing = false;
            });
        }
        self.prev = function(){
            if(ing){
                return;
            }
            ing = true;
            var arg = arguments;
            shiftToLeft();
            self.trigger('beforeaction',arg);
            self.trigger('beforeprev',arg);
            _ul.animate({
                'margin-left':0
            },op.aTime,function(){
                self.trigger('afteraction',arg);
                self.trigger('goprev',arg);
                ing = false;
            });
        }
        if(op.btnNext){
            op.btnNext.click(self.next);
        }
        if(op.btnPrev){
            op.btnPrev.click(self.prev);
        }
    }
    $.fn.extend({
        scroller:function(op){
            var _this = $(this),
                s = new Scroller(_this, op||{});
            _this.data('scroller', s );
            return s;
        }
    });
// 上下
$.fn.extend({
        Scroll:function(opt,callback){
        if(!opt) var opt={};
        var _btnUp = $("#"+ opt.up);//向上按钮
        var _btnDown = $("#"+ opt.down);//向下按钮
        var timerID;
        var _this=this.eq(0).find("ul:first");
        var  lineH=_this.find("li:first").height(), 
            line=opt.line?parseInt(opt.line,10):parseInt(this.height()/lineH,10), 
            //每次滚动的行数，默认为一屏，即父容器高度
            speed=opt.speed?parseInt(opt.speed,10):500; 
            timer=opt.timer //滚动的时间间隔（毫秒）
        if(line==0) line=1;
        var upHeight=0-line*lineH;       
        var scrollUp=function(){
            _btnUp.unbind("click",scrollUp); //取消向上按钮的函数绑定
            _this.animate({
                    marginTop:upHeight
            },speed,function(){
                    for(i=1;i<=line;i++){
                            _this.find("li:first").appendTo(_this);
                    }
                    _this.css({marginTop:0});
                    _btnUp.bind("click",scrollUp); //绑定向上按钮的点击事件
            });
        }
        //向下翻页函数
        var scrollDown=function(){
            _btnDown.unbind("click",scrollDown);
            for(i=1;i<=line;i++){
                    _this.find("li:last").show().prependTo(_this);
            }
            _this.css({marginTop:upHeight});
            _this.animate({
                    marginTop:0
            },speed,function(){
                    _btnDown.bind("click",scrollDown);
            });
        }       
        var autoPlay = function(){
            if(timer)timerID = window.setInterval(scrollUp,timer);
        };
        var autoStop = function(){
            if(timer)window.clearInterval(timerID);
        };         
        _this.hover(autoStop,autoPlay).mouseout();
        _btnUp.css("cursor","pointer").click( scrollUp ).hover(autoStop,autoPlay);
        _btnDown.css("cursor","pointer").click( scrollDown ).hover(autoStop,autoPlay);

        }       
})
// 
})(jQuery);