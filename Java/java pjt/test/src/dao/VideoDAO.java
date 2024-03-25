package dao;

import dto.VideoDTO;

import java.sql.SQLException;

public interface VideoDAO {
    VideoDTO getVideoById(int videoId) throws SQLException;
    boolean insertVideo(VideoDTO videoDTO) throws SQLException;
    boolean deleteVideo(VideoDTO videoDTO) throws SQLException;
}
