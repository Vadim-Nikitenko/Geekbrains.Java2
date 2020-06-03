package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Socket socket;
        DataInputStream in;
        Scanner message;
        DataOutputStream out;
        String IP_ADDRESS = "localhost";
        int PORT = 8189;
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            message = new Scanner(System.in);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Чат начался:");
            new Thread(() -> {
                try {
                    while (true) {
                        String str = message.nextLine();
                        if (str.equals("/end")) {
                            System.out.println("Клиент отключился");
                            break;
                        }
                        out.writeUTF(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                try {
                    String msg = in.readUTF();
                    System.out.println("Сервер: " + msg);
                } catch (EOFException e) {
                    System.out.println("Сервер отключился");
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}