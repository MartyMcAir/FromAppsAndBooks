package z_OOP_BiG_Pack.OOP_MVC_3608.view;

import z_OOP_BiG_Pack.OOP_MVC_3608.controller.Controller;
import z_OOP_BiG_Pack.OOP_MVC_3608.model.ModelData;

public interface View {
    void refresh(ModelData modelData);

    void setController(Controller controller);

}
