package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.contex.InitialContext;
import com.javarush.task.task32.task3212.service.Service;

import java.io.Serializable;

// https://javarush.ru/tasks/com.javarush.task.task32.task3212#discussion
// задача понравилась решил сам, легко _ но интересная так что в B of The B
// благодаря чтени в основном https://www.codeflow.site/ru/article/java-service-locator-pattern - Шаблон сервисного локатора
public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    /**
     * First, check for a service object in the cache
     * If a service object is not in the cache, perform a lookup using
     * the JNDI initial context and get the service object. Add it to
     * the cache for future use.
     *
     * @param jndiName The name of the service object in the context
     * @return Object mapped to the name in context
     */
    public static Service getService(String jndiName) {
        // Code Here
        Service service = cache.getService(jndiName);
        if (service != null)
            return service; // если найдено в кэше то вовращаем их кэша

        InitialContext init = new InitialContext();  // далее кастуем к общему интерфейсу всех сервисов
        Service serviceInit = (Service) init.lookup(jndiName); // переключатель вернет нужный сервис
        cache.addService(serviceInit); // добавляем в кэш полученный сервис (при след запросе будет выдан из кэша)
        return serviceInit;
    }
}
