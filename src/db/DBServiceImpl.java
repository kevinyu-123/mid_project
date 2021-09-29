package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import common.DBCommon;
import dto.MovieDTO;
import dto.ResvDTO;

public class DBServiceImpl implements DBService{
	String sql;
	int result;
	PreparedStatement ps;
	ResultSet rs;
	public void updateResv(ResvDTO dto) {
		sql = "insert into reservations values(?,?,?,?,?,?,?,?,?)";
		DBCommon.setDBConnection();
		Long datetime = System.currentTimeMillis();
		SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd.HH:mm:ss");
		String time = date.format(datetime);
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1,dto.getTitle());
			ps.setString(2,dto.getId());
			ps.setString(3,dto.getResvNo());
			ps.setInt(4,Integer.parseInt(dto.getAdtTicket()));
			ps.setInt(5,Integer.parseInt(dto.getCdrTicket()));
			ps.setString(6,dto.getSeatNum());
			ps.setString(7,time);
			ps.setString(8,dto.getPayWith());
			ps.setInt(9,dto.getAmount());
			result = ps.executeUpdate();
			if(result==1) {System.out.println("저장 성공");}
			else {System.out.println("저장 실패");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResvDTO getResv(String resvno) {
		sql = "Select * from reservations where Resvno = ?";
		DBCommon.setDBConnection();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, resvno);
			rs = ps.executeQuery();
			ResvDTO dto = new ResvDTO();
			if(rs.next()) {
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setResvNo(rs.getString("resvno"));
				dto.setAdtTicket(""+rs.getInt("AdtTicket"));
				dto.setCdrTicket(""+rs.getInt("CdtTicket"));
				dto.setSeatNum(rs.getString("SeatNum"));
				dto.setPaymentDay(rs.getString("Paymentday"));
				dto.setPayWith(rs.getString("paywith"));
				dto.setAmount(rs.getInt("amount"));
				System.out.println("배출 성공");
				return dto;
			}
			else System.out.println("저장된 resv 없음");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public MovieDTO selectSQL(String movieName) {
		String sql = "select * from movieinfo where title = ?";
		MovieDTO dto = null;
		DBCommon.setDBConnection();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, movieName);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto= new MovieDTO();
				dto.setTitle(rs.getString("title"));
				dto.setInfomation(rs.getString("infomation"));
				dto.setNation(rs.getString("nation"));
				dto.setDirector(rs.getString("director"));
				dto.setActor(rs.getString("actor"));
				dto.setFilmRate(rs.getString("filmrate"));
				dto.setMovieDate(rs.getString("movieDate"));
				dto.setRunningTime(rs.getInt("runningtime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (DBCommon.con != null)
					DBCommon.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	public ArrayList<String> getResvSeatnum() {
		String sql = "select seatnum from reservations;";
		String seatNum = null;
		ArrayList<String> allSeatNum = new ArrayList<String>();
		DBCommon.setDBConnection();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				allSeatNum.add(rs.getString(1));
			}
			return allSeatNum;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}