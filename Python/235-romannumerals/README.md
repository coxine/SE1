python
AdditionalExam2018

附加题目：

1. 给定一个罗马数字，将罗马数字转换成整数

2. 给定一个整数，将整数转换成罗马数字

###相关资料

罗马数字中元字符共有 7 个，分别为 Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）和 Ⅿ（1000）。

这些元字符按照下述的规则可以表示任意正整数：

1. 一个罗马数字重复几次，就表示这个数的几倍。
2. 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
3. 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
4. 左减的数字有限制，仅限于 I、X、C。比如 45 不可以写成 VL，只能是 XLV
5. 但是，左减时不可跨越一个位值。比如，99 不可以用 IC 表示，而是用 XCIX 表示。
6. 左减数字必须为一位，比如 8 写成 VIII，而非 IIX。
7. 右加数字不可连续超过三位，比如 14 写成 XIV，而非 XIIII。
8. 同一数码最多只能连续出现三次，如 40 不可表示为 XXXX，而要表示为 XL

3 III
4 IV
8 VIII
9 IX
10
19 XIX
20 XX
30 XXX
40 XL
49 XLIX
99 XCIX