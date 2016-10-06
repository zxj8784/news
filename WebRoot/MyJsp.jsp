<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新闻中国</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
	function check(){
		var login_username = document.getElementById("uname");
		var login_password = document.getElementById("upwd");
		if(login_username.value == ""){
			alert("用户名不能为空！请重新填入！");
			login_username.focus();	
			return false;
		}else if(login_password.value == ""){
			alert("密码不能为空！请重新填入！");
			login_password.focus();
			return false;
		}
		return true;
	}
	
	function focusOnLogin(){
		var login_username = document.getElementById("uname");
		login_username.focus();	
	}
 </script>
</head>

<body onload="focusOnLogin()">
  
<div id="header">
  <div id="top_login">
    <form action="/News/doLogin" method="post" onsubmit="check(this)">
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="${user}" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="" class="login_input" />
      <input type="submit" class="login_sub" value="登录" />
      <label id="error"> </label>
      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
    </form>
  </div>
  <div id="nav">
    <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div class="sidebar">
    <h1> <img src="images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>      
       <c:forEach var="News" items="${chinaList }" varStatus="status" >
      	  <li> <a href='/News/context_init?nid=${News.nid }'><b> ${News.ntitle }</b></a> </li>
      	</c:forEach>
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>      
        <c:forEach var="News" items="${foreignList }" varStatus="status" >
      	  <li> <a href='/News/context_init?nid=${News.nid }'><b> ${News.ntitle }</b></a> </li>
        </c:forEach> 
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <c:forEach var="News" items="${ettmList }" varStatus="status" >
      	  <li> <a href='/News/context_init?nid=${News.nid }'><b> ${News.ntitle }</b></a> </li>
      	</c:forEach>
      </ul>
    </div>
  </div>

  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
        <li id='class_month'>
          <c:forEach var="Topic" items="${topicList }" varStatus="status" >
            <c:if test="${status.count<12 }">
      	      <a href="/News/index?ntid=${Topic.tid }"><b> ${Topic.tname }</b></a>
      	    </c:if>
	      </c:forEach>
	    </li>
	    
	    <li id='class_month'>
	      <c:forEach var="Topic" items="${topicList }" varStatus="status" >
            <c:if test="${status.count>=12 }">
      	      <a href="/News/index?ntid=${Topic.tid }"><b> ${Topic.tname }</b></a>
      	    </c:if>
	      </c:forEach>
      </li>	
      </ul>
      
      <ul class="classlist">
         <c:forEach var="news" items="${pageNumList }" varStatus="status" >
      	    <li><a href='/News/context_init?nid=${news.nid }'>${news.ntitle }</a>
      	       <span> ${news.ncreatedate }</span>
      	    </li>
      	  <c:if test="${status.count%5==0 }">
            <li class='space'></li>
          </c:if>
        </c:forEach>
      	 
      	 <c:if test="${pageNum>1&&pageNum<totalPageCount }">
           <p align="center">
            <a href = '
            <c:url value = "/index">
              <c:param name="pageNum" value="${pageNum-1 }" ></c:param>
              <c:param name="ntid" value="${ntid }" ></c:param>
            </c:url>'>上一页 </a>当前： ${pageNum } 页 | 共 ${totalPageCount } 页
            <a href ='<c:url value = "/index">
              <c:param name="pageNum" value="${pageNum+1 }" ></c:param>
              <c:param name="ntid" value="${ntid }" ></c:param>
            </c:url>' >下一页</a>
          </p>	
        </c:if>
        
        <c:if test="${pageNum==1&&totalPageCount!=1 }">
	      <p align="center">
            <a href = "javascript:void(0)">首页 </a>当前： ${pageNum } 页 | 共 ${totalPageCount } 页
            <a href ='<c:url value = "/index">
              <c:param name="pageNum" value="${pageNum+1 }" ></c:param>
              <c:param name="ntid" value="${ntid }" ></c:param>
            </c:url>' >下一页</a>
          </p>	
        </c:if>
        
        <c:if test="${pageNum==totalPageCount&&totalPageCount!=1 }">
	      <p align="center">
            <a href = '
            <c:url value = "/index">
              <c:param name="pageNum" value="${pageNum-1 }" ></c:param>
              <c:param name="ntid" value="${ntid }" ></c:param>
            </c:url>'>上一页 </a>当前： ${pageNum } 页 | 共 ${totalPageCount } 页
            <a href = "javascript:void(0)">末页</a>
          </p>	
        </c:if>
      </ul>
    </div>   
    
<div class="picnews">
  <ul>
    <li> <a href="#"><img src="images/Picture1.jpg" width="249" alt="" /> </a><a href="#">幻想中穿越时空</a> </li>
    <li> <a href="#"><img src="images/Picture2.jpg" width="249" alt="" /> </a><a href="#">国庆多变的发型</a> </li>
    <li> <a href="#"><img src="images/Picture3.jpg" width="249" alt="" /> </a><a href="#">新技术照亮都市</a> </li>
    <li> <a href="#"><img src="images/Picture4.jpg" width="249" alt="" /> </a><a href="#">群星闪耀红地毯</a> </li>
  </ul>
</div>
  </div>
</div>
  <div id="friend">
  <h1 class="friend_t"> <img src="images/friend_ico.gif" alt="合作伙伴" /> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="#">百度</a> </li>
      <li> <a href="#">谷歌</a> </li>
      <li> <a href="#">新浪</a> </li>
      <li> <a href="#">网易</a> </li>
      <li> <a href="#">搜狐</a> </li>
      <li> <a href="#">人人</a> </li>
      <li> <a href="#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a> &#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
    文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
    新闻中国 版权所有 </p>
</div>
</body>
</html>
</body>

</html>
