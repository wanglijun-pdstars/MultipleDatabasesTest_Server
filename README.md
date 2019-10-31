
## 目录  
* [背景介绍](#背景介绍)  
* [项目介绍](#项目介绍)  
* [使用说明](#使用说明)  
  * [引入mybatis-config](#引入mybatis-config)  
  * [配置文件](#配置文件)  
  * [Mysql与Sqlserver不兼容备忘](#Mysql与Sqlserver不兼容备忘)  
       * [连接字符串](#连接字符串)  
       * [使用PageHelper](#使用PageHelper)  
       * [子查询中有order by](#子查询中有orderby)  
       * [text类型转换](#text类型转换)  
       * [unsigned类型](#unsigned类型)  
       * [调用函数](#调用函数)  
       * [获取前n条数据](#获取前n条数据)  
       * [条件判断](#条件判断)  
       * [获取前n条数据](#获取前n条数据)  
       * [自增ID](#自增ID)  
       * [日期格式化](#日期格式化)  
       * [调用存储过程](#调用存储过程)  
  
<a name="背景介绍"></a>  
## 背景介绍  
  
由于公司以前的工程是Spring boot+Mybatis+Mysql编写的，但某个项目的数据库使用SqlServer，所以要求一套代码能够兼容Mysql和SqlServer  
  
<a name="项目介绍"></a>  
## 项目介绍  
使用了Spring boot+Mybatis的框架，DAL层使用一套Object+interface，两套XML完成，并通过配置完成相应XML的映射  
  
<a name="使用说明"></a>  
## 使用说明    
<a name="引入mybatis-config"></a>  
### 引入mybatis-config  
  
由于已将mybatis config封装为jar包，可在pom中加入下方依赖，完成mybatis config引入。  
  
* maven  
  
```  
    <dependency>  
        <groupId>com.pdstars.db</groupId>  
        <artifactId>mybatis-config</artifactId>  
        <version>1.0-SNAPSHOT</version>  
    </dependency>    
```  
<a name="配置文件"></a>  
### 配置文件  
  
在application.properties或application-xxx.properties中加入以下配置：  
```  
#mysql或sqlserver的XML路径  
#mysql:classpath:sqlmap/mysql/*.xml  
#sqlserver:classpath:sqlmap/mssql/*.xml  
sqlmap.location=classpath:sqlmap/mysql/*.xml  
sqlmap.typepackage=com.pdstars.dal  
sqlmap.configLocation=classpath:mybatis/mybatis-config.xml  

#MySQL配置  
#spring.datasource.url=jdbc:mysql://192.168.14.74:3306/multipledatabase?useUnicode=true&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=round&autoReconnect=true
#spring.datasource.username=root  
#spring.datasource.password=123456  
#spring.datasource.driver-class-name=com.mysql.jdbc.Driver  

#SqlServer配置  
spring.datasource.url=jdbc:sqlserver://192.168.24.15:1433;DatabaseName=multipledatabase  
spring.datasource.username=sa  
spring.datasource.password=Sa1234  
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver   
```  
<a name="Mysql与Sqlserver不兼容备忘"></a>  
### Mysql与Sqlserver不兼容备忘  
  
<a name="连接字符串"></a>  
#### 连接字符串  
   * **描述** sqlserver中不要用concat连接字符串，要使用+，sring1+string2+...。  
   * **例子** mysql中的like (concat('%\\',#{cityCountyQuery.regionName},'%')) ，  
   在sqlserver中为like '%'+#{cityCountyQuery.regionName}+'%'。  
   
<a name="使用PageHelper"></a>  
#### 使用PageHelper  
   * **描述** 如果使用PageHelper，那么后面执行的SQL语句必须要有order by，否则sqlserver会报错，报错信息为"请您在sql中包含order by语句!"。  

<a name="子查询中有orderby"></a>  
#### 子查询中有orderby  
   * **描述** 子查询中如果有order by，那么结果列中必须有Top，否则会报错“除非另外还指定了 TOP、OFFSET 或 FOR XML，否则，ORDER BY 子句在视图、内联函数、派生表、子查询和公用表表达式中无效。”。  
   * **例子** select * from (select Top 100 percent * from test order by id)tmp inner join test2 tmp2 on tmp1.id=tmp2.id。      

<a name="text类型转换"></a>  
#### text类型转换  
   * **描述** mybatis生成的text类型为LONGVARCHAR，但在sqlserver中使用时，会报错：“不支持从varchar(nvarchar)到CLOB”，所以需要把xml中的LONGVARCHAR修改为varchar。  
   * **例子** select * from (select Top 100 percent * from test order by id)tmp inner join test2 tmp2 on tmp1.id=tmp2.id。  

<a name="unsigned类型"></a>  
#### unsigned类型  
   * **描述** sqlserver中不存在unsigned类型。  
   * **例子** 在sqlserver中，强制转换时cast('123' as unsigned)修改为cast('123' as int)。  

<a name="调用函数"></a>  
#### 调用函数  
   * **描述** 调用function时，mysql直接写函数名称就行，sqlserver需要加dbo.，否则会报错"不是可以识别的内置函数名称"。  
   * **例子** Mysql中的GetNum()，在sqlserver应该为dbo.GetNum()。  
   * **引申**  
   ```     
    dbo是每个数据库的默认用户，具有所有者权限，全称：datebaseOwner ，即DbOwner。  
    在数据库中，新建对象时，默认对象的所有者为当前登录的账号。  
    如果通过用dbo作为所有者来定义对象，能够使数据库中的任何用户引用而不必提供所有者名称。  
    比如：你以User1登录进去并建表Table，而未指定dbo， 当用户User2登进去想访问Table时就得知道这个Table是你User1建立的，要写上User1.Table，如果他不知道是你建的，则访问会有问题。 如果你建表时把所有者指给了dbo，则别的用户进来时写上Dbo.Table就行了，不必知道User1。   
    不光表是如此，视图等数据库对象建立时也要如此才算是好。 所以在创建对象时，指定所有者为dbo，任何一个用户都可以引用。  
    建表、存储过程、视图等数据库对象时，其对应的所有者是创建它的用户。则除了该用户其他登录用户要引用这些东东时，都要加上前缀，很是麻烦。而且，程序因此易出错，你查来查去问题确出在这，浪费你时间。  
   ```  

<a name="获取1条数据"></a>  
#### 获取前n条数据  
   * **描述** sqlserver中没有limit 1，要用TOP 1,加在结果列前。  
   * **例子** Mysql中的select id,name from test limit 1，在sqlserver中为：select TOP 1 id,name from test。  

<a name="条件判断"></a>  
#### 条件判断  
   * **描述** mysql中的if()对应sqlserver中的case when。  
   * **例子** mysql中的SUM(IF(a = 0, 1, 0)) AS test,在sqlserver中修改为SUM( case when a=0 then 1 else 0 end ) AS test。  

<a name="获取前n条数据"></a>  
#### 获取前n条数据  
   * **描述** 获取前n条数据，n作为参数。  
   * **例子** mysql中的select top #{top} * from tb,在sqlserver中修改为select top ${top}  *  from tb。  
   * **引申**  
   ```     
    在Java中对数据库查询时经常使用“Select Top ？ * From 表名 Where 列名 = ？”的SQL语句，此时的问号是PreparedStatement预编译对象的参数占位符，需要使用setXX()系列方法对其赋值后再执行。  
    但是在sqlserver中，Top后面是不允许使用问号占位符的，所以要将语句：select top #{top}  *  from tb语句修改为：select top ${top}  *  from tb，否则会报错：“@P0”附近有语法错误。"
   ```     

<a name="自增ID"></a>  
#### 自增ID  
   * **描述** 如果在执行插入语句后，需要获取插入后的自增id。  
   * **例子** 在自动生成的xml中，mysql内容如下     
   ```  
   <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Long">  
   SELECT LAST_INSERT_ID()  
   </selectKey>  
   ```  
   那么在sqlserver中，不存在SELECT LAST_INSERT_ID()语句，需要替换为SELECT IDENT_CURRENT('xxx')，xxx为表名。  
   或者删除掉
   ```  
   <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Long">  
   SELECT LAST_INSERT_ID()  
   </selectKey>  
   ```  
   在<insert>增加useGeneratedKeys="true" keyProperty="id"，  
   即  
   ```     
   <insert id="insert" parameterType="com.pdstars.dal.dataobject.xxx"  useGeneratedKeys="true" keyProperty="id">  
   ```     

<a name="日期格式化"></a>  
#### 日期格式化  
   * **描述** mysql的日期格式化语句与sqlserver中的不同。  
   * **例子** mysqlk中的DATE_FORMAT(date,"%Y%m%d" )，在sqlserver修改为CONVERT(varchar(100),date, 23)。  

<a name="调用存储过程"></a>  
#### 调用存储过程  
   * **描述** mysql中的调用存储过程与sqlserver有所不同。  
   * **例子** mysql中的call Proc_updateCompany_cascade(#{companyId,mode=IN,jdbcType=BIGINT},#{companyName})，  
   在sqlserver中{call Proc_updateCompany_cascade(#{companyId,mode=IN,jdbcType=BIGINT},#{companyName})}，即在外面包一层{}。  
  
  
时间仓促，功能简陋，望您包涵。
