## Shell变量

### 规则

+ 命名只能使用英文字母，数字和下划线，首个字符不能以数字开头
+ 中间不能有空格，可以使用下划线_
+ 不能使用标点符号
+ 不能使用bash里的关键字

```shell
your_name="banyue" #变量与等号中间不能有空格(显式命名)

# 列出/etc目录下的文件(隐式命名)
for file in 'ls /etc'

for file in $(ls /etc)

```

### 使用

```shell
# 使用定义过的变量时，需在变量名前加$
echo ${your_name}
```


上面列出/etc目录下的文件完整版：

```shell
for file in 'ls /etc'; do
    echo ${file}
done
```

### 只读变量

readonly var_name

unset 删除变量

### 字符串

单引号：
+ 单引号里的任何字符都会原样输出，单引号字符串中的变量是无效的
+ 单引号字符串中不能出现单独的引号(使用转义字符后也不行)，但可成对出现，作为字符串拼接使用

双引号：
+ 可以有变量，可以有转义字符

```shell
your_name="banyue"

greeting_1="hello, "${your_name}"!"
greeting_2="hello, ${your_name} !"

greeting_3='hello,'${your_name}'!'
greeting_4='hello, ${your_name} !'

echo $greeting_1 $greeting_2
echo $greeting_3 $greeting_4
```

输出结果如下：
hello, banyue! hello, banyue !
hello,banyue! hello, ${your_name} !


获取字符串长度：


提取子字符串：


查找子字符串：

```shell                                                                             
str="banyue is a boy"

#输出字符串长度，空格包括在内
echo ${#str} 

#输出字符串从0到6的部分
echo ${str:0:6}

#输出字符y第一次出现的位置
echo `expr index "$str" y`

```
output:
15
banyue
4

### shell数组

bash仅支持一维数组

定义数组： array_name=(v0 v1 v2 v3 ... vn)
    或：
         arrya_name=(
             v0
             v1
             v2
             v3
             ...
             vn
         )

也可单独定义：
    array_name[0]=v0
    array_name[1]=v1
    array_name[n]=vn

```shell
name=${array_name[0]}

# 获取数组中的所有元素
echo ${array_name[@]}

# 获取数组长度
length=${#array_name[@]}
length=${#array_name[*]}

# 获取数组单个元素的长度
length_i=${#array_name[i]}
```