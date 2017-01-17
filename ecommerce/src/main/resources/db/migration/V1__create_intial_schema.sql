CREATE TABLE `product` (
  `id`            INT           NOT NULL AUTO_INCREMENT,
  `version`       INT           NOT NULL DEFAULT 0,
  `name`          VARCHAR(255)  NOT NULL,
  `stock`  VARCHAR(5)    NOT NULL,
  `description`   VARCHAR(255)  NULL,
  `rating`        SMALLINT      NULL,
  `reviews_count` INT           NULL,
  `list_price`    DECIMAL       NULL      DEFAULT 0.00,
  `discount`      DECIMAL(5,2)  NULL      DEFAULT 0.00,
  `actual_price`  DECIMAL       NULL      DEFAULT 0.00,
  `quantity`      INT           NULL,
  `restricted`    TINYINT       NULL      DEFAULT 0,
  `created`       TIMESTAMP     NULL      DEFAULT CURRENT_TIMESTAMP,
  `modified`      TIMESTAMP     NULL      DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `stock_UNIQUE` (`stock` ASC));
