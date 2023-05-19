#!/bin/bash

# shellcheck disable=SC2126
# shellcheck disable=SC2006
count=`netstat -apn | grep 9443 | wc -1`

if [ "$count" -gt 0 ]; then
  exit 0
else
  exit 1
fi