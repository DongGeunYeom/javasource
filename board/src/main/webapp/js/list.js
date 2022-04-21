/**
 *  qna_board_list.jsp 스크립트
 */
 
$(function(){
	// text에 엔터 금지
	$(':text').keydown(function(e){
		if(e.keyCode == 13){
			e.preventDefault();
		}
	})
	
	$(".btn-primary").click(function(e){
		// criteria의 value가 n이면 경고 메세지
		if($('[name="criteria"]').val() == "n"){
			alert("검색 조건이 없습니다.");
			return false;
		}
		// keyword 비어 있으면 경고 메세지
		if($('[name="keyword"]').val() == ""){
			alert("검색어가 없습니다.");
			return false;
		}
		
		// page 번호를 변경해서 보낸다
		// 검색 후 페이지는 1로 세팅
		$("#search").find("[name='page']").val("1");
		
		// form submit
		$("#search").submit();
	})
	
	// 페이지 나누기 이동
	
	// 페이지 나누기 정보를 가지고 있는 폼 가져오기
	let actionForm = $("#actionForm");
	
	// 글 제목 클릭 시 actionForm 보내기
	$(".move").click(function(e){
		// a태그 기능 중지
		e.preventDefault();
		
		// href에 있는 값을 가져온후 actionForm 안의 bno 값을 변경
		let bno = $(this).attr("href");
		actionForm.append("<input type='hidden' name='bno' value='"+bno+"' />");
		
		// actionForm 의 action 새로 지정 => /qHitUpdate.do
		actionForm.attr("action", "/qHitUpdate.do");
		
		// actionForm submit()
		actionForm.submit();
	})
	
	// 1234 or 이전, 다음이 클릭되면 actionForm 보내기
	$(".page-link").click(function(e){
		// a태그 기능 중지
		e.preventDefault();
		
		// a태그의 href 속성이 가지고 있는 값 가져오기
		let page = $(this).attr("href");
		
		if(totalPage < page){
			page = totalPage;
		}
		
		// actionForm안의 page 번호를 교체
		actionForm.find("[name='page']").val(page);
		
		// bno 요소 제거
		actionForm.find("[name='bno']").remove();
		
		// actionForm 보내기
		actionForm.attr("action", "/qList.do");
		actionForm.submit();
	})	
	
	// 새글 작성시 페이지 나누기 정보 보내기
	$(".btn-success").click(function(){
		actionForm.attr("action", "/view/qna_board_write.jsp");
		actionForm.attr("method", "post");
		actionForm.submit();
	})
	
})