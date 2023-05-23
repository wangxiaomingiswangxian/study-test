#!/bin/bash

echo "Now,I will detect your linux server's servies"
echo -e "The www, ftp, ssh, and mail (stmp) will be detect! \n"
testfile=/dev/shm/netstat_checking.txt
netstat -tuln > ${testfile}
testing=$(grep ":80" ${testfile})
if [ "${testing}" != "" ]; then
	echo "WWW is running in your system"
fi
testing=$(grep ":22" ${testfile})
if [ "${testing}" != "" ]; then
	echo "SSH is running in your system"
fi
testing=$(grep ":21" ${testfile})
if [ "${testing}" != "" ]; then
	echo "FTP is running in your system"
fi
testing=$(grep ":25" ${testfile})
if [ "${testing}" != "" ]; then
	echo "Mail is running in your system"
fi
