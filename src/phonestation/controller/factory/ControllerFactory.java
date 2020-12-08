package phonestation.controller.factory;

import phonestation.controller.ControllerImp;
import phonestation.controller.Controller;

public class ControllerFactory {
    private static final ControllerFactory instance = new ControllerFactory();
    private final Controller controller = new ControllerImp();
    private ControllerFactory(){};
    public static ControllerFactory GetInstance(){
        return instance;
    }
    public Controller GetController(){
        return controller;
    }
}
