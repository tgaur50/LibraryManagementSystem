package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LibrarianLogin extends JFrame{
    Container c;
    public LibrarianLogin(){
        c = getContentPane();
        JLabel label = new JLabel("Librarian Login Form");
        label.setBounds(200, 100, 200, 50);
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(50, 150, 100, 30);
        JTextField name = new JTextField();
        name.setBounds(200, 150, 200, 30);
        JLabel passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setBounds(50, 200, 100, 30);
        JPasswordField password = new JPasswordField();
        password.setBounds(200, 200, 200, 30);
        JButton login = new JButton("Login");
        login.setBounds(300, 250, 100, 50);

        c.add(label);
        c.add(nameLabel);
        c.add(name);
        c.add(passwordLabel);
        c.add(password);
        c.add(login);

        login.addActionListener(e -> {
            String lName = name.getText();
            String lPwd = password.getText();
            boolean isFound = false;
            ArrayList<Librararian> list = AdminDao.getLibrarians();
            for (Librararian librarian : list) {
                if (librarian.getName().equals(lName) && librarian.getPassword().equals(lPwd)) {
                    isFound = true;
                    break;
                }
            }
            if (isFound){
                dispose();
                new LibrarianPage();
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
            }
        });

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
