## Lambda表达式的语法
- 基本语法:

(方法参数) -> 返回值
或
(方法参数) ->{ 方法内的语句; }

- Lambda 简单与漂亮的案例

```
 //没用使用lambda 的代码
ArrayList<String> strs = new ArrayList<>();
Collections.sort(strs, new Comparator<String>() {
     @Override
     public int compare(String s1, String s2) {
         return s1.compareTo(s2);
    }
});
```

下面是使用了lambda后的效果


```
//4行代码只需要1句代码就搞定 
Collections.sort(strs, String::compareTo);
```


## Lambda 开始学习

使用说明见bolg :[Lambda的使用与实战](http://http://blog.csdn.net/relicemxd/article/details/51201255)