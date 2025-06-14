FROM nginx:1.23.3

LABEL org.opencontainers.image.title="clinic-frontend"
LABEL org.opencontainers.image.description="Clinic Frontend Service"
LABEL org.opencontainers.image.authors="Lucjan Gackowski"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/aui-proj-angular/browser /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
ADD docker/etc/nginx/nginx.conf /etc/nginx/templates/

