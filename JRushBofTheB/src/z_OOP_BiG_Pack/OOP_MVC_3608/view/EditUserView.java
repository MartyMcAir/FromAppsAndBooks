package z_OOP_BiG_Pack.OOP_MVC_3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

// copy past from UserView
public class EditUserView implements View {
    private Controller controller;

//    public void fireEventShowAllUsers() {
//        controller.onShowAllUsers();
//    }

    @Override
    public void refresh(ModelData modelData) {
//        String isActive = modelData.isDisplayDeletedUserList() ?
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    //    public void fireEventShowDeletedUsers() {
    //        controller.onShowAllDeletedUsers();
    //    }

    //  аналогично реализации предыдущих методов сделай следующее:
    public void fireEventUserDeleted(long id) {
        controller.onUserDelete(id);
    }

    //  аналогично реализации предыдущих методов сделай следующее (9):
    public void fireEventUserChanged(String name, long id, int level) {
        controller.onUserChange(name, id, level);
    }
}
