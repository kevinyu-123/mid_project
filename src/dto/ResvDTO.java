package dto;

public class ResvDTO {
	private String title,id,resvNo,resvDate,theater,PaymentDay,payWith,seatNum;
	private int amount,adtTicket,cdrTicket;
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
	public int getAdtTicket() {
		return adtTicket;
	}
	public void setAdtTicket(int adtTicket) {
		this.adtTicket = adtTicket;
	}
	public int getCdrTicket() {
		return cdrTicket;
	}
	public void setCdrTicket(int cdrTicket) {
		this.cdrTicket = cdrTicket;
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
}
