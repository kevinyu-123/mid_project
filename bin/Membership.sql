create table membership (
id varchar2(100) primary key, //아이디
password varchar2(100) , //비밀번호
email varchar2(100) , //이메일
name varchar2(100) , //이름
pwdQuestion varchar2(1000), //비밀번호 찾기 질문(콤보버튼 사용!) 
pwdAnswer varchar2(1000)); //비밀번호 찾기 답변
