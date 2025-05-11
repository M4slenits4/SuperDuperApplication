package de.superdupermarkt.services;

import de.superdupermarkt.entities.Product;
import de.superdupermarkt.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Service class for managing {@link Product} entities.*/
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Constructs a new {@code ProductService} with the provided {@code ProductRepository}.
     *
     * @param productRepository The data repository for {@code Product} entities.
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Retrieves all {@link Product} entities from the database.
     * This method delegates the data retrieval to the {@link ProductRepository}.
     *
     * @return A {@link List} containing all {@code Product} entities found in the database.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
