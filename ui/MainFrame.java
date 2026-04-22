package ui;

import javax.swing.*;
import java.awt.*;
import model.*;

public class MainFrame extends JFrame {

    Cart cart = new Cart();

    public MainFrame() {
        setTitle("E-Commerce Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        getContentPane().setBackground(new Color(240, 242, 245));

        // 🔷 Header
        JPanel header = new JPanel();
        header.setBackground(new Color(44, 62, 80));
        header.setPreferredSize(new Dimension(800, 60));

        JLabel title = new JLabel("E-Commerce Store");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        header.add(title);

        // Panels
        CartPanel cartPanel = new CartPanel(cart);
        ProductPanel productPanel = new ProductPanel(cart, cartPanel);

        add(header, BorderLayout.NORTH);
        add(productPanel, BorderLayout.CENTER);
        add(cartPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}