import java.io.FileInputStream;

import java.io.IOException;
import java.io.PrintWriter;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("What is your name?");
        Scanner scannerName = new Scanner(System.in);
        String name = scannerName.nextLine();


        try {
            Socket socket = new Socket("localhost", 6789);
            new Thread(new ListenerServer(socket)).start();

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            System.out.println(name + " connected");
            Scanner scannerConsole = new Scanner(System.in);
            while (true) {//###finish###
                String message = scannerConsole.nextLine();
                String messageTime = new SimpleDateFormat("(HH:mm:ss) ").format(Calendar.getInstance().getTime());
                printWriter.println( messageTime + name + ": " + message);
                printWriter.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
