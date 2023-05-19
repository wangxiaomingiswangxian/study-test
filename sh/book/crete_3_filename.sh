#!/bin/bash
#Program:
#	create three files ,which named by user's input and date comand
echo -e "I will use 'touch' create 3 files."
read -p "Please input your filename: " fileuser
filename=${fileuser:-"filename"}

date1=$(date --date='2 day ago' +%Y%m%d)
date2=$(date --date='1 day ago' +%Y%m%d)
date3=$(date +%Y%m%d)
file1=${filename}${date1}
file2=${filename}${date2}
file3=${filename}${date3}
touch "${file1}"
touch "${file2}"
touch "${file3}"
exit 0


