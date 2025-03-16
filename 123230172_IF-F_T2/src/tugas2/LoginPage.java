/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tugas2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author HP
 */

public class LoginPage extends JFrame implements ActionListener {
    private JLabel labelTitle = new JLabel("Login Page");
    private JLabel labelUsername = new JLabel("Username:");
    private JLabel labelPassword = new JLabel("Password:");
    
    private JTextField fieldUsername = new JTextField();
    private JPasswordField fieldPassword = new JPasswordField();
    
    private JButton buttonLogin = new JButton("Login");
    private JButton buttonReset = new JButton("Reset");
    
    public LoginPage() {
        setTitle("Login Form");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        add(labelTitle);
        add(labelUsername);
        add(labelPassword);
        add(fieldUsername);
        add(fieldPassword);
        add(buttonLogin);
        add(buttonReset);
        
        labelTitle.setBounds(180, 30, 200, 30);
        labelUsername.setBounds(50, 80, 100, 25);
        fieldUsername.setBounds(160, 80, 250, 30);
        labelPassword.setBounds(50, 130, 100, 25);
        fieldPassword.setBounds(160, 130, 250, 30);
        buttonLogin.setBounds(100, 200, 120, 35);
        buttonReset.setBounds(260, 200, 120, 35);
        
        buttonLogin.addActionListener(this);
        buttonReset.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == buttonLogin) {
                String username = fieldUsername.getText();
                String password = new String(fieldPassword.getPassword());
                
                // Validasi login
                if (username.equals("123230172") && password.equals("271032321")) {
                    JOptionPane.showMessageDialog(this, "Login Berhasil");
                    new HomePage(username);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau Password salah", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == buttonReset) {
                fieldUsername.setText("");
                fieldPassword.setText("");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
