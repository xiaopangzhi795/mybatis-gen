# 代码生成器

## 使用方式
### 生成mapper和实体类
1. resource配置文件中，35行，将数据库链接和数据库名字改一下，不要改后面的内容
2. 46行，更改一下实体类要存放的包路径位置
3. 52行，更改一下mapper存放的位置
4. 59行，mapper路径
5. table标签，生成全部的表，还是只有部分需要的表
6. 运行：maven-plugins-mybatis-generator：mybatis-generator:generator

### 生成高级查询
1. 打开com.geek45.mybatisgen.QueryCodeGenerator
2. 22行，更改要生成对象的DO类的全路径名字
3. 26行，表名
4. 运行main方法
5. 创建一个query对象，命名：xxxDOQuery
6. 将生成的query属性放进去，生成get&set方法
7. 将生成select语句复制到对应的mapper文件中
