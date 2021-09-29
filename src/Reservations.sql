create table reservations (
title varchar2 (100) , //영화 이름
Id varchar(100), // 회원 아이디
RESVNO VARCHAR2 (100) primary key, //예매 번호 (1111-2222-3333-4444)
RESEVDATE date, //관람 일시 (values(to_date('20xx-xx-xx')))
theater varchar2 (100), // 관람 극장 (CGV or 메가박스 or 롯데시네마)
adtTicket number, // 성인 티켓 수
cdrTicket number, // 청소년 티켓 수
SeatNum varchar2 (100), // 관람 좌석 (A~G 1~12)
PaymentDay varchar2 (100), // 결제 날짜 values(to_char(systimestamp,'yyyy mm dd hh24:mm'))
payWith varchar2(100), // 결제 수단 (신용카드 or 카카오페이 or 휴대폰결제 or 무통장입금)
AMOUNT number // 결제 금액 (13000)
);