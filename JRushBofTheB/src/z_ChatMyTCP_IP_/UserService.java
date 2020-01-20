package z_ChatMyTCP_IP_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService implements Runnable {
    private static final int PORT = 4403;
    private final ServerSocket serverSocket;
    private final Socket currentSocket;
    private final Date dateCreated;
    private AtomicInteger userId = new AtomicInteger();

    public UserService(Socket currentSocket, ServerSocket serverSocket) {
        this.currentSocket = currentSocket;
        this.dateCreated = new Date();
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        connectV2();
    }

    private void connectV2() {
        System.out.println("(в консоли сервера) сервер запущен.");
        String word = null;
        int id = userId.getAndIncrement();
        try (ServerSocket serverSocket2 = new ServerSocket(PORT); // создали серв
             Socket clientSocket2 = serverSocket2.accept();  // ждем клиента и получаем от него потоки
             // отвечаем юзеру через out
             PrintWriter out2 = new PrintWriter(new BufferedOutputStream(clientSocket2.getOutputStream()), true);
             // in читаем, то что получили от юзера
             BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));) {
            System.out.println("(в консоли сервера) объект, сервер создан.");

            while (!clientSocket2.isClosed()) {   // держим соединение пока юзер, сам его неразорвет
                word = in2.readLine(); // ждём пока клиент что-нибудь напишет
                System.out.println("(в консоли сервера) юзер написал: " + word);
                out2.println("(отправлено юзеру) вы написали: #" + id + " " + new Date() + " _ " + word); // отвечает клиенту
            }
        }
//        catch (UnknownHostException e) {   }
        catch (SocketException e) {
            System.out.println("Клиент разорвал соединение.");
        } catch (IOException e) {   // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Server.getUsers().remove(this);
            System.out.println("Users().size(): " + Server.getUsers().size());
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Socket getCurrentSocket() {
        return currentSocket;
    }
}
