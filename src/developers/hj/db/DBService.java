package developers.hj.db;

import dto.AdminDTO;

public interface DBService {
	public AdminDTO getInfo(String adminId);
	public AdminDTO setInfo();
}
