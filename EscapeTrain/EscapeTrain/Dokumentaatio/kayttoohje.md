# Asennusohje

1. Lataa [tiedosto](https://github.com/Varjokorento/Ohjelmistotekniikka/releases/tag/1.1)
2. Käynnistä tiedosto 
```
java -jar EscapeTrain-1.1.jar
```
(Pelin ei pitäisi vaatia mitään erillisiä konfiguraatioita)

# Käyttöohje

## Peliohje

Pelissä täytyy saada Engine roomin ovi auki ja vetää siellä vivusta, että saa junan pysäytettyä. Pelaajan täytyy löytää tyyny, käyttää tyynyä, jolloin saa dynamiittia, asettaa dynamiitti ja sen jälkeen sytyttää dynamiitti staff quarters -huoneessa.

Käskyt tulee kirjoittaa text input -kenttään. HUOM: Versiossa 1.1 huoneiden ja esineiden nimet on hyvä olla täsmälleen siinä muodossa, missä ne näkyvät käyttöliittymässä.

## Käskyt

### GOTO (PAIKAN NIMI)

Tällä käskyllä voi siirtyä paikkaan, jos sinne pääsee huoneesta. Eli jos seuraava huone on huoneen bordering area.

### TAKE (ESINEEN_NIMI)

Tällä käskyllä voi nostaa esineen, jos sellainen on huoneessa.

### USE (ESINEEN_NIMI) 

Tällä käskyllä voi käyttää esinettä, jos sellaisen omistaa. Lisäksi tällä käskyllä voi käyttää huoneissa olevia asioita. 
