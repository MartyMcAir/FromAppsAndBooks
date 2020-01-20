package z_ChatSimple;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Story { // класс хранящий в списке информацию о последних 10 (или меньше) сообщениях
    private LinkedList<String> story = new LinkedList<>();

    public void addStoryEl(String el) { // добавить новый элемент в список
        // если сообщений больше 10, удаляем первое и добавляем новое
        // иначе просто добавить
        if (story.size() >= 10) {
            story.removeFirst();
            story.add(el);
        } else {
            story.add(el);
        }
    }

    // отсылаем последовательно каждое сообщение из списка
    //     * в поток вывода данному клиенту (новому подключению)
    public void printStory(BufferedWriter writer) {
        if (story.size() > 0) {
            try {
                writer.write("History messages" + "\n");
                for (String vr : story) {
                    writer.write(vr + "\n");
                }
                writer.write("/...." + "\n");
                writer.flush();
            } catch (IOException ignored) {
            }
        }
    }
}