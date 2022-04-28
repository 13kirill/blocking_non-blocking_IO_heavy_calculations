import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int port = 16162;
        Fibonachi fibonachi = new Fibonachi();

        System.out.println("Server started");
        System.out.println("Я могу вычислить любой элемент из ряда Фибоначи.\n");

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {

            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // от сервера к клиенту - пишем
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) // от клиента к сервера - читаем
            {
                String fibonachiValue;

                while ((fibonachiValue = in.readLine()) != null) {
                    if (fibonachiValue.equals("end")) {
                        break;
                    }
                    int fibonachiNumber = Integer.parseInt(fibonachiValue);
                    out.println(fibonachi.getFibonacciValue(fibonachiNumber));
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}