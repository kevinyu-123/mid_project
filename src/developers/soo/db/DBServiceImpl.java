package developers.soo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBCommon;
import dto.MemberDTO;
import dto.ResvDTO;

public class DBServiceImpl implements DBService {
	PreparedStatement ps;		
	ResultSet rs;		
	@Override
	public int DBSave(MemberDTO memdto) {
		// 연결이 됐는지 확인
				System.out.println("DB에 회원가입 합니다.");
				// 회원가입 할 sql문구 삽입
				String sql = "insert into membership values(?,?,?,?,?,?)";
				// try- catch로 ps에 sql을 넣기
				int result = 0;
				try {
					ps = DBCommon.con.prepareStatement(sql);
					// ps.set(내가 설정한 변수형태)로 아까 sql ? 에 넣을 값 설정
					ps.setString(1	, memdto.getId());
					ps.setString(2	, memdto.getPassword());
					ps.setString(3, memdto.getEmail());
					ps.setString(4, memdto.getName());
					ps.setString(5, memdto.getPwdQuestion());
					ps.setString(6, memdto.getPwdAnswer());
					// SELECT를 제외한 나머지 명령어는 executeUpdate()로 실행
					// executeUpdate로 돌려주는 값은 성공 시 1 , 실패 시 0, 또는 exception 발생
					result = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
	}

	@Override
	public MemberDTO loginCheck(String userId) {
		System.out.println("DB에 로그인이 되는지 확인합니다. ");
		String sql = "SELECT * FROM membership WHERE id=?";
		MemberDTO memdto = null;
		
		try {
			ps = DBCommon.con.prepareStatement(sql);
			ps.setString(1, userId);
			// SELECT는 executeQuery로 처리한다.
			// 성공 시 데이터를 가져오고, 실패 시 
			rs = ps.executeQuery();
			if (rs.next()) {		// rs.next() == db에 값이존재하니??
				memdto = new MemberDTO();
				memdto.setId(rs.getString("id"));
				memdto.setPassword(rs.getString("password"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memdto;
	}
		@Override
		public MemberDTO idCheck(String userId) {
			String sql = "SELECT * FROM membership WHERE id=?";
			
			MemberDTO memdto = null;
			try {
				ps =DBCommon.con.prepareStatement(sql);
				ps.setString(1, userId);
				// SELECT는 executeQuery로 처리한다.
				// 성공 시 데이터를 가져오고, 실패 시 
				rs = ps.executeQuery();
				if (rs.next()) {		// rs.next() == db에 값이존재하니??
					memdto = new MemberDTO();
					memdto.setId(rs.getString("id"));
					memdto.setPwdQuestion(rs.getString("pwdquestion"));
					memdto.setPwdAnswer(rs.getString("pwdanswer"));
					memdto.setPassword(rs.getString("password"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return memdto;
		}

		@Override
		public MemberDTO myPage(String userId) {
			String sql = "SELECT * FROM membership WHERE id=?";
			
			MemberDTO memdto = null;
			try {
				ps =DBCommon.con.prepareStatement(sql);
				ps.setString(1, userId);
				// SELECT는 executeQuery로 처리한다.
				// 성공 시 데이터를 가져오고, 실패 시 
				rs = ps.executeQuery();
				if (rs.next()) {		// rs.next() == db에 값이존재하니??
					memdto = new MemberDTO();
					memdto.setId(rs.getString("id"));
					memdto.setPassword(rs.getString("password"));
					memdto.setEmail(rs.getString("email"));
					memdto.setName(rs.getString("name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return memdto;
		}

		@Override
		public MemberDTO pwdCheck(String pwd) {
			String sql = "SELECT * FROM membership WHERE password=?";
			
			MemberDTO memdto = null;
			try {
				ps =DBCommon.con.prepareStatement(sql);
				ps.setString(1, pwd);
				// SELECT는 executeQuery로 처리한다.
				// 성공 시 데이터를 가져오고, 실패 시 
				rs = ps.executeQuery();
				if (rs.next()) {		// rs.next() == db에 값이존재하니??
					memdto = new MemberDTO();
					memdto.setId(rs.getString("id"));
					memdto.setEmail(rs.getString("email"));
					memdto.setPwdQuestion(rs.getString("pwdquestion"));
					memdto.setPwdAnswer(rs.getString("pwdanswer"));
					memdto.setPassword(rs.getString("password"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return memdto;
		}

		@Override
		public int memSave(MemberDTO memdto, String userId) {
			String sql = "UPDATE membership SET password=?,email=?,pwdquestion=?,pwdanswer=? WHERE id=?";
			int result = 0;
			try {
				ps = DBCommon.con.prepareStatement(sql);
				// ps.set(내가 설정한 변수형태)로 아까 sql ? 에 넣을 값 설정
				ps.setString(1	, memdto.getPassword());
				ps.setString(2, memdto.getEmail());
				ps.setString(3, memdto.getPwdQuestion());
				ps.setString(4, memdto.getPwdAnswer());
				ps.setString(5, userId);
				// SELECT를 제외한 나머지 명령어는 executeUpdate()로 실행
				// executeUpdate로 돌려주는 값은 성공 시 1 , 실패 시 0, 또는 exception 발생
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}

		@Override
		public ResvDTO resvCheck(String resvNo) {
			String sql =  "SELECT * FROM reservations WHERE resvno=?";
			
			ResvDTO dto = null;
			try {
				ps =DBCommon.con.prepareStatement(sql);
				ps.setString(1, resvNo);
				// SELECT는 executeQuery로 처리한다.
				// 성공 시 데이터를 가져오고, 실패 시 
				rs = ps.executeQuery();
				if (rs.next()) {		// rs.next() == db에 값이존재하니??
					dto = new ResvDTO();
					dto.setId(rs.getString("id"));
					dto.setTitle(rs.getString("title"));
					dto.setResvNo(rs.getString("resvno"));
					dto.setResvDate(rs.getString("resevdate"));
					dto.setTheater(rs.getString("theater"));
					dto.setAdtTicket(rs.getString("adtticket"));
					dto.setCdrTicket(rs.getString("cdrticket"));
					dto.setSeatNum(rs.getString("seatnum"));
					dto.setPaymentDay(rs.getString("paymentday"));
					dto.setPayWith(rs.getString("paywith"));
					dto.setAmount(rs.getInt("amount"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}
		
		@Override
		public int resvDelete(String resvNo) {
			String sql = "DELETE FROM reservations WHERE resvno=?";
			int result = 0;
			try {
				ps =DBCommon.con.prepareStatement(sql);
				ps.setString(1, resvNo);
				// SELECT는 executeQuery로 처리한다. 나머지는 executeUpdate!!
				// 성공 시 데이터를 가져오고, 실패 시 
				result = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

}
