show tables;

create table ott(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,			/* 작품 이름 */
	ott			varchar(30) not null,			/* ott 종류 */
	genre		varchar(30) not null,			/* 장르 */
	open		int not null,							/* 개봉년도 */
	img     varchar(50) not null			/* 포스터 제목 */
);

desc ott;
--drop table ott;

--insert into ott values (default, '안나', 'Coupang Play', '드라마', 2022, '쿠팡플레이 안나.jpg');
insert into ott values (default, '하이드', 'Coupang Play', '드라마', 2024,'쿠팡플레이 하이드.jpg');
insert into ott values (default, 'SNL 코리아', 'Coupang Play', '예능', 2021, '쿠팡플레이 SNL 코리아.jpg');
insert into ott values (default, '소년시대', 'Coupang Play', '드라마', 2023, '쿠팡플레이 소년시대.jpg');
insert into ott values (default, '미끼', 'Coupang Play', '드라마', 2023, '쿠팡플레이 미끼.jpg');
insert into ott values (default, '사내연애', 'Coupang Play', '예능', 2022, '쿠팡플레이 사내연애.jpg');
insert into ott values (default, '체인리액션', 'Coupang Play', '예능', 2022, '쿠팡플레이 체인리액션.jpg');
insert into ott values (default, '어느날', 'Coupang Play', '드라마', 2021, '쿠팡플레이 어느날.jpg');
insert into ott values (default, '킬러들의 쇼핑몰', 'Disney Plus', '드라마', 2024, '디즈니 킬러들의쇼핑몰.jpg');
--insert into ott values (default, '무빙', 'Disney Plus', '드라마', 2023, '디즈니 무빙.jpg');
--insert into ott values (default, '카지노', 'Disney Plus', '드라마', 2022, '디즈니 카지노.jpg');
insert into ott values (default, '비질란테', 'Disney Plus', '드라마', 2023, '디즈니 비질란테.jpg');
insert into ott values (default, '로얄로더', 'Disney Plus', '드라마', 2024, '디즈니 로얄로더.jpg');
insert into ott values (default, '원더풀월드', 'Disney Plus', '드라마', 2024, '디즈니 원더풀월드.jpg');
insert into ott values (default, '재벌X형사', 'Disney Plus', '드라마', 2024, '디즈니 재벌형사.jpg');
insert into ott values (default, '악귀', 'Disney Plus', '드라마', 2023, '디즈니 악귀.jpg');
insert into ott values (default, '한강', 'Disney Plus', '드라마', 2023, '디즈니 한강.jpg');
insert into ott values (default, '형사록 시즌1', 'Disney Plus', '드라마', 2022, '디즈니 형사록.jpg');
insert into ott values (default, '형사록 시즌2', 'Disney Plus', '드라마', 2023, '디즈니 형사록2.jpg');
--insert into ott values (default, '살인자ㅇ난감', 'Netflix', '드라마', 2024, '넷플 살인자ㅇ난감.jpg');
--insert into ott values (default, '킹덤 시즌 1', 'Netflix', '드라마', 2019, '넷플 킹덤1.jpg');
--insert into ott values (default, '킹덤 시즌 2', 'Netflix', '드라마', 2020, '넷플 킹덤2.jpg');
--insert into ott values (default, '킹덤 아신전', 'Netflix', '드라마', 2021, '넷플 킹덤 아신전.jpg');
--insert into ott values (default, '더글로리', 'Netflix', '드라마', 2022, '넷플 더글로리.jpg');
insert into ott values (default, '정신병동에도 아침이 와요', 'Netflix', '드라마', 2023, '넷플 정신병동.jpg');
insert into ott values (default, '닭강정', 'Netflix', '드라마', 2024, '넷플 닭강정.jpg');
insert into ott values (default, '스위트홈', 'Netflix', '드라마', 2024, '넷플 스위트홈.jpg');
insert into ott values (default, '마스크걸', 'Netflix', '드라마', 2023, '넷플 마스크걸.jpg');
insert into ott values (default, '이두나', 'Netflix', '드라마', 2023, '넷플 이두나.jpg');
insert into ott values (default, '피지컬100', 'Netflix', '예능', 2022, '넷플 피지컬100.jpg');
insert into ott values (default, 'DP', 'Netflix', '드라마', 2022, '넷플 DP.jpg');
insert into ott values (default, '마이네임', 'Netflix', '드라마', 2022, '넷플 마이네임.jpg');
insert into ott values (default, '소년심판', 'Netflix', '드라마', 2022, '넷플 소년심판.jpg');
insert into ott values (default, '솔로지옥 시즌 1', 'Netflix', '예능', 2021, '넷플 솔로지옥.jpg');
insert into ott values (default, '솔로지옥 시즌 2', 'Netflix', '예능', 2022, '넷플 솔로지옥2.jpg');
insert into ott values (default, '솔로지옥 시즌 3', 'Netflix', '예능', 2023, '넷플 솔로지옥3.jpg');
insert into ott values (default, '고요의 바다', 'Netflix', '드라마', 2021, '넷플 고요의바다.jpg');
insert into ott values (default, '길복순', 'Netflix', '영화', 2023, '넷플 길복순.jpg');
--insert into ott values (default, '술꾼 도시 여자들 시즌 1', 'Tving', '드라마', 2021, '티빙 술꾼.jpg');
--insert into ott values (default, '술꾼 도시 여자들 시즌 2', 'Tving', '드라마', 2022, '티빙 술꾼2.jpg');
--insert into ott values (default, '환승연애 시즌 3', 'Tving', '예능', 2023, '티빙 환승연애3.jpg');
--insert into ott values (default, '피라미드게임', 'Tving', '드라마', 2024, '티빙 피라미드게임.jpg');
insert into ott values (default, '웨딩임파서블', 'Tving', '드라마', 2024, '티빙 웨딩임파서블.jpg');
insert into ott values (default, 'LTNS', 'Tving', '드라마', 2024, '티빙 LTNS.jpg');
insert into ott values (default, '운수오진날', 'Tving', '드라마', 2023, '티빙 운수오진날.jpg');
insert into ott values (default, '이재, 곧 죽습니다', 'Tving', '드라마', 2023, '티빙 이재.jpg');
insert into ott values (default, '유미의 세포들', 'Tving', '드라마', 2021, '티빙 유미의 세포들.jpg');
insert into ott values (default, '환승연애 시즌 1', 'Tving', '예능', 2021, '티빙 환승연애1.jpg');
insert into ott values (default, '환승연애 시즌 2', 'Tving', '예능', 2022, '티빙 환승연애2.jpg');
insert into ott values (default, '러브캐처 인 서울', 'Tving', '예능', 2021, '티빙 러브캐쳐 서울.jpg');
insert into ott values (default, '러브캐처 인 발리', 'Tving', '예능', 2022, '티빙 러브캐쳐 발리.jpg');
insert into ott values (default, '유퀴즈 온 더 블럭', 'Tving', '예능', 2018, '티빙 유퀴즈.jpg');
insert into ott values (default, '하트시그널 시즌 1', 'Tving', '예능', 2017, '티빙 하트시그널1.jpg');
insert into ott values (default, '하트시그널 시즌 2', 'Tving', '예능', 2018, '티빙 하트시그널2.jpg');
insert into ott values (default, '하트시그널 시즌 3', 'Tving', '예능', 2020, '티빙 하트시그널3.jpg');
--insert into ott values (default, '하트시그널 시즌 4', 'Tving', '예능', 2023, '티빙 하트시그널4.jpg');

