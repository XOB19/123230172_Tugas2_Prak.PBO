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

public class HomePage extends JFrame implements ActionListener {
    private String username;
    private JLabel labelWelcome;
    private JLabel labelInstruction = new JLabel("Silakan pilih kategori DVD di bawah:");
    private JButton buttonDvdAnak = new JButton("DVD Anak");
    private JButton buttonDvdDewasa = new JButton("DVD Dewasa");
    private JButton buttonDvdLansia = new JButton("DVD Lansia");
    private JButton buttonLogout = new JButton("Log Out");
    
    public HomePage(String uname) {
        this.username = uname;
        labelWelcome = new JLabel("Selamat Datang, " + this.username);
        
        setTitle("Home Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        add(labelWelcome);
        add(labelInstruction);
        add(buttonDvdAnak);
        add(buttonDvdDewasa);
        add(buttonDvdLansia);
        add(buttonLogout);
        
        labelWelcome.setBounds(20, 20, 300, 30);
        labelInstruction.setBounds(20, 50, 300, 25);
        buttonDvdAnak.setBounds(20, 100, 150, 50);
        buttonDvdDewasa.setBounds(200, 100, 150, 50);
        buttonDvdLansia.setBounds(380, 100, 150, 50);
        buttonLogout.setBounds(20, 180, 510, 40);
        
        buttonLogout.addActionListener(this);
        buttonDvdAnak.addActionListener(this);
        buttonDvdDewasa.addActionListener(this);
        buttonDvdLansia.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogout) {
            JOptionPane.showMessageDialog(this, "Anda Logout");
            new LoginPage();
            dispose();
        } else if (e.getSource() == buttonDvdAnak) {
            new PurchasePage("DVD Anak", 27.891f, this.username);
            dispose();
        } else if (e.getSource() == buttonDvdDewasa) {
            new PurchasePage("DVD Dewasa", 35.396f, this.username);
            dispose();
        } else if (e.getSource() == buttonDvdLansia) {
            new PurchasePage("DVD Lansia", 38.550f, this.username);
            dispose();
        }
    }
}

