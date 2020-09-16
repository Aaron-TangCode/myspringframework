### Spring的设计初衷

- 轻量级：最少的侵入，与应用程序低耦合。
- 可以采用Spring来构造任何程序，而不局限于web程序。

### Spring-core（核心）

- 包含框架基本的核心工具类，其他组件使用到这个包的类
- 定义并提供资源的访问方式
- 为IOC和DI提供最基础的服务（研究对象）

### Spring-beans（核心）

> spring主要面向bean编程（BOP）

- Bean的定义
- Bean的解析
- Bean的创建（码农唯一需要关心的就是Bean的创建，其他都是spring管理好的）
- BeanFactory(研究对象)

### Spring-context（核心）

- 为spring提供运行时环境，保存对象的状态
- 扩展了beanfactor
- ApplicationContext（研究对象）

### Spring-aop(核心):

> 最小化的动态代理实现

- JDK动态代理
- 基于类，CGlib
- 只能使用运行时织入，仅支持方法级编织，仅支持方法执行切入点

### 为了完整而讲的非核心模块

- Spring-aspectj + spring-instrument : full AspectJ
- 编译器织入
- 类加载器织入
- 运行期织入

### 简单demo

- xml配置bean文件
- 加载xml文件
- 获取bean

### 学好spring的建议

- 先学会如何使用spring
- 阅读spring官方文档-spring framework reference
- 多动手调试
- 掌握设计模式，熟悉spring框架的标签和注解的作用

### 设计模式：门面模式

- 就是提供给外部访问的接口，组装了N个子系统的方法。
- 其中Slf4J就是门面模式的代表。后续会继续介绍	

### 泛型是否可以使用具备继承关系的类

- 不可以

- 如果非要，那可以使用通配符?，但是会使得泛型的类型检查失去意义
- 给泛型加入上边界 ？ Extends E
- 给泛型加入下边界 ？super E

### 泛型方法、泛型类、泛型接口

- 泛型方法可以独立于泛型类
- 泛型方法

```Java
public static <E> void printArray(E[] inputArray){
        for (E e : inputArray) {
            System.out.println(e);
        }
    }
```

- 有泛型参数的普通方法

```java
public T handleSomething(T target){
        return target;
    }
```

### DispatcherServlet

- 拦截所有请求
- 解析请求并处理

### 简单工厂模式：直接生产所需要的对象

- 使用场景
  - 需要创建的对象比较少
  - 客户端不需要关心对象的创建过程
- 被创建对象有共同的父类或接口
- 优缺点
  - 优点：可以对创建的对象进行”加工“，对客户端隐藏相关细节
  - 缺点：因为创建的逻辑复杂或者创建的对象过多而造成代码臃肿
  - 缺点：**新增，删除子类，都违反开闭原则**

### 随机应变

- 所有原则并非一定要遵守的，要结合具体业务的实际情况。但可能满足开闭原则。

### 公厂方法模式：让工厂的子类工厂去生产所需要的对象

- 定义：一个用于创建对象的接口，让子类决定实例化哪一个类

- 对类的实例化延迟到其子类：其实就是让工厂的子类去生产所需要的对象

- 优点

  - **遵循开闭原则。如果增加子工厂，是符合的。但如果新增产品，那就违背开闭原则。**

  - 对客户端隐藏对象的创建细节
  - 遵循单一原则

- 缺点

  - 随着功能增加，类的个数成对增加。要增加工厂类和其生产对象

  - 只支持同一类的产品创建

    

### 抽象工厂模式

- 相对工厂方法模式的优点：可支持创建多个产品
- 缺点：添加新产品时，**依旧违背开闭原则**，增加系统复杂度

### 反射

- 反射机制的作用

  - 在运行时判断一个对象所属的类
  - 在运行时，获取类的对象
  - 在运行时，访问对象的属性，方法，构造方法等

- Class类的特点

  - Class类也是类的一种，class是关键字
  - Class类只有一个私有private的构造函数，只有JVM能够创建Class类的实例
  - 在运行期间，任意一个类，**有且仅有**一个Class对象与之对应。

- 获取Class对象的是那种方式

  - object的getClass()
  - .class
  - forName(name)

- 获取构造方法

  - 获取多个构造方法

    - ```JAVA
      getConstructors();//获取的“public”的构造方法
      ```

    - ```java
      getDeclaredConstructors();//获取所有的构造方法。包括private,protected,public,default
      ```

  - 获取单个构造方法

    - ```Java
      getConstructor(Class<?>... parameterTypes);//获取的“public”的构造方法
      ```

    - ```java
      getDeclaredConstructor(Class<?>... parameterTypes);//获取所有的构造方法。包括private,protected,public,default
      ```

- 创建实例：newInstance();

  - 备注：如果是private的构造方法，在调用newInstance之前，调用setAccessible(true);//进行暴力访问

# 反射获取源

- XML：集中式元数据设置方式
- 注解：分散式元数据设置方式



**元数据**：是添加到程序元素如方法，字段，类和包上的**额外信息**。



注解：不能直接干扰程序的运行



元注解：

- @Target：注解的作用目标。有很多枚举：直接看`ElementType`
- @Retention:注解的生命周期。有三种生命周期。直接看`RetentionPolicy`
- @Documented:注解是否应当被包含在JavaDoc文档中
- @Inherited：是否允许子类继承该注解

### 注解获取属性值的底层实现

