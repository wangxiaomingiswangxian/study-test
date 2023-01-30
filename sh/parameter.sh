#!/bin/bash
echo "hello world !"
your_name="wangxian"
echo $your_name
readonly your_name="xiaoming"
echo ${your_name}

string="runoob is a great site"
echo `expr index "$string" io`

:<<EOF
这里是一些多行注释
EOF