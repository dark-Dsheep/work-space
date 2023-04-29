-- SQL67

DROP TABLE IF EXISTS `Products`;
CREATE TABLE IF NOT EXISTS `Products` (
    `prod_id` VARCHAR(255) NOT NULL COMMENT '产品 ID',
    `prod_name` VARCHAR(255) NOT NULL COMMENT '产品名称',
    `prod_price` DOUBLE NOT NULL COMMENT '产品价格'
    );
INSERT INTO `Products` VALUES ('a0018','sockets',9.49),
                              ('a0019','iphone13',600),
                              ('b0019','gucci t-shirts',1000);

select prod_id, prod_name
from Products where prod_price = 9.49;

-- SQL68
DROP TABLE IF EXISTS `Products`;
CREATE TABLE IF NOT EXISTS `Products` (
                                          `prod_id` VARCHAR(255) NOT NULL COMMENT '产品 ID',
                                          `prod_name` VARCHAR(255) NOT NULL COMMENT '产品名称',
                                          `prod_price` DOUBLE NOT NULL COMMENT '产品价格'
);
INSERT INTO `Products` VALUES ('a0011','usb',9.49),
                              ('a0019','iphone13',600),
                              ('b0019','gucci t-shirts',1000);

select prod_id, prod_name
from Products where prod_price >= 9;

-- SQL69
DROP TABLE IF EXISTS `Products`;
CREATE TABLE IF NOT EXISTS `Products` (
                                          `prod_id` VARCHAR(255) NOT NULL COMMENT '产品 ID',
                                          `prod_name` VARCHAR(255) NOT NULL COMMENT '产品名称',
                                          `prod_price` DOUBLE NOT NULL COMMENT '产品价格'
);
INSERT INTO `Products` VALUES ('a0011','egg',3),
                              ('a0019','sockets',4),
                              ('b0019','coffee',15);

select prod_name, prod_price
from Products
where prod_price >= 3 and prod_price <= 6
order by prod_price;


-- SQL70

DROP TABLE IF EXISTS `OrderItems`;
CREATE TABLE IF NOT EXISTS `OrderItems`(
                                           order_num VARCHAR(255) NOT NULL COMMENT '商品订单号',
                                           quantity VARCHAR(255) NOT NULL COMMENT '商品数量'
);
INSERT `OrderItems` VALUES ('a1','105'),('a2','1100'),('a2','200'),('a4','1121'),('a5','10'),('a2','19'),('a7','5');

select distinct order_num
from OrderItems
where quantity >= 100;

-- SQL71

DROP TABLE IF EXISTS `Vendors`;
CREATE TABLE IF NOT EXISTS `Vendors` (
                                         `vend_name` VARCHAR(255) NOT NULL COMMENT 'vend名称',
                                         `vend_country` VARCHAR(255) NOT NULL COMMENT 'vend国家',
                                         `vend_state` VARCHAR(255) NOT NULL COMMENT 'vend州'
);
INSERT INTO `Vendors` VALUES ('apple','USA','CA'),
                             ('vivo','CNA','shenzhen'),
                             ('huawei','CNA','xian');

select vend_name
from Vendors
where vend_state = 'CA' and vend_country = 'USA';

-- SQL72

DROP TABLE IF EXISTS `OrderItems`;
CREATE TABLE IF NOT EXISTS `OrderItems`(

                                           prod_id VARCHAR(255) NOT NULL COMMENT '商品号',
                                           order_num VARCHAR(255) NOT NULL COMMENT '商品订单号',
                                           quantity INT(255) NOT NULL COMMENT '商品数量'
);
INSERT `OrderItems` VALUES ('BR01','a1','105'),('BR02','a2','1100'),('BR02','a2','200'),('BR03','a4','1121'),('BR017','a5','10'),('BR02','a2','19'),('BR017','a7','5');

select order_num, prod_id, quantity
from OrderItems
where prod_id in ('BR01', 'BR02', 'BR03') and quantity >= 100;

