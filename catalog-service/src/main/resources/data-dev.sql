INSERT INTO brands(name)
VALUES
    ('Apple'),
    ('Samsung'),
    ('Nike'),
    ('Adidas'),
    ('Sony'),
    ('Dell'),
    ('HP'),
    ('Puma'),
    ('Boat'),
    ('Lenovo');

INSERT INTO products
(sku, title, description, category, price, currency, brand_id, status)
SELECT
    CONCAT('SKU-', n),
    ELT(1 + FLOOR(RAND() * 5),
        'Gaming Laptop',
        'Wireless Headphones',
        'Sports Shoes',
        'Mechanical Keyboard',
        'Smart Watch'
    ),
    'Auto generated seeded product',
    ELT(1 + FLOOR(RAND() * 4),
        'Electronics',
        'Fashion',
        'Accessories',
        'Footwear'
    ),
    ROUND(1000 + (RAND() * 90000), 2),
    'INR',
    FLOOR(1 + (RAND() * 10)),
    ELT(1 + FLOOR(RAND() * 3),
        'ACTIVE',
        'INACTIVE',
        'DRAFT'
    )
FROM (
         SELECT a.N + b.N * 10 + c.N * 100 + d.N * 1000 + 1 n
         FROM
             (SELECT 0 N UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) a,
             (SELECT 0 N UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) b,
             (SELECT 0 N UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) c,
             (SELECT 0 N UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) d
     ) numbers
    LIMIT 5000;