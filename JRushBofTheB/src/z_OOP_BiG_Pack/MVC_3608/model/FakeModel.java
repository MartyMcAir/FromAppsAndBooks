package z_OOP_BiG_Pack.MVC_3608.model;

import z_OOP_BiG_Pack.MVC_3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model { // это так называема mock модель - т.е. не настоящая
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
//        List<User> list = getModelData().getUsers();
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User("MartyMacAir", 368913, 24));
        list.add(new User("Thanos", 368914, 24));
        list.add(new User("Nebula", 368915, 23));
        list.add(new User("Gomora", 368912, 21));
        modelData.setUsers(list); // инициализировать список юзеров любыми данными
    }

    // Распредели методы по классам MVC
    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    //
    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
