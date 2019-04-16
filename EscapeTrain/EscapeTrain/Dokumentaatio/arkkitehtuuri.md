# Arkkitehtuurikuvaus

## Rakenne

Sovelluksen päätoiminnallisuus koostuu GameControllerista, joka kutsuuu pelimoottoria, joka on Java-luokka GameEngine. GameEngine ottaa käyttäjän syötteen, tekee sen perusteella päätöksiä ja palauttaa controllerille GameObject-luokan toteuttavan olion, joka on se, mitä käyttäjälle näytetään. 

Sovelluksen lopullinen rakenne tulee hyödyntämään Parser-luokkia enemmän. Esimerkiksi kaikki tapahtumat käsiteltäisiin niin, että EventParser palauttaisi kaikki Event-tapahtumat. 

## Käyttöliittymä

Käyttöliittymä sisältää kolme erillistä näkymää
- pelinäkymä
- tutoriaalinäkymä
- credits
- Aloitusnäkymän

Jokainen näistä on toteutettu omana controller-olionaan. Syy tähän on se, ettei näkymien välillä hypitä juuri lainkaan, joten controllereiden injektoimista toisilla controllereilla ei ollut tarkoituksenmukaista tehdä. 

Käyttöliittymä on pyritty eristämään sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion gameEnginen metodeja ja reagoi saatujen tietojen mukaan. 


## Luokkakaavio

<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/77507036.jpg" width="700">

## Sovelluslogiikka

Toiminnallisista kokonaisuuksista vastaa luokkan GameEngine. GameEngine saa käyttäjän kirjoittaman käskyn ja sen perusteella näyttää muuttuneen tilanteen käyttäjälle. 

Seuraavaksi käskyjen GOTO, TAKE ja USE sekvenssikaaviot:

### GOTO-KÄSKY
<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/GOTO%20SEQUENCE%20(1).png" width="700">

### TAKE-KÄSKY
<img src="https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/TAKE%20%20ITEM%20SEQUENCE.png" width="700">

### USE-KÄSKY
<img src="https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/USE%20TARGET%20SEQUENCE.png" width="700">
