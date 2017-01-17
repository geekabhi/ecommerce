USE ecommerce_test;

TRUNCATE TABLE products;

INSERT INTO `products`
(`name`,
 `stock`,
 `description`,
 `rating`,
 `reviews_count`,
 `list_price`,
 `discount`,
 `actual_price`,
 `quantity`,
 `restricted`,
 `created`,
 `modified`)
VALUES
  ('Apple',
    '12345',
    'Apple Mac',
    5,
    1000,
    10.00,
    0.50,
    5.00,
    100,
   1,
   CURRENT_TIMESTAMP,
   CURRENT_TIMESTAMP);