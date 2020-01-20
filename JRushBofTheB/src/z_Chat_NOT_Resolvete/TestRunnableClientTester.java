package z_Chat_NOT_Resolvete;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRunnableClientTester implements Runnable {

    static Socket socket;

    public static void main(String[] args) throws IOException, InterruptedException {

        // çàïóñòèì ïóë íèòåé â êîòîðûõ êîëëè÷åñòâî âîçìîæíûõ íèòåé îãðàíè÷åíî -
        // 10-þ.
        ExecutorService exec = Executors.newFixedThreadPool(10);
        int j = 0;

        // ñòàðòóåì öèêë â êîòîðîì ñ ïàóçîé â 10 ìèëèñåêóíä ñòàðòóåì Runnable
        // êëèåíòîâ,
        // êîòîðûå ïèøóò êàêîå-òî êîëè÷åñòâî ñîîáùåíèé
        while (j < 10) {
            j++;
            exec.execute(new TestRunnableClientTester());
            Thread.sleep(10);
        }

        // çàêðûâàåì ôàáðèêó
        exec.shutdown();
    }

    public TestRunnableClientTester() {
        try {

            // ñîçäà¸ì ñîêåò îáùåíèÿ íà ñòîðîíå êëèåíòà â êîíñòðóêòîðå îáúåêòà
            socket = new Socket("localhost", 3345);
            System.out.println("Client connected to socket");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try (

                // ñîçäà¸ì îáúåêò äëÿ çàïèñè ñòðîê â ñîçäàííûé ñêîêåò, äëÿ
                // ÷òåíèÿ ñòðîê èç ñîêåòà
                // â try-with-resources ñòèëå
                DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                DataInputStream ois = new DataInputStream(socket.getInputStream())) {
            System.out.println("Client oos & ois initialized");

            int i = 0;
            // ñîçäà¸ì ðàáî÷èé öèêë
            while (i < 5) {

                // ïèøåì ñîîáùåíèå àâòîãåíåðèðóåìîå öèêëîì êëèåíòà â êàíàë
                // ñîêåòà äëÿ ñåðâåðà
                oos.writeUTF("clientCommand " + i);

                // ïðîòàëêèâàåì ñîîáùåíèå èç áóôåðà ñåòåâûõ ñîîáùåíèé â êàíàë
                oos.flush();

                // æä¸ì ÷òîáû ñåðâåð óñïåë ïðî÷åñòü ñîîáùåíèå èç ñîêåòà è
                // îòâåòèòü
                Thread.sleep(10);
                System.out.println("Client wrote & start waiting for data from server...");

                // çàáèðàåì îòâåò èç êàíàëà ñåðâåðà â ñîêåòå
                // êëèåíòà è ñîõðàíÿåìå¸ â ois ïåðåìåííóþ, ïå÷àòàåì íà
                // êîíñîëü
                System.out.println("reading...");
                String in = ois.readUTF();
                System.out.println(in);
                i++;
                Thread.sleep(5000);

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}