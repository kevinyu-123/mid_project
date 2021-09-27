package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.DBCommon;
import dto.ResvDTO;

public class DBServiceImpl implements DBService{
	String sql;
	int result;
	PreparedStatement ps;
	ResultSet rs;
	public void updateResv(ResvDTO dto) {
		sql = "update reservations set "
				+ "ResvNo = ?,"
				+ "adtTicket = ?,"
				+ "cdrTicket = ?,"
				+ "seatNum = ?,"
				+ "PaymentDay = ?,"
				+ "payWith = ?,"
				+ "amount = ?"
				+ "where id = ?";
		DBCommon.setDBConnection();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1,dto.getResvNo());
			ps.setInt(2,dto.getAdtTicket());
			ps.setInt(3,dto.getCdrTicket());
			ps.setString(4,dto.getSeatNum());
			ps.setString(5,"to_char(systimestamp,'yyyy mm dd hh24:mm')");
			ps.setString(6,dto.getPayWith());
			ps.setInt(7,dto.getAmount());
			ps.setString(8,dto.getId());
			result = ps.executeUpdate();
			if(result==1) {System.out.println("저장 성공");}
			else {System.out.println("저장 실패");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResvDTO toIdgetResv(String id) {
		sql = "Select * from reservations where id = ?";
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			ResvDTO dto = new ResvDTO();
			if(rs.next()) {
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setResvNo(rs.getString("resvno"));
				dto.setResvDate(rs.getString("resevdate"));
				dto.setTheater(rs.getString("theater"));
				dto.setAdtTicket(rs.getInt("AdtTicket"));
				dto.setCdrTicket(rs.getInt("CdtTicket"));
				dto.setSeatNum(rs.getString("SeatNum"));
				dto.setPaymentDay(rs.getString("Paymentday"));
				dto.setPayWith(rs.getString("paywith"));
				dto.setAmount(rs.getInt("amount"));
				System.out.println("배출 성공");
				return dto;
			}
			else System.out.println("저장된 id 없음");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}