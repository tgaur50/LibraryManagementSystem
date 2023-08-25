package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminLogin extends JFrame {
    Container c;
    public AdminLogin(ArrayList<Librararian> list){
        c = getContentPane();
        JLabel label = new JLabel("Admin Login Form");
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
            String n = name.getText();
            String pwd = password.getText();
            if (n.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("admin123")){
                dispose();
                new AdminPage(list);
            }
            else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
            }
        });

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
