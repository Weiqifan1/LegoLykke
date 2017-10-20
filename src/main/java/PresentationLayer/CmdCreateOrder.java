/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
public class CmdCreateOrder extends Command{

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, OrderSampleException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        int userID = user.getId();
        String length = request.getParameter( "length" );
        String width = request.getParameter( "width" );
        String height = request.getParameter( "height" );
        LogicFacade.createOrder(userID, length, width, height);
                
        request.setAttribute("email", user.getEmail());
        request.setAttribute("neworder", "You can see you new order by clicking show Orders");
        return user.getRole() + "page";
        
    }
    
}












