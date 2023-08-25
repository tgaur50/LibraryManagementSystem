package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddLibrarianPage extends JFrame {
    Container c;
    public AddLibrarianPage(ArrayList<Librararian> list){
        c = getContentPane();

        JLabel label = new JLabel("Add Librarian");
        label.setBounds(200, 50, 200, 50);
        JLabel name = new JLabel("Name:");
        name.setBounds(50, 100, 100, 50);
        JTextField nameField = new JTextField();
        nameField.setBounds(200, 100, 200, 30);
        JLabel password = new JLabel("Password:");
        password.setBounds(50, 150, 100, 50);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(200, 150, 200, 30);
        JLabel email = new JLabel("Email");
        email.setBounds(50, 200, 100, 50);
        JTextField emailField = new JTextField();
        emailField.setBounds(200, 200, 200, 30);
        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 100, 50);
        JTextField addrField = new JTextField();
        addrField.setBounds(200, 250, 200, 30);
        JLabel city = new JLabel("City:");
        city.setBounds(50, 300, 100, 50);
        JTextField cityField = new JTextField();
        cityField.setBounds(200, 300, 200, 30);
        JLabel contact = new JLabel("Contact No:");
        contact.setBounds(50, 350, 100, 50);
        JTextField contactField = new JTextField();
        contactField.setBounds(200, 350, 200, 30);
        JButton add = new JButton("Add Librarian");
        add.setBounds(300, 400, 100, 50);
        JButton back = new JButton("Back");
        back.setBounds(200, 480, 100, 50);

        c.add(label);
        c.add(name);
        c.add(nameField);
        c.add(password);
        c.add(passField);
        c.add(email);
        c.add(emailField);
        c.add(address);
        c.add(addrField);
        c.add(city);
        c.add(cityField);
        c.add(contact);
        c.add(contactField);
        c.add(add);
        c.add(back);

        add.addActionListener(e -> {
            String nameVal = nameField.getText();
            String pwd = passField.getText();
            String em = emailField.getText();
            String addr = addrField.getText();
            String cityVal = cityField.getText();
            String contactVal = contactField.getText();
            int id;
            Librararian l = null;
            String nameRegex = "[A-Za-z\s\\.]+";
            String pwdRegex = ".{5,}";
            String emailRegex = "[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            String addrRegex = "[A-Za-z0-9-_\s,\\.]+";
            String cityRegex = "[A-Za-z]+";
            String contactRegex = "(\\+[0-9]{2})*[0-9]{10}";
            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(nameVal);

            Pattern pwdPattern = Pattern.compile(pwdRegex);
            Matcher pwdMatcher = pwdPattern.matcher(pwd);

            Pattern emailPattern = Pattern.compile(emailRegex);
            Matcher emailMatcher = emailPattern.matcher(em);

            Pattern addrPattern = Pattern.compile(addrRegex);
            Matcher addrMatcher = addrPattern.matcher(addr);

            Pattern cityPattern = Pattern.compile(cityRegex);
            Matcher cityMatcher = cityPattern.matcher(cityVal);

            Pattern contactPattern = Pattern.compile(contactRegex);
            Matcher contactMatcher = contactPattern.matcher(contactVal);
            l = new Librararian();
            if (list.isEmpty()){
                id = 1;
            }
            else {
                id = list.get(list.size() - 1).getId() + 1;
            }
            l.setId(id);
            String error = "";
            if (nameMatcher.matches()){
                l.setName(nameVal);
            }else{
                error = error + "Invalid Name!\n";
            }
            if(pwdMatcher.matches()){
                l.setPassword(pwd);
            }
            else {
                error = error + "Invalid Password!\n";
            }
            if (emailMatcher.matches()){
                l.setEmail(em);
            }
            else {
                error += "Invalid Email!\n";
            }
            if (addrMatcher.matches()) {
                l.setAddress(addr);
            }
            else {
                error += "Invalid Address!\n";
            }
            if (cityMatcher.matches()) {
                l.setCity(cityVal);
            }
            else {
                error += "Invalid City!\n";
            }
            if (contactMatcher.matches()){
                l.setContact(contactVal);
            }
            else {
                error += "Invalid Contact!\n";
            }
            if (error.equals("")){
                list.add(l);
                JOptionPane.showMessageDialog(this, "Librarian added successfully!");
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, error);
            }
        });

        back.addActionListener(e -> {
            dispose();
//            new AdminPage(list);
        });

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
