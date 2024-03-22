package dao;

import java.util.List;

public interface ITEST02DAO {
	public void add_text(TEST02VO_text vo_T) throws Exception;
	public void delete_text(TEST02VO_text vo_T) throws Exception;
	public void update_text(TEST02VO_text vo_T) throws Exception;
	public List<TEST02VO_text> read_text() throws Exception;
	
	public void add_recomm(TEST02VO_recomm vo_R) throws Exception;
	public void delete_recomm(TEST02VO_recomm vo_R) throws Exception;
	public void update_recomm(TEST02VO_recomm vo_R) throws Exception;
	public List<TEST02VO_recomm> read_recomm() throws Exception;
}
