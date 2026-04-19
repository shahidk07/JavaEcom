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

        setLayout(new BorderLayout());

        area = new JTextArea(8, 30);
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);

        JPanel bottomPanel = new JPanel();

        JButton refreshBtn = new JButton("Refresh");
        JButton removeBtn = new JButton("Remove Last");
        JButton checkoutBtn = new JButton("Checkout");

        totalLabel = new JLabel("Total: ₹0");

        // 🔄 Refresh cart
        refreshBtn.addActionListener(e -> updateCart());

        // ❌ Remove last item
        removeBtn.addActionListener(e -> {
            int size = cart.getItems().size();
            if(size > 0) {
                cart.removeProduct(size - 1);
                updateCart();
            }
        });

        // 💳 Checkout
        checkoutBtn.addActionListener(e -> {
            double total = cart.getTotal();
            JOptionPane.showMessageDialog(this, "Order placed! ₹" + total);
            cart.clearCart();
            updateCart();
        });

        bottomPanel.add(refreshBtn);
        bottomPanel.add(removeBtn);
        bottomPanel.add(checkoutBtn);
        bottomPanel.add(totalLabel);

        add(scroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void updateCart() {
        StringBuilder sb = new StringBuilder();

        for(Product p : cart.getItems()) {
            sb.append(p.toString()).append("\n");
        }

        area.setText(sb.toString());
        totalLabel.setText("Total: ₹" + cart.getTotal());
    }
}