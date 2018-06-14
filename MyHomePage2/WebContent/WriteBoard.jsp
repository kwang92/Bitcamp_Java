<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<c:set var = "contextPath" value ="<%=request.getContextPath()%>"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">	
</script>

<link rel="stylesheet" type="text/css" href= "${contextPath}/css/writeBoard.css?ver=3">
<link rel="stylesheet" type="text/css" href= "${contextPath}/daumeditor/css/editor.css" charset = "utf-8">
<script src = "${contextPath}/daumeditor/js/editor_loader.js?enviroment=development" type = "text/javascript" charset="utf-8"></script>
<!-- <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script> -->
<script type = "text/javascript">
var path = "${contextPath}";
alert(path);
function setConfig(){
	var config = { txHost: '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) http://xxx.xxx.com */ 
					txPath: '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) /xxx/xxx/ */ 
					txService: 'sample', /* 수정필요없음. */ 
					txProject: 'sample', /* 수정필요없음. 프로젝트가 여러개일 경우만 수정한다. */ 
					initializedId: "", /* 대부분의 경우에 빈문자열 */ 
					wrapper: "tx_trex_container", /* 에디터를 둘러싸고 있는 레이어 이름(에디터 컨테이너) */ 
					form: 'tx_editor_form'+"", /* 등록하기 위한 Form 이름 */ 
					txIconPath: "/daumeditor/images/icon/editor/", /*에디터에 사용되는 이미지 디렉터리, 필요에 따라 수정한다. */ 
					txDecoPath: "/daumeditor/images/deco/contents/", /*본문에 사용되는 이미지 디렉터리, 서비스에서 사용할 때는 완성된 컨텐츠로 배포되기 위해 절대경로로 수정한다. */ 
					canvas: { styles: 
								{ color: "#123456", /* 기본 글자색 */ 
										fontFamily: "굴림", /* 기본 글자체 */ fontSize: "10pt", /* 기본 글자크기 */ backgroundColor: "#fff", /*기본 배경색 */ lineHeight: "1.5", /*기본 줄간격 */ padding: "8px" /* 위지윅 영역의 여백 */ }, showGuideArea: false }, events: { preventUnload: false }, sidebar: { attachbox: { show: true, confirmForDeleteAll: true } }, size: { contentWidth: 700 /* 지정된 본문영역의 넓이가 있을 경우에 설정 */ } }; EditorJSLoader.ready(function(Editor) { editor = new Editor(config); }); }
	$(function(){
		$.ajax({
			type : "get",
			url : path+"/daumeditor/editor_template.html",	// path - request.getContextPath()
			dataType : "html",
			success : function(data){
				$("#editorTd").html(data);
				setConfig();
			},
			error : function(){
				alert("에러");
			}
		});
	});
function validForm(editor){
	var validator = new Trex.Validator();
	var content = editor.getContent();
	if(!validator.exists(content)){
		alert("내용을 입력하셔야합니다.");
		return false;
	}
}
function setForm(editor){
	var form = editor.getForm();
	var content = editor.getContent();
	var textarea = document.createElement('textarea');
	textarea.name = 'content';
	textarea.value = content;
	form.createField(textarea);
	return true;
}
</script>
</head>
<body>
	<div id = "wrap">
		<form action = "board" name = "writeBoard" id = "myFrm" onSubmit="Editor.save();">
			<input type = "hidden" name = "cmd" value = "write">
			<table>
				<tr>
					<th class = "tps" style = "width : 20%">작성자</th>
					<td class = "tps" style = "width : 80%; font-weight : bold"> ${user.name}</td>
				</tr>
				<tr>
					<th class = "tps" style = "width : 20%">제목</th>
					<td class = "tps" style = "width : 80%"><input type = "text" name = "title" style = "width : 100%"></td>
				</tr>
				<tr class = "board">
					<th>내용</th>
					
					<td id ="editorTd" class = "ops" style = "height : 400px">
<!-- 						<textarea name = "context" id = "context"></textarea> -->
					</td>
				</tr>
				<tr>
					<td colspan = "2" class = "ops" style = "text-align : right">
						<button onclick = "history.go(-1);">취소</button>
						<button onclick = "writeBoard.submit()">작성</button>
					</td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>