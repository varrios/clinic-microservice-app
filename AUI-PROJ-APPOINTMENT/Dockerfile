FROM eclipse-temurin:22.0.2_9-jdk

LABEL org.opencontainers.image.title="aui-proj-appointment"
LABEL org.opencontainers.image.description="Appointment Service"
LABEL org.opencontainers.image.authors="Lucjan Gackowski"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT 8080

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_ENABLED=true

EXPOSE 8080

COPY target/AUI-PROJECT-APPOINTMENT-0.0.1-SNAPSHOT.jar /opt/aui-proj-appointment/aui-proj-appointment.jar

CMD ["java", "-jar", "/opt/aui-proj-appointment/aui-proj-appointment.jar"]