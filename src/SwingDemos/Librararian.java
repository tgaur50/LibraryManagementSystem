package SwingDemos;

import java.util.ArrayList;

public class Librararian {
    private int id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private String contact;

    public Librararian(){
        id = 0;
        name = "";
        password = "";
        email = "";
        address = "";
        city = "";
        contact = "";
    }

    public Librararian(int id, String name, String password, String email, String address, String city, String contact) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact = contact;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
