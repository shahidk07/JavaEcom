package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.*;
import dao.*;

public class ProductPanel extends JPanel {

    public ProductPanel(Cart cart) {
        setLayout(new GridLayout(0,1));

        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();

        for(Product p : products) {
            JButton btn = new JButton("Add: " + p.toString());

            btn.addActionListener(e -> {
                cart.addProduct(p);
                JOptionPane.showMessageDialog(this, p.getName() + " added!");
            });

            add(btn);
        }
    }
}