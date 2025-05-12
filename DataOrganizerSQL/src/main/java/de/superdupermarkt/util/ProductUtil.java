package de.superdupermarkt.util;

import de.superdupermarkt.entities.Product;
import de.superdupermarkt.services.ProductService;
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
    private List<de.superdupermarkt.products.Product> getProductDataFromSQL() {
        List<Product> allProducts = productService.getAllProducts();
        List<de.superdupermarkt.products.Product> productList = new ArrayList<>();

        allProducts.forEach(e -> {
            de.superdupermarkt.products.Product specificProduct = de.superdupermarkt.products.Product.create(e.getLabel(), e.getQuality(), e.getExpireDate());
            if (specificProduct != null) {
                productList.add(specificProduct);
            }
        });
        return productList;
    }
}
