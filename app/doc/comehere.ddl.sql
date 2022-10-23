-- 회원
DROP TABLE IF EXISTS member RESTRICT;

-- 게시글
DROP TABLE IF EXISTS board RESTRICT;

-- 첨부파일
DROP TABLE IF EXISTS board_file RESTRICT;

-- 운동 분류
DROP TABLE IF EXISTS sports RESTRICT;

-- 운동 지역
DROP TABLE IF EXISTS region RESTRICT;

-- 모임
DROP TABLE IF EXISTS party RESTRICT;

-- 장소
DROP TABLE IF EXISTS location RESTRICT;

-- 모임후기
DROP TABLE IF EXISTS party_review RESTRICT;

-- 나의 목표
DROP TABLE IF EXISTS plan RESTRICT;

-- 댓글
DROP TABLE IF EXISTS board_comment RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS notice RESTRICT;

-- 1:1 문의
DROP TABLE IF EXISTS qna RESTRICT;

-- 관리자
DROP TABLE IF EXISTS admin RESTRICT;

-- 관심지역
DROP TABLE IF EXISTS favorite_region RESTRICT;

-- 관심 운동
DROP TABLE IF EXISTS favorite_sport RESTRICT;

-- 모임참여명단
DROP TABLE IF EXISTS party_members RESTRICT;

-- 모임 첨부파일
DROP TABLE IF EXISTS party_file RESTRICT;

-- 모임후기 첨부파일
DROP TABLE IF EXISTS party_review_file RESTRICT;

-- 모임 댓글
DROP TABLE IF EXISTS party_comment RESTRICT;

-- 장소후기 첨부파일
DROP TABLE IF EXISTS location_review_file RESTRICT;

-- 장소후기
DROP TABLE IF EXISTS location_review RESTRICT;

-- 알림
DROP TABLE IF EXISTS alert RESTRICT;

-- 게시글신고
DROP TABLE IF EXISTS board_tatlle RESTRICT;

-- 스크랩
DROP TABLE IF EXISTS scrap RESTRICT;

-- 회원신고
DROP TABLE IF EXISTS member_tatlle RESTRICT;

-- 게시글카테고리
DROP TABLE IF EXISTS board_category RESTRICT;

-- 댓글신고
DROP TABLE IF EXISTS comment_tatlle RESTRICT;

-- 공지사항 첨부파일
DROP TABLE IF EXISTS notice_file RESTRICT;

-- 신고사유 카테고리
DROP TABLE IF EXISTS tatlle_reason RESTRICT;

-- 신청처리
DROP TABLE IF EXISTS party_status RESTRICT;

-- 회원
CREATE TABLE member (
	mno      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	name     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	id       VARCHAR(20)  NOT NULL COMMENT '아이디', -- 아이디
	email    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	pwd      VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
	nick     VARCHAR(255) NOT NULL COMMENT '닉네임', -- 닉네임
	tel      INTEGER      NOT NULL COMMENT '휴대전화', -- 휴대전화
	bday     DATE         NOT NULL COMMENT '생년월일', -- 생년월일
	sex      BOOLEAN      NOT NULL COMMENT '성별', -- 성별
	filepath VARCHAR(255) NULL     COMMENT '파일경로', -- 파일경로
	cdt      DATETIME     NOT NULL DEFAULT now() COMMENT '등록일', -- 등록일
	act      BOOLEAN      NOT NULL DEFAULT 1 COMMENT '활성화여부', -- 활성화여부
	black    BOOLEAN      NOT NULL DEFAULT 0 COMMENT '블랙여부' -- 블랙여부
)
COMMENT '회원';

-- 회원
ALTER TABLE member
	ADD CONSTRAINT PK_member -- 회원 기본키
		PRIMARY KEY (
			mno -- 회원번호
		);

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_member
	ON member ( -- 회원
		email ASC -- 이메일
	);

-- 회원 유니크 인덱스2
CREATE UNIQUE INDEX UIX_member2
	ON member ( -- 회원
		nick ASC -- 닉네임
	);

-- 회원 유니크 인덱스3
CREATE UNIQUE INDEX UIX_member3
	ON member ( -- 회원
		id ASC -- 아이디
	);

-- 회원 인덱스
CREATE INDEX IX_member
	ON member( -- 회원
		name ASC -- 이름
	);

ALTER TABLE member
	MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 게시글
