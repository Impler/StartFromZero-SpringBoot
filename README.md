# StartFromZero-SpringBoot
Spring Boot用来简化Spring应用开发，约定大于配置，去繁从简。  
优点：

- 快速创建独立运行的Spring项目
- 使用嵌入式的Servlet容器，无需打war包
- starters自动依赖与版本控制
- 大量的自动配置，简化开发，也可修改默认值
- 无需配置XML，无代码生成，开箱即用
- 准生产环境的运行时应用监控
- 与云计算天然集成 
## 配置文件
### 全局配置文件
- application.properties
- application.yml
作用是修改Springboot自动配置的默认值。
### 默认加载配置文件位置
- file:./config/：当前项目的根目录下的config目录
- file:./：当前项目的根目录下
- classpath:/config/：classpath根目录下的config目录
- classpath:/：classpath根目录
优先级从高到低，高优先级配置覆盖低优先级配置。  
项目打包好后，还可以使用`spring.config.location`命令行参数，指定配置文件位置。  
### YAML配置文件
以数据为中心，比JSON和XML更适合做配置文件。  
#### 基本语法
- KEY:(空格)VALUE，表示一对键值对
- 以空格的缩进来控制层级关系，只要是左对齐的一列数据，属于同一层级
#### 值的写法
- 字面值： 数字，字符串，布尔
  - 字符串默认不用加单引号或双引号
    - 双引号：不会转义字符串里面的特殊字符，例如："\n"，输出换行
    - 单引号：会转义特殊字符，把特殊字符当做普通字符数据，例如'\n'，输出'\n'
- 对象：Map
  - 对象名独占一行，下一行写对象的属性和值
  ```
    friends:
      name: 张三
      age: 12
  ```
  - 行内写法
  ```
    friends:{name: 张三, age: 12}  
  ```
- 数组：List、Set
  - 用"-值"表示数组中的一个元素
  ```
  pets:
    - cat
    - dog 
  ```
  - 行内写法
  ```
  pets: [cat, dog]
  ```
### 自动装配原理
- SpringBoot启动时，加载主配置类，启动@EnableAutoConfiguration
- 扫描所有类路径下的META-INFO/spring.factories
- 将配置的所有EnableAutoConfiguration的值加入到容器中，用他们做自动配置
- 根据当前不同的条件判断，决定这个配置类是否生效
`debug=true`，开启自动配置报告。  

## Springboot Web
### 静态资源映射
- `/wabjars/**`：以jar包的方式引入静态资源，Springboot默认扫描`classpath:/META-INF/resources/webjars`目录
- `/**`：访问静态资源，扫描以下目录：
  - `classpath:/META-INF/resources/`
  - `classpath:/resources/`
  - `classpath:/static/`
  - `classpath:/public/`
- 首页映射：扫描静态资源目录下的index.html
- 图标映射：扫描静态资源目录下的favicon.ico
- 自定义静态资源位置：使用`spring.resources.static-locations`参数
### 模板引擎
#### Thymeleaf模板引擎
- 引入
  ```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
  </dependency>
  ```
- thymeleaf 默认处理`classpath:/templates/`目录下以`.html`为后缀的模板文件

### SpringMVC自动配置
- 配置ViewResolver
- 装配静态资源文件夹路径和webjars
- 配置 静态首页
- 注册Converter和Formatter
- 配置HttpMessageConverters
- 配置MessageCodeResolver，定义错误码生成规则
- 配置Web数据绑定器

## 配置嵌入式Web容器

SpringBoot默认使用tomcat作为嵌入式的Web容器。  

- 通用配置：
  - server.xxx

- 配置tomcat
  - server.tomcat.xxx
- EmbeddedServletContainerCustomizer，定制嵌入式容器配置
- 注册Servlet三大组件：Servlet、Filter、Listener：
  - ServletRegistrationBean
  - FilterRegistrationBean
  - ServletListenerRegistrationBean

### 切换嵌入式Web容器

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <exclusions>
    <!-- 排除tomcat-->
    <exclusion>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-tomcat</artifactId>
    </exclusion>
  </exclusions>
</dependency>
<!-- 引入jetty-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

### 嵌入式Web容器自动配置原理

`EmbeddedWebServerFactoryCustomizerAutoConfiguration`

## 外置Web容器

嵌入式Servlet容器，应用打成jar包，简单便捷，但不支持JSP，优化定制比较复杂。

外置Web容器，应用打成war包：

- 创建war项目
- 将嵌入式的Tomcat指定为provided
- 重写SpringBootServletInitializer的configure方法
- 启动Web容器

## Spring Boot启动配置原理

启动流程

- 创建SpringApplication对象
  - 保存主配置类
  - 判断是否web环境
  - 从类路径下找META-INF/spring.factories配置的所有ApplicationContextInitializer
  - 从类路径下找META-INF/spring.factories配置的所有ApplicationListener
  - 从多个配置类中找到包含main方法的配置类
- 执行run方法
  - 从类路径下找META-INF/spring.factories配置的所有SpringApplicationListener