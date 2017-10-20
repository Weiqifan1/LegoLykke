/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Christian
 */
public class OrderMapper {
    
    public static void putToOrderTable(int user_id, String length, String width, String height) throws OrderSampleException {
        try {
            Connection con = Connector.connection();
            
            DateFormat myformat = new SimpleDateFormat("yyyyMMdd HH:mm");
            String createTime = myformat.format(new Date(System.currentTimeMillis()));
            
            String insertOrder = "INSERT INTO diverse.order ("
                + "createtime, "
                + "user_id,"
                + "length,"
                + "width,"
                + "height) "
                + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement recipePstmt = con.prepareStatement(insertOrder);
            try {
                con.setAutoCommit(false);
                recipePstmt.setString(1, createTime);
                recipePstmt.setInt(2, user_id);
                recipePstmt.setInt(3, Integer.parseInt(length));
                recipePstmt.setInt(4, Integer.parseInt(width));
                recipePstmt.setInt(5, Integer.parseInt(height));
                recipePstmt.executeUpdate();
                con.commit();
            } finally {
                con.setAutoCommit(true);
            }
                        
        }catch ( ClassNotFoundException | SQLException ex ) {
            throw new OrderSampleException(ex.getMessage());
        }
    }
    
    public static Order getOrderFromID(String orderID) throws OrderSampleException {
        Order output = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM diverse.order WHERE createtime=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, orderID );
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst() ) {  
                rs.next();
                String createTime = rs.getString( "createtime" );
                int userID = rs.getInt( "user_id" );
                String sendTime = rs.getString( "sendtime" );
                    int length = rs.getInt("length" );
                    int width = rs.getInt( "width" );
                    int height = rs.getInt( "height" );
                    output = new Order(createTime, userID, sendTime, length, width, height);
            } else {
                throw new OrderSampleException( "No Order found" );
            } 
        }catch ( ClassNotFoundException | SQLException ex ) {
            throw new OrderSampleException(ex.getMessage());
        }
        return output;
    }
    
    public static ArrayList<Order> getOrderList(int userId) throws OrderSampleException {
        ArrayList<Order> output = new ArrayList<Order>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM diverse.order WHERE user_id=?";
                    //"SELECT * FROM order WHERE user_id=2"; //?
                    
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, Integer.toString(userId) );
            ResultSet rs = ps.executeQuery();
            
            if (rs.isBeforeFirst() ) {    
                 while ( rs.next()) {
                    String createTime = rs.getString( "createtime" );
                    String sendTime = rs.getString( "sendtime" );
                    int length = rs.getInt("length" );
                    int width = rs.getInt( "width" );
                    int height = rs.getInt( "height" );
                    Order order = new Order(createTime, userId, sendTime, length, width, height);
                    output.add(order);
                }
            } else {
                throw new OrderSampleException( "No orderlist found" );
            }                  
                                    
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new OrderSampleException(ex.getMessage());
        }
        return output;
    }
    /*
    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    */
}
