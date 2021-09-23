package dto;

import java.util.ArrayList;

public class ResvDTO {
	private String title,id,resvNo,resvDate,theater,PaymentDay,payWith;
	private ArrayList<String> seatNum;
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
	public ArrayList<String> getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(ArrayList<String> seatNum) {
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
