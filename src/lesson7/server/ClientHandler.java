package lesson7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean authorized;

    private String nick;


    private String login;

    public ClientHandler(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    //цикл аутентификации
                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/auth ")) {
                            String[] token = str.split(" ");

                            System.out.println(str);
                            if (token.length < 2) {
                                continue;
                            }

                            String newNick = server.getAuthService()
                                    .getNicknameByLoginAndPassword(token[1], token[2]);
                            authorized = false;
                            if (newNick != null) {
                                for (ClientHandler c : server.getClients()) {
                                    if (c.getLogin().equals(token[1])) {
                                        System.out.println("Пользователь уже авторизован");
                                        sendMsg("/authError");
                                        authorized = true;
                                        break;
                                    }
                                }
                                if (!authorized) {
                                    sendMsg("/authok " + newNick);
                                    nick = newNick;
                                    login = token[1];
                                    server.subscribe(this);
                                    System.out.println("Клиент: " + nick + " подключился");
                                    authorized = false;
                                    break;
                                }
                            } else {
                                sendMsg("Неверный логин / пароль");
                            }
                        }
                    }

                    //цикл работы
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            sendMsg("/end");
                            break;
                        }
                        if (str.startsWith("/w ")) {
                            try {
                                String[] nickMessageArr = str.split(" ", 3);
                                String nickname = nickMessageArr[1].replace("/w ", "");
                                String message = nickMessageArr[2];
                                server.privateMessage(nickname, nick + ": " + message);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Клиент отправил пустое сообщение");
                            }
                        } else {
                            server.broadcastMsg(nick + ": " + str);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    server.unsubscribe(this);
                    System.out.println("Клиент отключился");
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String[] msg, String nick) {
        try {
            if (nick.equals(msg[2])) {
                out.writeUTF(msg[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }

    public String getLogin() {
        return login;
    }
}
