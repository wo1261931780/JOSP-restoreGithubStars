# JOSP-restoreGithubStars

GitHub Stars 整理和管理系统的后端服务。

## 技术栈

| 技术 | 版本 |
|------|------|
| Spring Boot | 3.5.3 |
| Java | 17/25 |
| MyBatis-Plus | 3.5.7 |
| MySQL | 8.x |
| Knife4j | 4.5.0 |
| Hutool | 5.8.41 |

## 项目结构

```
src/main/java/wo1261931780/JOSP_restoreGithubStars/
├── JospRestoreGithubStarsApplication.java    # 启动类
├── client/
│   └── GithubClient.java                      # GitHub API 客户端
├── config/
│   ├── CorsConfig.java                        # 跨域配置
│   ├── GlobalExceptionHandler.java            # 全局异常处理
│   ├── MybatisPlusConfig.java                 # MyBatis-Plus 配置
│   └── ShowResult.java                        # 统一响应封装
├── controller/
│   ├── DataController.java                    # 数据管理接口
│   └── GitHubController.java                  # GitHub 集成接口
├── DTO/
│   ├── GithubDTO.java                         # GitHub API 响应
│   ├── LicenseDTO.java                        # 许可证信息
│   ├── OwnerDTO.java                          # 仓库所有者
│   └── PermissionsDTO.java                    # 仓库权限
├── entity/
│   ├── Repository.java                         # 仓库实体 (API)
│   └── Repositories.java                      # 仓库实体 (DB)
├── mapper/
│   └── RepositoriesMapper.java                # 数据访问层
└── service/
    ├── DataService.java                       # 数据管理服务
    └── GitHubService.java                     # GitHub API 服务
```

## 快速开始

### 1. 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+

### 2. 数据库初始化

```sql
CREATE DATABASE github_stars;
USE github_stars;
SOURCE demo.sql;
```

### 3. 配置

编辑 `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/github_stars
    username: root
    password: your_password

github:
  token: your_github_token
```

### 4. 运行

```bash
mvn clean install
mvn spring-boot:run
```

### 5. 访问

- 后端地址: http://localhost:8081
- API文档: http://localhost:8081/doc.html

## API 接口

### 获取用户 Stars

```
GET /api/repositories/stars/{username}
```

### Star 仓库

```
PUT /api/repositories/star
Body: {"owner": "owner", "repo": "repo"}
```

### Unstar 仓库

```
DELETE /api/repositories/unstar
Body: {"owner": "owner", "repo": "repo"}
```

## 数据库

表: `repositories`

| 字段 | 类型 | 说明 |
|------|------|------|
| id | BIGINT | 自增主键 |
| repositorie_name | VARCHAR | 仓库名称 |
| html_url | VARCHAR | 仓库链接 |
| code_language | VARCHAR | 编程语言 |
| forks_count | BIGINT | Fork数量 |
| watchers_count | BIGINT | Watcher数量 |
| pushed_at | DATETIME | 最近推送时间 |
| created_at | DATETIME | 创建时间 |
| updated_at | DATETIME | 更新时间 |
| license_name | VARCHAR | 许可证 |
| description | TEXT | 仓库描述 |

## License

AGPL-3.0