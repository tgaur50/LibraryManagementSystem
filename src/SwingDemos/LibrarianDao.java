package SwingDemos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LibrarianDao {
    public static boolean addBooksToDB(Books b){
        boolean isDone = false;
        try {
            Connection con = CreateConnection.createConnection();
            String query;
            boolean isFound = false;
            PreparedStatement prepStm;
            ArrayList<Books> list = getAllBooks();
            Books foundBook = null;
            for (Books book : list) {
                if (book.getCallNo().equalsIgnoreCase(b.getCallNo())) {
                    if (book.getBookName().equalsIgnoreCase(b.getBookName())
                            && book.getAuthorName().equalsIgnoreCase(b.getAuthorName())
                            && book.getPublisherName().equalsIgnoreCase(b.getPublisherName())) {
                        isFound = true;
                        foundBook = book;
                        break;
                    }
                }
            }
            if (isFound){
                query = "update Books SET quantity=?, issued=? where callNo=?";
                prepStm = con.prepareStatement(query);
                prepStm.setInt(1, (foundBook.getQuantity() + b.getQuantity()));
                prepStm.setInt(2, foundBook.getIssuedQuantity());
                prepStm.setString(3, b.getCallNo());
            }
            else {
                query = "insert into Books(callNo, name, author, publisher, quantity, issued, added_date) values(?, ?, ?, ?, ?, ?, ?)";
                prepStm = con.prepareStatement(query);
                prepStm.setString(1, b.getCallNo());
                prepStm.setString(2, b.getBookName());
                prepStm.setString(3, b.getAuthorName());
                prepStm.setString(4, b.getPublisherName());
                prepStm.setInt(5, b.getQuantity());
                prepStm.setInt(6, b.getIssuedQuantity());
                prepStm.setString(7, b.getAddedDate());
            }
            prepStm.executeUpdate();
            isDone = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isDone;
    }

    public static boolean updateBook(Books b, IssuedBook book){
        boolean isDone = false;
        try {
            Connection con = CreateConnection.createConnection();
            String query1 = "update Books SET quantity=?, issued=? where id=?";
            String query2 = "insert into IssuedBooks(bookcallno, studentid, studentname, studentcontact, issueddate) values(?, ?, ?, ?, ?)";
            PreparedStatement prepStm1 = con.prepareStatement(query1);
            prepStm1.setInt(1, (b.getQuantity() - 1));
            prepStm1.setInt(2, (b.getIssuedQuantity() + 1));
            prepStm1.setInt(3, b.getId());
            prepStm1.executeUpdate();

            PreparedStatement prepStm2 = con.prepareStatement(query2);
            prepStm2.setString(1, book.getBookCallNo());
            prepStm2.setString(2, book.getStudentId());
            prepStm2.setString(3, book.getStudentName());
            prepStm2.setString(4, book.getStudentContact());
            prepStm2.setString(5, book.getIssuedDate());
            prepStm2.executeUpdate();

            isDone = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isDone;
    }

    public static boolean returnBook(IssuedBook book, Books b){
        boolean isDone = false;
        try {
            Connection con = CreateConnection.createConnection();
            ArrayList<Books> list = getAllBooks();
            String query1 = "delete from IssuedBooks where id=?";
            String query2 = "update Books SET quantity=?, issued=? where id=?";
            PreparedStatement prepStm1 = con.prepareStatement(query1);
            prepStm1.setInt(1, book.getId());
            prepStm1.executeUpdate();

            PreparedStatement prepStm2 = con.prepareStatement(query2);
            prepStm2.setInt(1, (b.getQuantity() + 1));
            prepStm2.setInt(2, (b.getIssuedQuantity() - 1));
            prepStm2.setInt(3, b.getId());
            prepStm2.executeUpdate();

            isDone = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isDone;
    }

    public static ArrayList<Books> getAllBooks(){
        ArrayList<Books> list = new ArrayList<>();
        try {
            Connection con = CreateConnection.createConnection();
            Statement stm = con.createStatement();
            String query = "select * from Books";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String callno = rs.getString("callNo");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int quantity = rs.getInt("quantity");
                int issued = rs.getInt("issued");
                String date = rs.getString("added_date");
                Books b = new Books(id, callno, name, author, publisher, quantity, issued, date);
                list.add(b);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<IssuedBook> getIssuedBooks(){
        ArrayList<IssuedBook> list = new ArrayList<>();
        try {
            Connection con = CreateConnection.createConnection();
            Statement stm = con.createStatement();
            String query = "select * from IssuedBooks";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String callno = rs.getString("bookcallno");
                String stuid = rs.getString("studentid");
                String stuname = rs.getString("studentname");
                String stucontact = rs.getString("studentcontact");
                String issueddate = rs.getString("issueddate");
                IssuedBook b = new IssuedBook(id, callno, stuid, stuname, stucontact, issueddate);
                list.add(b);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
