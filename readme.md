1. 项目需要使用jjt，构建语法树，在项目启动时即编译好
2. 使用通用比较函数来实现逻辑判断
3. 支持类似 `1<a<4` 或 `5<a<=1` 的操作
4. 支持类似 `a-1>0` 或 `a+1<=10`的操作
5. 支持 `a = 1` 或者 `a = [1,2]`
6. 自动识别字符串，如上示例，根据 `a` 的实际类型，将值转换为对应类型
7. 支持将 `%` 自动转换为小数
8. 支持括号，用来分组
9. 支持 `AND、OR、NOT`
10. 支持的操作符 `>、>=、=、!=、<、<=、+、-`

