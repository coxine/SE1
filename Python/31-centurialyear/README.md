##CenturialYear

编写一个程序，接受用户输入的一个年份，判断该年份是否为世纪年。如果是世纪年，输出"是世纪年"，否则输出"不是世纪年"。世纪年是指以00结尾的年份，但必须能被400整除才是世纪年，否则不是。


###项目说明：

>src目录下为题目代码源文件，需要完成的内容为centurial_year.py里的get_year方法。
>src目录下的__init__.py文件不需要改动。



### 示例：
>注意：不需要进行输入输出的处理，输入作为函数的参数传入，结果直接作为函数的返回值返回。

	输入：
	2013

	输出：
	False
	
	输入：
	400

	输出：
	True
	
	
	输入：
	100

	输出：
	False