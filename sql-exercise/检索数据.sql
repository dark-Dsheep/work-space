-- SQL60
CREATE TABLE IF NOT EXISTS `Customers`(
    cust_id VARCHAR(255) DEFAULT NULL
    );
INSERT `Customers` VALUES ('A'),('B'),('C');

-- 从 Customers 表中检索所有的 ID
select cust_id from Customers;

-- SQL61
CREATE TABLE IF NOT EXISTS `OrderItems`(
    prod_id VARCHAR(255) NOT NULL COMMENT '商品id'
);
INSERT `OrderItems` VALUES ('a1'),('a2'),('a3'),('a4'),('a5'),('a6'),('a6');

-- 检索并列出已订购产品的清单
select distinct prod_id from OrderItems;

-- SQL62
DROP TABLE IF EXISTS `Customers`;
CREATE TABLE IF NOT EXISTS `Customers`(
                                          cust_id VARCHAR(255) NOT NULL COMMENT '客户id',
                                          cust_name VARCHAR(255) NOT NULL COMMENT '客户姓名'
);
INSERT `Customers` VALUES ('a1','andy'),('a2','ben'),('a3','tony'),('a4','tom'),('a5','an'),('a6','lee'),('a7','hex');

select cust_id, cust_name from Customers;

-- SQL63
DROP TABLE IF EXISTS `Customers`;
CREATE TABLE IF NOT EXISTS `Customers`(
                                          cust_id VARCHAR(255) NOT NULL COMMENT '客户id',
                                          cust_name VARCHAR(255) NOT NULL COMMENT '客户姓名'
);
INSERT `Customers` VALUES ('a1','andy'),('a2','ben'),('a3','tony'),('a4','tom'),('a5','an'),('a6','lee'),('a7','hex');

select cust_name from Customers order by cust_name desc;

-- SQL64
DROP TABLE IF EXISTS `Orders`;
CREATE TABLE IF NOT EXISTS `Orders` (
                                        `cust_id` varchar(255) NOT NULL COMMENT '顾客 ID',
                                        `order_num` varchar(255) NOT NULL COMMENT '订单号',
                                        `order_date` timestamp NOT NULL COMMENT '订单时间'
);
INSERT INTO `Orders` VALUES ('andy','aaaa','2021-01-01 00:00:00'),
                            ('andy','bbbb','2021-01-01 12:00:00'),
                            ('bob','cccc','2021-01-10 12:00:00'),
                            ('dick','dddd','2021-01-11 00:00:00');

select cust_id, order_num from Orders order by cust_id , order_date desc;

-- SQL65

DROP TABLE IF EXISTS `OrderItems`;
CREATE TABLE IF NOT EXISTS `OrderItems` (
                                            `quantity` INT(64) NOT NULL COMMENT '数量',
                                            `item_price` INT(64) NOT NULL COMMENT '订单价格'
);
INSERT INTO `OrderItems` VALUES (1,100),
                                (10,1003),
                                (2,500);

select quantity, item_price from OrderItems order by quantity desc, item_price desc;

-- SQL66
DROP TABLE IF EXISTS `Vendors`;
CREATE TABLE IF NOT EXISTS `Vendors` (
    `vend_name` VARCHAR(255) NOT NULL COMMENT 'vend名称'
);
INSERT INTO `Vendors` VALUES ('海底捞'),
                             ('小龙坎'),
                             ('大龙燚');

select vend_name from Vendors order by vend_name desc;
