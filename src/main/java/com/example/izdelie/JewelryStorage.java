package com.example.izdelie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JewelryStorage {
    private final ObservableList<JewelryItem> items = FXCollections.observableArrayList();
    private int nextId = 1;

    public JewelryStorage() {
        // Добавим пример данных
        addItem("Кольцо", "Золото", "585", "Кольцо", "В наличии", 15000);
        addItem("Серьги", "Серебро", "925", "Серьги", "Продано", 5000);
        addItem("Цепочка", "Золото", "750", "Цепь", "В наличии", 25000);
    }

    public void addItem(String name, String material, String sample, String type, String status, int price) {
        items.add(new JewelryItem(nextId++, name, material, sample, type, status, price));
    }

    public ObservableList<JewelryItem> getAllItems() {
        return items;
    }

    public ObservableList<JewelryItem> searchByName(String name) {
        ObservableList<JewelryItem> result = FXCollections.observableArrayList();
        String keyword = name.trim().toLowerCase();
        for (JewelryItem item : items) {
            if (item.getName().toLowerCase().contains(keyword)) {
                result.add(item);
            }
        }
        return result;
    }
}