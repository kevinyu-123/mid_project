create table MovieInfo (
title varchar2 (100) not null primary key, //영화 이름
infomation varchar2 (900), // 개요
nation varchar2 (100), // 국가
runningTime varchar2 (30), // 상영시간
MovieDate varchar2 (50), // 2021년 5월 19일 //개봉 년월일
director varchar2 (50), // 감독
actor varchar2 (50), // 류현진, 박찬호 // 주연진
filmRate varchar2(50) // [국내]청소년 관람불가 // 등급
);