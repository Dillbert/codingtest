import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private Connection con = null;
    public Statement statement = null; 
    private final String CREATE_CUSTOMER_DB_SQL = "CREATE DATABASE IF NOT EXISTS customers";
    private final String CREATE_CUSTOMER_TABLE_SQL  = 
    "CREATE TABLE IF NOT EXISTS customer " +
    "(id INTEGER not NULL AUTO_INCREMENT, " +
    " ref VARCHAR(10), " + 
    " name VARCHAR(20), " + 
    " addrLine1 VARCHAR(200), " + 
    " addrLine2 VARCHAR(200), " + 
    " town VARCHAR(30), " + 
    " county VARCHAR(30), " + 
    " country VARCHAR(30), " + 
    " postCode VARCHAR(10), " + 
    " createdDate DATE, " + 
    " PRIMARY KEY ( id ))"; 
    private final String DROP_TABLE_CUSTOMER_SQL  =  "Delete from customer where id != 0";
    private final String USE_DATABASE_CUSTOMERS_SQL  =  "USE customers";

    public Database(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=rootuser"); 
        
        } catch(Exception e){
            e.printStackTrace();
        }
    }

     
    private Connection getConnection(){
        return this.con;
    }
    
    public void Setup(){
        try { 
            statement = getConnection().createStatement();
            statement.executeUpdate(CREATE_CUSTOMER_DB_SQL);
            statement.executeUpdate(USE_DATABASE_CUSTOMERS_SQL); 
            statement.executeUpdate(CREATE_CUSTOMER_TABLE_SQL); 
            statement.executeUpdate(DROP_TABLE_CUSTOMER_SQL); 

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
