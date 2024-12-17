## ⚙️ 기술 스택
**Environment**

<img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellij idea&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

**Language**

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">

**Development**

<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">

**Deploy**

<img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white"> <img src="https://img.shields.io/badge/amazonrds-527FFF?style=for-the-badge&logo=amazonrds&logoColor=white"> 

**CI/CD**

<img src="https://img.shields.io/badge/github actions-2088FF?style=for-the-badge&logo=github actions&logoColor=white"> <img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">

## 🚀 How to start
#### 💻 로컬 환경에서  API 서버 실행 방법
1. Git clone 을 통한 스프링 부트 프로젝트 생성<br><br>
   ```
   
   ```
2. application.yml 설정<br><br>
   ```
   spring:
    datasource:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/foodiebuddy?createDatabaseIfNotExist=true&characterEncoding=UTF-8&characterSetResults=UTF-8
      username: // 로컬 DB의 username 입력
      password: // 로컬 DB의 password 입력
    jpa:
      hibernate:
        ddl-auto: update
      generate-ddl: true
      show-sql: true
      open-in-view: false

   ```
3. 어플리케이션 RUN
