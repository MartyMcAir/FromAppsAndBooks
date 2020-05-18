package z_OOP_BiG_Pack.ServiceLocator_3212;

import z_OOP_BiG_Pack.ServiceLocator_3212.service.*;
//import z_OOP_BiG_Pack.ServiceLocator_3212.service.*;
//import com.javarush.task.task32.task3212.service.Service;

/* 
Service Locator
*/

// https://javarush.ru/tasks/com.javarush.task.task32.task3212#discussion
public class Solution {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("EJBService");
        service.execute();
        System.out.println();
        service = ServiceLocator.getService("JMSService");
        service.execute();

    }
}
