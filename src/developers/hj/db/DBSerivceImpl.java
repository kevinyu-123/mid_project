package developers.hj.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.dbCommon;
import dto.AdminDTO;

public class DBSerivceImpl implements DBService {
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public AdminDTO getInfo(String adminId) {
		String sql = "SELECT * FROM admin WHERE id=?";
		AdminDTO dto = null;
		try {
			ps = dbCommon.con.prepareStatement(sql);
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

}
