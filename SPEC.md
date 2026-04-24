# JOSP-restoreGithubStars 技术规格

## 1. 项目概述

| 属性 | 值 |
|------|-----|
| 项目名称 | JOSP-restoreGithubStars |
| 项目类型 | Spring Boot REST API 后端服务 |
| 版本 | 0.0.1-SNAPSHOT |
| 描述 | GitHub Stars 整理和管理系统 |

## 2. 技术栈

- **Spring Boot**: 3.5.3
- **Java**: 17 (源码配置), 25 (运行环境)
- **MyBatis-Plus**: 3.5.7
- **MySQL**: 8.x
- **Knife4j**: 4.5.0 (API文档)
- **Hutool**: 5.8.41

## 3. 项目结构

```
src/main/java/wo1261931780/JOSP_restoreGithubStars/
├── JospRestoreGithubStarsApplication.java
├── client/
│   └── GithubClient.java                      # GitHub API 客户端
├── config/
│   ├── CorsConfig.java                        # 跨域配置
│   ├── GlobalExceptionHandler.java            # 全局异常处理
│   ├── MybatisPlusConfig.java                 # MyBatis-Plus 分页
│   └── ShowResult.java                        # 统一响应封装
├── controller/
│   ├── DataController.java                    # 数据管理
│   └── GitHubController.java                  # GitHub 接口
├── DTO/
│   ├── GithubDTO.java
│   ├── LicenseDTO.java
│   ├── OwnerDTO.java
│   └── PermissionsDTO.java
├── entity/
│   ├── Repository.java                         # API 操作
│   └── Repositories.java                      # DB 存储
├── mapper/
│   └── RepositoriesMapper.java
└── service/
    ├── DataService.java
    └── GitHubService.java
```

## 4. 核心功能

### 4.1 GitHub API 集成

| 功能 | 方法 | 端点 |
|------|------|------|
| 获取用户 Stars | GET | /api/repositories/stars/{username} |
| Star 仓库 | PUT | /api/repositories/star |
| Unstar 仓库 | DELETE | /api/repositories/unstar |

### 4.2 数据管理

- 同步 GitHub Stars 到本地数据库
- 分页查询仓库列表
- 仓库信息转换与存储

### 4.3 API 文档

- Knife4j Swagger UI: `/doc.html`

## 5. 数据库

### 表: `repositories`

| 字段 | 类型 | 说明 |
|------|------|------|
| id | BIGINT | 自增主键 |
| repositorie_name | VARCHAR(255) | 仓库名称 |
| html_url | VARCHAR(255) | 仓库链接 |
| code_language | VARCHAR(100) | 编程语言 |
| forks_count | BIGINT | Fork数量 |
| watchers_count | BIGINT | Watcher数量 |
| pushed_at | DATETIME | 最近推送时间 |
| created_at | DATETIME | 创建时间 |
| updated_at | DATETIME | 更新时间 |
| license_name | VARCHAR(100) | 许可证 |
| description | TEXT | 仓库描述 |

## 6. 配置

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/github_stars
    username: root
    password: password

server:
  port: 8081

github:
  token: ${GITHUB_TOKEN}
```

## 7. 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+

## 8. 文档状态

- README.md: 存在
- SPEC.md: 本文档
- LICENSE: 存在