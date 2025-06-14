FROM eclipse-temurin:22.0.2_9-jdk

LABEL org.opencontainers.image.title="clinic-doctor"
LABEL org.opencontainers.image.description="Clinic Doctor Service"
LABEL org.opencontainers.image.authors="Lucjan Gackowski"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"


ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_ENABLED=true

ENV AUI_PROJ_DOCTOR=http://localhost:8081

EXPOSE 8080

COPY target/doctor-0.0.1-SNAPSHOT.jar /opt/clinic-doctor/clinic-doctor.jar

CMD ["java", "-jar", "/opt/clinic-doctor/clinic-doctor.jar"]