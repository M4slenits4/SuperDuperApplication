package de.superdupermarkt.products;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;

import de.superdupermarkt.enumerations.ProductTyp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The abstract class {@code Product} defines the basic properties and capabilities
 * of every product in the supermarket. It serves as a base class for more specific product types. *
 */
@AllArgsConstructor
@Getter
@Setter
public abstract class Product {

    // Bezeichnung
    private String label;
    // Qualität
    private int quality;
    // Verfallsdatum
    private Instant expireDate;
    // Preis
    private double price;

    /**
     * Calculate and round the daily price of a product.
     *
     * @param basicPrice    basic price of the product.
     * @param priceValue    Price dependency such as quality to adjust the price.
     */
    public void calculatePrice(double basicPrice, int priceValue) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(basicPrice + (0.10 * priceValue)));
        BigDecimal roundedPrice = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        setPrice(roundedPrice.doubleValue());
    }

    /**
     * Get out all needed product details of the product.
     */
    @Override
    public String toString() {
        return "Bezeichnung: " + getLabel() + ", Preis: " + getPrice() + ", Qualität: " + getQuality();
    }

    /**
     * Checks the quality level of the product
     *
     * @return {@code true} if the quality level fits, otherwise {@code false}
     */
    public abstract boolean checkQualityLevel();

    /**
     * Update the quality level for the product. Depends on the product.
     *
     * @param today The current date and time.
     */
    public abstract void updateQualityLevel(Instant today);

    /**
     * Update the price if there are changes  for the product.
     */
    public abstract void updatePrice();

    /**
     * Checks for the expiry date of the product
     *
     * @param today The current date and time.
     * @return {@code true} if the product is expired, otherwise {@code false}
     */
    public abstract boolean isExpired(Instant today);


    /**
     * Creates a Product instance based on the provided label, quality, and expiration date.
     *
     * @param label The label of the product, used to determine the specific Product subclass to create. Must not be null.
     * @param quality The quality of the product.
     * @param expireDate The expiration date of the product.
     * @return A new instance of a Product subclass, or null if an error occurs during instantiation
     * @throws AssertionError if the productClass is null.
     */
    public static Product create(String label, int quality, Instant expireDate) {
        try {
            Class<? extends Product> productClass = ProductTyp.getClassPathByLabel(label);
            assert productClass != null;
            return productClass.getDeclaredConstructor(String.class, int.class, Instant.class)
                    .newInstance(label, quality, expireDate);
        } catch (Exception ex) {
            System.err.println("Fehler beim Erstellen des Produkts für Label: " + label + " - " + ex.getMessage());
            return null;
        }
    }
}