CREATE TABLE board (
	bno    INTEGER      NOT NULL COMMENT '게시글번호', -- 게시글번호
	cateno INTEGER      NOT NULL COMMENT '게시글카테고리번호', -- 게시글카테고리번호
	mno    INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	title  VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	act    BOOLEAN      NOT NULL DEFAULT 1 COMMENT '활성화여부', -- 활성화여부
	cont   MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	cdt    DATETIME     NOT NULL DEFAULT now() COMMENT '등록일', -- 등록일
	vw_cnt INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '게시글';

-- 게시글
ALTER TABLE board
	ADD CONSTRAINT PK_board -- 게시글 기본키
		PRIMARY KEY (
			bno -- 게시글번호
		);

ALTER TABLE board
	MODIFY COLUMN bno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글번호';

-- 첨부파일
CREATE TABLE board_file (
	bfno     INTEGER      NOT NULL COMMENT '첨부파일번호', -- 첨부파일번호
	filepath VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
	bno      INTEGER      NOT NULL COMMENT '게시글번호' -- 게시글번호
)
COMMENT '첨부파일';

-- 첨부파일
ALTER TABLE board_file
	ADD CONSTRAINT PK_board_file -- 첨부파일 기본키
		PRIMARY KEY (
			bfno -- 첨부파일번호
		);

ALTER TABLE board_file
	MODIFY COLUMN bfno INTEGER NOT NULL AUTO_INCREMENT COMMENT '첨부파일번호';

-- 운동 분류
CREATE TABLE sports (
	sno  INTEGER     NOT NULL COMMENT '운동일련번호', -- 운동일련번호
	name VARCHAR(50) NOT NULL COMMENT '운동 명' -- 운동 명
)
COMMENT '운동 분류';

-- 운동 분류
ALTER TABLE sports
	ADD CONSTRAINT PK_sports -- 운동 분류 기본키
		PRIMARY KEY (
			sno -- 운동일련번호
		);

ALTER TABLE sports
	MODIFY COLUMN sno INTEGER NOT NULL AUTO_INCREMENT COMMENT '운동일련번호';

-- 운동 지역
CREATE TABLE region (
	rno  INTEGER      NOT NULL COMMENT '지역일련번호', -- 지역일련번호
	sido VARCHAR(255) NOT NULL COMMENT '시/도', -- 시/도
	sigu VARCHAR(255) NOT NULL COMMENT '시/군/구' -- 시/군/구
)
COMMENT '운동 지역';

-- 운동 지역
ALTER TABLE region
	ADD CONSTRAINT PK_region -- 운동 지역 기본키
		PRIMARY KEY (
			rno -- 지역일련번호
		);

-- 운동 지역 인덱스
CREATE INDEX IX_region
	ON region( -- 운동 지역
		sigu ASC -- 시/군/구
	);

ALTER TABLE region
	MODIFY COLUMN rno INTEGER NOT NULL AUTO_INCREMENT COMMENT '지역일련번호';

-- 모임
CREATE TABLE party (
	pno     INTEGER      NOT NULL COMMENT '모임 일련번호', -- 모임 일련번호
	sno     INTEGER      NOT NULL COMMENT '운동일련번호', -- 운동일련번호
	lno     INTEGER      NOT NULL COMMENT '장소 일련번호', -- 장소 일련번호
	title   VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	act     BOOLEAN      NOT NULL DEFAULT 1 COMMENT '활성화여부', -- 활성화여부
	cont    MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	cdt     DATETIME     NOT NULL DEFAULT now() COMMENT '등록일', -- 등록일
	headcnt INTEGER      NOT NULL COMMENT '정원', -- 정원
	ptime   TIME         NOT NULL COMMENT '모임시간', -- 모임시간
	pdate   DATE         NOT NULL COMMENT '모임일' -- 모임일
)
COMMENT '모임';

-- 모임
ALTER TABLE party
	ADD CONSTRAINT PK_party -- 모임 기본키
		PRIMARY KEY (
			pno -- 모임 일련번호
		);

ALTER TABLE party
	MODIFY COLUMN pno INTEGER NOT NULL AUTO_INCREMENT COMMENT '모임 일련번호';

-- 장소
CREATE TABLE location (
	lno INTEGER NOT NULL COMMENT '장소 일련번호', -- 장소 일련번호
	rno INTEGER NOT NULL COMMENT '지역일련번호', -- 지역일련번호
	sno INTEGER NOT NULL COMMENT '운동일련번호' -- 운동일련번호
)
COMMENT '장소';

-- 장소
ALTER TABLE location
	ADD CONSTRAINT PK_location -- 장소 기본키
		PRIMARY KEY (
			lno -- 장소 일련번호
		);

ALTER TABLE location
	MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '장소 일련번호';

-- 모임후기
CREATE TABLE party_review (
	prno  INTEGER      NOT NULL COMMENT '후기 일련번호', -- 후기 일련번호
	mno   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	pno   INTEGER      NOT NULL COMMENT '모임 일련번호', -- 모임 일련번호
	star  DEC(3,2)     NOT NULL COMMENT '별점', -- 별점
	title VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	cont  MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	cdt   DATETIME     NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '모임후기';

-- 모임후기
ALTER TABLE party_review
	ADD CONSTRAINT PK_party_review -- 모임후기 기본키
		PRIMARY KEY (
			prno -- 후기 일련번호
		);

ALTER TABLE party_review
	MODIFY COLUMN prno INTEGER NOT NULL AUTO_INCREMENT COMMENT '후기 일련번호';

-- 나의 목표
CREATE TABLE plan (
	plno  INTEGER      NOT NULL COMMENT '계획 일련번호', -- 계획 일련번호
	mno   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	title VARCHAR(255) NOT NULL COMMENT '계획 명', -- 계획 명
	act   BOOLEAN      NOT NULL DEFAULT 0 COMMENT '달성여부', -- 달성여부
	dday  DATE         NULL     COMMENT '목표일', -- 목표일
	chl   DEC(5,2)     NOT NULL COMMENT '목표치' -- 목표치
)
COMMENT '나의 목표';

-- 나의 목표
ALTER TABLE plan
	ADD CONSTRAINT PK_plan -- 나의 목표 기본키
		PRIMARY KEY (
			plno -- 계획 일련번호
		);

ALTER TABLE plan
	MODIFY COLUMN plno INTEGER NOT NULL AUTO_INCREMENT COMMENT '계획 일련번호';

-- 댓글
CREATE TABLE board_comment (
	bcno INTEGER    NOT NULL COMMENT '댓글번호', -- 댓글번호
	bno  INTEGER    NOT NULL COMMENT '게시글번호', -- 게시글번호
	mno  INTEGER    NOT NULL COMMENT '회원번호', -- 회원번호
	cont MEDIUMTEXT NOT NULL COMMENT '내용', -- 내용
	act  BOOLEAN    NOT NULL DEFAULT 1 COMMENT '활성화여부', -- 활성화여부
	cdt  DATETIME   NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '댓글';

-- 댓글
ALTER TABLE board_comment
	ADD CONSTRAINT PK_board_comment -- 댓글 기본키
		PRIMARY KEY (
			bcno -- 댓글번호
		);

ALTER TABLE board_comment
	MODIFY COLUMN bcno INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글번호';

-- 공지사항
CREATE TABLE notice (
	nno    INTEGER      NOT NULL COMMENT '게시글번호', -- 게시글번호
	title  VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	cont   MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	cdt    DATETIME     NOT NULL DEFAULT now() COMMENT '등록일', -- 등록일
	vw_cnt INTEGER      NOT NULL DEFAULT 0 COMMENT '조회수' -- 조회수
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE notice
	ADD CONSTRAINT PK_notice -- 공지사항 기본키
		PRIMARY KEY (
			nno -- 게시글번호
		);

ALTER TABLE notice
	MODIFY COLUMN nno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글번호';

-- 1:1 문의
CREATE TABLE qna (
	qno   INTEGER      NOT NULL COMMENT '문의질문번호', -- 문의질문번호
	mno   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	title VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	act   BOOLEAN      NOT NULL DEFAULT 0 COMMENT '답변여부', -- 답변여부
	cont  MEDIUMTEXT   NOT NULL COMMENT '질문', -- 질문
	cdt   DATETIME     NOT NULL DEFAULT now() COMMENT '등록일', -- 등록일
	acont MEDIUMTEXT   NULL     COMMENT '답변', -- 답변
	adt   DATETIME     NULL     COMMENT '답변일' -- 답변일
)
COMMENT '1:1 문의';

-- 1:1 문의
ALTER TABLE qna
	ADD CONSTRAINT PK_qna -- 1:1 문의 기본키
		PRIMARY KEY (
			qno -- 문의질문번호
		);

ALTER TABLE qna
	MODIFY COLUMN qno INTEGER NOT NULL AUTO_INCREMENT COMMENT '문의질문번호';


-- 관리자
CREATE TABLE admin (
	adno  INTEGER      NOT NULL COMMENT '관리자번호', -- 관리자번호
	name  VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	id    VARCHAR(20)  NOT NULL COMMENT '아이디', -- 아이디
	email VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	pwd   VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
	cdt   DATETIME     NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '관리자';

-- 관리자
ALTER TABLE admin
	ADD CONSTRAINT PK_admin -- 관리자 기본키
		PRIMARY KEY (
			adno -- 관리자번호
		);

-- 관리자 유니크 인덱스
CREATE UNIQUE INDEX UIX_admin
	ON admin ( -- 관리자
		email ASC -- 이메일
	);

-- 관리자 인덱스
CREATE INDEX IX_admin
	ON admin( -- 관리자
		name ASC -- 이름
	);

ALTER TABLE admin
	MODIFY COLUMN adno INTEGER NOT NULL AUTO_INCREMENT COMMENT '관리자번호';

-- 관심지역
CREATE TABLE favorite_region (
	rno INTEGER NOT NULL COMMENT '지역일련번호', -- 지역일련번호
	mno INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '관심지역';

-- 관심지역
ALTER TABLE favorite_region
	ADD CONSTRAINT PK_favorite_region -- 관심지역 기본키
		PRIMARY KEY (
			rno, -- 지역일련번호
			mno  -- 회원번호
		);

-- 관심 운동
CREATE TABLE favorite_sport (
	sno INTEGER NOT NULL COMMENT '운동일련번호', -- 운동일련번호
	mno INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '관심 운동';

-- 관심 운동
ALTER TABLE favorite_sport
	ADD CONSTRAINT PK_favorite_sport -- 관심 운동 기본키
		PRIMARY KEY (
			sno, -- 운동일련번호
			mno  -- 회원번호
		);

-- 모임참여명단
CREATE TABLE party_members (
	mno  INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	pno  INTEGER NOT NULL COMMENT '모임 일련번호', -- 모임 일련번호
	psno INTEGER NOT NULL COMMENT '신청처리번호', -- 신청처리번호
	auth BOOLEAN NOT NULL COMMENT '권한' -- 권한
)
COMMENT '모임참여명단';

-- 모임참여명단
ALTER TABLE party_members
	ADD CONSTRAINT PK_party_members -- 모임참여명단 기본키
		PRIMARY KEY (
			mno, -- 회원번호
			pno  -- 모임 일련번호
		);

-- 모임 첨부파일
CREATE TABLE party_file (
	pfno     INTEGER      NOT NULL COMMENT '모임첨부번호', -- 모임첨부번호
	filepath VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
	pno      INTEGER      NOT NULL COMMENT '모임 일련번호' -- 모임 일련번호
)
COMMENT '모임 첨부파일';

-- 모임 첨부파일
ALTER TABLE party_file
	ADD CONSTRAINT PK_party_file -- 모임 첨부파일 기본키
		PRIMARY KEY (
			pfno -- 모임첨부번호
		);

ALTER TABLE party_file
	MODIFY COLUMN pfno INTEGER NOT NULL AUTO_INCREMENT COMMENT '모임첨부번호';

-- 모임후기 첨부파일
CREATE TABLE party_review_file (
	prfno    INTEGER      NOT NULL COMMENT '모임후기첨부번호', -- 모임후기첨부번호
	filepath VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
	prno     INTEGER      NOT NULL COMMENT '후기 일련번호' -- 후기 일련번호
)
COMMENT '모임후기 첨부파일';

-- 모임후기 첨부파일
ALTER TABLE party_review_file
	ADD CONSTRAINT PK_party_review_file -- 모임후기 첨부파일 기본키
		PRIMARY KEY (
			prfno -- 모임후기첨부번호
		);

ALTER TABLE party_review_file
	MODIFY COLUMN prfno INTEGER NOT NULL AUTO_INCREMENT COMMENT '모임후기첨부번호';

-- 모임 댓글
CREATE TABLE party_comment (
	pcno INTEGER    NOT NULL COMMENT '모임댓글번호', -- 모임댓글번호
	mno  INTEGER    NOT NULL COMMENT '회원번호', -- 회원번호
	pno  INTEGER    NOT NULL COMMENT '모임 일련번호', -- 모임 일련번호
	cont MEDIUMTEXT NOT NULL COMMENT '내용', -- 내용
	cdt  DATETIME   NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '모임 댓글';

-- 모임 댓글
ALTER TABLE party_comment
	ADD CONSTRAINT PK_party_comment -- 모임 댓글 기본키
		PRIMARY KEY (
			pcno -- 모임댓글번호
		);

ALTER TABLE party_comment
	MODIFY COLUMN pcno INTEGER NOT NULL AUTO_INCREMENT COMMENT '모임댓글번호';

-- 장소후기 첨부파일
CREATE TABLE location_review_file (
	lrfno    INTEGER      NOT NULL COMMENT '장소후기첨부번호', -- 장소후기첨부번호
	filepath VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
	lrno     INTEGER      NOT NULL COMMENT '후기 일련번호' -- 후기 일련번호
)
COMMENT '장소후기 첨부파일';

-- 장소후기 첨부파일
ALTER TABLE location_review_file
	ADD CONSTRAINT PK_location_review_file -- 장소후기 첨부파일 기본키
		PRIMARY KEY (
			lrfno -- 장소후기첨부번호
		);

ALTER TABLE location_review_file
	MODIFY COLUMN lrfno INTEGER NOT NULL AUTO_INCREMENT COMMENT '장소후기첨부번호';

-- 장소후기
CREATE TABLE location_review (
	lrno  INTEGER      NOT NULL COMMENT '후기 일련번호', -- 후기 일련번호
	mno   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	pno   INTEGER      NOT NULL COMMENT '모임 일련번호', -- 모임 일련번호
	title VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	cont  MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	star  DEC(3,2)     NOT NULL COMMENT '별점', -- 별점
	cdt   DATETIME     NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '장소후기';

-- 장소후기
ALTER TABLE location_review
	ADD CONSTRAINT PK_location_review -- 장소후기 기본키
		PRIMARY KEY (
			lrno -- 후기 일련번호
		);

ALTER TABLE location_review
	MODIFY COLUMN lrno INTEGER NOT NULL AUTO_INCREMENT COMMENT '후기 일련번호';

-- 알림
CREATE TABLE alert (
	alno    INTEGER    NOT NULL COMMENT '알림번호', -- 알림번호
	mno     INTEGER    NOT NULL COMMENT '회원번호', -- 회원번호
	cont    MEDIUMTEXT NOT NULL COMMENT '내용', -- 내용
	aldt    DATETIME   NOT NULL DEFAULT now() COMMENT '알림시간', -- 알림시간
	alcheck BOOLEAN    NOT NULL DEFAULT 0 COMMENT '읽음표시' -- 읽음표시
)
COMMENT '알림';

-- 알림
ALTER TABLE alert
	ADD CONSTRAINT PK_alert -- 알림 기본키
		PRIMARY KEY (
			alno -- 알림번호
		);

ALTER TABLE alert
	MODIFY COLUMN alno INTEGER NOT NULL AUTO_INCREMENT COMMENT '알림번호';

-- 게시글신고
CREATE TABLE board_tatlle (
	btno   INTEGER    NOT NULL COMMENT '신고번호', -- 신고번호
	mno    INTEGER    NOT NULL COMMENT '신고자', -- 신고자
	decbno INTEGER    NOT NULL COMMENT '신고대상글', -- 신고대상글
	trno   INTEGER    NOT NULL COMMENT '신고사유번호', -- 신고사유번호
	tdt    DATETIME   NOT NULL DEFAULT now() COMMENT '신고일', -- 신고일
	cont   MEDIUMTEXT NULL     COMMENT '처리내용', -- 처리내용
	comdt  DATETIME   NULL     COMMENT '처리일' -- 처리일
)
COMMENT '게시글신고';

-- 게시글신고
ALTER TABLE board_tatlle
	ADD CONSTRAINT PK_board_tatlle -- 게시글신고 기본키
		PRIMARY KEY (
			btno -- 신고번호
		);

ALTER TABLE board_tatlle
	MODIFY COLUMN btno INTEGER NOT NULL AUTO_INCREMENT COMMENT '신고번호';

-- 스크랩
CREATE TABLE scrap (
	mno INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	bno INTEGER NOT NULL COMMENT '게시글번호' -- 게시글번호
)
COMMENT '스크랩';

-- 스크랩
ALTER TABLE scrap
	ADD CONSTRAINT PK_scrap -- 스크랩 기본키
		PRIMARY KEY (
			mno, -- 회원번호
			bno  -- 게시글번호
		);

-- 회원신고
CREATE TABLE member_tatlle (
	mtno  INTEGER    NOT NULL COMMENT '신고번호', -- 신고번호
	mnoee INTEGER    NOT NULL COMMENT '신고자회원번호', -- 신고자회원번호
	mnoer INTEGER    NOT NULL COMMENT '피신고자회원번호', -- 피신고자회원번호
	trno  INTEGER    NOT NULL COMMENT '신고사유번호', -- 신고사유번호
	tdt   DATETIME   NOT NULL DEFAULT now() COMMENT '신고일', -- 신고일
	cont  MEDIUMTEXT NULL     COMMENT '처리내용', -- 처리내용
	comdt DATETIME   NULL     COMMENT '처리일' -- 처리일
)
COMMENT '회원신고';

-- 회원신고
ALTER TABLE member_tatlle
	ADD CONSTRAINT PK_member_tatlle -- 회원신고 기본키
		PRIMARY KEY (
			mtno -- 신고번호
		);

ALTER TABLE member_tatlle
	MODIFY COLUMN mtno INTEGER NOT NULL AUTO_INCREMENT COMMENT '신고번호';

-- 게시글카테고리
CREATE TABLE board_category (
	cateno INTEGER      NOT NULL COMMENT '게시글카테고리번호', -- 게시글카테고리번호
	name   VARCHAR(255) NOT NULL COMMENT '게시글카테고리명' -- 게시글카테고리명
)
COMMENT '게시글카테고리';

-- 게시글카테고리
ALTER TABLE board_category
	ADD CONSTRAINT PK_board_category -- 게시글카테고리 기본키
		PRIMARY KEY (
			cateno -- 게시글카테고리번호
		);

ALTER TABLE board_category
	MODIFY COLUMN cateno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글카테고리번호';

-- 댓글신고
CREATE TABLE comment_tatlle (
	ctno  INTEGER    NOT NULL COMMENT '신고번호', -- 신고번호
	mno   INTEGER    NOT NULL COMMENT '신고자', -- 신고자
	bcno  INTEGER    NOT NULL COMMENT '댓글번호', -- 댓글번호
	trno  INTEGER    NOT NULL COMMENT '신고사유번호', -- 신고사유번호
	tdt   DATETIME   NOT NULL DEFAULT now() COMMENT '신고일', -- 신고일
	cont  MEDIUMTEXT NULL     COMMENT '처리내용', -- 처리내용
	comdt DATETIME   NULL     COMMENT '처리일' -- 처리일
)
COMMENT '댓글신고';

-- 댓글신고
ALTER TABLE comment_tatlle
	ADD CONSTRAINT PK_comment_tatlle -- 댓글신고 기본키
		PRIMARY KEY (
			ctno -- 신고번호
		);

ALTER TABLE comment_tatlle
	MODIFY COLUMN ctno INTEGER NOT NULL AUTO_INCREMENT COMMENT '신고번호';

-- 공지사항 첨부파일
CREATE TABLE notice_file (
	nfno     INTEGER      NOT NULL COMMENT '첨부파일번호', -- 첨부파일번호
	filepath VARCHAR(255) NOT NULL COMMENT '파일경로', -- 파일경로
	nno      INTEGER      NULL     COMMENT '게시글번호' -- 게시글번호
)
COMMENT '공지사항 첨부파일';

-- 공지사항 첨부파일
ALTER TABLE notice_file
	ADD CONSTRAINT PK_notice_file -- 공지사항 첨부파일 기본키
		PRIMARY KEY (
			nfno -- 첨부파일번호
		);

-- 신고사유 카테고리
CREATE TABLE tatlle_reason (
	trno   INTEGER      NOT NULL COMMENT '신고사유번호', -- 신고사유번호
	reason VARCHAR(255) NOT NULL COMMENT '신고사유' -- 신고사유
)
COMMENT '신고사유 카테고리';

-- 신고사유 카테고리
ALTER TABLE tatlle_reason
	ADD CONSTRAINT PK_tatlle_reason -- 신고사유 카테고리 기본키
		PRIMARY KEY (
			trno -- 신고사유번호
		);

-- 신청처리
CREATE TABLE party_status (
	psno   INTEGER      NOT NULL COMMENT '신청처리번호', -- 신청처리번호
	status VARCHAR(255) NOT NULL COMMENT '처리상태' -- 처리상태
)
COMMENT '신청처리';

-- 신청처리
ALTER TABLE party_status
	ADD CONSTRAINT PK_party_status -- 신청처리 기본키
		PRIMARY KEY (
			psno -- 신청처리번호
		);

-- 게시글
ALTER TABLE board
	ADD CONSTRAINT FK_member_TO_board -- 회원 -> 게시글
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 게시글
ALTER TABLE board
	ADD CONSTRAINT FK_board_category_TO_board -- 게시글카테고리 -> 게시글
		FOREIGN KEY (
			cateno -- 게시글카테고리번호
		)
		REFERENCES board_category ( -- 게시글카테고리
			cateno -- 게시글카테고리번호
		);

-- 첨부파일
ALTER TABLE board_file
	ADD CONSTRAINT FK_board_TO_board_file -- 게시글 -> 첨부파일
		FOREIGN KEY (
			bno -- 게시글번호
		)
		REFERENCES board ( -- 게시글
			bno -- 게시글번호
		);

-- 모임
ALTER TABLE party
	ADD CONSTRAINT FK_sports_TO_party -- 운동 분류 -> 모임
		FOREIGN KEY (
			sno -- 운동일련번호
		)
		REFERENCES sports ( -- 운동 분류
			sno -- 운동일련번호
		);

-- 모임
ALTER TABLE party
	ADD CONSTRAINT FK_location_TO_party -- 장소 -> 모임
		FOREIGN KEY (
			lno -- 장소 일련번호
		)
		REFERENCES location ( -- 장소
			lno -- 장소 일련번호
		);

-- 장소
ALTER TABLE location
	ADD CONSTRAINT FK_region_TO_location -- 운동 지역 -> 장소
		FOREIGN KEY (
			rno -- 지역일련번호
		)
		REFERENCES region ( -- 운동 지역
			rno -- 지역일련번호
		);

-- 장소
ALTER TABLE location
	ADD CONSTRAINT FK_sports_TO_location -- 운동 분류 -> 장소
		FOREIGN KEY (
			sno -- 운동일련번호
		)
		REFERENCES sports ( -- 운동 분류
			sno -- 운동일련번호
		);

-- 모임후기
ALTER TABLE party_review
	ADD CONSTRAINT FK_party_members_TO_party_review -- 모임참여명단 -> 모임후기
		FOREIGN KEY (
			mno, -- 회원번호
			pno  -- 모임 일련번호
		)
		REFERENCES party_members ( -- 모임참여명단
			mno, -- 회원번호
			pno  -- 모임 일련번호
		);

-- 나의 목표
ALTER TABLE plan
	ADD CONSTRAINT FK_member_TO_plan -- 회원 -> 나의 목표
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 댓글
ALTER TABLE board_comment
	ADD CONSTRAINT FK_board_TO_board_comment -- 게시글 -> 댓글
		FOREIGN KEY (
			bno -- 게시글번호
		)
		REFERENCES board ( -- 게시글
			bno -- 게시글번호
		);

-- 댓글
ALTER TABLE board_comment
	ADD CONSTRAINT FK_member_TO_board_comment -- 회원 -> 댓글
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 1:1 문의
ALTER TABLE qna
	ADD CONSTRAINT FK_member_TO_qna -- 회원 -> 1:1 문의
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 관심지역
ALTER TABLE favorite_region
	ADD CONSTRAINT 
		FOREIGN KEY (
			rno -- 지역일련번호
		)
		REFERENCES region ( -- 운동 지역
			rno -- 지역일련번호
		);

-- 관심지역
ALTER TABLE favorite_region
	ADD CONSTRAINT FK_member_TO_favorite_region -- 회원 -> 관심지역
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 관심 운동
ALTER TABLE favorite_sport
	ADD CONSTRAINT 
		FOREIGN KEY (
			sno -- 운동일련번호
		)
		REFERENCES sports ( -- 운동 분류
			sno -- 운동일련번호
		);

-- 관심 운동
ALTER TABLE favorite_sport
	ADD CONSTRAINT FK_member_TO_favorite_sport -- 회원 -> 관심 운동
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 모임참여명단
ALTER TABLE party_members
	ADD CONSTRAINT FK_member_TO_party_members -- 회원 -> 모임참여명단
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 모임참여명단
ALTER TABLE party_members
	ADD CONSTRAINT FK_party_TO_party_members -- 모임 -> 모임참여명단
		FOREIGN KEY (
			pno -- 모임 일련번호
		)
		REFERENCES party ( -- 모임
			pno -- 모임 일련번호
		);

-- 모임참여명단
ALTER TABLE party_members
	ADD CONSTRAINT FK_party_status_TO_party_members -- 신청처리 -> 모임참여명단
		FOREIGN KEY (
			psno -- 신청처리번호
		)
		REFERENCES party_status ( -- 신청처리
			psno -- 신청처리번호
		);

-- 모임 첨부파일
ALTER TABLE party_file
	ADD CONSTRAINT FK_party_TO_party_file -- 모임 -> 모임 첨부파일
		FOREIGN KEY (
			pno -- 모임 일련번호
		)
		REFERENCES party ( -- 모임
			pno -- 모임 일련번호
		);

-- 모임후기 첨부파일
ALTER TABLE party_review_file
	ADD CONSTRAINT FK_party_review_TO_party_review_file -- 모임후기 -> 모임후기 첨부파일
		FOREIGN KEY (
			prno -- 후기 일련번호
		)
		REFERENCES party_review ( -- 모임후기
			prno -- 후기 일련번호
		);

-- 모임 댓글
ALTER TABLE party_comment
	ADD CONSTRAINT FK_party_TO_party_comment -- 모임 -> 모임 댓글
		FOREIGN KEY (
			pno -- 모임 일련번호
		)
		REFERENCES party ( -- 모임
			pno -- 모임 일련번호
		);

-- 모임 댓글
ALTER TABLE party_comment
	ADD CONSTRAINT FK_member_TO_party_comment -- 회원 -> 모임 댓글
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 장소후기 첨부파일
ALTER TABLE location_review_file
	ADD CONSTRAINT FK_location_review_TO_location_review_file -- 장소후기 -> 장소후기 첨부파일
		FOREIGN KEY (
			lrno -- 후기 일련번호
		)
		REFERENCES location_review ( -- 장소후기
			lrno -- 후기 일련번호
		);

-- 장소후기
ALTER TABLE location_review
	ADD CONSTRAINT FK_party_members_TO_location_review -- 모임참여명단 -> 장소후기
		FOREIGN KEY (
			mno, -- 회원번호
			pno  -- 모임 일련번호
		)
		REFERENCES party_members ( -- 모임참여명단
			mno, -- 회원번호
			pno  -- 모임 일련번호
		);

-- 알림
ALTER TABLE alert
	ADD CONSTRAINT FK_member_TO_alert -- 회원 -> 알림
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 게시글신고
ALTER TABLE board_tatlle
	ADD CONSTRAINT FK_member_TO_board_tatlle -- 회원 -> 게시글신고
		FOREIGN KEY (
			mno -- 신고자
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 게시글신고
ALTER TABLE board_tatlle
	ADD CONSTRAINT FK_board_TO_board_tatlle -- 게시글 -> 게시글신고
		FOREIGN KEY (
			decbno -- 신고대상글
		)
		REFERENCES board ( -- 게시글
			bno -- 게시글번호
		);

-- 게시글신고
ALTER TABLE board_tatlle
	ADD CONSTRAINT FK_tatlle_reason_TO_board_tatlle -- 신고사유 카테고리 -> 게시글신고
		FOREIGN KEY (
			trno -- 신고사유번호
		)
		REFERENCES tatlle_reason ( -- 신고사유 카테고리
			trno -- 신고사유번호
		);

-- 스크랩
ALTER TABLE scrap
	ADD CONSTRAINT FK_member_TO_scrap -- 회원 -> 스크랩
		FOREIGN KEY (
			mno -- 회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 스크랩
ALTER TABLE scrap
	ADD CONSTRAINT FK_board_TO_scrap -- 게시글 -> 스크랩
		FOREIGN KEY (
			bno -- 게시글번호
		)
		REFERENCES board ( -- 게시글
			bno -- 게시글번호
		);

-- 회원신고
ALTER TABLE member_tatlle
	ADD CONSTRAINT FK_member_TO_member_tatlle -- 회원 -> 회원신고
		FOREIGN KEY (
			mnoee -- 신고자회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 회원신고
ALTER TABLE member_tatlle
	ADD CONSTRAINT FK_member_TO_member_tatlle2 -- 회원 -> 회원신고2
		FOREIGN KEY (
			mnoer -- 피신고자회원번호
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 회원신고
ALTER TABLE member_tatlle
	ADD CONSTRAINT FK_tatlle_reason_TO_member_tatlle -- 신고사유 카테고리 -> 회원신고
		FOREIGN KEY (
			trno -- 신고사유번호
		)
		REFERENCES tatlle_reason ( -- 신고사유 카테고리
			trno -- 신고사유번호
		);

-- 댓글신고
ALTER TABLE comment_tatlle
	ADD CONSTRAINT FK_member_TO_comment_tatlle -- 회원 -> 댓글신고
		FOREIGN KEY (
			mno -- 신고자
		)
		REFERENCES member ( -- 회원
			mno -- 회원번호
		);

-- 댓글신고
ALTER TABLE comment_tatlle
	ADD CONSTRAINT FK_board_comment_TO_comment_tatlle -- 댓글 -> 댓글신고
		FOREIGN KEY (
			bcno -- 댓글번호
		)
		REFERENCES board_comment ( -- 댓글
			bcno -- 댓글번호
		);

-- 댓글신고
ALTER TABLE comment_tatlle
	ADD CONSTRAINT FK_tatlle_reason_TO_comment_tatlle -- 신고사유 카테고리 -> 댓글신고
		FOREIGN KEY (
			trno -- 신고사유번호
		)
		REFERENCES tatlle_reason ( -- 신고사유 카테고리
			trno -- 신고사유번호
		);

-- 공지사항 첨부파일
ALTER TABLE notice_file
	ADD CONSTRAINT FK_notice_TO_notice_file -- 공지사항 -> 공지사항 첨부파일
		FOREIGN KEY (
			nno -- 게시글번호
		)
		REFERENCES notice ( -- 공지사항
			nno -- 게시글번호
		);