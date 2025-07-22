# NowCoder MCP Server

## 项目简介
NowCoder MCP Server 是一个基于 Spring Boot 的后端服务，集成了 Spring AI 组件，支持面经搜索功能

## 技术栈
- Java 17
- Spring Boot 3.4.3
- Spring AI 1.0.0
- Retrofit 3.0.0

## 工具列表
**面经搜索** `faceWarpSearch`
- 根据关键词搜索牛客网中的面经

## 必备环境
- jdk17
- maven

## 快速开始

1. 克隆项目
   ```bash
   git clone https://github.com/CalmChih/nowcoder-mcp-server.git
   ```
2. 构建并运行
   ```bash
   cd nowcoder-mcp-server
   mvn clean package
   ```
3. 默认配置请参考 `src/main/resources/application.yml`

## 在 Claude 等平台中配置 MCP 服务
stdio模式:
```json
{
  "mcpServers": {
    "nowcoder-mcp-server": {
      "command": "java",
      "args": [
        "-jar",
        "<你的jar包地址>/nowcoder-mcp-server-1.0.0.jar",
         "--server.port=10088",
         "--spring.main.web-application-type=none",
         "--logging.pattern.console="
      ]
    }
  }
}
```
sse模式:
```json
{
  "mcpServers": {
    "nowcoder-mcp-server": {
      "type": "sse",
      "url": "http://<你部署的地址>/sse"
    }
  }
}
```

## 贡献与反馈
欢迎提交 issue 或 PR 以改进本项目。