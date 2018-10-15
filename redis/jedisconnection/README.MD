# pringboot使用 JedisConnectionFactory 访问 单节点redis

> springboot 中使用Redis,引入 `spring-boot-starter-data-redis` 模块即可。此时已经可以正常使用 StringRedisTemplate/RedisTemplate操作Redis。

### 但是，生产环境需要配置 connectionPool ，个人推荐使用 JedisConnectionFactory
springboot 访问Redis是通过 `[接口]RedisConnectionFactory` ，该接口有两个常用实现：

##### 1. JedisConnectionFactory
##### 2. LettuceConnectionFactory [default]

> 使用Redis时，获取Connnetion 通过RedisConnectionFactory 接口提升效率。pringboot默认使用 LettuceConnectionFactory

### 为了使用 JedisConnectionFactory,可以显示配置：
```bash
    @Bean
    public RedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        return new JedisConnectionFactory(jedisPoolConfig);
    }
    
    或者
    
    @Bean
    public RedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }
```
> 两种方式的区别在于，前者可以可以自定义 pool config. 比如：
```bash
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(99);
        //。。。
        return config;
    }
```