create table `book`(
    `book_id` bigint(20) not null auto_increment comment '图书id',
    `name` varchar(100) not null comment '图书名称',
    `introd` varchar(1000) not null comment '图书简介',
    `number` int(11) not null comment '馆藏数量',
    primary key (`book_id`)
)engine =InnoDB auto_increment=1000 default CHARSET=utf8 COMMENT='图书表';
insert into `book`(`book_id`,`name`,`introd`,`number`)
values
(1000, 'Java程序设计', 'Java程序设计是一门balbal',10),
(1001, '数据结构','数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。', 10),
(1002, '设计模式','设计模式（Design Pattern）是一套被反复使用、多数人知晓的、经过分类的、代码设计经验的总结。',10),
(1003, '编译原理','编译原理是计算机专业的一门重要专业课，旨在介绍编译程序构造的一般原理和基本方法。',10),
(1004,'大学语文','基于长期的教学实践和学科思考，我们编写了这本《大学语文》教材balbal',10),
(1005,'计算方法','计算方法又称“数值分析”。是为各种数学问题的数值解答研究提供最有效的算法。',10),
(1006,'高等数学','广义地说，初等数学之外的数学都是高等数学，也有将中学较深入的代数、几何以及简单的集合论初步balbal',10);
create table `appointment`(
    `book_id` bigint(20) not null comment '图书id',
    `student_id` bigint(20) not null comment '学号',
    `appoint_time` timestamp not null  default current_timestamp on update current_timestamp comment '预约时间',
    primary key (`book_id`,`student_id`),
    index `idx_appoint_time`(`appoint_time`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约图书表';
create  table  `student`(
    `student_id` bigint(20) not null  comment '学生id',
    'password' bigint(20)not null comment '密码',
    primary key (`student_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生统计表';
INSERT INTO `student`(`student_id`,`password`)
VALUES
(3211200801,346543),
(3211200802,754323),
(3211200803,674554),
(3211200804,542344),
(3211200805,298383),
(3211200806,873973),
(3211200807,193737),
(3211200808,873092);