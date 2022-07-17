## 简介

> 需要明白，在大型项目中使用gcc挨个去编译明显是一件效率很低的事情，因此出现了像make和CMake这样的管理大型项目构建的工具。

主要参考自：https://cmake.org/cmake/help/latest/guide/tutorial/index.html

https://sfumecjf.github.io/cmake-examples-Chinese/

CMake, Cross platform Make, 简单点来说CMake是一款跨平台的构建项目的工具(用于编译)，CMake语法比makefile简单，比makefile在大型项目中更有优势。



## 基本cmake工程框架

下面的是平常使用的cmake工程框架，不涉及动态库，静态库，第三方库等

```shell
.
├── build
├── CMakeLists.txt
├── include
├── output
└── src

# build - 使用cmake时需要创建的一个目录，在一次编译之后可以进行删除，下次编译时可再创建
# CMakeLists.txt 文件名不可更改，大小写也要一致，可以理解为一种脚本
# include 存放头文件的目录
# output 存放可执行文件的目录(也可是bin等名称，自定义)
# src 存放源码的目录
```

CMakeLists.txt

```cmake
cmake_minimum_required(VERSION 2.0)
project(hello_cmake)

set(SOURCES
	src/hello.cpp
	src/main.cpp
)

set(EXECUTABLE_OUTPUT_PATH ${CMAKE_SOURCE_DIR}/output/)
add_executable(${PROJECT_NAME} ${SOURCES})

target_include_directories(${PROJECT_NAME}
	PRIVATE
		${PROJECT_SOURCE_DIR}/include
)
```



## 使用方式

```shell
mkdir build
cd build
cmake ..
make VERBOSE=1
```



## CMake常见变量

| Variable                 | Info                                                       |
| :----------------------- | :--------------------------------------------------------- |
| CMAKE_SOURCE_DIR         | 根源代码目录，工程顶层目录。暂认为就是PROJECT_SOURCE_DIR   |
| CMAKE_CURRENT_SOURCE_DIR | 当前处理的 CMakeLists.txt 所在的路径                       |
| PROJECT_SOURCE_DIR       | 工程顶层目录                                               |
| CMAKE_BINARY_DIR         | 运行cmake的目录。外部构建时就是build目录                   |
| CMAKE_CURRENT_BINARY_DIR | The build directory you are currently in.当前所在build目录 |
| PROJECT_BINARY_DIR       | 暂认为就是CMAKE_BINARY_DIR                                 |

