"use strict"
var app = app || {};
app = (()=>{
	const WHEN_ERR = '호출하는 JS파일을 찾지 못했습니다.'
		let init=x=>{
			app.$.init(x);
		}
		let onCreate=()=>{
			setContentView();
		}
		let setContentView=()=>{
			$.when(
					$.getScript($.js()+'/compo.js'),
					$.getScript($.js()+'/auth.js')
			).done(()=>{
				auth.init();
			});
		}
		return {init:init, onCreate:onCreate};
})();

app.$ ={
		init : x=>{
			$.getScript(x+'/resources/js/router.js',()=>{
				$.extend(new Session(x));
				app.onCreate();
			})
			}
		};

