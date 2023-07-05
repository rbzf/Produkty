package pl.as.produkty;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository

public class ProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Olej Kujawski", 9.5, Category.FOOD));
        products.add(new Product("Czekolada mleczna Wedel", 4.2, Category.FOOD));
        products.add(new Product("Piwo Żywiec", 3.8, Category.FOOD));
        products.add(new Product("Płyn do zmywania naczyń", 7.5, Category.HOUSEHOLD));
        products.add(new Product("Domestos", 10, Category.HOUSEHOLD));
        products.add(new Product("Papier do drukarki", 34.99, Category.OTHER));
        products.add(new Product("Koperty A4 25 sztuk", 8.95, Category.OTHER));
    }

    public List<Product> findByCategory(Category category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public double getSumByCategory(Category category) {
        List<Product> productsByCategory = findByCategory(category);
        double sum = 0;
        for (Product product : productsByCategory) {
            sum += product.getPrice();
        }
        return sum;
    }

    public List<Product> findAll() {
        return products;
    }

    public double getSumAll() {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void add(Product product) {
        products.add(product);
    }
}
