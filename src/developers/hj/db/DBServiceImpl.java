package developers.hj.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBCommon;
import dto.AdminDTO;
import dto.MemberDTO;
import dto.MovieDTO;
import dto.ResvDTO;

public class DBServiceImpl implements DBService {
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public AdminDTO getAdminInfo(String adminId) {
		String sql = "SELECT * FROM admin WHERE id=?";
		AdminDTO dto = null;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, adminId);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new AdminDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setMemNo(rs.getString("memno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public AdminDTO setInfo() {
		return null;
	}

	@Override
	public MemberDTO getMemInfo(String memName) {
		String sql = "SELECT * FROM membership WHERE name=?";
		MemberDTO dto = new MemberDTO();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, memName);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setEmail(rs.getString("email"));
				dto.setPwdQuestion(rs.getString("pwdquestion"));
				dto.setName(rs.getString("name"));
				dto.setPwdAnswer(rs.getString("pwdanswer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public ArrayList<MemberDTO> getAllInfo() {
		String sql = "SELECT * FROM membership";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			ps = DBCommon.con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setEmail(rs.getString("email"));
				dto.setPwdQuestion(rs.getString("pwdquestion"));
				dto.setName(rs.getString("name"));
				dto.setPwdAnswer(rs.getString("pwdanswer"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int setMoiveInfo(MovieDTO dto) {
		String sql = "INSERT INTO movieinfo values(?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getInfomation());
			ps.setString(3, dto.getNation());
			ps.setInt(4, dto.getRunningTime());
			Date date = java.sql.Date.valueOf(dto.getMovieDate());
			ps.setDate(5, date);
			ps.setString(6, dto.getDirector());
			ps.setString(7, dto.getActor());
			ps.setString(8, dto.getFilmRate());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public MovieDTO getMovieInfo(String movieName) {
		String sql = "SELECT * FROM movieinfo WHERE title=?";
		MovieDTO dto = null;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, movieName);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new MovieDTO();
				dto.setTitle(rs.getString("title"));
				dto.setInfomation(rs.getString("infomation"));
				dto.setActor(rs.getString("actor"));
				dto.setDirector(rs.getString("director"));
				dto.setFilmRate(rs.getString("filmrate"));
				dto.setRunningTime(rs.getInt("runningTime"));
				dto.setMovieDate(rs.getString("MovieDate"));
				dto.setNation(rs.getString("nation"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int deleteMovie(String name) {
		String sql = "DELETE FROM movieinfo WHERE title = ?";
		int result = 0;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, name);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResvDTO getResvINFO(String id) {
		String sql = "SELECT * FROM reservations where id = ?";
		ResvDTO dto = null;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, id);
			rs= ps.executeQuery();
			if(rs.next()) {
				dto = new ResvDTO();
				dto.setId(rs.getString("id"));
				dto.setAmount(rs.getInt("amount"));
				dto.setPaymentDay(rs.getString("paymentday"));
				dto.setPayWith(rs.getString("paywith"));
				dto.setTheater(rs.getString("theater"));
				dto.setResvDate(rs.getString("resevdate"));
				dto.setResvNo(rs.getString("resvno"));
				//dto.setSeatNum(rs.getString("seatnum"));
				dto.setTitle(rs.getString("title"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int deleteResv(String id) {
		String sql = "DELETE FROM reservations WHERE id = ?";
		int result = 0;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
