package de.superdupermarkt.util;

import de.superdupermarkt.entities.Product;
import de.superdupermarkt.enumerations.ProductTyp;
import de.superdupermarkt.services.ProductService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


/** Utility class for operations related to product data. */
@AllArgsConstructor
@Component
public class ProductUtil {

    private ProductService productService;

    /**
     * Retrieves product data from the SQL database.
     * This method fetches a list of generic Product objects from the database
     * using the productService, and then transforms each generic Product into a
     * specific de.superdupermarkt.products.Product instance.
     *
     * @return A List of de.superdupermarkt.products.Product objects representing
     * the product data from the database.  Returns an empty list if no
     * products are found.
     */
    public List<de.superdupermarkt.products.Product> getProductDataFromSQL() {
        List<Product> allProducts = productService.getAllProducts();
        List<de.superdupermarkt.products.Product> productList = new ArrayList<>();

        allProducts.forEach(e -> {
            de.superdupermarkt.products.Product specificProduct = createProduct(e.getLabel(), e.getQuality(), e.getExpireDate());
            if (specificProduct != null) {
                productList.add(specificProduct);
            }
        });
        return productList;
    }

    /**
     * Creates a Product instance based on the provided label, quality, and expiration date.
     *
     * @param label The label of the product, used to determine the specific Product subclass to create. Must not be null.
     * @param quality The quality of the product.
     * @param expireDate The expiration date of the product.
     * @return A new instance of a Product subclass, or null if an error occurs during instantiation
     * @throws AssertionError if the productClass is null.
     */
    private static de.superdupermarkt.products.Product createProduct(String label, int quality, Instant expireDate) {
        try {
            Class<? extends de.superdupermarkt.products.Product> productClass = ProductTyp.getClassByLabel(label);
            assert productClass != null;
            return productClass.getDeclaredConstructor(String.class, int.class, Instant.class)
                    .newInstance(label, quality, expireDate);
        } catch (Exception ex) {
            System.err.println("Fehler beim Erstellen des Produkts für Label: " + label + " - " + ex.getMessage());
            return null;
        }
    }
}
