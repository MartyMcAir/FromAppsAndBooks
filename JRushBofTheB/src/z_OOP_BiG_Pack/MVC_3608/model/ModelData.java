package z_OOP_BiG_Pack.OOP_MVC_3608.model;

import z_OOP_BiG_Pack.OOP_MVC_3608.bean.User;

import java.util.List;

public class ModelData {
    // как я понимаю, это не самый гибкий MVC пример (и при этом, не самый простой и понятный),
    // т.к. хоть и есть интерфейс View мы же юзаем в Controller конкретно EditUserView и UsersView _ -
    // т.е.если захотим менять вьюху редактирования, - то лучше было бы заюзать для этого отдельный интерфейс
    // который бы наследовала вьюха редактирования..
    // И Интерфейс Model, жестко привязан к конкретному классу в методе: ModelData getModelData(); - тоже не гуд..
    // А после изменения конкретного юзера вызываем ...fireEventShowDeletedUsers() - а он вообще-то не delete,
    // а был изменен _ так может лучше было бы назвать этот метод типо..: fireEventShowChanges() -!?
    // - раз мы его юзаем и после удаления и после изменений..
    // Связка MainModel и ModelData - несколько запутывает.. Этоо как бы типо.. MainModel это такой связующий мост
    // между DAO и какой-то ещё моделью..т.е. в нашем случае с ModelData... мол выгружает данные через UserService,
    // в MainModel и сеттим изменения и данные в ModelData -////....
    // Это типо давай из одной модели в другую будем перекидывать, а между моделями будем добавлять еще одну сущность,
    // как мост или маркер с пометками между ними
    // Сущности ради сущностей... - или она реально нужна и необходима!?
    // Или это как... эмм.. т.е. в ModelData сеттятся актив юзер (setActiveUser),
    // юзер что удален или не удален (setDisplayDeletedUserList), сеттится лист (setUsers)...
    private List<User> users;
    private User activeUser;
    private boolean displayDeletedUserList;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    // Когда наши данные выводятся в консоль, то совсем не понятно,
    // список каких пользователей - удаленных или нет - выводится.
    // Давай сделаем так, чтобы Вью отображала эту информацию.
    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }
}
