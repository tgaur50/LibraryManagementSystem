package SwingDemos;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
    static Connection con;
    public static Connection createConnection(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Library_Management";
            String userName = "root";
            String password = "ThisisMySql11*";
            con = DriverManager.getConnection(url, userName, password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
