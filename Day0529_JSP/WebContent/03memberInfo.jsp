<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id = "member" class = "model.Member" />
<%--
<jsp:setProperty property="id" name="member"/>
<jsp:setProperty property="pwd" name="member"/>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		<jsp:useBean>으로 bean 하나 만들고 해당하는 bean에 파라미터 넣기
	 --%>
	<jsp:setProperty name = "member" property = "*"/>	<%-- 다 가져와서 알아서 들어감 --%>
	memberID : <%=member.getId() %><br>
	memberPWD : <%=member.getPwd() %><br>
	memberMail : <%=member.getEmail() %><br>
	memberName : <%=member.getName() %>
</body>
</html>