package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {
        
    private static Connection singleton;
    
        private static final String IP =       "46.101.152.26";//"127.0.0.1";//"46.101.152.26";
        private static final String PORT =     "3306";
        private static final String DATABASE = "diverse"   ;//"diverse";
        private static final String USERNAME = "diverseuser";//"root";
        private static final String PASSWORD =  "diversemysql"   ;//"Mantzius1";
    
    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( singleton == null || singleton.isClosed()) {
            Class.forName( "com.mysql.jdbc.Driver" );
            String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }
}        
    
/*
package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
        
    private static Connection singleton;
    
        private static final String IP = "46.101.152.26";
        private static final String PORT = "3306";
        private static final String DATABASE = "diverse";
        private static final String USERNAME = "diverseuser";
        private static final String PASSWORD = "diversemysql";
    
    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( singleton == null || singleton.isClosed()) {
            Class.forName( "com.mysql.jdbc.Driver" );
            String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }
}    
*/





    // 2017-10-10 : oprindelig kode.
    /*
    private static final String url = "jdbc:mysql://46.101.253.149:3306/useradmin";
    private static final String username = "doorkeeper";
    private static final String password = "bank3*andyouarein";

    private static Connection singleton;

    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( singleton == null ) { //if ( singleton == null || singleton.isClosed)
            Class.forName( "com.mysql.jdbc.Driver" );
            singleton = DriverManager.getConnection( url, username, password );
        }
        return singleton;
    }
    */
    
    
    
    // laant kode fra tidl projekt:
    
    
    /*
        private Connection connection = null;

        private static final String IP = "localhost";
        private static final String PORT = "3306";
        private static final String DATABASE = "glaziersp";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "Mantzius1";

        public DBConnector() throws Exception {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
            this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
        }

        public Connection getConnection() {
            return this.connection;
        }
    */
    

