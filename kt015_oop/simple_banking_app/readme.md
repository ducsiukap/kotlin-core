Let's create database to test.

```
create database simple_banking_app.db;

use simple_banking_app_db;

create table customer (
	id int auto_increment primary key,
    name nvarchar(100),
	username varchar(100) not null unique,
    password varchar(100) not null,
    balance float not null check(balance >= 0)
);

insert into customer(name, username, password, balance) values
("Pham Van Duc", "vduczz", "123456", 1000);

select * from customer;
```

Then, change the user and password in `app/src/kotlin/dao/DAO.kt`  
First, you need to open and build this project by run this command: `./gradlew build`  
Then, I dont know the reason of i cannot input in terminal when use `./gradlew run` to run this project. So, you can run manualy:

1. go to project : `cd /path/to/simple_banking_app`
2. Download [Connector/J](https://dev.mysql.com/downloads/connector/j/) and extract. Then copy path of file `mysql-connector-j-9.0.4.0.jar`
3. run this command

   ```
   java -cp "app/build/classes/kotlin/main;C:\Program Files\kotlinc\lib\kotlin-stdlib.jar;path\to\mysql-connector-j-9.4.0\mysql-connector-j-9.4.0\mysql-connector-j-9.4.0.jar" MainKt
   ```

   then paste the copied path to `path/to/mysql-connector-j-9.0.4.0.jar`  
   You also may be find the path of `kotlin-stdlib.jar`

### Anyway, now we have ChatGPT. Let's asked it to fix your every error.! :)
