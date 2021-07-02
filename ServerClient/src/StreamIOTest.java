import java.io.*;
import java.util.Scanner;

public class StreamIOTest {
    public static void main(String[] args) {
        //        Scanner scanner = new Scanner(System.in);
//        String message = scanner.nextLine();

//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileInputStream("test.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }


//        PrintWriter printWriter = new PrintWriter(System.out);
//        printWriter.println("Hello");
//        printWriter.flush();

//        try (PrintWriter printWriter = new PrintWriter("file1.txt")) {
//            //printWriter.println("test2");
//            printWriter.append("test");
//            printWriter.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream("file2.txt", true),true)) {
            printWriter.println("Hello1");
            printWriter.println("Hello2");
            printWriter.println("Hello3");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        try (Scanner scanner = new Scanner(new FileInputStream("test.txt"))) {
//            while (scanner.hasNextLine()) {
//                String message = scanner.nextLine();
//                System.out.println(message);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
