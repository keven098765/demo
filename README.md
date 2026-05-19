学生管理系统 API

技术栈：Spring Boot + MyBatis + MySQL

接口列表：
GET /users 查询所有
GET /user/{id} 按id查询
GET /students?page=1&size=10 分页查询
POST /add-student 添加
PUT /update-student 更新
DELETE /delete-student/{id} 删除

运行方法：
1. 修改 application.properties 里的数据库密码
2. 运行 DemoApplication.java
3. 访问 localhost:8080/users

作者：Kevin
