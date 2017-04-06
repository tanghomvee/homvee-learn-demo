<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
     <%@include file="/common/css.html"%>
      <title>添加水站信息</title>
  </head>
  <body>
      <div data-role="page">
          <%@include file="/common/header.html"%>
          <div data-role="content">
              <form id="form">
                  <input type="hidden" id="id" name="id" value=""/>
                  <label for="waterStationName">名称:</label>
                  <input type="text" id="waterStationName" name="waterStationName" placeholder="水站名称"/>

                  <label for="waterStationMp">手机号码:</label>
                  <input type="number" id="waterStationMp" name="waterStationMp" pattern="[0-9]{11}" placeholder="输入手机号" maxlength="11"/>

                  <label for="waterStationCode">编号:</label>
                  <input type="text" id="waterStationCode" name="waterStationCode"placeholder="姓名拼音"/>

                  <label for="openTime">营业开始时间:</label>
                  <input type="time" id="openTime" name="openTime" placeholder="营业开始时间"/>

                  <label for="closeTime">营业结束时间:</label>
                  <input type="time" id="closeTime" name="closeTime" placeholder="营业结束时间"/>

                  <label for="waterStationAddr">详细地址:</label>
                  <textarea id="waterStationAddr" name="waterStationAddr" placeholder="详细地址"></textarea>
              </form>
              <a id="yes" href="#"  data-transition="slidedown" data-role="button" data-rel="popup" class="ui-btn ui-btn-inline" data-position-to="window">提交</a>
              <a id="no" href="#" data-role="button" class="ui-btn ui-btn-inline">重置</a>
          </div>
          <%@include file="/common/footer.html"%>
      </div>
  </body>
  <%@include file="/common/js.html"%>
  <script src="/assets/js/water-station.js"></script>
  <script>
      function msgTip(data){
          if(data){
              popup4Msg(null,data.msg);
          }else{
              popup4Msg(null,"未知错误");
          }
      }

      $(function(){
         $("#no").on({
             click:function(event){
                 //阻止默认行为
                 event.preventDefault();
                 //执行回调
                 cleanForms($("#form"))
                 //取消冒泡
                 event.stopPropagation();
             }
         });
         $("#yes").on({
             click:function(event){
                 edit('form','/station/add',msgTip);
             }
         });
      });
  </script>
</html>
