create table MovieInfo (
title varchar2 (100) not null primary key, //영화 이름
infomation varchar2 (1000), // 개요
nation varchar2 (100), // 국가
runningTime number, // 상영시간
MovieDate date, //개봉 년월일 (values(to_date('2021-06-03')))
director varchar2 (100), // 감독
actor varchar2 (100), // 류현진, 박찬호 // 주연진
filmRate varchar2(100) // [국내]청소년 관람불가 // 등급
);