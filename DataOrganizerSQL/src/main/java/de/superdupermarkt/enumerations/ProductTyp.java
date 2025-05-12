package de.superdupermarkt.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/** Represents the different types of products available in the SuperDuperMarkt. */
@Getter
@AllArgsConstructor
@ToString
public enum ProductTyp {

    /** Represents the 'Cheese' product type. */
    CHEESE("Cheese", "de.superdupermarkt.products.Cheese"),
    /** Represents the 'Wine' product type. */
    WINE("Wine", "de.superdupermarkt.products.Wine"),
    /** Represents the 'Sausage' product type. */
    SAUSAGE("Sausage", "de.superdupermarkt.products.Sausage");

    /** The label of the product type. */
    private final String bezeichnung;
    /** The fully qualified class path of the Java class that implements this product type. */
    private final String classPath;

    /**
     * Retrieves the fully qualified class path associated with the given product type label.
     *
     * @param label The label of the product type to search.
     * @return The fully qualified class path of the corresponding product type,
     * or {@code null} if no product type with the given label is found.
     */
    public static String getClassPathByLabel(String label) {
        for (ProductTyp type : ProductTyp.values()) {
            if (type.bezeichnung.equalsIgnoreCase(label)) {
                return type.classPath;
            }
        }
        return null;
    }
}
