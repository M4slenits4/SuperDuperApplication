package de.superdupermarkt.NewProduct;

import de.superdupermarkt.products.Product;

import java.time.Instant;

public class Wurst extends Product {
    public Wurst(String label, int quality, Instant expireDate, double price) {
        super(label, quality, expireDate, price);
    }

    @Override
    public boolean checkQualityLevel() {
        return false;
    }

    @Override
    public void updateQualityLevel(Instant toDay) {

    }

    @Override
    public void updatePrice() {

    }

    @Override
    public boolean isExpired(Instant toDay) {
        return false;
    }
}
