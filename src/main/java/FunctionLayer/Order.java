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
public class Order {
    
    public Order(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public Order(String dateTime, int userId, int length, int width, int height) {
        this.userEmail = null;
        this.dateTime = dateTime;
        this.userId = userId;
        this.sendTime = null;
        this.length = length;
        this.width = width;
        this.height = height;
                
    }
        
    public Order(String dateTime, int userId, String sendTime, int length, int width, int height) {
        this.userEmail = null;
        this.dateTime = dateTime;
        this.userId = userId;
        this.sendTime = sendTime;
        this.length = length;
        this.width = width;
        this.height = height;
    }  
    
    private String userEmail;
    private String dateTime;
    private int userId;
    private String sendTime;
    private int length;
    private int width;
    private int height;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Order{" + "userEmail=" + userEmail + ", dateTime=" + dateTime + ", userId=" + userId + ", sendTime=" + sendTime + ", length=" + length + ", width=" + width + ", height=" + height + '}';
    }

    
    
    
    
    
    
}
