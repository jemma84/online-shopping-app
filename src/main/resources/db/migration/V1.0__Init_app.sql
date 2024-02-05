CREATE SEQUENCE products_seq
    MINVALUE 1
    MAXVALUE 9999999999999999
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE reviews_seq
    MINVALUE 1
    MAXVALUE 9999999999999999
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS categories (
                            id BIGINT PRIMARY KEY,
                            created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            name VARCHAR(255) NOT NULL,
                            description VARCHAR(255),
                            UNIQUE (name)
);
CREATE TABLE IF NOT EXISTS products (
                          id BIGINT PRIMARY KEY default nextval('products_seq'),
                          created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          name VARCHAR(255) NOT NULL,
                          price DECIMAL(10, 2) NOT NULL,
                          quantity INTEGER NOT NULL,
                          status VARCHAR(20) NOT NULL,
                          sales_counter INTEGER DEFAULT 0,
                          category_id BIGINT,
                          FOREIGN KEY (category_id) REFERENCES categories(id),
                          UNIQUE (name)
);
CREATE TABLE IF NOT EXISTS reviews (
                         id BIGINT PRIMARY KEY default nextval('reviews_seq'),
                         created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         title VARCHAR(255) NOT NULL,
                         rating DOUBLE PRECISION,
                         description VARCHAR(255),
                         product_id BIGINT NOT NULL,
    CONSTRAINT fk_products FOREIGN KEY (product_id) REFERENCES products(id)
);
CREATE TABLE IF NOT EXISTS customers (
                           id BIGINT PRIMARY KEY,
                           first_name VARCHAR(255) NOT NULL,
                           last_name VARCHAR(255) NOT NULL,
                           phone VARCHAR(20),
                           email VARCHAR(255) NOT NULL,
                           address_1 VARCHAR(255),
                           city VARCHAR(100),
                           country VARCHAR(100),
                           postcode VARCHAR(20),
                           subscription_date DATE,
                           enabled BOOLEAN NOT NULL,
                           created_date TIMESTAMP,
                           last_modified_date TIMESTAMP
);
CREATE TABLE IF NOT EXISTS carts (
                       id BIGINT PRIMARY KEY,
                       customer_id BIGINT NOT NULL,
                       status VARCHAR(20),
                       created_date TIMESTAMP,
                       last_modified_date TIMESTAMP,
                       FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE IF NOT EXISTS payments (
                        id BIGINT PRIMARY KEY,
                        status VARCHAR(255),
                        paypal_payment_id BIGINT,
                        amount NUMERIC(19, 2),
                        created_date TIMESTAMP,
                        last_modified_date TIMESTAMP
    );
CREATE TABLE IF NOT EXISTS orders (
                        id BIGINT PRIMARY KEY,
                        total_price DECIMAL(19,2),
                        status VARCHAR(20),
                        address_1 VARCHAR(255),
                        city VARCHAR(100),
                        country VARCHAR(100),
                        postcode VARCHAR(20),
                        shipment_date TIMESTAMP,
                        created_date TIMESTAMP,
                        last_modified_date TIMESTAMP,
                        customer_id BIGINT NOT NULL,
    CONSTRAINT fk_customers FOREIGN KEY (customer_id) REFERENCES customers(id)
);
CREATE TABLE IF NOT EXISTS order_items (
                         id BIGINT PRIMARY KEY,
                         quantity INTEGER,
                         order_id INTEGER REFERENCES orders(id),
                         product_id INTEGER,
                         created_date TIMESTAMP,
                         last_modified_date TIMESTAMP,
                         FOREIGN KEY (product_id) REFERENCES products(id)
);



