package z_OOP_BiG_Pack.OOP_MVC_3608.model;

import z_OOP_BiG_Pack.OOP_MVC_3608.bean.User;
import z_OOP_BiG_Pack.OOP_MVC_3608.model.service.UserService;
import z_OOP_BiG_Pack.OOP_MVC_3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    // userService, инициализируй объектом.
    private UserService userService = new UserServiceImpl();

    // Необходимо реализовать приватный метод List<User> getAllUsers() в классе MainModel.
    // private - потому что юзается только внтри текущего класса, для личных нужл
    private List<User> getAllUsers() {
        List<User> list = modelData.getUsers();
//        List<User> list2 = userService.filterOnlyActiveUsers(modelData.getUsers());
        // для валидатора все это от 1 до 100
        List<User> result = userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
        return result;
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        // Достань всех пользователей между 1 и 100 уровнями. (Метод getUsersBetweenLevels(1, 100)).
        // 3.2. Положи всех пользователей в modelData.
//        List<User> list = userService.getUsersBetweenLevels(1, 100);
        // где требуется список пользователей, нужно работать только с активными(живыми) пользователями.
//        List<User> list2 = userService.filterOnlyActiveUsers(list);
        modelData.setUsers(getAllUsers());
    }

    // Распредели методы по классам MVC
    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> list = userService.getAllDeletedUsers();
        modelData.setUsers(list);
    }
    //

    // Распредели методы по классам MVC (2)
    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    //  аналогично реализации предыдущих методов сделай следующее (8ое):
    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        // должен установить список всех активных пользователей объекту modelData.
//        List<User> list2 = userService.filterOnlyActiveUsers(modelData.getUsers());
        modelData.setUsers(getAllUsers());
    }

    //  аналогично реализации предыдущих методов сделай следующее (9ое задание):
    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAllUsers());
    }
}
