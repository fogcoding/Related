Related
MarkDown语法
=================================
中标题
————————————————————————————————————
# 一级标题格式： #+空格+标题名
## 二级标题： ##+空格+标题名
### 三级标题： ###+空格+标题名
#### 四级标题： ####+空格+标题名
### ** 注：标题的级别会影响文字的大小**

*斜体内容：两个 * 包围内容*
### **加粗内容： 两个 ** 包围内容**
### ** 注：如果 * 和 ** 左右没有内容，那么它们只会被当作普通符号**
### ** 单行文本框： 一行编辑的内容用两个tabs包围 **
### ** 单行文本框： 每行编辑的内容用两个tabs包围 **

####引用：
>;这里是引用区域

>;引用的语法： &gt； +引用内容

>;  &gt；为第一层引用 ， &gt；&gt；为第二层引用，依此类推

>; 引用区域每一行用 > 开头即可划定区域

>; 两层引用实例：

>&gt; 这是第一层引用。

>&gt;

>&gt; &gt; 这是嵌套的引用块。

>&gt;

>&gt; 回到第一层


#### 列表
#####无序列表
> 在文字的前方加上* 或 -就能变为无序列表
> ###### 示例：
> * 这里是列表内容1
> * 这里是列表内容2
> * 这里是列表内容3
#####有序列表
> 在文字的前方加上1. , 2. 3. ···就能变为无序列表
> ######示例：
> 1.这里是列表内容1
> 2.这里是列表内容2
> 3.这里是列表内容3

####图片和链接
> 图片和链接插入规则很相似
> 区别只在一个!
> # 图片格式：！ [ 图片名字 ] ( 图片URL )
> # 链接格式： [ 链接名称 ] ( 链接url )
> ######示例： 
> ![Android小图标](http://f.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=4fe590dbc895d143ce7bec711299e967/2934349b033b5bb5c4a85c2636d3d539b700bcee.jpg)
> # [Github](www.github.com)

####表格
> ###### 编码方式：
> *`| Tables        | Are           | Cool  |`
> *`| ------------- |:-------------:| -----:|`
> *`| col 3 is      | right-aligned | $1600 |`
> *`| col 2 is      | centered      |   $12 |`
> *`| zebra stripes | are neat      |    $1 |`
> ###### 实际效果：
> | Tables        | Are           | Cool  |
> | ------------- |:-------------:| -----:|
> | col 3 is      | right-aligned | $1600 |
> | col 2 is      | centered      |   $12 |
> | zebra stripes | are neat      |    $1 |


####代码框
> 使用、把代码框起来即可，tab还可以缩进
> ######例如：
> `System.out.printlin("Hello world!")`
>

####分割线
***
> 只要使用***即可出现分割线

####下划线

---

> 只要使用---即可出现下划线

