package de.superdupermarkt.repositories;

import de.superdupermarkt.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Repository interface for managing {@link Product} entities in the database.*/
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}