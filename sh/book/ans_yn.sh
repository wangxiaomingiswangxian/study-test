#!/bin/bash

read -p "Please input (Y/N) :" yn
[ "${yn}" == "Y" -o "${yn}" == "y" ] && echo "OK, countinue" && exit 0
[ "${yn}" == "N" -o "${yn}" == "n" ] && echo "OK, interrupt" && exit 0
echo "I don't know what your choice is" && exit 0
