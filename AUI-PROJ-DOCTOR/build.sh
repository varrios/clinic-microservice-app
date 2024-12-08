#!/usr/bin/env bash
# Builds application and docker image using Dockerfile and tags it based on org.opencontainers.image.version label in
# Dockerfile.
# ######################################
# Script main function. Builds applicaiton and docker image using Dockerfile and tags it based on # org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
# ######################################



JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/bin/java mvn clean verify
title="$(grep -n "org.opencontainers.image.title" Dockerfile | cut -f2 -d "=" | xargs)"
version="$(grep -n "org.opencontainers.image.version" Dockerfile | cut -f2 -d "=" | xargs)"
docker build \
  --label "org.opencontainers.image.created=$(date +%Y-%m-%dT%H:%M:%S%:z)" \
  --label "org.opencontainers.image.ref.name=$(git rev-parse HEAD)" \
  --label "org.opencontainers.image.revision=$(git rev-parse HEAD)" \
  -t "${title}":"${version}" .


