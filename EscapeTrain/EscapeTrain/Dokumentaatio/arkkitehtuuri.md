# Arkkitehtuurikuvaus

## Rakenne

Sovelluksen päätoiminnallisuus koostuu GameControllerista, joka kutsuuu pelimoottoria, joka on Java-luokka GameEngine. GameEngine ottaa käyttäjän syötteen, tekee sen perusteella päätöksiä ja palauttaa controllerille GameObject-luokan toteuttavan olion, joka on se, mitä käyttäjälle näytetään. 

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

Toiminnallisista kokonaisuuksista vastaa luokkan GameEngine. 

## Tietojen pysyväistallennus


### Tiedostot


### Päätoiminnallisuudet


#### Pelin pelaaminen



## Ohjelman rakenteeseen jääneet heikkoudet



