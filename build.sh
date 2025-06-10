#!/usr/bin/env bash
# Builds all applications and all docker images using Dockerfile and tags it based on org.opencontainers.image.version
# label in Dockerfile.
# ######################################
# Script main function. Builds all applications and all docker images using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments: 
#   None. #######################################



# shellcheck disable=SC2164
cd ./AUI-PROJ-APPOINTMENT/; bash ./build.sh; cd ..
# shellcheck disable=SC2164
cd ./AUI-PROJ-DOCTOR/; bash ./build.sh; cd ..
# shellcheck disable=SC2164
cd ./AUI-PROJ-GATEWAY/; bash ./build.sh; cd ..
# shellcheck disable=SC2164
cd ./AUI-PROJ-ANGULAR/; bash ./build.sh; cd ..


