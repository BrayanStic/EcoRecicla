package com.example.ecorecicla.models;

public class Papel {
        private final String idUser;
        private int quantity, price;
        private String month;

        public Papel(int quantity, int price, String month, String idUser) {
            this.quantity = quantity;
            this.price = price;
            this.month = month;
            this.idUser=idUser;
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

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getIdUser() {
            return idUser;
        }
}
