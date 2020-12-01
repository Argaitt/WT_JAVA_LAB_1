package phonestation.controller;

import phonestation.controller.command.Command;
import  phonestation.controller.command.imp.SingIn;
import  phonestation.controller.command.imp.Registration;
import  phonestation.controller.command.CommadName;

import java.util.HashMap;
import java.util.Map;

final class CommadProvider {
    private final Map<String, Command> repository = new HashMap<>();
    CommadProvider(){
        repository.put(CommadName.SIGN_IN,new SingIn());
        repository.put(CommadName.REGISTRATION, new Registration());
    }
    Command GetCommand(String name){
        Command command = null;
        try {
            command = repository.get(name.toUpperCase());
        }catch (IllegalArgumentException | NullPointerException e){

        }
        return command;
    }
}
