# ==============================
# 1️⃣ Build stage: compile project với Maven + JDK 17
# ==============================
FROM maven:3.9.1-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom và download dependencies trước (cache hiệu quả)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy toàn bộ source code
COPY src ./src

# Build project (tạo jar)
RUN mvn clean package -DskipTests

# ==============================
# 2️⃣ Run stage: chạy ứng dụng với JDK nhẹ
# ==============================
FROM eclipse-temurin:17-jdk-alpine

# Thư mục ứng dụng
WORKDIR /app

# Copy jar từ stage build
COPY --from=build /app/target/*.jar app.jar

# Expose port ứng dụng (mặc định Spring Boot 8080)
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java","-jar","app.jar"]
