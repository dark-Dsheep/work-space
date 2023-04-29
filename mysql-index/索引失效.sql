
-- UserInfo Table
create table user (
    `id` int not null comment '主键id' auto_increment,
    `name` varchar(32) not null comment '名称',
    `age` int not null comment '年龄',
    `address` varchar(64) not null comment '地址',
    primary key (`id`)
) comment '用户表';

-- Insert Data
insert into user (`name`, `age`, `address`)
    values ('张某', 26, '北京市海淀区'),
           ('林某', 18, '深圳市南山区'),
           ('陈某', 30, '广州市海珠区'),
           ('周某', 34, '深圳市南山区'),
           ('曾某', 25, '上海市松江区'),
           ('黄某', 28, '深圳市宝安区'),
           ('谢某', 38, '北京市海淀区'),
           ('钟某', 23, '深圳市南山区'),
           ('吴某', 28, '上海市浦东新区');


select * from user where id = 1;

-- name 为二级索引
select * from user where name = '林某';          -- 这里会进行回表操作

explain select id from user where name = '林某'; -- 这里使用到了二级索引


-- 索引失效
-- 1.对索引使用左或者左右模糊匹配
-- like %xx or like %xx% 都会造成索引失效
explain select * from user where name like '%林'; -- 全表扫描
-- 查找name前缀为林的用户
explain select * from user where name like '林%'; -- 走二级索引

-- 2.对索引使用函数
-- 索引保存的是字段的初始值，而不是经过函数计算后的值，自然没办法走索引
-- mysql8.0后有改进
explain select * from user where length(name) = 6;

-- 3.对索引进行表达式计算
explain select * from user where id + 1 = 10;
-- 对上面的 where id + 1 = 10 修改为 where id = 10 - 1这样就不算是在索引字段进行表达式计算
explain select * from user where id = 10 - 1;

-- 4.对索引隐式类型转换
-- 5.联合索引非最左匹配
-- 6.where子句中的 or
-- 在where 子句中，如果在or前的列是索引列，而在or后的列不是索引列，那么索引会失效
explain select * from user where id = 1 or age = 18;
-- 解决办法 -> 将age列字段设置为索引