- 万物皆对象
- JVM会为注解生成代理对象



### 所有框架都应该具备的最基本功能

- 解析配置。把定义好的数据加载到内存 。解析的配置就是所谓的语言，这里指注解
- 定位和注册对象。在web框架中，声明的@Controller类，IOC可以定位到该对象。对象：泛指被标记的东西，这里指类
- 注入对象。
- 提供通用的工具类。



### IOC容器的实现

- 需要实现的点

- - 创建注解（输入）

  - - 声明controller
    - 声明service
    - 声明repository
    - 声明component

  - 提取标记对象（输入）

  - - 少不了遍历，但是遍历要有范围，这个范围是开发者指定的。

    - 实现思路：

    - - 指定范围，获取范围内的所有类

      - - 具体实现：

        - - 获取到类的加载器。目的：获取项目发布的实际路径。那为什么不传入绝对路径，因为机器不同，路径可能不同
          - 通过类加载器获取到加载的资源信息。类加载器的功能：根据一个指定的类名称，找到或者生成其对应的字节码。
          - 依据不同的资源类型，采用不同的方式获取资源的集合

      - 遍历所有类，获取被注解标记的类并加载进容器里

  - 实现容器（输入）

  - 标记对象存入容器（输入）

  - 依赖注入（输出）



1、获取类的加载器

2、通过类的加载器获取加载的资源。获取到URL

3、过滤file协议的url

4、根据url获取路径，根据路径获取文件夹路径

5、递归调用文件夹，获取.class

6、根据.class生成class对象



### 容器的组成部分

- - 保存class对象及其实例的载体

  - 容器的加载

  - - 配置的管理与获取。在这里指如何将注解管理起来
    - 获取指定范围内的Class对象
    - 依据配置提取Class对象，连同实例一并存入容器

  - 容器的操作方式

  - - CRUD
    - 根据Class获取对应的实例
    - 获取所有Class和实例
    - 通过注解获取被注解的Class
    - 通过超类获取对应子类的Class
    - 获取容器载体保存Class的数量



先说大体，再说细节

- - 根据给定的包名，在对应的目录下，获取所有class对象组成的set
  - 用给定的注解，看看set里面的class是否有给定的注解。有，则加载到容器中，无，就不加载。
  - 容器：ConcurrentHashMap<Class<?>,Object> 



### 实现容器的依赖注入

- 实现思路

- - 定义相关的注解标签
  - 实现创建被注解标记的成员变量实例，并将其注入到成员变量里
  - 依赖注入的使用

### 深入spring源码

- AnnotationConfigApplication

- spring支持不同语言的解析：比如xml,注解

- 主心骨

- - 解析配置
  - 定位与注册对象
  - 注入对象



##### Bean与BeanDefinition

- Bean是spring的一等公民

- - Bean其实也是java对象，只不过生命周期由容器管理

- 描述bean的beandefinition

- - 常用属性：

  - - 作用范围scope(@Scope):
    - 懒加载lazy-init:@Lazy
    - 首选primary:@Primary
    - Factorybean:@Configuration
    - Factorymethod:@Bean

- RootBeanDefinition，不能有parent，否则报错。

- GenericBeanDefinition，已经基本取代ChildBeanDefinition。

- 他们三者，是用组合来实现父子类的。不是用extend



- 组件扫描：其实就是扫描被@Component等注解的类
- 自动装配：其实就是把被@Autowire等注解的类，注入bean



##### AutowireCapableBeanFactory:可以填充那些不受IOC容器控制的类。就是new 出来的类。



@Autowired注入bean，最终会调用AutowireCapableBeanFactory的resolveDependency方法



##### DefaultListableBeanFactory.最重要的是beanDefinitionMap<String,BeanDefinition>。用来装载已经注册的beandefinition。有工厂功能。registerBeanDefinition用来注册beanName和beanDefinition.



##### SimpleBeanDefinitionRegistry里面也有beanDefinitonMap，但仅仅是注册表，不提供工厂功能。



##### ApplicationContext容器

- 继承的接口：
  - EnvironmentCapable：获取环境配置
  - ListableBeanFactory：管理列表bean
  - HierarchicalBeanFactory：管理曾经bean
  - MessageSource:国际化
  - ApplicationEventPublisher：监听器，观察者模式
  - ResourcePatternResolver：加载资源

- 实现类：

- - 基于xml的配置

  - - FileSystemXmlApplicationContext:从文件系统加载
    - ClassPathXmlApplicationContext：从classpath加载

  - 目前比较流行的容器，基于注解

  - - AnnotationConfigApplicationContext

- 主要学习容器的共性

- - refresh()大致功能

  - - 容器初始化，配置解析
    - BeanFactoryPostProcessor和BeanPostProcessor的注册和激活
    - 国际化配置

### 模板方法模式

- 模板方法
- 具体方式
- 钩子方法（子类可根据自己情况来实现或不实现）
- 抽象方法（子类必须实现）





在spring中。AbstractApplicationContext的refresh方法就是典型的模板方法。

### 策略模式

##### Resource、AbstracteResource及其实现类。使用的是策略模式



##### BeanDefinitionReader是ResourceLoader的使用者



- 资源定位
- 资源加载
- 资源解析
- 资源注册



### 用注解加载bean

- 内置beandefinition是在this()构造函数时被注册的
- @Configuration标记的配置类，是在register()方法时注册的
- 常规beandefinition是在refresh()时被注册的