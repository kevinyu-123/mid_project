package db;

import dto.MovieDTO;
import dto.ResvDTO;

public interface DBService {
	public void updateResv(ResvDTO dto);
	public ResvDTO toIdgetResv(String id);
	public MovieDTO selectSQL(String movieName);
}