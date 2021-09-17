package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCommon {
	public static Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215","five","oracle");
			System.out.println("연결 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!= null) {
				try {
					con.close();
				}catch(Exception e) {}
			}
		}
	}
}