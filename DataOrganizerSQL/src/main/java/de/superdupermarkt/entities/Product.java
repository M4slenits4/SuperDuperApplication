package de.superdupermarkt.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.Instant;

/**
 * Represents a product entity in the SuperDuperMarkt application.
 * This class is mapped to the "products" table in the database.
 */
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * The unique identifier for the product.
     * This field is the primary key and is mapped to the "bezeichnung" column.
     */
    @Id
    @Column(name = "bezeichnung")
    private String Label;

    /**
     * The type of the product.
     * This field is mapped to the "Typ" column.
     */
    @Column(name = "Typ")
    private String type;

    /**
     * The quality of the product, represented as an integer.
     * This field is mapped to the "qualitaet" column.
     */
    @Column(name = "qualitaet")
    private int quality;

    /**
     * The expiration date of the product.
     * This field is mapped to the "verfallsdatum" column.
     */
    @Column(name = "verfallsdatum")
    private Instant expireDate;
}