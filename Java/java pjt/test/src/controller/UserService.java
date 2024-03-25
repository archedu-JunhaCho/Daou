// user Service
package controller;

import dao.UserDAOImpl;
import dto.UserDTO;
import network.Request;
import network.Response;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class UserService {
    // settings
    private Response response;
    private final UserDTO userDTO;
    private final UserDAOImpl dbUtil;
    private final ObjectOutputStream serverOut;

    // constructor
    public UserService(Socket socket) throws Exception {
        this.dbUtil = new UserDAOImpl();
        this.userDTO = new UserDTO();
        this.response = new Response();
        this.serverOut = new ObjectOutputStream(socket.getOutputStream());
    }

    // service methods
    public void userSignup(Request request) throws Exception {
        userDTO.setId(request.get("id"));
        userDTO.setPassword(request.get("password"));
        boolean result = dbUtil.insertUser(userDTO);

        response = new Response();
        response.put("msg", result ? "Success" : "Failed");
        response.put("select", "user/signup");
        serverOut.writeObject(response);
        serverOut.flush();
    }
    public void userSignout(Request request) throws Exception {
        userDTO.setId(request.get("id"));
        userDTO.setPassword(request.get("password"));
        boolean result = dbUtil.deleteUser(userDTO);

        response = new Response();
        response.put("msg", result ? "Success" : "Failed");
        response.put("select", "user/signout");
        serverOut.writeObject(response);
        serverOut.flush();
    }
    public void userLogin(Request request) throws Exception {
        userDTO.setId(request.get("id"));
        userDTO.setPassword(request.get("password"));
        String accessToken = dbUtil.loginUser(userDTO);

        response = new Response();
        response.put("msg", accessToken != null ? "Success" : "Failed");
        /** add logic - Access add **/
        response.put("select", "user/login");
        serverOut.writeObject(response);
        serverOut.flush();
    }
    public void userLogout(Request request) throws Exception {
        userDTO.setAccess(request.get("access"));
        boolean result = dbUtil.logoutUser(userDTO);

        response = new Response();
        response.put("msg", result ? "Success" : "Failed");
        response.put("select", "user/logout");
        serverOut.writeObject(response);
        serverOut.flush();
    }
}

