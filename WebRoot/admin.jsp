<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加主题--管理后台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    <link href="css/admin.css" rel="stylesheet" type="text/css">
</head>

<body style="zoom: 1;">

<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="images/logo.jpg" alt="新闻中国"></div>
    <div id="a_b01"><img src="images/a_b01.gif" alt=""></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：  ${userName }  登录  &#160;&#160;&#160;&#160; <a href="/News/index">login out</a></div>
  <div id="channel"> </div>
</div>

<div id="main">
  <div id="opt_list">
  <ul>
    <li><a href="/News/news_add_init?opr=findTopics">添加新闻</a></li>
    <li><a href="/News/admin_init?opr=list">编辑新闻</a></li>
    <li><a href="topic_add.jsp">添加主题</a></li>
    <li><a href="/News/topic_list_init">编辑主题</a></li>
  </ul>
</div>

  <div id="opt_area">    
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	
</script>
    <ul class="classlist">
    
      <c:forEach var="news" items="${newsList }" varStatus="status" >
        <li>${news.ntitle }<span> 作者：${news.nauthor } &nbsp;&nbsp;&nbsp;&nbsp; 
          <a href="/News/news_update_init?opr=findNew&amp;nid=${news.nid }">修改</a> &nbsp;&nbsp;&nbsp;&nbsp; 
          <a href="/News/news_delete?opr=del&amp;nid=${news.nid }" onclick="clickdel(this)">删除</a> 
         </span> 
        </li>
        <c:if test="${status.count%5==0 }">
          <li class='space'></li>
        </c:if>
      </c:forEach>
       
    </ul>
  </div>
</div>
<div id="footer">
  <div id="site_link">
   <a href="/News/admin_init">关于我们</a><span>|</span> 
   <a href="/News/admin_init">Aboue Us</a><span>|</span> 
   <a href="/News/admin_init">联系我们</a><span>|</span> 
   <a href="/News/admin_init">广告服务</a><span>|</span> 
   <a href="/News/admin_init">供稿服务</a><span>|</span> 
   <a href="/News/admin_init">法律声明</a><span>|</span> 
   <a href="/News/admin_init">招聘信息</a><span>|</span> 
   <a href="/News/admin_init">网站地图</a><span>|</span> 
   <a href="/News/admin_init">留言反馈</a> </div>
<div id="footer">
  <p class="">24小时客户服务热线：010-68988888  &nbsp;&nbsp;&nbsp;&nbsp; <a href="/News/admin_init">常见问题解答</a> &nbsp;&nbsp;&nbsp;&nbsp;  新闻热线：010-627488888<br>
    文明办网文明上网举报电话：010-627488888  &nbsp;&nbsp;&nbsp;&nbsp;  举报邮箱：<a href="/News/admin_init">jubao@jb-aptech.com.cn</a></p>
  <p class="copyright">Copyright © 1999-2009 News China gov, All Right Reserver<br>
    新闻中国   版权所有</p>
</div>

</div>

<div></div></body></html>
