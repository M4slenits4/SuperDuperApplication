package de.superdupermarkt.products;

import java.time.Instant;

/**
 * The class {@code Sausage} extends the abstract class {@code Product} and represents the
 * Sausage product type. It implements the behavior of sausage.
 */
public class Sausage extends Product {

    /** The basic price of the sausage. */
    public static final double BASIC_PRICE = 9.50;
    /** Factor used to calculate the price when the quality is above the tipping point. */
    public static final int GOOD_PRICE_FACTOR = 60;
    /** Factor used to calculate the price when the quality is below or equal to the tipping point. */
    public static final int BAD_PRICE_FACTOR = 10;
    /** Amount by which the quality decreases per update cycle when the quality is good. */
    private static final int QUALITY_DECREMENT_WITH_GOOD_QUALITY = 1;
    /** Amount by which the quality decreases per update cycle when the quality is bad. */
    private static final int QUALITY_DECREMENT_WITH_BAD_QUALITY = 4;
    /** The quality level at which the rate of quality degradation and price calculation changes. */
    private static final int QUALITY_TIPPING_POINT = 60;

    /**
     * Creates a new {@code Sausage} object with the specified attributes.
     *
     * @param label      The label of the sausage.
     * @param quality    The initial quality level of the sausage.
     * @param expireDate The expiration date.
     */
    public Sausage(String label, int quality, Instant expireDate) {
        super(label, quality, expireDate, BASIC_PRICE);
    }

    /**
     * {@inheritDoc}
     * Checks if the current quality level of the product is greater than zero.
     *
     * @return {@code true} if the current quality level is greater than 0,
     * {@code false} otherwise.
     */
    @Override
    public boolean checkQualityLevel() {
        return getQuality() > 0;
    }

    /**
     * {@inheritDoc}
     * Updates the quality level of the sausage based on its current quality.
     * If the quality is above the tipping point, it degrades slowly; otherwise, it degrades faster.
     *
     * @param today The current date and time (not directly used in this implementation
     * but inherited from the {@link Product} interface).
     */
    @Override
    public void updateQualityLevel(Instant today) {
        if (getQuality() > QUALITY_TIPPING_POINT) {
            setQuality(getQuality() - QUALITY_DECREMENT_WITH_GOOD_QUALITY);
        } else {
            setQuality(getQuality() - QUALITY_DECREMENT_WITH_BAD_QUALITY);
        }
    }

    /**
     * {@inheritDoc}
     * Updates the price of the sausage based on its current quality.
     * A higher quality results in a price calculated with a higher factor.
     */
    @Override
    public void updatePrice() {
        if (getQuality() > QUALITY_TIPPING_POINT) {
            calculatePrice(BASIC_PRICE, GOOD_PRICE_FACTOR);
        } else {
            calculatePrice(BASIC_PRICE, BAD_PRICE_FACTOR);
        }
    }

    /**
     * {@inheritDoc}
     * Checks if the sausage is expired based on its expiration date.
     *
     * @param today The current date and time.
     * @return {@code true} if the cheese's expiration date is before the {@code today}'s
     * date, indicating that it is expired; {@code false} otherwise.
     */
    @Override
    public boolean isExpired(Instant today) {
        return getExpireDate().isBefore(today);
    }
}
