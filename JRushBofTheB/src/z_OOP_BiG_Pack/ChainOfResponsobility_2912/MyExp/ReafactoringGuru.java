package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.util.HashMap;
import java.util.Map;

public class ReafactoringGuru {
    public static void main(String[] args) {
        // на Сервер сеттятся все данные
        // на сервер сетится цепь проверок
        // цепь проверок запускается на сервере через метод что юзает _ засеттеное поле цепи проверок

        Server server = new Server();
        server.register("user@example.com", "user_pass"); // добавл юзера в BD
        // Строим цепь нужных уникальных проверок
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());
        server.setMiddleware(middleware); // сеттим цепь на сервер

        boolean success = server.logIn("user@example.com", "user_pass"); // получаем boolean result
//        boolean success = server.logIn("fff@email.com", "mySuperPassw"); // получаем boolean result
        System.out.println(success);
    }

    // ___ Сервер храняющий юзеров и обрабатывающий цепи
    public static class Server {
        private Map<String, String> users = new HashMap<>();
        private Middleware middleware;

        public void setMiddleware(Middleware middleware) { // сеттим цепь на сервер
            this.middleware = middleware;
        }

        public boolean logIn(String email, String password) { // через логин
            if (middleware.check(email, password)) { // запускаем цепь проверок
                System.out.println("Authorization have been successful!");
                // ..код, для авторизированных пользователей..
                return true;
            }
            return false;
        }

        public void register(String email, String password) {
            users.put(email, password);
        } // добавляем юзера

        public boolean hasEmail(String email) { // чекаем почту в списке
            System.out.println("Server _ hasEmail(..)");
            return users.containsKey(email);
        }

        public boolean isValidPassword(String email, String password) {
            System.out.println("Server _ isValidPassword(..)");
            return users.get(email).equals(password); // чекаем пароль по email'у
        }
    }

    // ___ Базовый стартовый класс цепочки
    public static abstract class Middleware { //
        private Middleware next;

        public Middleware linkWith(Middleware next) { // метод постройки цепей
            this.next = next;    // c этого метода всё и запускается
            return next;
        }    // добавляется, след цепь и возвращает ее же

        // общий метод валидации для всех элементов-классов цепи
        public abstract boolean check(String email, String password);

        protected boolean checkNext(String email, String password) {
//            System.out.println("Abstract Middleware _ linkWith(..)");
            if (next == null) { // если ссылка на след. проверку null
                return true;
            }    // иначе идем далее по цепи
            return next.check(email, password);
        }
    }

    // --- Классы объекты-элементы-цепи валидаций (проверок) ---
    public static class UserExistsMiddleware extends Middleware { // логин и пароль
        // наследов. Middleware, обеспечив возможность, быть в кач. элемента цепи
        private Server server;

        public UserExistsMiddleware(Server server) {
            this.server = server;
        }

        public boolean check(String email, String password) {
            System.out.println("UserExistsMiddleware _ checkNext(..)");
            if (!server.hasEmail(email)) {
                System.out.println("This email is not registered!");
                return false;
            }
            if (!server.isValidPassword(email, password)) {
                System.out.println("Wrong password!");
                return false;
            } // if всё валидно, то возвращ. след проверку
            return checkNext(email, password);
        }
    }

    public static class RoleCheckMiddleware extends Middleware { // ___ роли доступа
        public boolean check(String email, String password) {
            System.out.println("RoleCheckMiddleware _ checkNext(..)");
            if (email.equals("admin@example.com")) {
                System.out.println("Hello, admin!");
                return true;
            }    // если не, админ идем дальше по цепи..
            System.out.println("Hello, user!");
            return checkNext(email, password);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // еще одна возможная цепь
    public static class ThrottlingMiddleware extends Middleware { // лимит запросов
        private int requestPerMinute, request;
        private long currentTime;

        public ThrottlingMiddleware(int requestPerMinute) {
            this.requestPerMinute = requestPerMinute;
            this.currentTime = System.currentTimeMillis();
        }

        public boolean check(String email, String password) {
            System.out.println("ThrottlingMiddleware _ checkNext(..)");
            if (System.currentTimeMillis() > currentTime + 60_000) {
                request = 0;
                currentTime = System.currentTimeMillis();
            }
            request++;

            if (request > requestPerMinute) { // при превышении лимита запросов
                System.out.println("Request limit exceeded!");
                Thread.currentThread().stop();
            }
            // делаем возврат boolean из след вызова checkNext(), след элемента цепи
            return checkNext(email, password); // эдакая рекурсия
        }
    }
}
