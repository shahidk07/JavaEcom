package model;

import java.util.*;

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product p) {
        items.add(p);
    }

    public void removeProduct(int index) {
        if(index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for(Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public void clearCart() {
        items.clear();
    }
}