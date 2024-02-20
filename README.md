This is a Spring Boot application

- Uses H2 for DB
- H2 credentials in `resources/application.yml`
- H2 available at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- Swagger available at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Database initialized with data from `resources/data.sql`
- Pre-built app can be run with `java -jar bredex-task-0.0.1-SNAPSHOT.jar` or build from source

Továbbfejlesztési lehetőségek:
- Client és Position entitások összekapcsolása foreign key használatával, így a kliensek alapján is lehetne szűrni a meghirdetett pozíciókat. Ez külön nem volt említve a feladatok között így egyelőre nem kapcsoltam őket össze.
- Az autentikációt mindenképpen refaktorálni kellene, ha production ready appot akarunk. A jelenlegi autorizációhoz csak annyi szükséges, hogy api_key paraméterként egy az adatbázisban már létező UUID-t adjon meg a felhsználó. Mivel a feladat leírásában nem részletezték, hogy milyen módon autentikáljunk az api kulccsal, ezért a lehető legegyszerűbb megoldást választottam.
- Tesztek írása
- UI készítés
- Standalone adatbázis használata


