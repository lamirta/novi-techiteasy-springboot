# Opdrachtbeschrijving

## Inleiding

Je bent net begonnen als developer bij een bedrijf genaamd Tech It Easy, dat TV's verkoopt. Tijdens de cursus Spring Boot ga jij een backend applicatie voor hen programmeren. De winkel heeft een inventaris van televisies die moet worden bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen in de vorm van huiswerk. Zo krijgen we stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde van de cursus zullen we een werkende Tech It Easy backend hebben!

## Recap van vorige opdracht

De vorige opdracht was een best pittige opgave, maar als alles gelukt is heb je nu een applicatie met meerdere modellen en relaties gevormd. Super gaaf, hier wordt de werkgever dolblij van. Enkel vind de opdrachtgever wel dat er veilig gebruik van de app moet worden gemaakt, het zou niet tof zijn als de inventaris door klanten aangepast kan worden. Hiervoor moet je gaan nadenken over een inlogsysteem, daar komt heel veel bij kijken. Stel dat je een inlogsysteem hebt, wil je niet dat een `Hacker` deze met gemak omzeilt. Dus je moet ook het inloggen beveiligen. Daar ga je met deze opdracht mee aan de slag.

## De opdracht
- Maak de beveiliging voor de applicatie (met JWT-Token)
- Zorg dat een user(employee) aangemaakt kan worden door de admin
- Zorg dat de user en admin verschillende dingen mogen / kunnen (enkel de admin mag authorities aanmaken/ verwijderen en alle users opvragen)

## Randvoorwaarden

- De `POM` bevat de _spring-boot-starter-security_ dependency
- De app bevat:
  - `GlobalCorsConfiguration`
  - `SpringSecurityConfig`
  - `AuthenticationController`
  - `UserController`
  - `UserDto` (of `UserDto en UserInputDto`)
  - `UsernameNotFoundException`
  - `JWTFilter`
  - `Authority`
  - `AuthorityKey`
  - `User`
  - `AuthenticationRequest`(vorm van inputDto)
  - `AuthenticationResponse` (vorm van dto)
  - `UserRepository`
  - `CustomUserDetailService`
  - `UserService`
  - `JwtUtil`
  - `RandomStringGenerator`
- Binnen de app wordt rekening gehouden met CORS
- De applicatie moet draaien met toegang tot de endpoints voor de juiste gebruikers geven

### Belangrijk
- De app moet geen toegang geven zonder authenticatie en identificatie
- De app heeft een user(employee) en admin rol
- De applicatie moet draaien met toegang tot de endpoints voor de juiste gebruikers

## Stappenplan
Omdat we nu al een tijdje met de opdracht bezig zijn en we 2 lessen krijgen over `Security` wil ik jullie uitdagen om zelf een stappenplan te maken en te zien hoe ver jullie komen. Daarom voeg ik nu geen stappenplan toe. Kijk ook of je het voor elkaar krijgt om de beveiliging te implementeren.






Ok vooruit hierbij toch een stappenplan voor de mensen die het graag willen. Let wel op dat het veel al copie paste is.
1. Voeg de volgende dependencies toe aan je POM.XML
- `<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
  </dependency>`
- `<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt</artifactId>
  <version>0.9.1</version>
  </dependency>`

2. Voeg de `User`, `Authority` en de `AuthorityKey` toe als modellen

3. Voeg een `UserRepository` toe aan het project

4. Voeg de `UserService` en de `CustomUserDetailService` toe aan het project

5. Voeg de `BadRequestException` en de `UsernameNotFoundException` toe aan je project en zorg dat de exception handler is toegevoeg in je `ExceptionController`

6. Voeg de `AuthenticationController` en de `UserController` toe aan je project

7. Voeg de `UserDto` toe aan de app

8. Voeg `AuthenticationRequest` en de `AuthenticationResponse` toe aan het project

9. Voeg `JwtUtil` en de `RandomStringGenerator` toe aan het project

10. Voeg de `JwtRequestFilter` toe aan je project

11. Voeg als laatste de `SpringSecurityConfig` en de `GlobalCorsConfiguration` toe aan het project

12. Kijk goed of je in de `SpringSecurityConfig` nog antmatchers wil/ moet toevoegen

13. Update de data.sql met users en authorities
