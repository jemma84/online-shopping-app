package com.example.onlineshoppingapp.repository;

import com.example.onlineshoppingapp.dto.ProductDTO;
import com.example.onlineshoppingapp.dto.ReviewDTO;
import com.example.onlineshoppingapp.enums.ProductStatus;
import com.example.onlineshoppingapp.model.Category;
import com.example.onlineshoppingapp.model.Product;
import com.example.onlineshoppingapp.model.Review;
import com.example.onlineshoppingapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest extends AbstractPostgreSQLTestContainerIT {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @BeforeEach
    void setup() {
        Review review = new Review("Mega soap", 10.0, "Fantastic!");
        reviewRepository.save(review);
        
        Category category = new Category();
        category.setName("Skincare");
        category.setDescription("Products for skincare routines");
        categoryRepository.save(category);

        Product product = new Product();
        product.setName("Soap");
        product.setStatus(ProductStatus.AVAILABLE);
        product.setPrice(new BigDecimal(5.0));
        product.setSalesCounter(1);
        product.setQuantity(3);
        product.setCategory(category);
        product.setReviews(List.of(review));
        productRepository.save(product);
    }

    @Test
    void find_product_by_name_ok() {
        List<Product> productList = productRepository.findAllByCategoryId(1L);
        assertThat(productList).hasSize(1);
    }
}
