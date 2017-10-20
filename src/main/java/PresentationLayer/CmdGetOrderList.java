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
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
public class CmdGetOrderList extends Command{

    public CmdGetOrderList() {
    }   
    
    //public OrderList(String orderId) throws OrderSampleException {
    //    Order myorder = LogicFacade.getOrderByID(orderId);
        
    //}  
    
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws OrderSampleException {
        // de to nedenstående skal ikke bruges, da "wantorderlist" ikke involvere input fra brugeren
        //String email = request.getParameter( "email" );
        //String password = request.getParameter( "password" );
        
        ArrayList<String> str1 = Collections.list(request.getParameterNames());
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        // lav et kald til logic facaden og send resultatet til "showorderlist"
        // nedestående metode skal nok ændres, så den tager user.GetEmaiil,
        // derefter skal userEmail lægges ned i hver ordre....men dette er måske for meget spagetti.
        ArrayList<Order> orderList = LogicFacade.getOrderList(user.getId(), user.getEmail());
        
        request.setAttribute("showorderlist", orderList);
        request.setAttribute("username", user.getEmail());
               
        
        /*
        User user = LogicFacade.login( email, password );
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        return user.getRole() + "page";
        */
        
        return "customerorderlist";
    }
    
}
