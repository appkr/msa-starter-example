# example

## 개발 환경
- [amazonaws corretto jdk11](https://docs.aws.amazon.com/ko_kr/corretto/latest/corretto-11-ug/what-is-corretto-11.html) 을 사용합니다
```bash
$ brew cask install corretto11 --appdir="/Applications"
$ jenv add /Library/Java/JavaVirtualMachines/amazon-corretto-11.jdk/Contents/Home
$ jenv versions
$ jenv local corretto64-11.0.9
```
- 아래 명령으로 MySQL(3306), Kafka(9092) 등을 구동합니다
```bash
$ ./gradlew up
# Ctrl + c to quit
```
- UAA(9999)는 실행중이라 가정합니다
- 애플리케이션을 구동합니다
```bash
$ export SPRING_PROFILES_ACTIVE=local; export USER_TIMEZONE="Asia/Seoul"; ./gradlew clean bootRun
$ curl -s http://localhost:8080/management/health
```
- [Postman Collection & Environment](./postman)를 import하여 Example 및 UAA API를 작동해볼 수 있습니다

