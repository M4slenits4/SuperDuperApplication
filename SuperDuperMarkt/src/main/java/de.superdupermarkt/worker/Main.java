package de.superdupermarkt.worker;

import de.superdupermarkt.csv.util.CSVProductReader;
import de.superdupermarkt.services.ProductService;
import de.superdupermarkt.util.ProductUtil;
import de.superdupermarkt.products.Product;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Main {

    /** Message line separator. */
    private static final String LINE_SEPARATOR = "-------------------------------------------------------";
    /** The file path to the CSV files. */
    private static final String BASE_PATH = new File("SuperDuperMarkt/src/main/java/de.superdupermarkt/files").getAbsolutePath();
    /** The file name of the CSV file containing the product types. */
    private static final String FILE_NAME_PRODUCT_TYPES = BASE_PATH + "/ProductTypes.csv";
    /** The file name of the CSV file containing the product data. */
    public static final String FILE_NAME_PRODUCT_DATA = BASE_PATH + "/ProductData.csv";

    public static void main(String[] args){

        Instant startTime = Instant.parse("2025-05-08T19:00:31.907111500Z");

        // read in product types and product list
        CSVProductReader.getProductTypesFromCSV(FILE_NAME_PRODUCT_TYPES);
        List<Product> productList = CSVProductReader.getProductDataFromCSV(FILE_NAME_PRODUCT_DATA);

        // Als beispiel für die entity über sql anstatt über CSV. Funktioniert so natütlich nicht :)
        // ProductUtil productUtil = new ProductUtil(new ProductService());
        // List<Product> productList = ProductUtil.getProductDataFromSQL();

        if (productList.isEmpty()) {
            System.out.println(" Produkt-Liste ist leer !");
        }

        // start
        System.out.println("Startwerte des Programmes");
        System.out.println(LINE_SEPARATOR);
            productList.forEach(System.out::println);

        for (int anzahlTage = 0; anzahlTage < 150; anzahlTage++) {

            System.out.println(" ");
            System.out.println("Tag: " + (anzahlTage + 1) + " Datum: " + startTime);

            StringBuilder productInfos;
            for (Product product : productList) {
                product.updatePrice();
                product.updateQualityLevel(startTime);
                productInfos = new StringBuilder(product.toString());
                // Check the quality level and expiration date of the product.
                if (!product.checkQualityLevel() || product.isExpired(startTime)) {
                    productInfos.append(" ! Muss ausgeräumt werden !");
                }
                System.out.println(productInfos);
            }
            startTime = startTime.plus(Duration.ofDays(1));
            System.out.println(LINE_SEPARATOR);
        }
    }
}