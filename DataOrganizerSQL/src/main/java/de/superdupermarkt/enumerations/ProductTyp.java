package de.superdupermarkt.enumerations;

import de.superdupermarkt.products.Cheese;
import de.superdupermarkt.products.Sausage;
import de.superdupermarkt.products.Wine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/** Represents the different types of products available in the SuperDuperMarkt. */
@Getter
@AllArgsConstructor
@ToString
public enum ProductTyp {

    /** Represents the 'Cheese' product type. */
    CHEESE("Cheese", Cheese.class),
    /** Represents the 'Wine' product type. */
    WINE("Wine", Wine.class),
    /** Represents the 'Sausage' product type. */
    SAUSAGE("Sausage", Sausage.class);

    /** The label of the product type. */
    private final String bezeichnung;
    /** The fully qualified class path of the Java class that implements this product type. */
    private final Class<?> clazz;

    /**
     * Retrieves the fully qualified class path associated with the given product type label.
     *
     * @param label The label of the product type to search.
     * @return The fully qualified class path of the corresponding product type,
     * or {@code null} if no product type with the given label is found.
     */
    public static Class getClassByLabel(String label) {
        for (ProductTyp type : ProductTyp.values()) {
            if (type.bezeichnung.equalsIgnoreCase(label)) {
                return type.clazz;
            }
        }
        return null;
    }
}
