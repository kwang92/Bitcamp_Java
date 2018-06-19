<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${showMember.name}님 프로필</title>

<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type = "text/javascript">

	$(this).keydown(function(event){
		this.close();
	});
</script>
<style type = "text/css">
#profile_Img{
	width : 200px;
	height : 200px;
	border : 1px solid lightgray;
	border-radius: 100px;
}
th{
	background-color: yellowgreen;
}
th,td{
	border : 1px solid gray;
	border-radius: 10px;
	padding : 10px;
}
#pic{
	border : 0;
	padding : 10px;
}
</style>
</head>
<body>
	<div id = "wrap" align = "center">
		<table style = "text-align : center">
			<tr>
				<td colspan = "2" id = "pic">
					<img id="profile_Img" src = "imageReq?cmd=other&who=${showMember.mem_id}" width="200" height="100" alt="프로필사진">
				</td>
			</tr>
			<tr>
				<th>
					이름
				</th>
				<td>
					${showMember.name}
				</td>
			</tr>
			<tr>
				<th>
					이메일
				</th>
				<td>
					${showMember.email}
				</td>
			</tr>
		</table>
	</div>
</body>
</html>