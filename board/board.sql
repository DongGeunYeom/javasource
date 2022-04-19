create table board(
	bno number(8), 					  -- 글번호
	name nvarchar2(10) not null,	  -- 작성자
	password varchar2(15) not null,	  -- 비밀번호
	title nvarchar2(50) not null,	  -- 제목	
	content nvarchar2(1000) not null, -- 내용
	attach nvarchar2(100),			  -- 파일첨부
	re_ref number(8) not null,		  -- 답변글 작성시 참조되는 글 번호
	re_lev number(8) not null,		  -- 답변글 레벨
	re_seq number(8) not null,		  -- 답변글 순서
	readcount number(8) default 0,	  -- 조회수
	regdate date default sysdate	  -- 작성날짜
);

-- item psize => "size" // 이미 존재하는 identifier로 중복을 피하기 위해 쌍따옴표 사용.

alter table board add constraint pk_board primary key(bno);

create sequence board_seq;

insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) 
values(board_seq.nextval, '홍길동', '1234', 'jsp/servlet 게시판', '게시판 작성해 봅시다.', null , board_seq.currval ,0 ,0);

drop table board;

update board set title=1, content=2 where bno=29 and password=1234;

select * from board;

-- 게시물 전체 개수
select count(*) from board;

-- 가장 마지막 글 번호 확인
select max(bno) from board;

-- 댓글, 검색, 페이지 나누기


-- 더미 데이터
insert into board(bno, name, password, title, content, re_ref, re_lev, re_seq) 
(select board_seq.nextval, name, password, title, content, board_seq.currval, re_lev, re_seq from board);

select bno, title, re_ref, re_seq, re_lev from board where bno=33;

-- 첫 번째 댓글
insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) 
values(board_seq.nextval, '댓글러', '1234', 're: 댓글1', '댓글작성', null , 33,1,1);

-- 원본글과 댓글 그룹으로 가져오기(re_ref 사용)
select bno, title, re_ref, re_seq, re_lev from board where re_ref = 33;

-- 댓글 작성시 댓글을 최신 순으로 추출할 수 있어야 함(re_seq 사용)

-- 1) 기존 댓글의 re_seq 값을 업데이트
--	  update board set re_seq = re_seq + 1 where re_ref = 원본글의 re_ref and re_seq > 원본글의 re_seq;

-- 2) 새로운 댓글 삽입
-- 댓글작성(re_ref : 원본글의 re_ref값과 동일하게 삽입,
--			re_lev : 원본글의 re_lev + 1 삽입,
--			re_seq : 원본글의 re_seq + 1 삽입)

insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) 
values(board_seq.nextval, '댓글러2', '1234', 're: 댓글2', '댓글작성2', null , 33,2,2);

