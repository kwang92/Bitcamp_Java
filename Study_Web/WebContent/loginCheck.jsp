<%@page import="model.User"%>
<%@page import="model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
	UserDAO user_Dao;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login check Test</title>
</head>
<body>
	<%-- login.jsp에서 보낸 데이터 처리 --%>
	<%--
		response.sendRedirect("jsp파일") 은 이전 요청에 대한 정보를 없이 브라우저에게 새 요청을 통해 창을 띄우지만
		RequestDispatcher를 통한 forward는 현재 받아온 request와 response를 유지한 채 창을 띄울 수가 있다.
	 --%>
	<%	
		user_Dao = new UserDAO();
		String id = request.getParameter("user_id");
		out.print(id);
		String pwd = request.getParameter("user_pwd");
		out.print(pwd);
		
		
		User usr = new User(id, pwd);
		boolean check = user_Dao.checkUser(usr);
		
		RequestDispatcher dispatcher;
		String next_Page = "loginFail.jsp";
	 	if(check){
	 		next_Page = "loginSuccess.jsp";	
	 	}
	 	dispatcher = request.getRequestDispatcher(next_Page);	// 이동할 페이지를 RequestDispatcher에 저장하고
		dispatcher.forward(request, response);
	 
	%>

</body>
</html>