# 字符串算法题总结

## 0. 常用到的类与方法

+ Scanner

  处理控制台输入，常见形式：

  ```java
  import java.util.Scanner;
  
  Scanner in = new Scanner(System.in);
  
  while(in.hasNext()){
      int a = in.nextInt();
      ...
  }
  
  in.close();
  ```

  + hasNext() 
  + hasNextLine()---------nextLine()
  + hasNextInt()----------nextInt()
  + hasNextFloat()--------nextFloat()

+ String

  ```java
  char[] data = {'a','b','c'};
  //用于需要将字符数组转换成字符串的场景，等价于String str = "abc";
  String str = new String(data);
  
  char[] ch = str.toCharArray();
  //s = "bc",编号从0开始，包含起始元素不包含终末元素
  String s = str.substring(1,3);
  //s = "c"
  String s = str.substring(2);
  //ch = 'a'
  char ch = str.charAt(0);
  //true
  str.endsWith("bc");
  //返回第一次访问到'c'的下标
  str.indexOf('c');
  
  str.indexOf("bc");
  str.lastIndexOf('c');
  str.lastIndexOf("bc");
  //是否与正则表达式匹配
  str.matchex(String regex);
  
  replace(char oldChar, char newChar);
  replaceAll(String regex,String replacement);
  replaceFirst(String regex,String replacement);
  //按正则表达式分割,返回字符串数组
  str.split(String regex);
  
  strip();
  stripLeading();
  stripTrailing();
  
  toLowerCase();
  
  toUpperCase();
  
      
  ```

+ StringBuilder

  append

+ Integer

  + Integer.parseInt():返回对应的int值
  + Integer.toBinaryString():数字转成二进制字符串
  + Integer.toHexString():转成八进制
  + Integer.toOctalString():转成十六进制

+ Character

+ Pattern、Matcher

  ```java
  Pattern pattern = Pattern.compile(regex);
  Matcher matcher = pattern.matcher(String str);
  //返回true或false
  matcher.find()
  ```

  

## 1. 格式化字符串

1. [HJ4 字符串分隔](https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21225&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking)

   字符串长度大于8时，每8个字符取子串；小于8时，用0拼接

   ```java
   Scanner in = new Scanner(System.in);
           
           while(in.hasNextLine()){
               String str = in.nextLine();
   
               while(str.length() >= 8){
                   System.out.println(str.substring(0, 8));
                   str = str.substring(8);
               }
   
               if(str.length() < 8 && str.length() > 0){
                   String s = "00000000";
                   System.out.println(str.substring(0)+s.substring(0,8-str.length()));
               }
   ```

   

2. [坐标移动](https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1)

   关键在于用正则表达式判断输入是否符合条件：

   ```java
   //A S W D代表方向，后面跟数字，不超过两位
   String pattern = "[ASWD]\\d{1}\\d?";
   ```

3. [单词倒排](https://www.nowcoder.com/practice/81544a4989df4109b33c2d65037c5836?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1)

   难点在于，除了空格外还包括其它非字母字符，可以使用正则表达式全部转为空格，再按空格分割

   ```java
   s = s.replaceAll("[^a-zA-Z]"," ");
   //删除首尾空格
   s.trim();
   
   String[] res = s.split(" ");
   ```

   

4. [参数解析](https://www.nowcoder.com/practice/668603dc307e4ef4bb07bcd0615ea677?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1)

   难点：引号内的空格需要特殊处理

   设计一个标志变量flag = false，访问到引号时更改为true,遇到第二个引号，重新改为false,只在flag == false的空格处分割

   

## 2. 回文子串

1. [最长回文子串](https://www.nowcoder.com/practice/12e081cd10ee4794a2bd70c7d68f5507?tpId=37&&tqId=21308&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking)
2. []





## 3. 公共子串

1. [最长公共子串](https://www.nowcoder.com/practice/98dc82c094e043ccb7e0570e5342dd1b?tpId=37&tags=&title=&difficulty=0&judgeStatus=0&rp=1)

## 4. 字符串匹配



## 5. 位运算



# 

