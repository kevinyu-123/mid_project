package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBService {
	String sql;
	int result;
	PreparedStatement ps;
	ResultSet rs;
	/*public void insertMember() {
		sql = "insert into research values(?,?,?,?,?,?)";
		try {
			ps = dbCommon.con.prepareStatement(sql);
			ps.setString();
			ps.setString();
			ps.setString();
			ps.setString();
			ps.setString();
			ps.setString();
			result = ps.executeUpdate();
			if(result==1) {System.out.println("저장 성공");}
			else {System.out.println("저장 실패");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
/*
	public int DBSave(dto dto) {
		// 연결이 됐는지 확인
		System.out.println("DB에 회원가입 합니다.");
		// 회원가입 할 sql문구 삽입
		String sql = "insert into five values(?,?,?,?,?,?)";
		// try- catch로 ps에 sql을 넣기
		int result = 0;
		try {
			ps = DBCommon.con.prepareStatement(sql);
			// ps.set(내가 설정한 변수형태)로 아까 sql ? 에 넣을 값 설정
			ps.setString(1	, dto.getId());
			ps.setString(2	, dto.getPassword());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getName());
			ps.setString(5, dto.getPwdQuestion());
			ps.setString(6, dto.getPwdAnswer());
			// SELECT를 제외한 나머지 명령어는 executeUpdate()로 실행
			// executeUpdate로 돌려주는 값은 성공 시 1 , 실패 시 0, 또는 exception 발생
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	} */
}