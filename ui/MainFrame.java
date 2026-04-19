package ui;

import javax.swing.*;
import java.awt.*;
import model.*;

public class MainFrame extends JFrame {

    Cart cart = new Cart();

    public MainFrame() {
        setTitle("E-Commerce JDBC App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new ProductPanel(cart), BorderLayout.CENTER);
        add(new CartPanel(cart), BorderLayout.SOUTH);

        setVisible(true);
    }
}