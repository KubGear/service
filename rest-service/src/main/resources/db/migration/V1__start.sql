
CREATE TABLE `task`.`my_order` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(255) NOT NULL , `address` VARCHAR(255) NOT NULL , `sumOrder` INT NOT NULL , `createDate` DATE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

CREATE TABLE `task`.`order_details` ( `id` INT NOT NULL AUTO_INCREMENT , `serial_number` VARCHAR(255) NOT NULL , `quantity` INT NOT NULL , `order_id` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

CREATE TABLE `task`.`product_description` ( `id` INT NOT NULL AUTO_INCREMENT , `serial_number` VARCHAR(255) NOT NULL , `name` VARCHAR(255) NOT NULL , `description` VARCHAR(255) NOT NULL , `createDate` DATE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

ALTER TABLE `order_details` ADD `product_id` INT NOT NULL AFTER `order_id`;

ALTER TABLE `order_details` ADD INDEX( `order_id`);
ALTER TABLE `order_details` ADD INDEX( `product_id`);
