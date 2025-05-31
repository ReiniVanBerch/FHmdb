package at.ac.fhcampuswien.fhmdb.Controller;

import javafx.util.Callback;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory implements Callback<Class<?>, Object>
{

    private final Map<Class<?>, Object> controllerInstances = new HashMap<>();

    @Override
    public Object call(Class<?> controllerClass) {
        return controllerInstances.computeIfAbsent(controllerClass, cls -> {
            try {
                return cls.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Controller-Instanz konnte nicht erstellt werden: " + cls.getName(), e);
            }
        });
    }
}


