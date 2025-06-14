FROM eclipse-temurin:22.0.2_9-jdk

LABEL org.opencontainers.image.title="clinic-gateway"
LABEL org.opencontainers.image.description="Clinic Gateway Service"
LABEL org.opencontainers.image.authors="Lucjan Gackowski"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"


ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080


ENV AUI_PROJ_GATEWAY_HOST=localhost:8080
ENV AUI_PROJ_APPOINTMENT_URL=http://localhost:8081
ENV AUI_PROJ_DOCTOR_URL=http://localhost:8082

EXPOSE 8080

COPY target/gateway-0.0.1-SNAPSHOT.jar /opt/clinic-gateway/clinic-gateway.jar

CMD ["java", "-jar", "/opt/clinic-gateway/clinic-gateway.jar"]