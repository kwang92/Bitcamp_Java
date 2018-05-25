<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
	String userid = "hong123";
	String userpw = "12345";
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
		String id = request.getParameter("user_id"); 
	 	String pwd =  request.getParameter("user_pwd"); 
		out.print(id+","+userid);
	 	if(userid.equals(id)){
	 		if(userpw.equals(pwd)){
	 		//	response.sendRedirect("loginSuccess.jsp");	// 이 방식은 로그인 요청을 받았을 때의 파라미터가 없어짐 (로그인 정보)
	 			RequestDispatcher dispatcher;
	 			dispatcher = request.getRequestDispatcher("loginSuccess.jsp");	// 이동할 페이지를 RequestDispatcher에 저장하고
	 			dispatcher.forward(request, response);	// dispatcher.forward를 이용해 현재 request와 response를 담아서 보내준다 (유지)
	 			// forward : 브라우저랑은 상관없이 서버 내부에서 화면 전환
	 		} else{
	 			response.sendError(0);
	 			response.sendRedirect("login.jsp");
	 		}
	 	} else{
			response.sendRedirect("login.jsp");
	 	}
	 
	%>

</body>
</html>