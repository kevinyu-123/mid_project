create table reservations (
title varchar2 (100) primary key, //영화 이름
numbering number, //예매 번호 (1111-2222-3333-4444)
dateOfViewing varchar2 (50), //관람 일시 (2012년 09월 01일)
theater varchar2 (50), // 관람 극장 (CGV or 메가박스 or 롯데시네마)
SeatNum varchar2 (50), // 관람 좌석 (A~G 1~12)
PaymentDay varchar2 (50), // 결제 날짜 (21년 09월 01일 01시 01분 01초)
ticket number, // 구매한 매수 
payWith varchar(50) // 결제 수단 (신용카드 or 카카오페이 or 휴대폰결제 or 무통장입금)
);