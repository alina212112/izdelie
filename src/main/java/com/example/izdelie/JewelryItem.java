package com.example.izdelie;

public class JewelryItem {
    private final int id;
    private final String name;
    private final String material;
    private final String sample;
    private final String type;
    private final String status;
    private final int price;

    public JewelryItem(int id, String name, String material, String sample, String type, String status, int price) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.sample = sample;
        this.type = type;
        this.status = status;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getMaterial() { return material; }
    public String getSample() { return sample; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public int getPrice() { return price; }
}