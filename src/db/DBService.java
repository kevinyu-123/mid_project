package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbService {
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
	}
