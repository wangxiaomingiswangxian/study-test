#!/usr/bin/env bash
echo \"It is a test\";

#显示变量
read name;
echo "$name It is a test";


#显示换行
echo -e "OK! \n" # -e 开启转义
echo "It is a test"

#显示不换行
echo -e "OK! \c" # -e 开启转义
echo "It is a test"

#显示结果定向至文件
echo "It is a test" > myfile.sh

#显示命令执行结果
echo `date`