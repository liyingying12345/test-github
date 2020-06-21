<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- css -->
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<!-- js -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>

<script type="text/javascript">
	$(function(){
		
		$.post("queryCategory",function(data){
			
			var str = "";
			for(var i in data){
				str+="<option value='"+data[i].cid+"'>"+data[i].cname+"</option>";
			}
			
			$("#cid").append(str);
			$("#cid").val("${map.cid}");
			
		})
		
	})

</script>
</head>
<body>
	<h1>欢迎使用Maven</h1>
	<form action="findAll" method="post">
		商品名称:<input type="text" name="gname" value="${map.gname}">
		上架时间:<input type="date" name="startTime" value="${map.startTime}">~<input type="date" name="endTime" value="${map.endTime}">
		商品分类:<select id="cid" name="cid">
				<option>请选择</option>
			  </select>
		<input type="submit" value="搜索">
	</form>
	<table>
		<tr>
			<td colspan="11">
				<a href="add.jsp"><input type="button" value="添加"></a>
			</td>
		</tr>
		<tr>
			<td>编号</td>
			<td>商品名称</td>
			<td>商品时间</td>
			<td>分类</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list}" var="p">
			<tr>
				<td>${p.gid}</td>
				<td>${p.gname}</td>
				<td>${p.gtime}</td>
				<td>${p.cname}</td>
				<td>
					<a href="toUpdate?gid=${p.gid}"><input type="button" value="修改"></a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="11">
				<a href="?pageNum=1">首页</a>
				<a href="?pageNum= ${page.pageNum - 1 < 1 ? page.pageNum : page.pageNum - 1 }">上一页</a>
				<a href="?pageNum= ${page.pageNum + 1 > page.pages ? page.pages : page.pageNum + 1 }">下一页</a>
				<a href="?pageNum= ${page.pages }">末页</a>
				第${page.pageNum}页/共${page.pages}页
			</td>
		</tr>
	</table>
</body>
</html>