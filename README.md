# JUnit_study_2
SpringBoot × JUnitの調査。

## 使用技術
- SpringBoot
- JUnit
- Spring Data JPA
- H2DB
- Lombok

## 目標
以下のごちゃごちゃ状態でもJUnitでテストできるようになる。

- あらゆるクラスは@Autowiredされる
- 本番にはPostgreSQLを使用する。ただしテストにはH2のインメモリDBを使用する
- テスト用初期データはxmlから投入する
- テストごとにDBのデータは初期化する
- Spring Data JPAを用いてDBアクセスする


