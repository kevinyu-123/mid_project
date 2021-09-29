package developers.soo.db;

import dto.MemberDTO;
import dto.ResvDTO;

public interface DBService {
	public int DBSave(MemberDTO memdto);
	public MemberDTO loginCheck(String userId);
	public MemberDTO idCheck(String userId);
	public MemberDTO myPage(String userId);
	public MemberDTO pwdCheck(String userId);
	public int memSave(MemberDTO memdto, String userId);
	public ResvDTO resvCheck(String resvNo);
	public int resvDelete(String resvNo);
}
