/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Calc;
import FunctionLayer.Order;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class RenderOrder {
    
    public static String renderOrderList(ArrayList<Order> orderList) {
        String output = "";
        for (Order o: orderList) {
            output = output + o.toString() + " " + o.getDateTime() + "<br>"
                    + showLinkToOrder(o.getDateTime()) + "<br>";
        }
        return output;
    }
    
    private static String showLinkToOrder(String orderId) {//String orderId) {
        String str1 = "<form name= formOrderButton action= FrontController method= POST >";
        String str2 = "<input type= hidden name= command value="; 
        String str3 =  "\"" + orderId + "\"";//orderId;
        String str4 = "> <input type= submit  value= showThisOrder > </form>";
        
        return   str1 + str2 + str3 + str4;
            
    }
    
    public static String renderSingleOrder(Calc input) {
        //return input.getOrder().toString();
        return input.toString();
    }
    
    
    
    
}   



    /*
    public static String renderOrderList(ArrayList<Order> orderList) {
        String output = "";
        output += "<tbody>";

        for (Order o : orderList) {
            String id = o.getDateTime();
            String username = o.getUserEmail();

            output += "<br> "
                    + "<tr><td>" + id + "</td>"
                    + "<td>" + username + "</td>"
                    + "<td><a href=\"/LegoLykke/WEB-INF/customerorder.jsp\"> View this order </a></td>";
                    //http://localhost:8084/LegoLykke/WEB-INF/customerorder.jsp
                    //http://localhost:8084/LegoLykke/WEB-INF/customerorder.jsp
                    //"<td><a href=\"/WEB-INF/customerorder.jsp\"> View this order </a></td>";
                    //"<td><a href=\"customerorder.jsp?orderId=" + id + "\"> View this order </a></td>";
        }
        output += "</tbody>";
        return output;
    }
    */
    
    /*
    public static String renderOrderList(ArrayList<Order> orderList) {
        String output = "";
        for (Order o: orderList) {
            output = output + o.toString() + "<br>" + showLinkToOrder(o.getDateTime()) + "<br>";
        }
        return output;
    }
    
    private static String showLinkToOrder(String orderId) {//String orderId) {
        String str1 = "<form name= formOrderButton action= FrontController method= POST >";
        String str2 = "<input type= hidden name= command value="; 
        String str3 = orderId;
        String str4 = "> <input type= submit  value= showThisOrder > </form>";
        
        return   str1 + str2 + str3 + str4;
            
    }
    */

