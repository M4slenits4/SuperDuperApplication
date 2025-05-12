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
     * Retrieves product data from the SQL database and transforms it into a list of specific product implementation classes.
     * For each {@link Product} entity fetched from the database, this method attempts to instantiate the corresponding
     * concrete product class based on the product's label.
     *
     * @return A list of concrete {@link de.superdupermarkt.products.Product} objects populated with data from the SQL database.
     */
    private List<de.superdupermarkt.products.Product> getProductDataFromSQL() {

        List<Product> allProducts = productService.getAllProducts();
        List<de.superdupermarkt.products.Product> productList = new ArrayList<>();

        allProducts.forEach( e -> {
            try {
                Class<de.superdupermarkt.products.Product> productClass = (Class<de.superdupermarkt.products.Product>) Class.forName(ProductTyp.getClassPathByLabel(e.getLabel()));
                de.superdupermarkt.products.Product product = productClass.getDeclaredConstructor(String.class, int.class, Instant.class)
                        .newInstance(e.getLabel(), e.getQuality(), e.getExpireDate());
                productList.add(product);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        return productList;
    }
}
