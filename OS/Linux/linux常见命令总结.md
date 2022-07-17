---
title:linux常用命令总结
tags:Linux基础
---

总结了一些在命令行状态下常用的操作，日后常更新。

<!--more-->

<!--more-->

## ls

```shell
# 仅列出当前目录可见文件
ls
# 可见文件详细信息
ls -l
# 详细信息并显示可读的文件大小
ls -hl
# 列出所有文件的详细信息，包括隐藏文件
ls -al
# 按修改时间查看
ls -lt
# 按访问时间查看
ls -lut
```

## tree

默认以树状图的形式列出当前目录下的所有目录以及文件，

```shell
# 显示dir目录下的所有目录及文件
tree dir
# 显示目录名称而非内容
tree -d dir
# 显示目录和文件的修改时间
tree -D dir
# 控制显示的层级
tree -L num dir
```

## cd/pwd

```
# 切换到指定路径（. 表示当前路径， .. 表示上一级）
cd path_name
# 显示当前工作路径，为绝对路径名
pwd
```

## mkdir/rm/cp/mv

mkdir 可用于创建文件夹，创建文件使用touch命令；

linux 的 rm 过于强大，需谨慎使用，尤其是在拥有root权限的情况下；

mv 除了移动文件外，重命名文件也是通过该命令实现

```shell
# 创建名为dir_name的文件夹
mkdir dir_name
# 递归创建文件夹，如果dir1， dir2存在就保持不变
mkdir -p dir1/dir2/dir_name

rm file_name
rm -i file_name
rm -rf dir1/dir2/
rm -d dir

cp source dest
cp source/* dest
cp -r source dest

mv source folder
mv source dest
mv -i source folder
```



## cat/more/less

cat / more / less 都可用于显示文件内容，cat 会将文件内容全部输出，无法进行翻页，适用于文件内容较少的情况；more 和 less 功能类似，可以用于文件内容较多的情况，可以进行翻页，less的功能更为强大。

```shell
cat /etc/locale.gen
cat -n /etc/loecale.gen

more /etc/locale.gen
more +100 /etc/locale.gen

less /etc/locale.gen
less +100 /etc/local.gen
```

## tar/unzip

```shell
tar -cvf filename.tar .
tar -xvf filename.tar
tar -cvzf filename.tar.gz
tar -xvzf filename.tar.gz
tar -tf filename
```

## ln

```shell
ln source dest
ln -s source dest
```



## chmod

```shell
chmod +x file_name
chmod -x file_name
chmod +w file_name
chmod ugo=rwx file_name
chmod ug=rw file_name
chmod ugo=--- file_name
```



## find

```shell
find . -name ".c"

find . -ctime -20

```



  

## 参考

1. https://linux.cn/article-6160-1.html
2. https://www.runoob.com/linux/linux-comm-find.html