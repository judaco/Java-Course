package com.company;

import java.nio.ByteBuffer;

/**
 * Created by Juda on 21/03/2017.
 */
class Expense {

    private String name;
    private double price;
    private String description;

    public Expense(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Expense (byte [] bytes){
        name = new String(bytes, 1, bytes[0]);
        description = new String(bytes, 1 + bytes[0], bytes [1 + bytes[0]]);
        price = ByteBuffer.wrap(bytes).getDouble(1 + bytes[0] + 1 + bytes[1 + bytes[0]]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte [] getBytes() {
        byte [] nameBytes = name.getBytes();
        byte [] descriptionBytes = description.getBytes();
        byte [] result = new byte[1 + nameBytes.length + descriptionBytes.length +8];
        result [0] = (byte)nameBytes.length;
        for (int i = 0; i < nameBytes.length; i++) {
            result  [1 + i] = nameBytes[i];
        }
        result [1 + nameBytes.length] = (byte)descriptionBytes.length;
        for (int i = 0; i < descriptionBytes.length; i++) {
            result [i + nameBytes.length + 1 + i] = descriptionBytes[i];
        }
        ByteBuffer.wrap(result).putDouble(1 + nameBytes.length + 1 + descriptionBytes.length, price);
        return result;
    }
}
