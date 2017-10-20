/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Christian
 */
public class Calc {

    public Calc(Order order) {
        this.order = order;
    }
        
    private Order order;
    private int fourByTwo;
    private int twoByTwo;
    private int oneByTwo;

    public Order getOrder() {
        return order;
    }

    public int getFourByTwo() {
        return fourByTwo;
    }

    public void setFourByTwo(int fourByTwo) {
        this.fourByTwo = fourByTwo;
    }

    public int getTwoByTwo() {
        return twoByTwo;
    }

    public void setTwoByTwo(int twoByTwo) {
        this.twoByTwo = twoByTwo;
    }

    public int getOneByTwo() {
        return oneByTwo;
    }

    public void setOneByTwo(int oneByTwo) {
        this.oneByTwo = oneByTwo;
    }

    @Override
    public String toString() {
        return "Calc{" + " Created:"+ order.getDateTime()+" Sent:"+order.getSendTime()+" userId:"+order.getUserId()+" "+
        " dimensions: " + "L:"+order.getLength()+ " W:" + order.getWidth()+ " H:" + order.getHeight()  +" "+
        "Bricks: fourByTwo=" + fourByTwo + ", twoByTwo=" + twoByTwo + ", oneByTwo=" + oneByTwo + '}';
    }

    

    

    
    
    
}
