# LOGO

## 题目描述

简单模拟LOGO语言的小乌龟。

有一个大小为10*10的方格棋盘，最左上角的格子中有一个正不动的小乌龟。你需要让这个小乌龟能按照一定的指示在棋盘上画出一些内容。我们会输入n条指令，每条指令有2或3个操作数。第一个是移动的方向：U、D、L、R分别代表接下来像上/下/左/右移动；第二个是移动的步数：每移动一步后都会在脚下的格子中填上特定的字符。第三个操作数则是要填的字符，如果它不存在则沿用上一次移动所填充的字符。在移动的过程中，如果乌龟在指令下移动到了棋盘之外，则立刻输出Error并结束程序。若n条指令执行完，则输出整个棋盘上所画的内容。

## 输入格式

第一行一个数n，为指令的个数

接下来n行，每行2或3个字符，其中第一个为移动方向（UDLR中的一个），第二个为移动步数（0-9），第三个为一个字符（如果有）

## 输出格式

Error!或10行10列字符，表示最后的棋盘的结果。

## 样例

### 输入

```
2
R 3 X
D 5 Y
```

### 输出

```
0XXX000000
000Y000000
000Y000000
000Y000000
000Y000000
000Y000000
0000000000
0000000000
0000000000
0000000000
```

**! ! ! 注意此处的‘0’代表空白符，实际输出需用空白符代替。! ! !**

### 输入

```
3
D 2 1
R 4
U 1 2
```

### 输出

```
0000000000
1000200000
1111100000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
```

### 输入

```
3
R 1 N
U 3 E
D 7 G
```

### 输出

```
Error!
```



## 输入规定

指令条数1<=n<=15，保证不会出现不符合以上格式的指令，且第一条指令一定会指定要画的符号。

每次移动步数不会为0。

项目说明：

> src目录下为题目代码源文件，需要完成的内容为logo.py里的logo_play()方法。
> src目录下的__init__.py文件不需要改动。