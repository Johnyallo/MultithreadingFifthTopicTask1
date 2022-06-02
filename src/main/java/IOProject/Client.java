package IOProject;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final int PORT = 21334;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", PORT);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

             String number;
             while (true) {
                     System.out.println("Enter number for server: ");
                     number = scanner.nextLine();
                     out.println(number);

                     if ("end".equals(number)) break;

                     System.out.println("SERVER: " + in.readLine());
             }
        }
    }
}
