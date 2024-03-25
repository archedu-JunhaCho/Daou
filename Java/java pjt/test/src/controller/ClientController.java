package controller;

import dto.FavoriteDTO;
import dto.UserDTO;
import dto.VideoDTO;
import network.Request;
import network.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientController implements Runnable {
    // settings
    private final Socket socket;
    private final UserService userService;
    private final VideoService videoService;
    private final FavoriteService favoriteService;
    private final ObjectInputStream serverIn;

    // constructor
    public ClientController(Socket socket) throws Exception {
        this.socket = socket;
        this.userService = new UserService(socket);
        this.videoService = new VideoService(socket);
        this.favoriteService = new FavoriteService(socket);
        this.serverIn = new ObjectInputStream(socket.getInputStream());
    }

    // controller function
    @Override
    public void run() {
        boolean run_server = true;
        while(run_server) {
            try {
                // request read
                Request request = (Request) serverIn.readObject();
                System.out.println("\nREQ\n"+socket + request.toString());

                // request parse
                switch (request.get("select")){
                    case "user/signUp":
                        userService.userSignup(request);
                        break;
                    case "user/signOut":
                        userService.userSignout(request);
                        break;
                    case "user/logIn":
                        userService.userLogin(request);
                        break;
                    case "user/logOut":
                        userService.userLogout(request);
                        break;
                    case "video/add":
                        videoService.videoAdd(request);
                        break;
                    case "video/delete":
                        videoService.videoDelete(request);
                        break;
                    case "user/video/getList":
                        favoriteService.favoriteGetList(request);
                        break;
                    case "user/video/add":
                        favoriteService.favoriteAdd(request);
                        break;
                    case "user/video/delete":
                        favoriteService.favoriteDelete(request);
                        break;
                    case "exit":
                        run_server = false;
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e) {
                e.getStackTrace();
                break;
            }
        }
    }
}