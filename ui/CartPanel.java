package ui;

import javax.swing.*;
import java.awt.*;
import model.*;

public class CartPanel extends JPanel {

    private Cart cart;
    private JTextArea area;
    private JLabel totalLabel;

    public CartPanel(Cart cart) {
        this.cart = cart;

        setLayout(new BorderLayout(10,10));
        setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        area = new JTextArea(5, 30);
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);

        JButton removeBtn = new JButton("Remove Last");
        JButton checkoutBtn = new JButton("Checkout");

        totalLabel = new JLabel("Total: ₹0");

        removeBtn.addActionListener(e -> {
            int size = cart.getItems().size();
            if(size > 0) {
                cart.removeProduct(size - 1);
                updateCart();
            }
        });

        checkoutBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Order placed! ₹" + cart.getTotal());
            cart.clearCart();
            updateCart();
        });

        JPanel bottom = new JPanel();
        bottom.add(removeBtn);
        bottom.add(checkoutBtn);
        bottom.add(totalLabel);

        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    public void updateCart() {
        StringBuilder sb = new StringBuilder();

        for(Product p : cart.getItems()) {
            sb.append(p.getName()).append(" - ₹").append(p.getPrice()).append("\n");
        }

        area.setText(sb.toString());
        totalLabel.setText("Total: ₹" + cart.getTotal());
    }
}