-- SQL73

DROP TABLE IF EXISTS `Products`;
CREATE TABLE IF NOT EXISTS `Products` (
                                          `prod_id` VARCHAR(255) NOT NULL COMMENT '产品 ID',
                                          `prod_name` VARCHAR(255) NOT NULL COMMENT '产品名称',
                                          `prod_price` INT(255) NOT NULL COMMENT '产品价格'
);
INSERT INTO `Products` VALUES ('a0011','egg',3),
                              ('a0019','sockets',4),
                              ('b0019','coffee',15);

select prod_name, prod_price
from Products
where prod_price >= 3 and prod_price <= 6
order by prod_price;

-- SQL74

DROP TABLE IF EXISTS `Vendors`;
CREATE TABLE IF NOT EXISTS `Vendors` (
                                         `vend_name` VARCHAR(255) NOT NULL COMMENT 'vend名称',
                                         `vend_country` VARCHAR(255) NOT NULL COMMENT 'vend国家',
                                         `vend_state` VARCHAR(255) NOT NULL COMMENT 'vend州'
);
INSERT INTO `Vendors` VALUES ('apple','USA','CA'),
                             ('beef noodle king','USA','CA'),
                             ('vivo','CNA','shenzhen'),
                             ('huawei','CNA','xian');

select vend_name
from Vendors
where vend_country = 'USA' and vend_state = 'CA'
order by vend_name;

-- SQL75
DROP TABLE IF EXISTS `Products`;
CREATE TABLE IF NOT EXISTS `Products` (
                                          `prod_name` VARCHAR(255) NOT NULL COMMENT '产品 ID',
                                          `prod_desc` VARCHAR(255) NOT NULL COMMENT '产品名称'
);
INSERT INTO `Products` VALUES ('a0011','usb'),
                              ('a0019','iphone13'),
                              ('b0019','gucci t-shirts'),
                              ('c0019','gucci toy'),
                              ('d0019','lego toy');


select prod_name, prod_desc
from Products
where prod_desc like '%toy%';

-- SQL76

DROP TABLE IF EXISTS `Products`;
CREATE TABLE IF NOT EXISTS `Products` (
                                          `prod_name` VARCHAR(255) NOT NULL COMMENT '产品 ID',
                                          `prod_desc` VARCHAR(255) NOT NULL COMMENT '产品名称'
);
INSERT INTO `Products` VALUES ('a0011','usb'),
                              ('a0019','iphone13'),
                              ('b0019','gucci t-shirts'),
                              ('c0019','gucci toy'),
                              ('d0019','lego toy');

select prod_name, prod_desc
from Products
where prod_desc not like '%toy%';

-- SQL77
DROP TABLE IF EXISTS `Products`;
CREATE TABLE IF NOT EXISTS `Products` (
                                          `prod_name` VARCHAR(255) NOT NULL COMMENT '产品 ID',
                                          `prod_desc` VARCHAR(255) NOT NULL COMMENT '产品名称'
);
INSERT INTO `Products` VALUES ('a0011','usb'),
                              ('a0019','iphone13'),
                              ('b0019','gucci t-shirts'),
                              ('c0019','gucci toy'),
                              ('d0019','lego carrots toy');

select prod_name, prod_desc
from Products
where prod_desc like '%toy%' and prod_desc like '%carrots%';

-- SQL78DROP TABLE IF EXISTS `Products`;
CREATE TABLE IF NOT EXISTS `Products` (
                                          `prod_name` VARCHAR(255) NOT NULL COMMENT '产品 ID',
                                          `prod_desc` VARCHAR(255) NOT NULL COMMENT '产品名称'
);
INSERT INTO `Products` VALUES ('a0011','usb'),
                              ('a0019','iphone13'),
                              ('b0019','gucci t-shirts'),
                              ('c0019','gucci toy'),
                              ('d0019','lego toy carrots ');

select prod_name, prod_desc
from Products
where prod_desc like '%toy%carrots%';

