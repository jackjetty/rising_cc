var basePath=(document.getElementsByTagName("base")[0])?document.getElementsByTagName("base")[0].href:"/";
function checkRequestValidity_prompt(url){
	var dom=null;
	if(frameElement){
		var dg = null;
		dg = frameElement.lhgDG;
		if(dg){
			if(dg.inwin){
				dom=dg.inwin;
			}
		}
	}
	if(dom==null)dom=window;
	dom.location.href = url;
}
/**
 * 请求状态码参考GlobalResults
 * @param {} data
 * @return {Boolean}
 */
function checkAjaxRequestValidity(data){
	if(data){
		var obj = null;
		if(typeof(data) == "string"){
			try{obj = eval('(' + data + ')');}catch(e){}
		}else if(typeof(data) == "object"){
			obj = data;
		}
		if(obj && obj.http_status_code_){
			var code = obj.http_status_code_;
			if(code=="systemNotLogin"){
				var url=basePath+'login/systemNotLogin.html';
				checkRequestValidity_prompt(url);
				return false;
			}
		}
		return true;
	}
	return true;
}