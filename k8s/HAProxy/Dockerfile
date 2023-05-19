docker run -d --name k8s-haproxy \
  --net=host \
  --restart=always \
  -v ${PWD}/haproxy.cfg:/usr/local/etc/haproxy/haproxy.cfg:ro \
  haproxytech/haproxy-debian:2.3