# spring-boot configurationProperties学习测试

1.首先将需要配置的文件添加到properties或者yml配置文件中
2.编写配置文件的实体类用来接收保存配置文件信息
3.用@Component注解将该实体类添加到spring容器中
4.用@ConfigurationProperties(prefix = "配置文件前缀")注解获取到配置信息
5.使用配置属性时，采用@Autowired属性注入的方式将该配置类引入使用
6.如果属性文件单独存在，不包含在主配置文件中，则在属性类上加@PropertySource(value = {"classpath:config/*.properties"})
特别注意：@PropertySource注解不支持yml配置文件
7.多个属性文件使用@PropertySources(value = {
    @PropertySource(value={"classpath:config/*.properties"}),
    @PropertySource(value={"classpath:config/*.properties"})
})
需要特别注意的是两个合并了的属性文件分别有不同的前缀，那么只能使用配置文件对同一个属性类生成多个实例并指定不同的前缀
具体代码如下：

```java
@Configuration
public class PersonConfigurationProperties {

    @Bean
    @ConfigurationProperties(prefix = "person")
    public Person person1() {
        return new Person();
    }

    @Bean
    @ConfigurationProperties(prefix = "info")
    public Person person2() {
        return new Person();
    }
}
```

测试

```Java
@SpringBootTest
class SpringBootDemoApplicationTests {
    @Autowired
    @Qualifier("person1")
    private Person person1;

    @Autowired
    @Qualifier("person2")
    private Person person2;

    @Test
    void contextLoads() {
        System.out.println(person1);
        System.out.println(person2);
    }

}
```

如果存在多个地方配置有需要的配置信息，则会出现覆盖情况，后加载的覆盖前者，加载顺序遵循springboot配置文件的加载顺序，config文件下的比resource文件夹下的配置文件会先加载