select * from ott;

--=============================================================================================
/*
create table coupang(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,			/* 작품 이름 */
	ott			varchar(30) not null,			/* ott 종류 */
	genre		varchar(30) not null,			/* 장르 */
	open		int not null,							/* 개봉년도 */
	img     varchar(50) not null			/* 포스터 제목 */
);

desc coupang;
--drop table coupang;

insert into coupang values (default, '안나', 'Coupang Paly', '드라마', 2022, '쿠팡플레이 안나.jpg');
insert into coupang values (default, '하이드', 'Coupang Paly', '드라마', 2024,'쿠팡플레이 하이드.jpg');
insert into coupang values (default, 'SNL 코리아', 'Coupang Paly', '예능', 2021, '쿠팡플레이 SNL 코리아.jpg');
insert into coupang values (default, '소년시대', 'Coupang Paly', '드라마', 2023, '쿠팡플레이 소년시대.jpg');
insert into coupang values (default, '미끼', 'Coupang Paly', '드라마', 2023, '쿠팡플레이 미끼.jpg');
insert into coupang values (default, '사내연애', 'Coupang Paly', '예능', 2022, '쿠팡플레이 사내연애.jpg');
insert into coupang values (default, '체인리액션', 'Coupang Paly', '예능', 2022, '쿠팡플레이 체인리액션.jpg');
insert into coupang values (default, '어느날', 'Coupang Paly', '드라마', 2021, '쿠팡플레이 어느날.jpg');

