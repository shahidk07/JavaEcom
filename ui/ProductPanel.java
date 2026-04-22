package ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import model.*;
import dao.*;

public class ProductPanel extends JPanel {

    public ProductPanel(Cart cart, CartPanel cartPanel) {

        setLayout(new GridLayout(0, 3, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(240, 242, 245));

        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();

        System.out.println("Products loaded: " + products.size());

        for(Product p : products) {

            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setBackground(Color.WHITE);
            card.setBorder(BorderFactory.createLineBorder(new Color(220,220,220), 1));
            card.setPreferredSize(new Dimension(150, 160));

            // 🖼️ Image


            // 🖼️ Image
            String cleanName = p.getName().trim().toLowerCase();
            String imagePath = "images/" + cleanName + ".png";
            
            // Debug
            System.out.println("Loading image: " + imagePath);
            
            // ✅ ADD THIS (you missed it)
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + cleanName + ".png"));
            
            // fallback image
            if(icon.getIconWidth() == -1) {
                icon = new ImageIcon("images/default.png");
            }
            
            Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(img));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            // 📦 Name
            JLabel name = new JLabel(p.getName());
            name.setFont(new Font("Arial", Font.BOLD, 14));
            name.setForeground(new Color(44, 62, 80));
            name.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 💰 Price
            JLabel price = new JLabel("₹" + p.getPrice());
            price.setForeground(new Color(39, 174, 96));
            price.setAlignmentX(Component.CENTER_ALIGNMENT);

            // 🛒 Button
            JButton addBtn = new JButton("Add to Cart");
            addBtn.setBackground(new Color(52, 152, 219));
            addBtn.setForeground(Color.WHITE);
            addBtn.setFocusPainted(false);
            addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

            addBtn.addActionListener(e -> {
                cart.addProduct(p);
                cartPanel.updateCart();
            });

            // Layout
            card.add(Box.createVerticalStrut(10));
            card.add(imageLabel);
            card.add(Box.createVerticalStrut(10));
            card.add(name);
            card.add(Box.createVerticalStrut(5));
            card.add(price);
            card.add(Box.createVerticalStrut(10));
            card.add(addBtn);
            card.add(Box.createVerticalStrut(10));

            add(card);
        }

        revalidate();
        repaint();
    }
}