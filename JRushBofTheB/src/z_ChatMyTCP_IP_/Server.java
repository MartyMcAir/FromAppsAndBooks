package z_ChatMyTCP_IP_;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static List<UserService> users = new LinkedList<>();
    private static final int PORT = 4403;

    public static void main(String[] args) throws IOException {
        System.out.println("Server is starting.");
        UserService user = null;

//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String command = null;
        while (true) { // бессконечно слушает порт
//            System.out.println("доступны комманды для ввода: ");
//            command = bf.readLine();
//            if ("getUsersSize".equals(command.trim())) {
//            }

            try (ServerSocket serverSocket = new ServerSocket(PORT);
                 Socket socket = serverSocket.accept();) {
                System.out.println("Object server created.");
                user = new UserService(socket, serverSocket);
                users.add(user);
                runForUser(user, serverSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("users.size(): " + users.size());
        }
    }

    public static void runForUser(UserService user, ServerSocket serverSocket) {
        // ○ если какой-то поток завершил задачу, но и поступила нов задача то тот что,
        // уже завершил будет брать эту задачу и новый поток не будет создан (а уже созданный будет переиспользован)
        ExecutorService executors = Executors.newCachedThreadPool();
        executors.submit(user); // добавляет в список задач и сразу запускает
    }

    public static List<UserService> getUsers() {
        return users;
    }
}
