# Arkkitehtuurikuvaus

## Rakenne

Sovelluksen päätoiminnallisuus koostuu GameControllerista, joka kutsuu pelimoottoria, joka on Java-luokka GameEngine. GameEngine ottaa käyttäjän syötteen, tekee sen perusteella päätöksiä ja palauttaa controllerille GameObject-luokan toteuttavan olion, joka on se, mitä käyttäjälle näytetään. 

GameEngine on yhteydessä AreaParseriin, EventHandleriin sekä CommandParseriin, jotka on injektoitut siihen. Pelin tiedot, inventaario sekä tapahtuneet tapahtumat säilötään ja kutsutaan GameState-olion kautta. 

## Käyttöliittymä

Käyttöliittymä sisältää neljä erillistä näkymää
- pelinäkymä
- tutoriaalinäkymä
- credits
- Aloitusnäkymän

Jokainen näistä on toteutettu omana controller-olionaan. Syy tähän on se, ettei näkymien välillä hypitä juuri lainkaan, joten controllereiden injektoimista toisilla controllereilla ei ollut tarkoituksenmukaista tehdä. 

Käyttöliittymä on pyritty eristämään sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion gameEnginen metodeja ja reagoi saatujen tietojen mukaan. 

## Luokkakaavio pelitoiminnallisuudelle

<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/kaaviot/classdiagram.jpg">

[Controller]->[GameEngine],[GameEngine]->[GameState],[GameEngine]->[AreaParser],[GameEngine]->[ItemInfoParser],[GameEngine]->[CommandParser],[GameEngine]->[EventHandler],[EventHandler]->[Event],[ItemInfoParser]->[Event],[GameState]->[FlagStates],[GameState]->[Inventory],[Inventory]->[Item],[AreaParser]->[Area]

## Sovelluslogiikka

Sovellus toimii siten, että käyttäjä syöttää kaksisanaisen käskyn käyttöliittymän komentoriville. Tämän käskyn käsittelee GameEngine, joka lopulta palauttaa GameObject-rajapinnan toteuttavan objektin käyttöliittymälle ja käyttöliittymä näyttää tämän perusteella tapahtuman.

Kuvaus GameEngine-luokasta:

<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/kaaviot/05032726.jpg">


### Käskytoiminnallisuus

Käskyjä on kolmenlaisia: GOTO, TAKE, INSPECT ja USE

Seuraavaksi käskyjen GOTO, TAKE, INSPECT ja USE sekvenssikaaviot:

#### GOTO-KÄSKY
<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/GOTO%20SEQUENCE%20(1).png" width="700">

GOTO AREA-käsky tarkastaa voiko paikkaan mennä ja sitten palauttaa käyttöliittymälle sen paikan, mihin pelaaja siirtyy. 

#### TAKE-KÄSKY
<img src="https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/TAKE%20%20ITEM%20SEQUENCE.png" width="700">

TAKE ITEM -käsky tarkistaa onko kyseistä tavaraa huoneessa ja sen jälkeen lisää sen käyttäjän inventaarioon, jos mahdollista. 

#### USE-KÄSKY
<img src="https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/USE%20TARGET%20SEQUENCE.png" width="700">

USE ITEM -käsky tarkistaa käskyn toteutettavuuden (eli onko pelaaja esimerkiksi tietyssä huoneessa ja onko hänellä tietty esine) jonka jälkeen palauttaa USE -käskyyn liittyvän eventin, jonka käyttöliittymä näyttää. 

#### INSPECT-KÄSKY
<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/kaaviot/Inspect%20Item%20Sequence.png" width="700">

INSPECT ITEM -käsky tarkistaa käskyn toteutettavuuden, eli onko pelaajalla esinettä hallussaan, jonka jälkeen se palauttaa INSPECT -käskyyn liittyvän esineen tiedon, jonka käyttöliittymä näyttää.

### GAMESTATE-toiminnallisuus

<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/kaaviot/49875d51.jpg">

Käskyt ja muu toiminnallisuus perustuvat GameState-luokassa oleviin tietoihin. GameState-luokka injektoidaan GameEngine-konstruktorissa ja se määrittelee tällä hetkellä pelattavan pelin tilan. 

GameState on GameEngineen injektoitu riippuvuus. Muut luokat (kuten esimerkiksi EventHandler) saavat sen funktiokutsuissaan, jolloin ne voivat kutsua GameEnginen metodeita ja käsitellä sen tilaa. 

#### Pelialueen määritys

<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/kaaviot/GAMESTATE%20SEQUENCE.png">

GameEngine kysyy GameStatelta, mikä on nykyinen tilanne. Nykyinen tilanne määräytyy sen perusteella, mitä on tapahtunut pelissä aikaisemmin. GameState palauttaa GameEnginelle tämänhetkisen pelialueen. 

#### USE ITEM -käsky gamestatessa

<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/kaaviot/GAMESTATE%20USE%20ITEM%20SEQUENCE.png">

USE ITEM -tilanteessa GameStatessa säilötyn inventaarion perusteella EventHandler suorittaa käskyn. 

#### Pelitilanteen määritys
<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/kaaviot/GAMESTATE%20GAME%20OVER%20SEQUENCE.png">

GameEngine kysyy GameStatelta jotain tiettyä tilannetta, tässä kaaviossa isGameOver, jonka jälkeen GameState selvittää sen FlagState-luokan avulla. 

## Tiedonhallinta

### Tiedon lukeminen

Pelin tarvitsemia tietoja, esimerkiksi Area-luokkien tietoja, luetaan sovelluksen mukana tulevista .properties -tiedostoista.

### Tiedon kirjoittaminen

Pelissä on hyvin vähän pysyvän tiedon tallentamista. Ainoa tieto, joka tallennetaan on se, että kuinka monta kertaa kyseinen pelitietokoneenkäyttäjä on voittanut pelin. 

Pysyvän tiedon lukeminen ja kirjoittaminen tapahtuvat DataClient ja DataServices -luokkien kautta. DataService -luokka kutsuu DataClient-luokkaa. DataClient-luokka lukee ja kirjoittaa tietoa käyttäen [Javan Preferences -apia](https://docs.oracle.com/javase/8/docs/technotes/guides/preferences/). Preferences tallentaa tiedot käyttäjän hakemistoihin, riippuen siitä, käyttääkö pelaaja Windows-, OSX- vai Linux-ympäristöä.

