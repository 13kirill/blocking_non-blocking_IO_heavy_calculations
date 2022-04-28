import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        String host = "netology.homework";
        int port = 16162;
        Socket clientSocket = new Socket(host, port);

        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                Scanner scan = new Scanner(System.in)) {

            while (true) {
                System.out.println("Введи номер элемента из ряда Фибоначи (до 50, иначе программа будет считать долго):\n"
                + "Или введи end для остановки клиента.");
                String value = scan.nextLine();
                out.println(value);
                if (value.equals("end")) {
                    break;
                }
                String fv = in.readLine();
                System.out.println(fv);

            }
        }
    }
}