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

public class PurchasePage extends JFrame implements ActionListener {
    private String username;
    private String dvdCategory;
    private float dvdPrice;
    
    private JLabel labelTitle;
    private JLabel labelCategory;
    private JLabel labelPrice;
    private JLabel labelQuantity = new JLabel("Jumlah:");
    private JTextField fieldQuantity = new JTextField();
    private JButton buttonBack = new JButton("Kembali");
    private JButton buttonPurchase = new JButton("Beli");
    
    private JLabel labelDetailTitle = new JLabel("Total Pembelian");
    private JLabel labelUnitPrice = new JLabel("Harga Satuan:");
    private JLabel labelAmount = new JLabel("Jumlah:");
    private JLabel labelPPN = new JLabel("PPN (11%):");
    private JLabel labelTotalPrice = new JLabel("Total Harga:");
    
    private JLabel valueUnitPrice = new JLabel("Rp 0");
    private JLabel valueAmount = new JLabel("0 pcs");
    private JLabel valuePPN = new JLabel("Rp 0");
    private JLabel valueTotalPrice = new JLabel("Rp 0");
    
    public PurchasePage(String category, float price, String uname) {
        this.username = uname;
        this.dvdCategory = category;
        this.dvdPrice = price;
        
        labelTitle = new JLabel("Halaman Pembelian");
        labelCategory = new JLabel("Kategori: " + this.dvdCategory);
        labelPrice = new JLabel("Harga: Rp " + String.format("%.3f", this.dvdPrice) + " /pcs");

        setTitle("Purchase Page");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        add(labelTitle);
        add(labelCategory);
        add(labelPrice);
        add(labelQuantity);
        add(fieldQuantity);
        add(buttonPurchase);
        add(buttonBack);
        
        add(labelDetailTitle);
        add(labelUnitPrice);
        add(labelAmount);
        add(labelPPN);
        add(labelTotalPrice);
        
        add(valueUnitPrice);
        add(valueAmount);
        add(valuePPN);
        add(valueTotalPrice);

        labelTitle.setBounds(20, 20, 200, 25);
        labelCategory.setBounds(20, 50, 200, 25);
        labelPrice.setBounds(20, 80, 200, 25);
        labelQuantity.setBounds(20, 110, 100, 25);
        fieldQuantity.setBounds(100, 110, 100, 25);
        buttonPurchase.setBounds(20, 150, 350, 35);
        
        labelDetailTitle.setBounds(20, 200, 200, 25);
        labelUnitPrice.setBounds(20, 230, 120, 25);
        valueUnitPrice.setBounds(150, 230, 200, 25);
        labelAmount.setBounds(20, 260, 120, 25);
        valueAmount.setBounds(150, 260, 200, 25);
        labelPPN.setBounds(20, 290, 120, 25);
        valuePPN.setBounds(150, 290, 200, 25);
        labelTotalPrice.setBounds(20, 320, 120, 25);
        valueTotalPrice.setBounds(150, 320, 200, 25);
        
        buttonBack.setBounds(20, 360, 350, 35);

        buttonBack.addActionListener(this);
        buttonPurchase.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBack) {
            new HomePage(this.username);
            dispose();
        } else if (e.getSource() == buttonPurchase) {
            try {
                int quantity = Integer.parseInt(fieldQuantity.getText());
                float totalPPN = (quantity * dvdPrice * 0.11f);
                float total = (quantity * dvdPrice) + totalPPN;
                
                valueUnitPrice.setText("Rp " + String.format("%.3f", dvdPrice));
                valueAmount.setText(quantity + " pcs");
                valuePPN.setText("Rp " + String.format("%.3f", totalPPN));
                valueTotalPrice.setText("Rp " + String.format("%.3f", total));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan jumlah yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

