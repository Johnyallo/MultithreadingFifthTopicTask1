package IOProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    static List<Integer> list = new ArrayList<>();

    public static void createFibonachchiArray() {
        list.add(0);
        list.add(1);
        while (list.size() < 100) {
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Client.PORT);

        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String line;
                int value;

                createFibonachchiArray();

                while ((line = in.readLine()) != null) {
                    value = Integer.parseInt(line);
                    out.println("result: " + list.get(value));
                    if ("end".equals(line)) break;
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
