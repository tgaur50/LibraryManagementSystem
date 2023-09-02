package SwingDemos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDao {
    public static boolean insertLibrarian(Librararian l){
        boolean isDone = false;
        try {
            Connection con = CreateConnection.createConnection();
            String query = "insert into Librarian(name, password, email, address, city, contact) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement prepStm = con.prepareStatement(query);
            prepStm.setString(1, l.getName());
            prepStm.setString(2, l.getPassword());
            prepStm.setString(3, l.getEmail());
            prepStm.setString(4, l.getAddress());
            prepStm.setString(5, l.getCity());
            prepStm.setString(6, l.getContact());

            prepStm.executeUpdate();
            isDone = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isDone;
    }

    public static int deleteLibrarian(int libId){
        int numRows = 0;
        try {
            Connection con = CreateConnection.createConnection();
            String query = "delete from Librarian where id=?";
            PreparedStatement prepStm = con.prepareStatement(query);
            prepStm.setInt(1, libId);
            numRows = prepStm.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return numRows;
    }

    public static ArrayList<Librararian> getLibrarians(){
        ArrayList<Librararian> list = new ArrayList<>();
        try {
            Connection con = CreateConnection.createConnection();
            Statement stm = con.createStatement();
            String query = "select * from Librarian";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pwd = rs.getString("password");
                String email = rs.getString("email");
                String addr = rs.getString("address");
                String city = rs.getString("city");
                String contact = rs.getString("contact");
                Librararian l = new Librararian(id, name, pwd, email, addr, city, contact);
                list.add(l);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
