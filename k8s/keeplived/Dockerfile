docker run -d --name k8s-keepalived \
  --net=host \
  --restart=always \
  --cap-add=NET_ADMIN --cap-add=NET_BROADCAST --cap-add=NET_RAW \
  -v ${PWD}/keepalived.conf:/container/service/keepalived/assets/keepalived.conf \
  -v ${PWD}/check-haproxy.sh:/usr/bin/check-haproxy.sh \
  osixia/keepalived:2.0.20 --copy-service