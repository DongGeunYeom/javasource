/**
 *  qna_board_reply.jsp 폼 유효성 검증
 */
 $(function(){
 	$("#replyForm").validate({
 		rules:{
 			name:{
 				required:true
 			},
 			title:{
 				required:true
 			},
 			content:{
 				required:true
 			},
 			password:{
 				required:true
 			},
 			attach:{
 				extension:"png|jpg|gif",
 				maxsizetotal:204800
 			},
 		},
 		messages:{
 			name:{
 				required:"(이름 입력)"
 			},
 			title:{
 				required:"(제목 입력)"
 			},
 			content:{
 				required:"(내용 입력)"
 			},
 			password:{
 				required:"(비밀번호 입력)"
 			},
 			attach:{
 				extension:"(이미지 파일만 가능)",
 				maxsizetotal:"(파일 사이즈 초과)"
 			},
 		},
 		errorElement: "span",
 		errorPlacement: function(error,element){
 			if(element.prop("type") == "file"){
				$(element).closest("form")
						  .find("small[name='"+element.attr('name')+"']")
						  .append(error);
			}else{
				$(element).closest("form")
						  .find("label[name='"+element.attr('name')+"']")
						  .append("<br>").append(error);		
			}	
 		}
 	})
 })