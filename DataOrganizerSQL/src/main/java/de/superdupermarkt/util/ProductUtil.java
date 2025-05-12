package de.superdupermarkt.util;

import de.superdupermarkt.entities.Product;
import de.superdupermarkt.enumerations.ProductTyp;
import de.superdupermarkt.services.ProductService;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class ProductUtil {

    private ProductService productService;

    private List<de.superdupermarkt.products.Product> getProductDataFromSQL() {

        List<Product> allProducts = productService.getAllProducts();
        List<de.superdupermarkt.products.Product> productList = new ArrayList<>();

        allProducts.forEach( e -> {
            try {
                Class<? extends de.superdupermarkt.products.Product> productClass = (Class<? extends de.superdupermarkt.products.Product>) Class.forName(ProductTyp.getClassPathByLabel(e.getLabel()));
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
