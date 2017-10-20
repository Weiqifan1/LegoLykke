/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Calc;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
public class CmdGetOrder extends Command {
    
    private String orderID;
    public CmdGetOrder(String orderID) {
        this.orderID = orderID;
    }
    
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException {
        
        //nedenstående virker ikke. der returnesres null, 
        //formentlig fordig requesten er helt ny, og derfor tom.
        //ArrayList<Order> output = (ArrayList<Order>) request.getAttribute("showorderlist");
        
        Calc myCalc = LogicFacade.getOrderInfo(orderID);
        
        request.setAttribute("cmdorderresult", myCalc);
        return "customerorder";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
