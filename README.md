# IMDB TOP 250

#### 介绍
2020年1月份写的电影排名查看系统后端，可以处理电影的增删改查和图片的上传。

（正式版微信小程序已下架，只有体验版：皆非的万事屋）

参考bilibili：https://www.bilibili.com/video/BV1rD4y1D7zk?spm_id_from=333.999.0.0

#### 软件架构
Spring + SpringMVC + mybaitis


#### 使用教程

1.  在数据库中执行注目下的imdb.sql。（导入数据库和表以及一些数据）
2.  修改程序 imdb\src\main\resources\applicationContext.xml，配置其中的数据源（dataSource）
```xml
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/imdb?characterEncoding=UTF-8&amp;useSSL=false"/>
        <property name="user" value="root"/>
        <property name="password" value="12345"/>
    </bean>
```
3.  修改imdb\src\main\java\com\marchsoft\config\ParamConfig.java 中的私有变量img_path ：
```java
 //tomcat服务器或是nginx服务器或是其他服务器设置的静态资源访问地址
 private String img_path = "D:\\Software\\apache-tomcat-8.5.43\\images\\";

```

#### 使用说明

1.  导入idea，配置好tomcat服务器即可部署运行。

#### 参与贡献

jiefei30

