create table reservations (
title varchar2 (100) , //영화 이름
Id varchar(20), //회원 아이디
RESVNO VARCHAR2 (200) primary key, //예매 번호 (1111-2222-3333-4444)
RESEVDATE date, //관람 일시 (values(to_date('2021-06-03')))
theater varchar2 (50), // 관람 극장 (CGV or 메가박스 or 롯데시네마)
SeatNum varchar2 (50), // 관람 좌석 (A~G 1~12)
PaymentDay timestamp, // 결제 날짜 (values에 systimestamp 입력)
payWith varchar(50) // 결제 수단 (신용카드 or 카카오페이 or 휴대폰결제 or 무통장입금)
AMOUNT number // 결제 금액 (13000)
);