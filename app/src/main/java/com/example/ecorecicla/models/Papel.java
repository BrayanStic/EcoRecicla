package com.example.ecorecicla.models;

public class Papel {
    private String month,idUser;
    private int quantity,price;

    public Papel(String month, String idUser, int quantity, int price) {
        this.month = month;
        this.idUser = idUser;
        this.quantity = quantity;
        this.price = price;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIdUser() {
        return idUser;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
