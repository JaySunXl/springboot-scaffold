CREATE TABLE `scaffold`.`operation_log`  (
                                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志记录id',
                                        `create_time` timestamp NOT NULL COMMENT '创建时间',
                                        `level` int(2) NOT NULL COMMENT '日志等级',
                                        `operation_unit` varchar(50) NULL COMMENT '被操作的对象',
                                        `operation_type` varchar(255) NULL COMMENT '操作类型',
                                        `method` varchar(255) NULL COMMENT '方法名',
                                        `args` varchar(255) NULL COMMENT '参数',
                                        `user_id` varchar(255) NULL COMMENT '操作人id',
                                        `user_name` varchar(255) NULL COMMENT '操作人',
                                        `describe` varchar(1000) NULL COMMENT '日志描述',
                                        `run_time` bigint(20) NULL COMMENT '方法运行时间',
                                        `return_value` varchar(255) NULL COMMENT '方法返回值',
                                        PRIMARY KEY (`id`)
) ENGINE = InnoDB;