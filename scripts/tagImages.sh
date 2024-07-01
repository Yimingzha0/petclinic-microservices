#!/bin/bash
docker tag ${NAMESPACE}/spring-petclinic-config-server ${NAMESPACE}/spring-petclinic-config-server:${TAG}
docker tag ${NAMESPACE}/spring-petclinic-discovery-server ${NAMESPACE}/spring-petclinic-discovery-server:${TAG}
docker tag ${NAMESPACE}/spring-petclinic-api-gateway ${NAMESPACE}/spring-petclinic-api-gateway:${TAG}
docker tag ${NAMESPACE}/spring-petclinic-customers-service ${NAMESPACE}/spring-petclinic-customers-service:${TAG}
docker tag ${NAMESPACE}/spring-petclinic-admin-server ${NAMESPACE}/spring-petclinic-admin-server:${TAG}
