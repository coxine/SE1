# repeated-substring-pattern

## 题目

给定一个非空的字符串`s`，检查是否可以通过由它的一个子串重复多次构成。

### 子串

串中任意个连续的字符组成的子序列称为该串的**子串**

例如：

- `ab`和`bc`都是字符串`abc`的子串
- `ac`不是字符串`abc`的子串

## 你的任务

请在`repeat.cc`中实现方法`bool repeatedSubstringPattern(string s)`：

- 参数`s`表示输入的非空字符串
- 返回值为`bool`类型，返回`true`或`false`

## 公开测试用例（公开测试用例也是计分的！此外有5个非公开测试用例）

### test 1

- 输入`s`：`"abab"`
- 输出：`true`
- 解释：重复子字符串为`"ab"`

## test 2

- 输入`s`：`"abcabcabc"`
- 输出：`true`
- 解释：重复子字符串为`"abc"`

## test 3

- 输入`s`：`"aaaaa"`
- 输出：`true`
- 解释：重复子字符串为`"a"`

## test 4

- 输入`s`：`"abcd"`
- 输出：`false`
- 解释：无重复子字符串

## test 5

- 输入`s`：`"abcdeabcde"`
- 输出：`true`
- 解释：重复子字符串为`"abcde"`

