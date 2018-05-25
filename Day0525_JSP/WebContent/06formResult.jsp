<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form 요청으로부터 파라미터를 얻는 form</title>
</head>
<body>
	<%--
		요청정보를 담고있는 request 객체에서 정보를 읽어서 화면에 출력
		getParameter의 type은 무조건 String이다.
	 --%>
	 <%
	 	request.setCharacterEncoding("UTF-8");	// POST방식 사용 시 한글 깨짐 방지
	 %>
	 이름 : <%= request.getParameter("name") %><br>
	 주소 : <%= request.getParameter("address") %><br>
	 동물 :
	 <% 
	 	String[] pets = request.getParameterValues("pet");
	 	for(int i = 0; i < pets.length; i++){
	 		out.print(pets[i]+"  ");	
	 	} 
	 %>
	 <hr>
	 <%-- request.getParameterNames()  : request에 포함된 모든 파라미터들의 name을 반환하는 메소드  --%>
	 <%
	 	Enumeration<String> names = request.getParameterNames();	// request로 들어오는 모든 name들을 저장
	 	while(names.hasMoreElements()){
	 		String name = names.nextElement();	
	 		String info = request.getParameter(name);
	 		out.print(info);
	 		out.print("<br>");
	 	}// while문을 통해 request로 들어온 모든 파라미터들의 name을 가져와서 쓸 수가 있다.
	 %>
	 
	 <%-- request.getParameterMap()  : request로 들어온 파라미터들을 map형태로 반환한다.  Map : key - value
	 																				key : String, value : String[]
	  --%>
	  
	  <%
	  	out.print("<hr>");
	  	Map<String,String[]> paramMap = request.getParameterMap();
	  	for( Map.Entry<String, String[]> elem : paramMap.entrySet() ){
            out.print( String.format("키 : %s &nbsp; 값 : %s  &nbsp;|", elem.getKey(), elem.getValue()[0]) );
        }
	  %>
	  
	  <%-- request.getHeaderNames()  : request에 포함된 모든 파라미터들의 name을 반환하는 메소드  --%>
	  <%
	  	out.print("<hr>");
	  	out.print("헤더네임"+"<br>");
	  	// 헤더이름을 가져온다.
	  	Enumeration<String> headerNames = request.getHeaderNames();
	  	while(headerNames.hasMoreElements()){
	  		String headerName = headerNames.nextElement();
	  		String headerValue = request.getHeader(headerName);
	  		out.print(headerValue+"<br>");
	  	}
	  %>
</body>
</html>