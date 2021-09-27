package db;

import dto.ResvDTO;

public interface DBService {
	public void updateResv(ResvDTO dto);
	public ResvDTO toIdgetResv(String id);
}