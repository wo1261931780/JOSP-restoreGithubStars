# JOSP-restoreGithubStars 技术规格说明书

## 1. 项目概述

| 属性 | 值 |
|------|-----|
| **项目名称** | JOSP-restoreGithubStars |
| **项目类型** | Spring Boot REST API 后端服务 |
| **版本** | 0.0.1-SNAPSHOT |
| **描述** | GitHub Stars 整理和管理系统 - 通过 GitHub API 获取用户的 Star 项目列表并提供管理功能 |

## 2. 技术栈

### 核心框架
- **Spring Boot**: 3.4.10
- **Java**: 17 (源码配置) / 25 (运行环境，不兼容)
- **MyBatis-Plus**: 3.5.16 (Spring Boot 3 专用)
- **MySQL**: 8.x

### 依赖组件
| 依赖 | 版本 | 用途 |
|------|------|------|
| mybatis-plus-spring-boot3-starter | 3.5.16 | ORM框架 |
| lombok | 1.18.36 | 代码生成 |
| knife4j-openapi3-jakarta-spring-boot-starter | 4.5.0 | API文档 |
| hutool-all | 5.8.41 | 工具集 |
| jackson-databind | (Spring Boot管理) | JSON处理 |
| mysql-connector-j | (Spring Boot管理) | MySQL驱动 |

## 3. 项目结构

```
src/main/java/wo1261931780/JOSP_restoreGithubStars/
├── JospRestoreGithubStarsApplication.java    # 启动类
├── client/
│   └── GithubClient.java                      # GitHub API 客户端
├── config/
│   ├── CorsConfig.java                        # 跨域配置
│   ├── GlobalExceptionHandler.java            # 全局异常处理
│   ├── MybatisPlusConfig.java                 # MyBatis-Plus 分页配置
│   └── ShowResult.java                        # 统一响应封装
├── controller/
│   ├── DataController.java                    # 数据管理接口
│   └── GitHubController.java                  # GitHub 集成接口
├── DTO/
│   ├── GithubDTO.java                         # GitHub API 响应 DTO
│   ├── LicenseDTO.java                        # 许可证信息
│   ├── OwnerDTO.java                          # 仓库所有者信息
│   └── PermissionsDTO.java                    # 仓库权限信息
├── entity/
│   ├── Repository.java                         # 仓库实体 (用于API操作)
│   └── Repositories.java                      # 仓库实体 (用于数据库存储)
├── mapper/
│   └── RepositoriesMapper.java                # MyBatis Mapper
└── service/
    ├── DataService.java                       # 数据管理服务
    └── GitHubService.java                     # GitHub API 集成服务
```

## 4. 核心功能

### 4.1 GitHub API 集成
- 获取用户 Star 列表: `GET /users/{username}/starred`
- Star 仓库: `PUT /user/starred/{owner}/{repo}`
- Unstar 仓库: `DELETE /user/starred/{owner}/{repo}`

### 4.2 数据管理
- 同步 GitHub Stars 到本地数据库
- 分页查询仓库列表
- 仓库信息转换与存储

### 4.3 API 文档
- Knife4j 集成，提供 Swagger UI
- 访问地址: `/doc.html`

## 5. 数据库设计

### 表: `github_stars.repositories`

| 字段 | 类型 | 说明 |
|------|------|------|
| id | BIGINT | 自增主键 |
| repositorie_name | VARCHAR | 仓库名称 |
| html_url | VARCHAR | 仓库链接 |
| code_language | VARCHAR | 编程语言 |
| forks_count | BIGINT | Fork 数量 |
| watchers_count | BIGINT | Watcher 数量 |
| pushed_at | DATETIME | 最近推送时间 |
| created_at | DATETIME | 创建时间 |
| updated_at | DATETIME | 更新时间 |
| license_name | VARCHAR | 许可证名称 |
| description | TEXT | 仓库描述 |

## 6. 配置要求

### 6.1 application.yml 必要配置
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/github_stars
    username: root
    password: password

github:
  api:
    token: ${GITHUB_TOKEN}
    base-url: https://api.github.com
```

### 6.2 环境要求
- JDK 17 (推荐) - 当前 JDK 25 存在 Lombok 兼容性问题
- Maven 3.6+
- MySQL 8.0+

## 7. 编译状态

### ❌ 编译失败

**问题原因**: JDK 25 与 Lombok 1.18.36 不兼容

**错误列表**:
1. `@Slf4j` 未生成 `log` 变量 (DataController, GitHubService, GithubClient, GlobalExceptionHandler)
2. `@Data` 未生成 getter/setter (Repositories, GithubDTO, ShowResult 等)
3. `PaginationInnerInterceptor` 无法解析
4. 方法引用无效错误

**解决方案**: 
- 降级 JDK 至 17
- 或升级 Lombok 至支持 JDK 25 的版本

## 8. 文档状态

| 文档 | 状态 |
|------|------|
| README.md | ✅ 存在 |
| SPEC.md | ✅ 本文档 |
| LICENSE | ❌ 缺失 |

## 9. Git 状态

- 状态: git clean (无待提交更改)
- .gitignore: 存在但内容不完整，缺少 Maven target/、IDE 配置等

## 10. 已知问题

1. **Lombok + JDK 25 兼容性问题**: 编译时注解处理器无法正常工作
2. **.gitignore 不完整**: 缺少 target/, .idea/, *.iml 等常见忽略项
3. **LICENSE 文件缺失**: README 中提到 AGPL-3.0 许可证但文件不存在
