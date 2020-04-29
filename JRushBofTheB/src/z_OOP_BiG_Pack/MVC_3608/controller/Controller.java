package z_OOP_BiG_Pack.OOP_MVC_3608.controller;

import z_OOP_BiG_Pack.OOP_MVC_3608.model.Model;
import z_OOP_BiG_Pack.OOP_MVC_3608.view.EditUserView;
import z_OOP_BiG_Pack.OOP_MVC_3608.view.UsersView;

public class Controller { // соединяет модель с вьюхой
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void onShowAllUsers() {
        // должен обратиться к модели и инициировать загрузку пользователей.
//        FakeModel model = new FakeModel();
//        model.loadUsers();
        // Пойди в контроллер и добавь обновление данных во Вью.
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void setModel(Model model) {
        this.model = model;
    }

    // --- --- --- UsersView Методы --- --- ---
    public void setUsersView(UsersView usersView) {
        // Пойди в контроллер и добавь обновление данных во Вью.
        this.usersView = usersView;
//        usersView.refresh(model);
    }

    // Распредели методы по классам MVC
    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    // --- --- --- EditUserView Методы --- --- ---
    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    // Распредели методы по классам MVC _ (2):
    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    //  аналогично реализации предыдущих методов сделай следующее (8ое задание):
    public void onUserDelete(long id) {
//        model.loadUserById(id); // MainModel сеттит в modelData.setActiveUser(user);
//        model.deleteUserById(model.getModelData().getActiveUser().getId());
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    //  аналогично реализации предыдущих методов сделай следующее (9ое задание):
    public void onUserChange(String name, long id, int level) {
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }
}
