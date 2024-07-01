#!/bin/bash
docker push ${NAMESPACE}/spring-petclinic-config-server:${TAG}
docker push ${NAMESPACE}/spring-petclinic-discovery-server:${TAG}
docker push ${NAMESPACE}/spring-petclinic-api-gateway:${TAG}
docker push ${NAMESPACE}/spring-petclinic-customers-service:${TAG}

