package a_SingleOfThread;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* 
Тот, кто любит труд, не нуждается в развлечениях
*/
// https://javarush.ru/tasks/com.javarush.task.task26.task2606#discussion
// Расставь volatile там, где необходимо.
// сам разобрался, но пример запутанный
public class ThreadVolatile_2606 {
    private final URL javarushUrl;
    private final URL javarushUrl1Child;
    private final URL javarushVkGroupUrl;
    private final URL javarushVkGroupUrl1Child;
    private final URL javarushVkGroupUrl2Child;
    private final URL javarushVkGroupUrl3Child;

    private volatile ExecutorService executorService;  // volatile!!!
    private final Set<URL> urlsForProcessing = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        ThreadVolatile_2606 solution = new ThreadVolatile_2606();
        solution.start(); // обычный метод
        Thread.sleep(1000);
        solution.stop(); // делает executorService.shutdownNow()
    }

    public ThreadVolatile_2606() throws MalformedURLException {
        javarushUrl = new URL("http://javarush.ru/");
        javarushVkGroupUrl = new URL("http://vk.com/javarush");
        javarushUrl1Child = new URL("http://info.javarush.ru/page/FAQ/");
        javarushVkGroupUrl1Child = new URL("https://plus.google.com/114772402300089087607/about");
        javarushVkGroupUrl2Child = new URL("https://www.facebook.com/pages/Javarush/524321077686033");
        javarushVkGroupUrl3Child = new URL("https://twitter.com/javarush_ru");

        urlsForProcessing.add(javarushUrl);
        urlsForProcessing.add(javarushVkGroupUrl);
    }

    public synchronized void start() {
        // 	если какой-то поток завершил задачу, но и поступила нов задача то тот что,
        // 	уже завершил будет брать эту задачу и новый поток не будет создан (а уже созданный будет переиспользован)
        executorService = Executors.newCachedThreadPool();
        for (URL url : urlsForProcessing) {
            // url уходит в submitUrlTask(..) и там: executorService.execute(new UrlTask(url));
            // в UrlTask implements Runnable _
            //      а там идет в метод processPage что пишет url + will be processed
            //      и возвращает список полученный из др метода
            //      потом список перебирается и submitUrlTask запускает нить ..execute(new UrlTask(url));
            // ____ т.е. зачем-то закольцованно !?
            submitUrlTask(url);
        }
        urlsForProcessing.clear();  // чистит синхронизированную мапу
    }

    public synchronized void stop() throws InterruptedException {
        try {
            saveUnprocessedUrls(executorService.shutdownNow());
            if (executorService.awaitTermination(1_000, TimeUnit.MILLISECONDS)) {
                saveUnprocessedUrls(getCancelledTasksFromExecutor());
            }
        } finally {
            executorService = null;
        }
    }

    private List<Runnable> getCancelledTasksFromExecutor() {
        return Collections.EMPTY_LIST;
    }

    protected List<URL> processPage(URL url) {
        System.out.println(url + " will be processed");
        return getChildUrlByParent(url);
    }

    private List<URL> getChildUrlByParent(URL url) {
        List<URL> result = new ArrayList<>();

        if (javarushUrl.equals(url)) {
            result.add(javarushUrl1Child);
        } else if (javarushVkGroupUrl.equals(url)) {
            result.add(javarushVkGroupUrl1Child);
            result.add(javarushVkGroupUrl2Child);
            result.add(javarushVkGroupUrl3Child);
        }
        return result;
    }

    private void saveUnprocessedUrls(List<Runnable> unprocessed) {
        for (Runnable task : unprocessed) {
            urlsForProcessing.add(((UrlTask) task).getPage());
        }
    }

    private void submitUrlTask(URL url) {
        executorService.execute(new UrlTask(url));
    }

    public class UrlTask implements Runnable {
        private final URL url;

        private UrlTask(URL url) {
            this.url = url;
        }

        public void run() {
            for (URL link : processPage(url)) {
                if (Thread.currentThread().isInterrupted()) return;
                submitUrlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }
}
