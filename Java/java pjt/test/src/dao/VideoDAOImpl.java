package dao;

import db.DatabaseUtil;
import dto.VideoDTO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideoDAOImpl extends DatabaseUtil implements VideoDAO {
    // settings
    PreparedStatement pStmtInsert;
    PreparedStatement pStmtSelect;
    PreparedStatement pStmtDelete;
    public VideoDAOImpl() throws Exception {
        pStmtInsert = conn.prepareStatement("INSERT into Video values (?, ?)");
        pStmtSelect = conn.prepareStatement("SELECT * from Video WHERE videoId=?");
        pStmtDelete = conn.prepareStatement("DELETE FROM Video WHERE title=? and url=?");
    }

    @Override
    public VideoDTO getVideoById(int videoId) throws SQLException {
        pStmtSelect.setInt(1, videoId);
        rs = pStmtSelect.executeQuery();

        VideoDTO dto = new VideoDTO();
        dto.setVideo_id(videoId);
        dto.setTitle(rs.getString("title"));
        dto.setUrl(rs.getString("url"));
        return dto;
    }

    @Override
    public boolean insertVideo(VideoDTO dto) throws SQLException {
        pStmtInsert.setString(1, dto.getTitle());
        pStmtInsert.setString(1, dto.getUrl());
        try{
            pStmtInsert.executeQuery();
            return true;
        }
        catch (SQLException e){
            e.getStackTrace();
            return false;
        }
    }
    @Override
    public boolean deleteVideo(VideoDTO dto) throws SQLException {
        pStmtDelete.setString(1, dto.getTitle());
        pStmtDelete.setString(1, dto.getUrl());
        try{
            pStmtDelete.executeQuery();
            return true;
        }
        catch (SQLException e){
            e.getStackTrace();
            return false;
        }
    }
}
