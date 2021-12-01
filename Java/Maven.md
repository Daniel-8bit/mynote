## 简介

Apache Maven 是一套软件工程管理和整合工具。基于项目对象模型（POM，Project/Object/Model）的概念，通过一个中央信息管理模块，Maven能够管理项目的构建、报告和文档

**环境变量配置：**（前提是已经配置好了java的环境变量）MAVEN_HOME:maven安装路径、PATH：%MAVEN_HOME%/bin

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>idea-demo</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>idea-demo</name>
    <!--<packaging>war</packaging>-->

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.source>1.8</maven.compiler.source>
        <junit.version>5.7.1</junit.version>
    </properties>

    <dependencies>
    </dependencies>
</project>
```

pom.xml三个必须的配置：groupid,artifactid,version

| 节点       | 描述                                                         |
| ---------- | ------------------------------------------------------------ |
| groupId    | 这是工程组的标识。它在一个组织或者项目中通常是唯一的。例如，一个银行组织 com.company.bank 拥有所有的和银行相关的项目。 |
| artifactId | 这是工程的标识。它通常是工程的名称。例如，消费者银行。groupId 和 artifactId 一起定义了 artifact 在仓库中的位置。 |
| version    | 这是工程的版本号。在 artifact 的仓库中，它用来区分不同的版本。例如： com.company.bank:consumer-banking:1.0 com.company.bank:consumer-banking:1.1. |

所有的pom都继承自一个父pom（super pom），查看super pom默认配置的命令：mvn help:effecitve-pom( > [file_name].xml)

## Maven 生命周期

+ 构建生命周期

| 阶段              | 处理     | 描述                                                 |
| ----------------- | -------- | ---------------------------------------------------- |
| prepare-resources | 资源拷贝 | 本阶段可以自定义需要拷贝的资源                       |
| compile           | 编译     | 本阶段完成源代码编译                                 |
| package           | 打包     | 本阶段根据 pom.xml 中描述的打包配置创建 JAR / WAR 包 |
| install           | 安装     | 本阶段在本地 / 远程仓库中安装工程包                  |

+ 标准生命周期：clean,build(or default),site

+ 执行 mvn post-clean时，调用clean生命周期：pre-clean,clean,post-clean

  执行 mvn clean时，只会执行到clean阶段

```shell
PS C:\Users\banyue\Desktop\project> mvn post-clean
Active code page: 65001
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------< com.companyname.project-group:project >----------------
[INFO] Building project 1.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-antrun-plugin:1.1:run (id.pre-clean) @ project ---
[INFO] Executing tasks
     [echo] pre-clean phase
[INFO] Executed tasks
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ project ---
[INFO]
[INFO] --- maven-antrun-plugin:1.1:run (id.clean) @ project ---
[INFO] Executing tasks
     [echo] clean phase
[INFO] Executed tasks
[INFO]
[INFO] --- maven-antrun-plugin:1.1:run (id.post-clean) @ project ---
[INFO] Executing tasks
     [echo] post-clean phase
[INFO] Executed tasks
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.307 s
[INFO] Finished at: 2021-11-14T07:57:47+08:00
[INFO] ------------------------------------------------------------------------

PS C:\Users\banyue\Desktop\project> mvn clean
Active code page: 65001
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------< com.companyname.project-group:project >----------------
[INFO] Building project 1.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-antrun-plugin:1.1:run (id.pre-clean) @ project ---
[INFO] Executing tasks
     [echo] pre-clean phase
[INFO] Executed tasks
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ project ---
[INFO]
[INFO] --- maven-antrun-plugin:1.1:run (id.clean) @ project ---
[INFO] Executing tasks
     [echo] clean phase
[INFO] Executed tasks
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.312 s
[INFO] Finished at: 2021-11-14T07:58:17+08:00
[INFO] ------------------------------------------------------------------------

```

+ Build生命周期

  | 生命周期阶段          | 描述                                                         |
  | --------------------- | ------------------------------------------------------------ |
  | validate              | 检查工程配置是否正确，完成构建过程的所有必要信息是否能够获取到。 |
  | initialize            | 初始化构建状态，例如设置属性。                               |
  | generate-sources      | 生成编译阶段需要包含的任何源码文件。                         |
  | process-sources       | 处理源代码，例如，过滤任何值（filter any value）。           |
  | generate-resources    | 生成工程包中需要包含的资源文件。                             |
  | process-resources     | 拷贝和处理资源文件到目的目录中，为打包阶段做准备。           |
  | compile               | 编译工程源码。                                               |
  | process-classes       | 处理编译生成的文件，例如 Java Class 字节码的加强和优化。     |
  | generate-test-sources | 生成编译阶段需要包含的任何测试源代码。                       |
  | process-test-sources  | 处理测试源代码，例如，过滤任何值（filter any values)。       |
  | test-compile          | 编译测试源代码到测试目的目录。                               |
  | process-test-classes  | 处理测试代码文件编译后生成的文件。                           |
  | test                  | 使用适当的单元测试框架（例如JUnit）运行测试。                |
  | prepare-package       | 在真正打包之前，为准备打包执行任何必要的操作。               |
  | package               | 获取编译后的代码，并按照可发布的格式进行打包，例如 JAR、WAR 或者 EAR 文件。 |
  | pre-integration-test  | 在集成测试执行之前，执行所需的操作。例如，设置所需的环境变量。 |
  | integration-test      | 处理和部署必须的工程包到集成测试能够运行的环境中。           |
  | post-integration-test | 在集成测试被执行后执行必要的操作。例如，清理环境。           |
  | verify                | 运行检查操作来验证工程包是有效的，并满足质量要求。           |
  | install               | 安装工程包到本地仓库中，该仓库可以作为本地其他工程的依赖。   |
  | deploy                | 拷贝最终的工程包到远程仓库中，以共享给其他开发人员和工程。   |

+ Site生命周期：pre-site,site,post-site,site-deploy

  一般用来创建新的报告文档、部署站点等



## 重要命令

mvn archetype:generate 创建工程模板

mvn site 创建工程文档





https://www.w3cschool.cn/maven/u7oe1ht0.html

 

