package z_OOP_BiG_Pack.ServiceLocator_3212.service.impl;

//import com.javarush.task.task32.task3212.service.Service;
import z_OOP_BiG_Pack.ServiceLocator_3212.service.*;

public class JMSServiceImpl implements Service {

    @Override
    public void execute() {
        System.out.println("Executing the JMSService");
    }

    @Override
    public String getName() {
        return "JMSService";
    }

}
