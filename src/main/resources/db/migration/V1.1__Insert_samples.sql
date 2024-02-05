INSERT INTO categories (id, name, description) VALUES
                    (1, 'Skincare', 'Products for skincare routines'),
                    (2, 'Makeup', 'Cosmetic products for makeup'),
                    (3, 'Haircare', 'Hair care and styling products');

INSERT INTO products (name, price, quantity, status, sales_counter, category_id) VALUES
                    ('Lipstick', 14.99, 50, 'AVAILABLE', 10, 2),
                    ('Face Cream', 24.99, 30, 'AVAILABLE', 15, 1),
                    ('Mascara', 12.99, 40, 'AVAILABLE', 20, 3),
                    ('Foundation', 19.99, 25, 'AVAILABLE', 18, 2),
                    ('Shampoo', 13.99, 45, 'AVAILABLE', 18, 3),
                    ('Nail Polish', 7.99, 60, 'AVAILABLE', 30, 2),
                    ('Eyeliner', 9.99, 80, 'AVAILABLE', 25, 2);

INSERT INTO reviews (title, rating, description, product_id) VALUES
                     ('Great Product', 4.5, 'I love this product!', 1),
                     ('Disappointing', 2.0, 'Not what I expected.', 2),
                     ('Fantastic!', 5.0, 'Best purchase ever!', 3),
                     ('Average', 3.0, 'Its okay, nothing special.', 4),
                     ('Not Impressed', 2.0, 'Product did not meet expectations.', 5),
                     ('Exceptional Quality', 4.7, 'Impressed with the overall quality.', 3),
                     ('Terrible Experience', 1.0, 'Regret purchasing this product.', 5),
                     ('Satisfied Customer', 4.0, 'Good value for the price.', 5),
                     ('Could be Better', 3.5, 'Decent product but has some drawbacks.', 7),
                     ('Top-Notch', 4.9, 'Absolutely love it! Worth every penny.', 6),
                     ('Not Worth It', 1.5, 'Disappointed with the purchase.', 4),
                     ('Amazing Product', 5.0, 'Exceeded my expectations.', 3),
                     ('Highly Recommend', 4.8, 'Amazing quality.', 2);

INSERT INTO customers (id, first_name, last_name, phone, email, address_1, city, country, postcode, subscription_date, enabled, created_date, last_modified_date)
VALUES
    (1, 'John', 'Doe', '123456789', 'john.doe@email.com', '123 Main St', 'Boston', 'USA', '12345', '2023-01-01', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 'Alice', 'Smith', '987654321', 'alice.smith@email.com', '456 Elm St', 'Paris', 'France', '54321', '2023-01-15', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 'Michael', 'Johnson', '111222333', 'michael.johnson@email.com', '789 Pine St', 'Nuremberg', 'Germany', '67890', '2023-02-01', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 'Emily', 'Brown', '444555666', 'emily.brown@email.com', '101 Oak St', 'Toronto', 'Canada', '09876', '2023-02-15', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, 'William', 'Taylor', '777888999', 'william.taylor@email.com', '303 Maple St', 'Bordo', 'France', '11223', '2023-03-01', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO carts (id, customer_id, status, created_date, last_modified_date)
VALUES
    (1, 1, 'CONFIRMED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 2, 'NEW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 3, 'CONFIRMED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 4, 'CANCELED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, 5, 'CONFIRMED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO payments (id, status, paypal_payment_id, amount, created_date, last_modified_date)
VALUES
    (1, 'COMPLETED', 1234567890, 100.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 'PENDING', 9876543210, 200.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 'COMPLETED', 1234567891, 150.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 'PENDING', 9876543211, 250.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, 'COMPLETED', 1122334455, 350.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO orders (id, total_price, status, address_1, city, country, postcode, shipment_date, created_date, last_modified_date, customer_id)
VALUES
    (1, 100.00, 'PROCESSING', '123 Main St', 'Naples', 'Italy', '12345', '2023-01-02', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1),
    (2, 200.00, 'SHIPPED', '456 Elm St', 'Antwerpen', 'Belgium', '54321', '2023-01-16', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),
    (3, 150.00, 'PROCESSING', '789 Pine St', 'Lion', 'France', '67890', '2023-02-02', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3),
    (4, 250.00, 'SHIPPED', '101 Oak St', 'Istanbul', 'Turkey', '09876', '2023-02-16', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 5),
    (5, 350.00, 'DELIVERED', '303 Maple St', 'Ankara', 'Turkey', '11223', '2023-03-02', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 5);

INSERT INTO order_items (id, product_id, quantity, order_id, created_date, last_modified_date)
VALUES
    (1, 1, 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 2, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 3, 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 4, 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, 5, 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