select * from coupang;

--=============================================================================

create table disney(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,			/* 작품 이름 */
	ott			varchar(30) not null,			/* ott 종류 */
	genre		varchar(30) not null,			/* 장르 */
	open		int not null,							/* 개봉년도 */
	img     varchar(50) not null			/* 포스터 제목 */
);

desc disney;
--drop table disney;

insert into disney values (default, '킬러들의 쇼핑몰', 'Disney Plus', '드라마', 2024, '디즈니 킬러들의쇼핑몰.jpg');
insert into disney values (default, '무빙', 'Disney Plus', '드라마', 2023, '디즈니 무빙.jpg');
insert into disney values (default, '카지노', 'Disney Plus', '드라마', 2022, '디즈니 카지노.jpg');
insert into disney values (default, '비질란테', 'Disney Plus', '드라마', 2023, '디즈니 비질란테.jpg');
insert into disney values (default, '로얄로더', 'Disney Plus', '드라마', 2024, '디즈니 로얄로더.jpg');
insert into disney values (default, '원더풀월드', 'Disney Plus', '드라마', 2024, '디즈니 원더풀월드.jpg');
insert into disney values (default, '재벌X형사', 'Disney Plus', '드라마', 2024, '디즈니 재벌형사.jpg');
insert into disney values (default, '악귀', 'Disney Plus', '드라마', 2023, '디즈니 악귀.jpg');
insert into disney values (default, '한강', 'Disney Plus', '드라마', 2023, '디즈니 한강.jpg');
insert into disney values (default, '형사록 시즌1', 'Disney Plus', '드라마', 2022, '디즈니 형사록.jpg');
insert into disney values (default, '형사록 시즌2', 'Disney Plus', '드라마', 2023, '디즈니 형사록2.jpg');

select * from disney;

--=============================================================================

create table netflix(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,			/* 작품 이름 */
	ott			varchar(30) not null,			/* ott 종류 */
	genre		varchar(30) not null,			/* 장르 */
	open		int not null,							/* 개봉년도 */
	img     varchar(50) not null			/* 포스터 제목 */
);

desc netflix;
--drop table netflix;

