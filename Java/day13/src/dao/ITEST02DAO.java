package dao;

import java.util.List;

public interface ITEST02DAO {
	public void add(TEST02VO pvo) throws Exception;
	public void delete(TEST02VO pvo) throws Exception;
	public void update(TEST02VO pvo) throws Exception;
	public List<TEST02VO> read(TEST02VO pvo) throws Exception;
}
