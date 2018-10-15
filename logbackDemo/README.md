# logbackDemo
SpringBoot log logbackDemo

### 1. logback 介绍

> Logback 是log4j框架作者开发的新日志框架，效率更高并且支持环境配置，天然支持SLF4J 。推荐logback. 推荐配置文件为 resources/logback-spring.xml  


### 2. 日志框架

>  SLF4J (simple logging Facade 4 java) , 是对各类Java 日志框架的统一抽象(Facade抽象) 。 常见的Java日志框架
有 [java.util.logging,log4j,logback,commons-logging]


### 3. 配置使用

>  方式1: `private Logger logger = LoggerFactory.getLogger(this.getClass());`
>  方式2:  通过在类上使用 `@Slf4j` 
> 不需要特意引入依赖jar ，因为 `spring-boot-starter-web` 依赖logback的jar 文件。

