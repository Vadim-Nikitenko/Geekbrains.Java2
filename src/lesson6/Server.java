package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static int PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен!");

            try (Socket socket = server.accept()) {
                System.out.println("Клиент подключился ");

                try (DataInputStream in = new DataInputStream(socket.getInputStream());
                     Scanner message = new Scanner(System.in);
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                    System.out.println("Чат начался:");
                    new Thread(() -> {
                        try {
                            while (true) {
                                String str = message.nextLine();
                                if (str.equals("/end")) {
                                    System.out.println("Сервер отключился");
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
                            String str = in.readUTF();
                            System.out.println("Клиент: " + str);
                        } catch (EOFException e) {
                            System.out.println("Клиент отключился");
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}