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
		// form submit
		$("#search").submit();
	})
	
	// 페이지 나누기 이동
	
	// 페이지 나누기 정보를 가지고 있는 폼 가져오기
	let actionForm = $("#actionForm");
	
	// 1234 or 이전, 다음이 클릭되면 actionForm 보내기
	
	$(".page-link").click(function(e){
		// a태그 기능 중지
		e.preventDefault();
		
		// a태그의 href 속성이 가지고 있는 값 가져오기
		let page = $(this).attr("href");
		
		// actionForm안의 page value 교체
		actionForm.find("[name='page']").val(page);
		
		// actionForm 보내기
		actionForm.submit();
	})
		
})