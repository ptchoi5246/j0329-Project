show tables;

create table coupang(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,
	ott			varchar(30) not null,
	genre		varchar(30) not null,
	open		int not null,							/* 개봉년도 */
	img     varchar(50) not null			/* 그림파일 제목 */
);

desc coupang;
--drop table coupang;

insert into coupang values (default, '하이드', 'Coupang Paly', '드라마', 2024,'DisneyMain.jpg');
insert into coupang values (default, '미끼', 'Coupang Paly', '드라마', 2023);
insert into coupang values (default, '소년시대', 'Coupang Paly', '드라마', 2023);
insert into coupang values (default, '사내연애', 'Coupang Paly', '예능', 2022);
insert into coupang values (default, '안나', 'Coupang Paly', '드라마', 2022);
insert into coupang values (default, '체인리액션', 'Coupang Paly', '예능', 2022);
insert into coupang values (default, 'SNL 코리아', 'Coupang Paly', '예능', 2021);
insert into coupang values (default, '어느날', 'Coupang Paly', '드라마', 2021);

select * from coupang;

--=============================================================================

create table disney(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,
	ott			varchar(30) not null,
	genre		varchar(30) not null,
	open		int not null
);

desc disney;
--drop table disney;

insert into disney values (default, '로얄로더', 'Disney Plus', '드라마', 2024);
insert into disney values (default, '원더풀월드', 'Disney Plus', '드라마', 2024);
insert into disney values (default, '재벌X형사', 'Disney Plus', '드라마', 2024);
insert into disney values (default, '킬러들의 쇼핑몰', 'Disney Plus', '드라마', 2024);
insert into disney values (default, '무빙', 'Disney Plus', '드라마', 2023);
insert into disney values (default, '비질란테', 'Disney Plus', '드라마', 2023);
insert into disney values (default, '악귀', 'Disney Plus', '드라마', 2023);
insert into disney values (default, '한강', 'Disney Plus', '드라마', 2023);
insert into disney values (default, '카지노', 'Disney Plus', '드라마', 2022);
insert into disney values (default, '형사록 시즌1', 'Disney Plus', '드라마', 2022);
insert into disney values (default, '형사록 시즌2', 'Disney Plus', '드라마', 2023);


select * from disney;

--=============================================================================

create table netflix(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,
	ott			varchar(30) not null,
	genre		varchar(30) not null,
	open		int not null
);

desc netflix;
--drop table neflix;

insert into netflix values (default, '닭강정', 'Netflix', '드라마', 2024);
insert into netflix values (default, '살인자ㅇ난감', 'Netflix', '드라마', 2024);
insert into netflix values (default, '스위트홈', 'Netflix', '드라마', 2024);
insert into netflix values (default, '마스크걸', 'Netflix', '드라마', 2023);
insert into netflix values (default, '이두나', 'Netflix', '드라마', 2023);
insert into netflix values (default, '피지컬100', 'Netflix', '예능', 2022);
insert into netflix values (default, '정신병동에도 아침이 와요', 'Netflix', '드라마', 2023);
insert into netflix values (default, 'DP', 'Netflix', '드라마', 2022);
insert into netflix values (default, '마이네임', 'Netflix', '드라마', 2022);
insert into netflix values (default, '소년심판', 'Netflix', '드라마', 2022);
insert into netflix values (default, '더글로리', 'Netflix', '드라마', 2022);
insert into netflix values (default, '솔로지옥 시즌 1', 'Netflix', '예능', 2021);
insert into netflix values (default, '솔로지옥 시즌 2', 'Netflix', '예능', 2022);
insert into netflix values (default, '솔로지옥 시즌 3', 'Netflix', '예능', 2023);
insert into netflix values (default, '킹덤 시즌 1', 'Netflix', '드라마', 2019);
insert into netflix values (default, '킹덤 시즌 2', 'Netflix', '드라마', 2020);
insert into netflix values (default, '킹덤 아신전', 'Netflix', '드라마', 2021);
insert into netflix values (default, '고요의 바다', 'Netflix', '드라마', 2021);
insert into netflix values (default, '길복순', 'Netflix', '영화', 2023);

select * from netflix;

--=============================================================================

create table tving(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,
	ott			varchar(30) not null,
	genre		varchar(30) not null,
	open		int not null
);

desc tving;
--drop table tving;

insert into tving values (default, '웨딩임파서블', 'Tving', '드라마', 2024);
insert into tving values (default, 'LTNS', 'Tving', '드라마', 2024);
insert into tving values (default, '피라미드게임', 'Tving', '드라마', 2024);
insert into tving values (default, '운수오진날', 'Tving', '드라마', 2023);
insert into tving values (default, '이재, 곧 죽습니다', 'Tving', '드라마', 2023);
insert into tving values (default, '유미의 세포들', 'Tving', '드라마', 2021);
insert into tving values (default, '술꾼 도시 여자들 시즌 1', 'Tving', '드라마', 2021);
insert into tving values (default, '술꾼 도시 여자들 시즌 2', 'Tving', '드라마', 2022);
insert into tving values (default, '환승연애 시즌 1', 'Tving', '예능', 2021);
insert into tving values (default, '환승연애 시즌 2', 'Tving', '예능', 2022);
insert into tving values (default, '환승연애 시즌 3', 'Tving', '예능', 2023);
insert into tving values (default, '러브캐처 인 서울', 'Tving', '예능', 2021);
insert into tving values (default, '러브캐처 인 발리', 'Tving', '예능', 2022);
insert into tving values (default, '유퀴즈 온 더 블럭', 'Tving', '예능', 2018);
insert into tving values (default, '하트시그널 시즌 1', 'Tving', '예능', 2017);
insert into tving values (default, '하트시그널 시즌 2', 'Tving', '예능', 2018);
insert into tving values (default, '하트시그널 시즌 3', 'Tving', '예능', 2020);
insert into tving values (default, '하트시그널 시즌 4', 'Tving', '예능', 2023);

