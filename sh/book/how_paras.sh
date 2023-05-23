#!/bin/bash
echo "This script name is ==> ${0}"
echo "Total parameter number is ==> $#"
[ "$#" -lt 2 ] && echo "The number of parameter is less than 2. stop here." && exit 0
echo "Your whole paramter is ==> '$@'"
echo "The 1st paramter		==> ${1}"
echo "The 2st paramter		==> ${2}"
