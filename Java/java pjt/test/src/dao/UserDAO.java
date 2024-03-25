package dao;

import dto.UserDTO;

import java.sql.SQLException;

public interface UserDAO {
    UserDTO getUserById(int userId) throws SQLException;
    Boolean insertUser(UserDTO userDTO) throws SQLException;
    Boolean deleteUser(UserDTO userDTO) throws SQLException;
    String loginUser(UserDTO userDTO) throws SQLException;
    Boolean logoutUser(UserDTO userDTO);
}
