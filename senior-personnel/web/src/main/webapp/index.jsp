<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="assets/js/jquery-2.2.2.js">

    </script>
    <script>
      <%--  $.ajax({
        url:"parseVender",
        data:{id:12}
        });--%>

        var xml='<vender><id>34343434</id><venderName>XXXXXXXXXX</venderName></vender>';
         $.ajax({
        url:"parseVender",
        data:xml
        });
        var ids=[];
        ids.push(1);
        ids.push(2);
        var arrayData={};
        arrayData.ids=ids;
         $.ajax({
        url:"reqParams",
        traditional: true,
        data:arrayData
        });

    </script>
</head>
<body>4455
4333333333333333333333333333333333333333
</body>
</html>