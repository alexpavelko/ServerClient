import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ListenerServer implements Runnable {
    private Socket socket;
    private Scanner scanner;
    public ListenerServer(Socket socket) {
        this.socket = socket;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (scanner.hasNextLine()) {
            String messageFromServer = scanner.nextLine();
            System.out.println(messageFromServer);
        }
    }
}
