package developers.hj.db;

import java.util.ArrayList;

import dto.AdminDTO;
import dto.MemberDTO;
import dto.MovieDTO;
import dto.ResvDTO;

public interface DBService {
	public AdminDTO getAdminInfo(String adminId);
	public AdminDTO setInfo();
	public MemberDTO getMemInfo(String memName);
	public ArrayList<MemberDTO> getAllInfo();
	public int setMoiveInfo(MovieDTO dto);
	public MovieDTO getMovieInfo(String movieName);
	public int deleteMovie(String name);
	public ResvDTO getResvINFO(String id);
	public int deleteResv(String id);
	public int updateResvInfo(ResvDTO dto,String uId);
	public ArrayList<MovieDTO> getAllMovieInfo();
	public int updateMovieInfo(MovieDTO dto,String title);

}
