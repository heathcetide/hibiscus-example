# hibiscus-example

Hibiscus框架的演示项目,展示框架的核心功能与基础特性。

## 项目介绍

本项目是 Hibiscus 框架的官方演示项目,旨在帮助开发者快速上手和了解框架的各项功能。通过具体的代码示例和详细的说明文档,使开发者能够轻松地将 Hibiscus 框架整合到自己的项目中。

## 环境要求

- JDK 8+
- Maven 3.6+
- Redis 5.0+
- MySQL 5.7+

## 快速开始

### 1. 克隆项目

```bash
git clone https://github.com/heathcetide/hibiscus-example.git
cd hibiscus-example
```

### 2. 配置数据库

修改 `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/hibiscus_demo
    username: your_username
    password: your_password
  redis:
    host: localhost
    port: 6379
```

### 3. 初始化数据库

```bash
# 执行SQL脚本
mysql -u your_username -p hibiscus_demo < docs/sql/init.sql
```

### 4. 启动项目

```bash
mvn spring-boot:run
```

## 功能演示

### 基础功能

1. **用户认证**
   - 访问 http://localhost:8080/api/auth/login
   - 默认账号: admin
   - 默认密码: admin

2. **后台管理**
   - 访问 http://localhost:8080/api/hibiscus/code/backstage
   - 包含数据库管理、Redis管理等功能

3. **接口测试**
   - 访问 http://localhost:8080/api/hibiscus/interface
   - 支持接口调试和性能测试

4. **日志查看**
   - 访问 http://localhost:8080/api/hibiscus/logs
   - 实时日志展示和查询

### 示例代码

1. **配置文件示例**

```yaml
hibiscus:
  helper:
    api-test:
      enabled: true
      base-path: /api-test
    scanPath: com.example.demo
```

2. **控制器示例**

```java
@RestController
@RequestMapping("/api/demo")
public class DemoController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello Hibiscus!";
    }
}
```

## 目录结构

```
hibiscus-example/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── docs/
│   └── sql/
├── pom.xml
└── README.md
```

## 常见问题

1. **启动失败**
   - 检查数据库配置是否正确
   - 确保Redis服务已启动
   - 检查端口是否被占用

2. **无法访问页面**
   - 确认项目正常启动
   - 检查防火墙设置
   - 验证访问地址是否正确

## 参与贡献

1. Fork 本仓库
2. 创建新的分支: `git checkout -b feature/your-feature`
3. 提交更改: `git commit -m 'Add some feature'`
4. 推送到分支: `git push origin feature/your-feature`
5. 提交 Pull Request

## 联系我们

- 作者：heath-Cetide
- 邮箱：2148582258@qq.com
- 微信：ct288513832

## 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件 