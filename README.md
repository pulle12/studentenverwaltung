# Fullstack Entwicklung mit Spring Boot 
Ein Projekt aus dem Kapitel "Fullstack Development mit Spring Boot" im SWPP-Unterricht 2026/2027 an der HAK Imst bei Herr Prof. Riml und Herr Prof. DI Dr. Netzer.
Es wird ein [Video Tutorial](https://www.youtube.com/playlist?list=PL62XI1PkyESHApWZKk3bK2RBHcpQ1Btsq) von Ex-HAK-Lehrer Herr Prof. Dr. Landerer nachprogrammiert.

stehengeblieben bei: Video B fertig

## Erklärungen und Konzepte:

### Video B - Domainlayer und Repository (inkl. allgemeine Konzepte auch aus Video A)

#### 1. Domänenklasse & Lombok
* **Domänenklasse (z. B. Student):** Die zentrale fachliche Klasse, die ein Objekt (wie einen Studenten) repräsentiert und als Entität in der Datenbank gespeichert wird.
* **Lombok Java:** Erspart redundanten Code (Boilerplate). Durch einfache Annotationen werden Getter, Setter, `toString()` und Konstruktoren automatisch generiert.

#### 2. Datenbank, H2 Console & Konfiguration
* **H2 Datenbank:** Eine performante, leichtgewichtige In-Memory-Datenbank, die perfekt für Entwicklung und Tests geeignet ist.
* **H2 Console Web (`http://localhost:8080/h2-console`):** Eine browserbasierte Benutzeroberfläche, um Daten einzusehen und SQL-Abfragen auszuführen.
* **Extra Konfiguration in den Properties:** Sagt Spring Boot, dass die Datenbank automatisch angelegt werden soll, falls sie beim Start noch nicht existiert. Weil ich mich sonst auf der Web-Konsole nicht einloggen konnte.

#### 3. JPA, Repository & Hibernate
* **JpaRepository:** Ein vorgefertigtes Interface von Spring Data. Durch das Extenden erhält man sofort mächtige Methoden für Datenbankabfragen (CRUD), ohne sie selbst schreiben zu müssen.
* **SimpleJpaRepository:** Die standardmäßige Implementierung dieses Interfaces, die Spring Boot im Hintergrund vollautomatisch auswählt.
* **Hibernate:** Das zugrundeliegende ORM-Framework (Object-Relational Mapping), das Java-Objekte in SQL-Tabellen übersetzt und dabei auch komplexe Strukturen wie `drop table if exists student cascade` steuert. "Cascade" bedeutet dabei, dass eine Aktion automatisch auf verknüpfte Elemente (über FK-Constraints) übergreift: Entweder werden beim Löschen einer Tabelle abhängige Verknüpfungen automatisch mit entfernt (damit es keine Fehler gibt) oder, im Java-Code, beim Löschen eines Eltern-Objekts (z. B. Student) automatisch auch alle zugehörigen Kind-Objekte mitgelöscht.

#### 4. Dependency Injection & Beans
* **Wegfall von `new`:** Es muss nicht mehr manuell mit dem `new`-Schlüsselwort eine Instanz erzeugt werden.
* **Autowired-Annotation & Beans:** Spring verwaltet Klassen, von denen es Instanzen bilden soll, als sogenannte *Beans*. Über den **Dependency Injection Mechanismus** (mit `@Autowired` oder direkt über den Konstruktor) injiziert Spring diese Instanzen automatisch dorthin, wo sie gebraucht werden (z. B. das `@Repository` in einen Service). Laut KI (Gemini) funktioniert bei modernen Spring-Boot-Versionen mit nur einem Konstruktor die Injection oft auch ohne explizites `@Autowired`.

#### 5. ApplicationRunner
* **ApplicationRunner implementieren:** Ein Interface, das es erlaubt, bestimmten Java-Code direkt nach dem erfolgreichen Start der Spring-Boot-Anwendung automatisch auszuführen (ideal, um z. B. Testdaten in die Datenbank zu schreiben).