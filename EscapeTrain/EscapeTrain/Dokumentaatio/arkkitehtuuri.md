# Arkkitehtuurikuvaus

## Rakenne

Sovelluksen päätoiminnallisuus koostuu GameControllerista, joka kutsuuu pelimoottoria, joka on Java-luokka GameEngine. GameEngine ottaa käyttäjän syötteen, tekee sen perusteella päätöksiä ja palauttaa controllerille GameObject-luokan toteuttavan olion, joka on se, mitä käyttäjälle näytetään. 

GameEngine on yhteydessä AreaParseriin, EventHandleriin sekä CommandParseriin, jotka on injektoitut siihen. Pelin tiedot, inventaario sekä tapahtuneet tapahtumat, säilötään ja kutsutaan GameState-olion kautta. 

## Käyttöliittymä

Käyttöliittymä sisältää neljä erillistä näkymää
- pelinäkymä
- tutoriaalinäkymä
- credits
- Aloitusnäkymän

Jokainen näistä on toteutettu omana controller-olionaan. Syy tähän on se, ettei näkymien välillä hypitä juuri lainkaan, joten controllereiden injektoimista toisilla controllereilla ei ollut tarkoituksenmukaista tehdä. 

Käyttöliittymä on pyritty eristämään sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion gameEnginen metodeja ja reagoi saatujen tietojen mukaan. 


## Luokkakaavio

<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/77507036.jpg" width="700">

## Sovelluslogiikka

Sovellus toimii siten, että käyttäjä syöttää kaksisanaisen käskyn käyttöliittymän komentoriville. Tämän käskyn käsittelee GameEngine, joka lopulta palauttaa GameObject-rajapinnan toteuttavan objektin käyttöliittymälle ja käyttöliittymä näyttää tämän perusteella tapahtuman.

### Käskytoiminnallisuus

Käskyjä on kolmenlaisia: GOTO, TAKE ja USE

Seuraavaksi käskyjen GOTO, TAKE ja USE sekvenssikaaviot:

#### GOTO-KÄSKY
<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/GOTO%20SEQUENCE%20(1).png" width="700">

GOTO AREA-käsky tarkastaa voiko paikkaan mennä ja sitten palauttaa käyttöliittymälle sen paikan, mihin pelaaja siirtyy. 

#### TAKE-KÄSKY
<img src="https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/TAKE%20%20ITEM%20SEQUENCE.png" width="700">

TAKE ITEM -käsky tarkistaa onko kyseistä tavaraa huoneessa ja sen jälkeen lisää sen käyttäjän inventaarioon, jos mahdollista. 

#### USE-KÄSKY
<img src="https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/USE%20TARGET%20SEQUENCE.png" width="700">

USE ITEM -käsky tarkistaa käskyn toteutettavuuden (eli onko pelaaja esimerkiksi tietyssä huoneessa ja onko hänellä tietty esine) jonka jälkeen palauttaa USE -käskyyn liittyvän eventin, jonka käyttöliittymä näyttää. 

### GAMESTATE-toiminnallisuus

Käskyt ja muu toiminnallisuus perustuvat GameState-luokassa oleviin tietoihin. GameState-luokka injektoidaan GameEngine-konstruktorissa ja se määrittelee tällä hetkellä pelattavan pelin tilan. 
