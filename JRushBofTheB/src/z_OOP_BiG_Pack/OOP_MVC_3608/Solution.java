package z_OOP_BiG_Pack.OOP_MVC_3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

import java.util.Properties;

public class Solution {
    private Properties usersView;

    // https://javarush.ru/pictures/1281202/6752c231-6512-4a1b-8030-b8976fc568fd.png
    // https://javarush.ru/quests/lectures/questmultithreading.level04.lecture14
    public static void main(String[] args) {
        // ModelData - служит что-то вроде маркера там сеттится список, активный юзер и удален ли он
////        Model model = new FakeModel();
//        // Преимущества MVC в том, что в любой момент времени легко можно
//        // заменить любую часть паттерна.
//
//        // M_ Модель MainModel implements Model {
//        // работает в основном с userService методами
//        // содержит поля
//        // ..modelData = new ModelData(); и ..userService = new UserServiceImpl();
//        // userService - понятно, что как бы работает с DB
//        // а ModelData - это то что принимает на входе в UsersView
//        // т.е. связывает MainModel() c вьюхой через контроллер
//        Model model = new MainModel();
//
//
//        // V_ Вьюха UsersView implements View {
//        // содержит поле private Controller controller;
//        UsersView usersView = new UsersView();
//        EditUserView editUserView = new EditUserView(); // тож самое
//
//        // В Вьюхе сетится контроллер
//        // потом вызывается любой метод для вывода, а там вызывается метод контроллера
//        // , который подгружает - нужные данные из нужной Модели хранящей данные
//        // (т.е. юзает интерфейсную перменную Model model)
//        // и кидает их назад в вьюху в метод refresh(ModelData modelData) _,
//        // а та выводит на экран что требовалось
//        // т.е. в вьюхе только один метод который выводит refresh(..) _ остальные делают,
//        // запрос к контроллеру,-а котроллер берет что требуется с модели и кидает назад
//
//        // При этом в контроллер, зачем-то часть методов и подход жестко привязали
//        // к персональным ссылкам конкретных классов, так он
//        // работает с интреф Model и не с интерфейсом вьюх, а их пресональными полями,
//        // т.е. раздления на вьюху для всех и вьюха при редактировании юзера -иная
//
//        // причем сам interface Model - юзает метод getModelData()
//        // - который возвращает строго ModelData - тип
//
//        // C_ Контроллер содержит 3 поля
//        // Model model; UsersView usersView; EditUserView editUserView;
//        //
//        Controller controller = new Controller();
//
//
//
//        usersView.setController(controller);
//        editUserView.setController(controller);
//        controller.setModel(model);
//        controller.setUsersView(usersView);
//        controller.setEditUserView(editUserView);
//
//        usersView.fireEventShowAllUsers();
//
//        usersView.fireEventOpenUserEditForm(126L);
//        usersView.fireEventShowDeletedUsers();
//
//        editUserView.fireEventUserDeleted(124L);
//        usersView.fireEventShowDeletedUsers();
//
//        editUserView.fireEventUserChanged("Танос", 125L, 88);
//        usersView.fireEventShowDeletedUsers();

        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();

        usersView.fireEventOpenUserEditForm(126L);

        editUserView.fireEventUserDeleted(124L);

        editUserView.fireEventUserChanged("Валера новый", 125L, 15);

        usersView.fireEventShowDeletedUsers();

    }

    public void setUsersView(Properties usersView) {
        this.usersView = usersView;
    }
}