<%@page import="java.sql.DriverManager"%>
<%@page import="model.User"%>
<%@page import="model.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!	
	UserDAO user_Dao;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		user_Dao = new UserDAO();
		User usr = new User(id,pwd,name);
		boolean isIn = user_Dao.addUser(usr);
		
		RequestDispatcher dispatcher;
		if(isIn){
			dispatcher = request.getRequestDispatcher("joinSuccess.jsp");	// 이동할 페이지를 RequestDispatcher에 저장하고
			dispatcher.forward(request, response);	// dispatcher.forward를 이용해 현재 request와 response를 담아서 보내준다 (유지)
		}else{
			dispatcher = request.getRequestDispatcher("joinFail.jsp");
			dispatcher.forward(request, response);	// dispatcher.forward를 이용해 현재 request와 response를 담아서 보내준다 (유지)
		}
		/*try{
			Class.forName("oracle:jdbc:driver:OracleDriver");
		} catch(Exception e){}*/
	%>
	
</body>
</html>