CREATE TABLE `repositories` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增主键，唯一标识一条记录',
  `repositorie_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '仓库名称',
  `html_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '仓库的HTML链接',
  `code_language` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '编程语言',
  `forks_count` bigint DEFAULT '0' COMMENT 'Fork数量，默认为0',
  `watchers_count` bigint DEFAULT '0' COMMENT 'Watcher数量，默认为0',
  `pushed_at` datetime DEFAULT NULL COMMENT '最近推送时间',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `license_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '许可证名称',
  `description` longtext COLLATE utf8mb4_general_ci COMMENT '仓库描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=881655917 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='存储GitHub仓库信息';
