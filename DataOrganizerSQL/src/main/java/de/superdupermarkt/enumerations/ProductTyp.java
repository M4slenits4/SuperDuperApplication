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
    Wine("Wine", "de.superdupermarkt.products.Wine"),
    /** Represents the 'Sausage' product type. */
    Wurst("Sausage", "de.superdupermarkt.products.Sausage");

    /** The label of the product type. */
    private final String bezeichnung;
    /** The fully qualified class path of the Java class that implements this product type. */
    private final String classPath;

}
