package z_OOP_BiG_Pack.MVC_3608.view;

import z_OOP_BiG_Pack.MVC_3608.controller.Controller;
import z_OOP_BiG_Pack.MVC_3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;

    public void fireEventShowAllUsers() { // будет эмулировать событие клиента.
        // Обратись к контроллеру и вызови его нужный метод для отображения всех пользователей.
        controller.onShowAllUsers();
    }

    @Override
    public void refresh(ModelData modelData) {
        String strUsers = modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:";
        // Выведи в консоль всех пользователей, которые есть в modelData.
        System.out.println(strUsers);
        modelData.getUsers().forEach(v -> System.out.println("\t" + v));
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    // Распредели методы по классам MVC:
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    // Распредели методы по классам MVC
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
