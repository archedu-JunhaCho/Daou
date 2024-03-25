package controller;

import dao.FavoriteDAOImpl;
import dto.FavoriteDTO;
import network.Request;
import network.Response;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class FavoriteService {
    // settings
    private Response response;
    private final FavoriteDTO favoriteDTO;
    private final FavoriteDAOImpl dbUtil;
    private final ObjectOutputStream serverOut;

    // constructor
    public FavoriteService(Socket socket) throws Exception {
        this.favoriteDTO = new FavoriteDTO();
        this.dbUtil = new FavoriteDAOImpl();
        this.serverOut = new ObjectOutputStream(socket.getOutputStream());
    }

    // service methods
    public void favoriteAdd(Request request) throws Exception {
        favoriteDTO.setUser_id(Integer.valueOf(request.get("user_id")));
        favoriteDTO.setVideo_id(Integer.valueOf(request.get("video_id")));
        boolean result = dbUtil.addFavorite(favoriteDTO);

        response = new Response();
        response.put("msg", result ? "Success" : "Failed");
        response.put("select", "user/video/add");
        serverOut.writeObject(response);
        serverOut.flush();
    }
    public void favoriteDelete(Request request) throws Exception {
        favoriteDTO.setUser_id(Integer.valueOf(request.get("user_id")));
        favoriteDTO.setVideo_id(Integer.valueOf(request.get("video_id")));
        boolean result = dbUtil.deleteFavorite(favoriteDTO);

        response = new Response();
        response.put("msg", result ? "Success" : "Failed");
        response.put("select", "user/video/delete");
        serverOut.writeObject(response);
        serverOut.flush();
    }
    public void favoriteGetList(Request request) throws Exception {
        favoriteDTO.setUser_id(Integer.valueOf(request.get("user_id")));
        List<FavoriteDTO> result = dbUtil.getFavoriteList(favoriteDTO);

        response = new Response();
        response.put("msg", result != null ? "Success" : "Failed");
        response.put("select", "user/video/getList");
        /** add logic - list obj add **/
        serverOut.writeObject(response);
        serverOut.flush();
    }
}
