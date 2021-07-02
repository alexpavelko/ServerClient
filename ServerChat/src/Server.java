import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ListenerClient> listenerClients;

    public Server() {
        listenerClients = new ArrayList<>();
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("server started");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("client connected");
                ListenerClient listenerClient = new ListenerClient(socket,this);
                listenerClients.add(listenerClient);
                new Thread(listenerClient).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAll(String message) {
//        for (ListenerClient listenerClient : listenerClients) {
//            listenerClient.sendMessage(message);
//        }
        listenerClients.forEach(v -> v.sendMessage(message));
    }
}
