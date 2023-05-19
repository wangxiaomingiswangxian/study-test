#!/bin/bash
#Program

echo -e "You should inputs 2 integer numbers;Program will cross these two number"
read -p "first number: " firstnu
read -p "second number: " secnu
total=$((${firstnu}*${secnu}))
echo -e "\nThe result of ${firstnu} x ${secnu} is ==> ${total}"
exit 0
