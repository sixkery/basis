linux 命令
1. sudo apt-get update: 更新源
2. sudo apt-get upgrade: 更新已安装的包
3. tar -zxvf xxx.tar.gz: 解压命令
   z: 用gzip对存档压缩或解压
   x: 从存档展开文件
   v: 详细显示处理的文件
   f: 指定存档或设备

SSH 拷贝文件

1. 从服务器拷贝文件到本地

   ```shell
   $ scp root@ip:/docker/nginx/conf/nginx.conf /home/docker/nginx
   ```

   

### Ubuntu 下百度网盘不停缓冲打不开解决方法

运行命令

```shell
rm -rf ~/baidunetdisk
```



### ubuntu 下安装 nginx

1. sudo apt-get install nginx
2. sudo systemctl status nginx: 查看nginx运行情况
3. sudo nginx -v: 查看版本
4. 浏览器输入 ip: 查看运行情况
5. 主要配置文件: /usr/local/nginx/conf/nginx.conf
6. 启动脚本(需手动配置): /etc/init.d/
7. 程序文件: /usr/local/nginx/sbin/nginx
8. 日志: /var/log/nginx

### JWT

> JWT 是 json web token 的缩写，它是基于 RFC 7419 的标准定义的一种可以安全传输的 JSON 对象，由于使用了数字签名，所以是可信任和安全的。

### JWT 的组成

JWT token 的格式：header.payload.signature

* header : 用于存放签名的生成算法，例 : {"alg" : "HS512"}

* payload : 用于存放用户名，生成时间和过期时间。例 : {"sub" : "admin","created" : 1489079981393, "exp" : 1489684781}

* signature : 以 header 和 payload 生成的签名，一旦 header 和 payload 被篡改，验证就会失败。

  ```java
  // secret 是加密算法的密钥
  String signature = HMACSHA512(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret);
  ```


### JWT 实现认证和授权的原理

1. 用户调用登录的接口，登录成功后获取 JWT 中的 token。
   1. 之后用户每次调用接口都在 http 的 header 中添加一个叫 Authorization 





MySQL 命令

用一条 SQL 将一张表的数据插入到另一张表中

1.  表结构一样

   ```sql
   insert into table_1 select * from table_2;
   ```

2. 表结构不一样

   ```sql
   insert into table_1 (column_1, column_2, column_3) select column_1, column_2, column_3 from table_2;
   ```

3. 只从另一张表中复制部分值

   ```sql
   insert into (column_1, column_2, column_3) values (column_1, column_2, (select column_3 from table_2) );
   ```


1. 使用存储过程,循环插入 100 条数据.

   ```sql
   DROP PROCEDURE IF EXISTS proc_initData;--如果存在此存储过程则删掉
   DELIMITER $
   CREATE PROCEDURE proc_initData()
   BEGIN
       DECLARE i INT DEFAULT 1;
       WHILE i<=10000 DO
           INSERT INTO data(user_id) VALUES(i);
           SET i = i+1;
       END WHILE;
   END $
   -- 调用
   CALL proc_initData();
   ```

   

2. 使用存储过程,游标 给表中指定字段添加数据.

   ```sql
   --  给 om_dynamic_template 表中添加数据
   DROP PROCEDURE IF EXISTS insertTemplate;--如果存在此存储过程则删掉
   DELIMITER $
   CREATE PROCEDURE insertTemplate()
   BEGIN
       DECLARE i INT DEFAULT 1;
   		-- 定义一个游标数据变量
   		DECLARE ids varchar (20);
   		-- 遍历数据结束的标志
   		DECLARE done INT DEFAULT FALSE;
   		-- 游标
   		DECLARE business_ids CURSOR FOR SELECT id from bm_business;
   		-- 将结束标志绑定到游标
   		DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   		-- 打开游标
   		open business_ids;
   		 -- 开始循环
       read_loop: LOOP
   		-- 提取游标里的数据'
   		FETCH business_ids into  ids;
   		-- 声明结束的时候
   		IF done THEN
         LEAVE read_loop;
       END IF;
   		-- 做想做的事情
   		 INSERT INTO om_dynamic_template(id, `name`, describes,business_id) VALUES(i,"默认模板","默认模板",ids);
   		 SET i = i+1;
   		END LOOP;
       CLOSE business_ids;
   END $
   -- 调用
   CALL insertTemplate();
   
   
   DROP PROCEDURE IF EXISTS insertDynamic;--如果存在此存储过程则删掉
   DELIMITER $
   CREATE PROCEDURE insertDynamic()
   BEGIN
   		-- 定义一个游标数据变量
   		DECLARE ids varchar (20);
   		DECLARE idss varchar (20);
   		-- 遍历数据结束的标志
   		DECLARE done INT DEFAULT FALSE;
   		-- 游标
   		DECLARE template_ids CURSOR FOR SELECT id from om_dynamic_template;
   		DECLARE business_ids CURSOR FOR SELECT business_id from om_dynamic_template;
   		-- 将结束标志绑定到游标
   		DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   		-- 打开游标
   		open business_ids;
   		open template_ids;
   		 -- 开始循环
       read_loop: LOOP
   		-- 提取游标里的数据'
   		FETCH business_ids into  ids;
   		FETCH template_ids into  idss;
   		-- 声明结束的时候
   		IF done THEN
         LEAVE read_loop;
       END IF;
   		-- 做想做的事情
       update om_dynamic set template_id = idss where business_id = ids;
   		END LOOP;
       CLOSE business_ids;
   	  CLOSE template_ids;
   END $
   -- 调用
   CALL insertDynamic();
   
   ```

   

3. 修改表的数据类型

   ```sql
   ALTER TABLE om_dynamic_template MODIFY id VARCHAR (20);
   ```

4. 给表添加一列

   ```sql
   ALTER TABLE om_dynamic ADD template_id VARCHAR(20);
   ```

   

