package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
         
    public static void createOrder(int user_id, String length, String width, String height) throws OrderSampleException {
        OrderMapper.putToOrderTable(user_id, length, width, height);
    }
    
    public static Calc getOrderInfo(String orderID) throws OrderSampleException {
        Calc output = prepareCalc(orderID);
        return output;
        
    }
    
    public static ArrayList<Order> getOrderList(int userid, String useremail) throws OrderSampleException {
        ArrayList<Order> output = new ArrayList<Order>();
        output = OrderMapper.getOrderList(userid);
        output = completeOrder(output, useremail);
        return output;
    }
    
    private static ArrayList<Order> completeOrder(ArrayList<Order> orders, String useremail) {
        for (Order o: orders) {
            o.setUserEmail(useremail);
        }
        return orders;
    }
        
    private static Order getOrderByID(String orderID) throws OrderSampleException {
        Order output = OrderMapper.getOrderFromID(orderID);        
        return output;
    }  
        
    private static Calc prepareCalc(String orderID) throws OrderSampleException {
        Order myorder = getOrderByID(orderID);
        Calc prepareCalc = new Calc(myorder);
        Calc output = performCalc(prepareCalc);
        return output;
    }
    
    private static Calc performCalc(Calc input) {
        Calc output = input;        
        int length = input.getOrder().getLength(); 
        int width = input.getOrder().getWidth();
        int height = input.getOrder().getHeight(); 
        
        Brick allBricks = houseNoWalls(length, width, height);
        allBricks = addDoor(allBricks, length, width, height);
        allBricks = addDoor(allBricks, length, width, height);
        
        output.setFourByTwo(allBricks.getFourByTwo());
        output.setTwoByTwo(allBricks.getTwoByTwo());
        output.setOneByTwo(allBricks.getOneByTwo());
        
        return output;
    }
        
    private static Brick addWindow(Brick house, int length, int width, int height) {
        Brick output = null;
        Brick removeBricks = new Brick();
        if (height > 3 && length > 7) {
            if (length%4 == 0 || length%4 == 1) {
                removeBricks.setFourByTwo(-3);
                removeBricks.setTwoByTwo(2);
            }
            if (length%4 == 2 || length%4 == 3) {
                removeBricks.setFourByTwo(-2);
            }
        }
        output = addBricks(house, removeBricks);
        return output;
    }
        
    private static Brick addDoor(Brick house, int length, int width, int height) {
        Brick output = null;
        Brick removeBricks = new Brick();
        if (height > 3 && length > 7) {
            
            if (length%4 == 0 || length%4 == 1) {
                removeBricks.setFourByTwo(-5);
                removeBricks.setTwoByTwo(4);
            }
            if (length%4 == 2 || length%4 == 3) {
                removeBricks.setFourByTwo(-3);
            }
            
        }
        output = addBricks(house, removeBricks);
        return output;
    }
    
    private static Brick houseNoWalls(int length, int width, int height) {
        Brick allBricks = new Brick();
        Brick unevenLayer = unevenLayer(length, width);
        Brick evenLayer = evenLayer(length, width);
        for (int i = 0; i < (height/2); i++) {
            allBricks = addBricks(allBricks, unevenLayer);
            allBricks = addBricks(allBricks, evenLayer);
        }
        if (height%2 > 0) {
            allBricks = addBricks(allBricks, unevenLayer);
        }        
        return allBricks;
    }
    
    private static Brick evenLayer(int length, int width) {
        Brick output = new Brick();
        
        Brick longest = twoSides(width, 0);
        if (longest.getTwoByTwo() > 0 && longest.getOneByTwo() == 0) {
            longest.setTwoByTwo(longest.getTwoByTwo()-2);
            longest.setOneByTwo(longest.getOneByTwo()+4);
        }  
        Brick shortest = twoSides(length, 4);
        if (shortest.getTwoByTwo() > 0 && shortest.getOneByTwo() == 0) {
            shortest.setTwoByTwo(shortest.getTwoByTwo()-2);
            shortest.setOneByTwo(shortest.getOneByTwo()+4);
        }      
        
        Brick evenLayer = addBricks(longest, shortest);
        
        output.setFourByTwo(evenLayer.getFourByTwo());
        output.setTwoByTwo(evenLayer.getTwoByTwo());
        output.setOneByTwo(evenLayer.getOneByTwo());
        
        return output;
    }
    
    private static Brick unevenLayer(int length, int width) {
        Brick output = new Brick();
        
        Brick longest = twoSides(length, 0);
        Brick shortest = twoSides(width, 4);
        Brick uevenLayer = addBricks(longest, shortest);
        
        output.setFourByTwo(uevenLayer.getFourByTwo());
        output.setTwoByTwo(uevenLayer.getTwoByTwo());
        output.setOneByTwo(uevenLayer.getOneByTwo());
        
        return output;
    }
    
    private static Brick addBricks(Brick a, Brick b) {
        Brick output = new Brick();
        output.setFourByTwo(a.getFourByTwo() + b.getFourByTwo());
        output.setTwoByTwo(a.getTwoByTwo() + b.getTwoByTwo());
        output.setOneByTwo(a.getOneByTwo() + b.getOneByTwo());
        return output;
    }  
    
    private static Brick twoSides(int width, int reduceSide) {
        Brick output = new Brick();
        
        int fourByTwo = (width - reduceSide) / 4;
        int remain = (width - reduceSide) % 4;
        int twoByTwo = remain / 2;
        int oneByTwo = remain % 2;
        
        output.setFourByTwo(fourByTwo * 2);
        output.setTwoByTwo(twoByTwo * 2);
        output.setOneByTwo(oneByTwo * 2);
        
        return output;
    }
    
    public static void main(String[] args) {
                
        Order myorder = new Order(10,10,2);
        Calc mycalc = new Calc(myorder);
        
        Calc result1 = performCalc(mycalc);
        
        Brick result_uneven = unevenLayer(10,10);
        Brick result_even = evenLayer(10,10);
        
        System.out.println("combined result:");
        System.out.println(result1.toString());
        System.out.println("result_uneven:");
        System.out.println(result_uneven.toString());
        System.out.println("result_even:");
        System.out.println(result_even.toString());
        
    }
    

}
