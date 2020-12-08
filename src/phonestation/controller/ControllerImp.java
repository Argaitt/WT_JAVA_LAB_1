package phonestation.controller;

import  phonestation.controller.command.Command;
public class ControllerImp implements Controller {
    private final CommadProvider provider = new CommadProvider();
    private final char paramDelimiter = ' ';
    public String ExexuteTesk(String request){
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimiter));
        executionCommand = provider.GetCommand(commandName);
        String responce;
        responce = executionCommand.execute(request);
        return responce;
    }
}
