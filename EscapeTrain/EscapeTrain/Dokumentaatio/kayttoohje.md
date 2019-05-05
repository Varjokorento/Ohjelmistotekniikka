# Asennusohje

## Release-version asentaminen

1. Lataa [tiedosto](https://github.com/Varjokorento/Ohjelmistotekniikka/releases/tag/1.2)
2. Käynnistä tiedosto 
```
java -jar EscapeTrain-1.2.jar
```

## Projektin asentaminen paikallisesti
```
1. git clone https://github.com/Varjokorento/Ohjelmistotekniikka
2. siirtyminen EscapeTrain-kansioon
3. mvn install
4. mvn package
5. siirtyminen target -kansioon
6. java -jar EscapeTrain-1.0-SNAPSHOT.jar
```

# Käyttöohje

## Peliohje

Pelissä täytyy saada Engine roomin ovi auki ja vetää siellä vivusta, että saa junan pysäytettyä. Pelaajan täytyy löytää tyyny, käyttää tyynyä, jolloin saa dynamiittia, mennä Engine Roomiin, asettaa dynamiitti ja sen jälkeen sytyttää dynamiitti Staff quarters -huoneessa. 

Tämän jälkeen tulee mennä Engine Roomiin ja käyttää komentoa USE LEVER.

Käskyt tulee kirjoittaa text input -kenttään. HUOM: Versiossa 1.1 huoneiden ja esineiden nimet on hyvä olla täsmälleen siinä muodossa, missä ne näkyvät käyttöliittymässä.

### Pelin tarkka läpäisyohje

```
1. Mene cabin-huoneeseen
2. ota tyyny (take pillow)
3. Ota ravintola-huoneesta tulitikut (matches)
4. mene staff quarters -huoneeseen
5. käytä tyynyä (use pillow)
6. Nyt sinulla pitäisi olla dynamiitti
7. Käytä dynamiittia
8. Käytä tulitikkuja
9. Mene engine room-huoneeseen (jonka pitäisi nyt olla auki)
10. Käytä vipua (Use lever)
```

## Käskyt

### GOTO (PAIKAN NIMI)

Tällä käskyllä voi siirtyä paikkaan, jos sinne pääsee huoneesta. Eli jos seuraava huone on huoneen bordering area.

### TAKE (ESINEEN_NIMI)

Tällä käskyllä voi nostaa esineen, jos sellainen on huoneessa.

### USE (ESINEEN_NIMI) 

Tällä käskyllä voi käyttää esinettä, jos sellaisen omistaa. Lisäksi tällä käskyllä voi käyttää huoneissa olevia asioita. 

### INSPECT (ESINEEN_NIMI)

Tällä käskyllä voi tutkia esinettä, jota pitää hallussaan.
