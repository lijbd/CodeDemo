# feignDemo
A simple Demo of feign .


## feignServer

A normal web server .


#### 1. start server
```bash
cd /feignDemo/FeignServer

mvn clean install

java -jar target/FeignServer-0.0.1-SNAPSHOT.jar 
```
#### 2. check success
```
 curl http://localhost:8081/apiserver/hi
```

#### 注意事项
server pom.xml 添加 feign 依赖 jar
```bash
        <!-- 1-2 Feign 依赖 -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
		 <!-- 2-2 Feign 依赖 spring.cloud -->
		<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
```


## feignClient

Request feignServer through feign .

#### 1. start client
```bash
cd /feignDemo/FeignClient

mvn clean install

java -jar target/FeignClient-0.0.1-SNAPSHOT.jar 
```
#### 2. check success
```
  curl http://localhost:8089/client/hiserver
```
#### 注意事项
0. client pom.xml 依赖
```bash
        <!-- 1-3 feign依赖 -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
		<!-- 2-3 feign依赖 ribbon -->
		<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-ribbon -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
			<version>2.0.0.RELEASE</version>
		</dependency>
		<!-- 3-3 Feign 依赖 spring.cloud -->
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
```

1. application.properties 注册需要调用的服务，例如：
```bash
test.ribbon.listOfServers: localhost:8081
格式为 ${serverHost}.ribbon.listOfServers: ${具体的host,不能含有 path}
```
 
2. 添加HTTP访问接口：
```
@FeignClient(value ="test")
public interface HttpApi {

    @GetMapping(value = "/apiserver/hi")
    String sayHi();
    
    其中 test 即 ${serverHost}的值。
```

3. 开启feign 支持：
```bash
@EnableFeignClients(basePackages = "com.example.feignclient.feignclient.HttpServer")
@SpringBootApplication
public class FeignclientApplication {
  ...
}
    basePackages 即 HTTP访问接口所在package。
```

