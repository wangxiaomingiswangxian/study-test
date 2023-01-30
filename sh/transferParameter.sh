#!/bin/bash
# author:王贤

echo "Shell 传递参数实例！";
echo "执行的文件名：$0";
echo "第一个参数为：$1";
echo "第二个参数为：$2";
echo "第三个参数为：$3";

echo "参数的个数为: $#";


echo "传递的参数作为一个字符串显示：$*";
echo "传递的参数作为一个字符串显示：$@";

echo "--\$* 演示--";
for i in "$*";do
  echo $i
done

echo "--\$@ 演示--";
for i in "$@";do
  echo $i
done

:<<EOF
 $* 和$@ 区别
不同点：只有在双引号中体现出来。假设在脚本运行时写了三个参数 1、2、3，，则 " * " 等价于 "1 2 3"（传递了一个参数），而 "@" 等价于 "1" "2" "3"（传递了三个参数）。
EOF