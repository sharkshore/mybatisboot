
###搭建一个mybatis,mysql,druid,slf4j的起始项目,支持不同环境

1. 能启动访问接口  ok
2. 配置druid  ok
3. 配置mysql   ok
4. 配置mybatis  ok
5. 配置spring data jpa ok
6. 支持spring data jpa rest  ok
7. 配置redis ok
8. 配置slf4j  ok
9. 改造配置文件,支持不同环境  ok
10. 配置JdbcTemplate   ok
11. 支持热部署  ok
12. 支持分页查询(Mybatis分页插件)  ok
13. 支持单元测试  ok
14. 支持日志级别,日志输出 ok
15. druid监控 ok
16. 支持定时任务  ok
17. 支持swagger2快速查看接口文档
18. 支持参数效验(接口传参,资源文件效验)

# springboot版本:1.5.6.RELEASE
# java版本:java8

### 分支介绍
1. master分支,主分支(multi-module:Maven多模块结构)
2. 2.0.1.RELEASE Springboot版本
3. 1.5.6.RELEASE Springboot版本
4. single-module:mybatis全部环境,提供接口
5. mvc-page分支:页面模式,可以构建网站

3. multi-module:Maven多模块结构(该分支已经删除)

### 使用前准备

1. 执行doc目录下的user_demo.sql文件创建表和插入数据


### 使用注意事项
1. 下载项目后,首先修改项目访问根路径,代码包名,再shift+f6修改模块名
2. 修改基本包名后,记得修改BootApplication和Swagger2Config中的包名地址
3. 修改父pom.xml中的start.class
4. 如果整体加载workspace的话,记得修改spring.devtools中的监听文件路径,不然启动项目会报错
5. 修改mybatis.type-aliases-package路径
6. 修改AppConfig类上的注解@MapperScan("")
7. 修改日志等级和日志路径
8. 修改数据库的连接地址


### Spring data jpa rest
http://localhost:9000/spring-boot/profile

### swagger2查看接口文档地址：

1. 接口详细数据
http://localhost:9000/mybatisboot/v2/api-docs

2. 访问界面:
http://localhost:9000/mybatisboot/swagger-ui.html


### 日志输出内容元素具体如下：

* 时间日期：精确到毫秒
* 日志级别：ERROR, WARN, INFO, DEBUG or TRACE
* 进程ID
* 分隔符：--- 标识实际日志的开始
* 线程名：方括号括起来（可能会截断控制台输出）
* Logger名：通常使用源代码的类名
* 日志内容

### druid监控的地址
> http://127.0.0.1:9000/mybatisboot/druid/index.html
用户名:admin
密码:123456

> 支持SQL监控,Web应用监控,URI监控,Session监控
