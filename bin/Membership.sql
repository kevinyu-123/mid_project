create table membership (
id varchar2(20) not null primary key, //아이디
password varchar2(20) not null, //비밀번호
email varchar2(20) not null, //이메일
name varchar2(20) not null, //이름
pwdQuestion varchar2(80), //비밀번호 찾기 질문(콤보버튼 사용!) 
pwdAnswer varchar2(80)); //비밀번호 찾기 답변
