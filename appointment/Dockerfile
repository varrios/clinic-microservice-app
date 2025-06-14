FROM eclipse-temurin:22.0.2_9-jdk

LABEL org.opencontainers.image.title="clinic-appointment"
LABEL org.opencontainers.image.description="Clinic Appointment Service"
LABEL org.opencontainers.image.authors="Lucjan Gackowski"
LABEL org.opencontainers.image.version="0.0.1-SNAPSHOT"


ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8081

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:aui-proj-appointment
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

EXPOSE 8082
EXPOSE 8081

COPY target/appointment-0.0.1-SNAPSHOT.jar /opt/clinic-appointment/clinic-appointment.jar

CMD ["java", "-jar", "/opt/clinic-appointment/clinic-appointment.jar"]