select * from tving;

--=============================================================================

create table otttotal(
	idx			int not null auto_increment primary key,
	name		varchar(30) not null,
	ott			varchar(30) not null,
	genre		varchar(30) not null,
	open		int not null
);

desc otttotal;
--drop table otttotal;

insert into otttotal values (default, '하이드', 'Coupang Paly', '드라마', 2024);
insert into otttotal values (default, '미끼', 'Coupang Paly', '드라마', 2023);
insert into otttotal values (default, '소년시대', 'Coupang Paly', '드라마', 2023);
insert into otttotal values (default, '사내연애', 'Coupang Paly', '예능', 2022);
insert into otttotal values (default, '안나', 'Coupang Paly', '드라마', 2022);
insert into otttotal values (default, '체인리액션', 'Coupang Paly', '예능', 2022);
insert into otttotal values (default, 'SNL 코리아', 'Coupang Paly', '예능', 2021);
insert into otttotal values (default, '어느날', 'Coupang Paly', '드라마', 2021);
insert into otttotal values (default, '로얄로더', 'Disney Plus', '드라마', 2024);
insert into otttotal values (default, '원더풀월드', 'Disney Plus', '드라마', 2024);
insert into otttotal values (default, '재벌X형사', 'Disney Plus', '드라마', 2024);
insert into otttotal values (default, '킬러들의 쇼핑몰', 'Disney Plus', '드라마', 2024);
insert into otttotal values (default, '무빙', 'Disney Plus', '드라마', 2023);
insert into otttotal values (default, '비질란테', 'Disney Plus', '드라마', 2023);
insert into otttotal values (default, '악귀', 'Disney Plus', '드라마', 2023);
insert into otttotal values (default, '한강', 'Disney Plus', '드라마', 2023);
insert into otttotal values (default, '카지노', 'Disney Plus', '드라마', 2022);
insert into otttotal values (default, '형사록 시즌1', 'Disney Plus', '드라마', 2022);
insert into otttotal values (default, '형사록 시즌2', 'Disney Plus', '드라마', 2023);
insert into otttotal values (default, '닭강정', 'Netflix', '드라마', 2024);
insert into otttotal values (default, '살인자ㅇ난감', 'Netflix', '드라마', 2024);
insert into otttotal values (default, '스위트홈', 'Netflix', '드라마', 2024);
insert into otttotal values (default, '마스크걸', 'Netflix', '드라마', 2023);
insert into otttotal values (default, '이두나', 'Netflix', '드라마', 2023);
insert into otttotal values (default, '피지컬100', 'Netflix', '예능', 2022);
insert into otttotal values (default, '정신병동에도 아침이 와요', 'Netflix', '드라마', 2023);
insert into otttotal values (default, 'DP', 'Netflix', '드라마', 2022);
insert into otttotal values (default, '마이네임', 'Netflix', '드라마', 2022);
insert into otttotal values (default, '소년심판', 'Netflix', '드라마', 2022);
insert into otttotal values (default, '더글로리', 'Netflix', '드라마', 2022);
insert into otttotal values (default, '솔로지옥 시즌 1', 'Netflix', '예능', 2021);
insert into otttotal values (default, '솔로지옥 시즌 2', 'Netflix', '예능', 2022);
insert into otttotal values (default, '솔로지옥 시즌 3', 'Netflix', '예능', 2023);
insert into otttotal values (default, '킹덤 시즌 1', 'Netflix', '드라마', 2019);
insert into otttotal values (default, '킹덤 시즌 2', 'Netflix', '드라마', 2020);
insert into otttotal values (default, '킹덤 아신전', 'Netflix', '드라마', 2021);
insert into otttotal values (default, '고요의 바다', 'Netflix', '드라마', 2021);
insert into otttotal values (default, '길복순', 'Netflix', '영화', 2023);
insert into otttotal values (default, '웨딩임파서블', 'Tving', '드라마', 2024);
insert into otttotal values (default, 'LTNS', 'Tving', '드라마', 2024);
insert into otttotal values (default, '피라미드게임', 'Tving', '드라마', 2024);
insert into otttotal values (default, '운수오진날', 'Tving', '드라마', 2023);
insert into otttotal values (default, '이재, 곧 죽습니다', 'Tving', '드라마', 2023);
insert into otttotal values (default, '유미의 세포들', 'Tving', '드라마', 2021);
insert into otttotal values (default, '술꾼 도시 여자들 시즌 1', 'Tving', '드라마', 2021);
insert into otttotal values (default, '술꾼 도시 여자들 시즌 2', 'Tving', '드라마', 2022);
insert into otttotal values (default, '환승연애 시즌 1', 'Tving', '예능', 2021);
insert into otttotal values (default, '환승연애 시즌 2', 'Tving', '예능', 2022);
insert into otttotal values (default, '환승연애 시즌 3', 'Tving', '예능', 2023);
insert into otttotal values (default, '러브캐처 인 서울', 'Tving', '예능', 2021);
insert into otttotal values (default, '러브캐처 인 발리', 'Tving', '예능', 2022);
insert into otttotal values (default, '유퀴즈 온 더 블럭', 'Tving', '예능', 2018);
insert into otttotal values (default, '하트시그널 시즌 1', 'Tving', '예능', 2017);
insert into otttotal values (default, '하트시그널 시즌 2', 'Tving', '예능', 2018);
insert into otttotal values (default, '하트시그널 시즌 3', 'Tving', '예능', 2020);
insert into otttotal values (default, '하트시그널 시즌 4', 'Tving', '예능', 2023);
