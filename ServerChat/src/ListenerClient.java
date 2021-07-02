import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ListenerClient implements Runnable {
    private Socket socket;
    private Server server;
    private PrintWriter printWriter;
    private Scanner scanner;


    public ListenerClient(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        try {
            scanner = new Scanner(socket.getInputStream());
            printWriter = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        listenMessage();
    }

    private void listenMessage() {
        while (scanner.hasNextLine()) {
            String messageFromClient = scanner.nextLine();
            server.sendMessageToAll(messageFromClient);

            System.out.println(messageFromClient);
        }
        System.out.println("client disconnected");
    }

    public void sendMessage(String message) {
        printWriter.println(message);
        printWriter.flush();
    }


}
