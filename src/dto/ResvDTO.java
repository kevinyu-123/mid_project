package dto;

public class ResvDTO {
	private String title,id,resvNo,resvDate,theater,seatNum,PaymentDay,payWith,adtTicket,cdrTicket;
	private int amount;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResvNo() {
		return resvNo;
	}
	public void setResvNo(String resvNo) {
		this.resvNo = resvNo;
	}
	public String getResvDate() {
		return resvDate;
	}
	public void setResvDate(String resvDate) {
		this.resvDate = resvDate;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public String getPaymentDay() {
		return PaymentDay;
	}
	public void setPaymentDay(String paymentDay) {
		PaymentDay = paymentDay;
	}
	public String getPayWith() {
		return payWith;
	}
	public void setPayWith(String payWith) {
		this.payWith = payWith;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAdtTicket() {
		return adtTicket;
	}
	public void setAdtTicket(String adtTicket) {
		this.adtTicket = adtTicket;
	}
	public String getCdrTicket() {
		return cdrTicket;
	}
	public void setCdrTicket(String cdrTicket) {
		this.cdrTicket = cdrTicket;
	}
}
