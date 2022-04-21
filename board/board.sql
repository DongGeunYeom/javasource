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

select bno, title, re_ref, re_seq, re_lev from board where bno=2104;

-- 첫 번째 댓글
insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) 
values(board_seq.nextval, '댓글러', '1234', 're: 댓글1', '댓글작성', null , 2104,1,1);

-- 원본글과 댓글 그룹으로 가져오기(re_ref 사용)
select bno, title, re_ref, re_seq, re_lev, password from board where re_ref = 2104 order by re_seq asc;

-- 댓글 작성시 댓글을 최신 순으로 추출할 수 있어야 함(re_seq 사용)

-- 1) 기존 댓글의 re_seq 값을 업데이트
--	  update board set re_seq = re_seq + 1 where re_ref = 원본글의 re_ref and re_seq > 원본글의 re_seq;
update board set re_seq = re_seq+1 where re_ref=2104 and re_seq > 0;

-- 2) 새로운 댓글 삽입
-- 댓글작성(re_ref : 원본글의 re_ref값과 동일하게 삽입,
--			re_lev : 원본글의 re_lev + 1 삽입,
--			re_seq : 원본글의 re_seq + 1 삽입)

insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) 
values(board_seq.nextval, '댓글러2', '1234', 're: 댓글2', '댓글작성2', null , 2104,1,1);

-- 댓글의 댓글 작업
-- 업데이트 
-- update board set re_seq = re_seq+1 where re_ref = 원본글의 re_ref and re_seq > 원본글의 re_seq
update board set re_seq = re_seq+1 where re_ref = 2104 and re_seq > 1;

-- 댓글의 댓글 삽입
insert into board(bno, name, password, title, content, attach, re_ref, re_lev, re_seq) 
values(board_seq.nextval, '댓글러3', '1234', 're: re: 댓글3', '댓글작성3', null, 2104, 2, 2);

-- 원본글과 댓글 리스트 추출
select bno, title, name, regdate, readcount, re_ref, re_seq, re_lev from board
order by re_ref desc, re_seq asc;

-- 페이지 나누기
-- MySQL : limit
-- Oracle : rownum(가상 칼럼) - 조회된 결과에 번호를 순서적으로 매겨 줌
select rownum, bno, title from board;

select rownum, bno, title from board order by bno desc;

--결과 안나옴
select rownum, bno, title from board where rownum > 1 ; -- where절에 rownum을 쓰기 위해서는 이하(<=)로 설정해야 함

-- rownum을 사용할 때 order by 절 사용시 order by에 오는 컬럼은 index로 설정되어 있어야 한다.
select rownum, bno, title from board where rownum <= 10 order by bno desc;


-- 게시글에서는 이런 식으로 추출을 해야함(원하는 대로 최신글 추출이 불가)
select rownum, bno, title from board where rownum <= 10 order by re_ref desc, re_seq asc;

-- => 해결 : 첫 번째로 정렬을 하고 난 후 다음에 rownum을 부여하는 방식
select rownum, bno, title
from (select bno, title from board where bno>0 order by re_ref desc, re_seq asc)
where rownum<=10;

-- 1 클릭 => 가장 최신 게시물 10개 가져오기
-- 2 클릭 =? 그 다음 최신 게시물 10개 가져오기

select bno, title, name, regdate, readcount, re_ref, re_lev, re_seq 
from (select rownum AS rnum, bno, title, name, regdate, readcount, re_ref, re_lev, re_seq 
		from (select bno, title, name, regdate, readcount, re_ref, re_lev, re_seq
				from board 
				where bno>0 order by re_ref desc, re_seq asc)
		where rownum<=10)
where rnum > 0;

-- 순서
-- 1) 전체 게시물을 조회한 후 정렬하여 보여주기 
select bno, title, name, regdate, readcount, re_ref, re_lev, re_seq -- 4)
from board     -- 1)	
where bno>0    -- 2) 
order by re_ref desc, re_seq asc  -- 3)

-- 2) 1)번 결과에 rownum 부여 후 rownum이 10이하인 것만 추출
select rownum AS rnum, bno, title, name, regdate, readcount, re_ref, re_lev, re_seq 
from (1번결과)
where rownum<=10

--3) 2)번 결과에서 rnum이 0보다 큰 것만 추출
select bno, title, name, regdate, readcount, re_ref, re_lev, re_seq 
from (2번결과)
where rnum > 0;

-- 1page : rownum <= 10, rnum > 0(end) // 2page : rownum <= 20, rnum >10

-- 1 page
-- start = 1 * 10 // end = (1-1) * 10
-- 2 page
-- start = 2 * 10 // end = (2-1) * 10
-- n page : 페이지 n번호 * 한 페이지 당 보여줄 게시물 수 / (페이지n번-1) * 한 페이지 당 보여줄 게시물 수
-- n * 10 // (n-1)*10

select *
from (select rownum AS rnum, A.*
		from (select bno, title, name, regdate, readcount, re_ref, re_lev, re_seq
				from board 
				where bno>0 order by re_ref desc, re_seq asc) A
		where rownum<=20)
where rnum > 10;

-- 검색

select *
from (select rownum AS rnum, A.*
		from (select bno, title, name, regdate, readcount, re_ref, re_lev, re_seq
				from board 
				where bno>0 and title like '%jsp%' order by re_ref desc, re_seq asc) A
		where rownum<=10)
where rnum>0;