insert into netflix values (default, '살인자ㅇ난감', 'Netflix', '드라마', 2024, '넷플 살인자ㅇ난감.jpg');
insert into netflix values (default, '킹덤 시즌 1', 'Netflix', '드라마', 2019, '넷플 킹덤1.jpg');
insert into netflix values (default, '킹덤 시즌 2', 'Netflix', '드라마', 2020, '넷플 킹덤2.jpg');
insert into netflix values (default, '킹덤 아신전', 'Netflix', '드라마', 2021, '넷플 킹덤 아신전.jpg');
insert into netflix values (default, '더글로리', 'Netflix', '드라마', 2022, '넷플 더글로리.jpg');
insert into netflix values (default, '정신병동에도 아침이 와요', 'Netflix', '드라마', 2023, '넷플 정신병동.jpg');
insert into netflix values (default, '닭강정', 'Netflix', '드라마', 2024, '넷플 닭강정.jpg');
insert into netflix values (default, '스위트홈', 'Netflix', '드라마', 2024, '넷플 스위트홈.jpg');
insert into netflix values (default, '마스크걸', 'Netflix', '드라마', 2023, '넷플 마스크걸.jpg');
insert into netflix values (default, '이두나', 'Netflix', '드라마', 2023, '넷플 이두나.jpg');
insert into netflix values (default, '피지컬100', 'Netflix', '예능', 2022, '넷플 피지컬100.jpg');
insert into netflix values (default, 'DP', 'Netflix', '드라마', 2022, '넷플 DP.jpg');
insert into netflix values (default, '마이네임', 'Netflix', '드라마', 2022, '넷플 마이네임.jpg');
insert into netflix values (default, '소년심판', 'Netflix', '드라마', 2022, '넷플 소년심판.jpg');
insert into netflix values (default, '솔로지옥 시즌 1', 'Netflix', '예능', 2021, '넷플 솔로지옥.jpg');
insert into netflix values (default, '솔로지옥 시즌 2', 'Netflix', '예능', 2022, '넷플 솔로지옥2.jpg');
insert into netflix values (default, '솔로지옥 시즌 3', 'Netflix', '예능', 2023, '넷플 솔로지옥3.jpg');
insert into netflix values (default, '고요의 바다', 'Netflix', '드라마', 2021, '넷플 고요의바다.jpg');
insert into netflix values (default, '길복순', 'Netflix', '영화', 2023, '넷플 길복순.jpg');

select * from netflix;

--=============================================================================

create table tving(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,			/* 작품 이름 */
	ott			varchar(30) not null,			/* ott 종류 */
	genre		varchar(30) not null,			/* 장르 */
	open		int not null,							/* 개봉년도 */
	img     varchar(50) not null			/* 포스터 제목 */
);

desc tving;
--drop table tving;

insert into tving values (default, '술꾼 도시 여자들 시즌 1', 'Tving', '드라마', 2021, '티빙 술꾼.jpg');
insert into tving values (default, '술꾼 도시 여자들 시즌 2', 'Tving', '드라마', 2022, '티빙 술꾼2.jpg');
insert into tving values (default, '환승연애 시즌 3', 'Tving', '예능', 2023, '티빙 환승연애3.jpg');
insert into tving values (default, '피라미드게임', 'Tving', '드라마', 2024, '티빙 피라미드게임.jpg');
insert into tving values (default, '웨딩임파서블', 'Tving', '드라마', 2024, '티빙 웨딩임파서블.jpg');
insert into tving values (default, 'LTNS', 'Tving', '드라마', 2024, '티빙 LTNS.jpg');
insert into tving values (default, '운수오진날', 'Tving', '드라마', 2023, '티빙 운수오진날.jpg');
insert into tving values (default, '이재, 곧 죽습니다', 'Tving', '드라마', 2023, '티빙 이재.jpg');
insert into tving values (default, '유미의 세포들', 'Tving', '드라마', 2021, '티빙 유미의 세포들.jpg');
insert into tving values (default, '환승연애 시즌 1', 'Tving', '예능', 2021, '티빙 환승연애1.jpg');
insert into tving values (default, '환승연애 시즌 2', 'Tving', '예능', 2022, '티빙 환승연애2.jpg');
insert into tving values (default, '러브캐처 인 서울', 'Tving', '예능', 2021, '티빙 러브캐쳐 서울.jpg');
insert into tving values (default, '러브캐처 인 발리', 'Tving', '예능', 2022, '티빙 러브캐쳐 발리.jpg');
insert into tving values (default, '유퀴즈 온 더 블럭', 'Tving', '예능', 2018, '티빙 유퀴즈.jpg');
insert into tving values (default, '하트시그널 시즌 1', 'Tving', '예능', 2017, '티빙 하트시그널1.jpg');
insert into tving values (default, '하트시그널 시즌 2', 'Tving', '예능', 2018, '티빙 하트시그널2.jpg');
insert into tving values (default, '하트시그널 시즌 3', 'Tving', '예능', 2020, '티빙 하트시그널3.jpg');
insert into tving values (default, '하트시그널 시즌 4', 'Tving', '예능', 2023, '티빙 하트시그널4.jpg');

select * from tving;
*/
--=============================================================================
