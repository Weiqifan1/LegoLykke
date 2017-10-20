package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of Command is to...

 @author kasper
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        } else if (commandName.equals("wantorderlist")) { //
            commands.put("wantorderlist", new CmdGetOrderList() );
            System.out.println(commandName);
        } else if (commandName.equals("moveon")) {
            commands.put("moveon", new CmdGetOrder("moveon"));
        } else if (commandName.equals("writeorder")) {
            commands.put("writeorder", new CmdCreateOrder());
        }
        else{
           commands.put(commandName, new CmdGetOrder(commandName));
            
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException, OrderSampleException;

}
