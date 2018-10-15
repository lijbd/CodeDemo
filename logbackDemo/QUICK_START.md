# 快速实战

### 1. yml中配置日志输出路径
```bash
# 指定日志文件路径
logging:
  path: ./out_put_dir
```

### 2. logback-spring.xml
```bash
# 指定 context name , 指定服务名称
    <contextName>myServer</contextName>
    <property name="LOG_PATH" value="${LOG_PATH:-.}" />
    <property name="FILE_NAME" value="MyAppName" />
```

### 3. 打印日志
```bash
        @Slf4j

        log.debug("debug:{}",o);
        log.info("info:{}",o);
        log.debug("warn:{}",o);
        log.error("error:{}",o);
```