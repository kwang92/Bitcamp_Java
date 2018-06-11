<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type = "text/javascript">

	if(window.name == 'update'){
		window.opener.parent.location.href = "board?command=boardUpdateForm&num=${param.num}";
		window.close();		
	}
	else if(window.name == 'delete'){
		window.opener.parent.location.href = "board?command=boardDelete&num=${param.num}";
		window.close();		
	}
</script>
