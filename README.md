# ConcertLog

Opis Projekta
----------------------------
ConcertLog je web aplikacija pomoću koje se vodi evidencija koncerata i glazbenih događaja.  
Korisnicima omogućuje dodavanje, pregled pojedinačnih događaja, uređivanje i brisanje događaja.  

Također omogućuje dodavanje ocjena i recenzija za pojedini koncert te njihovo brisanje.  
Za bržu pretragu omogućena je pretraga prema žanru, izvođaču i gradu, kao i filtriranje prema statusu.

**Funkcionalnosti**
----------------------------
* Pregled svih koncerata
* Dodavanje koncerta
* Uređivanje koncerta
* Brisanje koncerta
* Detalji koncerta
* Dodavanje recenzije
* Brisanje recenzije
* Pretraga po izvođaču/gradu/žanru
* Filter po statusu

**Tehnologije**
-----------------------
**Backend**
* Java
* Spring Boot
* Spring Data JPA

**Frontend**
* Thymeleaf
* HTML
* CSS

**Baza podataka**
* MySQL

**Razvojno okruženje**
-------------------------
* IntelliJ IDEA

**Pokretanje aplikacije**
--------------------
1. Kreiranje baze podataka  
U MySQL-u kreirati bazu:
```sql
CREATE DATABASE concertlog;
```

3. Konfiguracija baze  
U datoteci application.properties postaviti:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/concertlog
spring.datasource.username=username
spring.datasource.password=lozinka
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Pokretanje projekta  
Otvoriti projekt u IntelliJ IDEA i pokrenuti glavnu klasu  ```ConcertLogApplication```

6. Pokretanje aplikacije u pregledniku  
Otvoriti:

```
http://localhost:8080
```
