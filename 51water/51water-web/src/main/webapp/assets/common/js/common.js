/**
 * 公用事件方法
 * @param params 请求参数
 * @param url 请求地址
 * @param dataType 数据类型
 * @param method 请求方法
 * @param timeout 超时时间
 * @param isSync 是否同步
 * @param callBack 回调函数
 */
function actionEvent(params,url,dataType,method,timeout,isSync,callBack){
    if(!url){
        return;
    }
    $.ajax({
        url: url,
        data: params || {},
        dataType : dataType || "text",
        async : isSync || true,
        cache:false,
        type:method || "POST",
        timeout:timeout || 3*60000,
        success:function(data){
            if(callBack){
                callBack(data);
            }
        },
        error:function(request){
            console.info(request);
        },
        complete:function(request){
            console.info(request);
        }
    });
}
/**
 * 将所有的输入数据转为JSON
 * @param inputs
 * @returns {{}}
 */
function convertText2Json(inputs){
    if(!inputs){
        return {};
    }
    var params={};
    $.each(inputs,function(index,obj){
        params[$(obj).attr("name")] = $(obj).val();
    });

    return params;
}
/**
 * 清除form表单内的所有数据
 * @param form 表单对象
 */
function cleanForms(form){
    var objs = $(form).find("input,textarea");
    if(objs){
        $.each(objs,function(index,obj){
           $(obj).val("");
        });
    }

}
/**
 * 弹出消息提示
 * @param popupId 弹出层的ID
 * @param msg 消息
 * @param params 关闭弹出层回调所需的参数
 * @param closeCallBack 关闭弹出层回调函数
 */
function popup4Msg(popupId,msg,params,closeCallBack){
    popupId = "#"+(popupId || "popupMsg");
    $(popupId).find("p").html(msg || "信息提示");
    if(closeCallBack){
        $(popupId).find("a").one("click",params || {} ,function(event){
            //阻止默认行为
            event.preventDefault();
            //执行回调
            closeCallBack(event.data);
            //取消冒泡
            event.stopPropagation();
        });
    }
    $(popupId).popup('open');
}
/**
 * 弹出对话框
 * @param popupId 对话框的ID
 * @param title 对话框的标题
 * @param msg 对话框的提示信息
 * @param params 对话框操作的回调函数所需的参数
 * @param sureCallBack 确定当前操作的回调函数
 * @param cancelCallBack 取消当前操作的回调函数
 */
function popup4Dialog(popupId,title,msg,params,sureCallBack,cancelCallBack){
    popupId = "#"+(popupId || "popupDialog");
    $(popupId).find("h1").html(title || "信息确认?");
    $(popupId).find("h3").html(msg || "确定执行此操作?");
    params = params  || {};
    if(cancelCallBack){
      $("#cancel").one("click",params ,function(event){
          //阻止默认行为
          event.preventDefault();
          //执行回调
          cancelCallBack(event.data);
          //取消冒泡
          event.stopPropagation();
      });
    }
    if(sureCallBack){
      $("#sure").one("click",params,function(event){
          //阻止默认行为
          event.preventDefault();
          //执行回调
          sureCallBack(event.data);
          //取消冒泡
          event.stopPropagation();
      });
    }
    $(popupId).popup('open');
}
