function edit(formId,url,callBack){
    if(!formId || !url){
        popup4Msg(null,"参数错误",null,null);
        return;
    }
    var datas = convertText2Json($("#"+formId).find("input,textarea"));
    actionEvent(datas,url,"JSON",null,null,false,callBack);
}