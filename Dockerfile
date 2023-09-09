FROM bellsoft/liberica-openjdk-alpine:17
COPY target/beautifulcode_sber-*.jar beautifulcode_sber.jar
ENTRYPOINT ["sh", "-c", "java -Dspring.profiles.active=dev -jar beautifulcode_sber.jar"]