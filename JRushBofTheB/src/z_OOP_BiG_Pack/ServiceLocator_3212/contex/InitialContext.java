package z_OOP_BiG_Pack.ServiceLocator_3212.contex;

//import com.javarush.task.task32.task3212.service.impl.EJBServiceImpl;
//import com.javarush.task.task32.task3212.service.impl.JMSServiceImpl;

import z_OOP_BiG_Pack.ServiceLocator_3212.service.*;
import z_OOP_BiG_Pack.ServiceLocator_3212.service.impl.*;

public class InitialContext {
    public Object lookup(String jndiName) {

        if (jndiName.equalsIgnoreCase("EJBService")) {
            System.out.println("Looking up and creating a new EJBService object");
            return new EJBServiceImpl();
        } else if (jndiName.equalsIgnoreCase("JMSService")) {
            System.out.println("Looking up and creating a new JMSService object");
            return new JMSServiceImpl();
        }
        return null;
    }
}
