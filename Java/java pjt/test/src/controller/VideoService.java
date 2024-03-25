// video controller
package controller;

import dao.VideoDAOImpl;
import dto.VideoDTO;
import network.Request;
import network.Response;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class VideoService {
    // settings
    private Response response;
    private final VideoDTO videoDTO;
    private final VideoDAOImpl dbUtil;
    private final ObjectOutputStream serverOut;

    // constructor
    public VideoService(Socket socket) throws Exception {
        this.dbUtil = new VideoDAOImpl();
        this.videoDTO = new VideoDTO();
        this.response = new Response();
        this.serverOut = new ObjectOutputStream(socket.getOutputStream());
    }

    // service methods
    public void videoAdd(Request request) throws Exception {
        videoDTO.setTitle(request.get("title"));
        videoDTO.setUrl(request.get("url"));
        boolean result = dbUtil.insertVideo(videoDTO);

        response = new Response();
        response.put("msg", result ? "Success" : "Failed");
        response.put("select", "video/add");
        serverOut.writeObject(response);
        serverOut.flush();
    }
    public void videoDelete(Request request) throws Exception {
        videoDTO.setTitle(request.get("title"));
        videoDTO.setUrl(request.get("url"));
        boolean result = dbUtil.deleteVideo(videoDTO);

        response = new Response();
        response.put("msg", result ? "Success" : "Failed");
        response.put("select", "video/delete");
        serverOut.writeObject(response);
        serverOut.flush();
    }
}
