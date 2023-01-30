#!/bin/bash

my_array=(A B "C" D)

echo ${my_array[2]}

#关联数组
declare -A site=(["google"]="www.google.com" ["runoob"]="www.runoob.com" ["taobao"]="www.taobao.com")

echo ${site[taobao]}

echo ${my_array[@]}
echo ${site[*]}

echo "数组的键为: ${!site[@]}"

echo "数组元素个数为: ${#my_array[@]}"
echo "数组元素个数为: ${#site[*]}"