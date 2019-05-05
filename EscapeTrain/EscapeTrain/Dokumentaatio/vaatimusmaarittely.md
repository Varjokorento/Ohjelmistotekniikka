# Vaatimusmäärittely

Nämä vaatimusmäärittelyt vastaavat loppureleasessa olevaa peliä. 

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on olla pelattava seikkailupeli nimeltä "Escape Train." Pelissä on tarkoitus paeta liikkuvasta junasta, joka 25 vuoron jälkeen syöksyy alas kielekkeeltä. Pelissä ratkotaan ongelmia ja arvoituksia, joilla on tarkoitus saada auki veturin ovi ja pysäytettyä juna. 

Vuoroksi lasketaan onnistunut siirtymä pelin alueiden välillä. Pelaajalle ei näytetä vuorojen kulumista, näin ylläpidetään jännitystä. 

Sovellus on toteutettu Java-ohjelmointikielellä. 

## Käyttöliittymä

Sovellus koostuu neljästä näkymästä: aloitusnäkymästä, Credits -näkymästä, tutoriaalinäkymästä (eli pelin ohjeista), pelinäkymästä ja lopputeksteistä. 

Sovellus aukeaa aloitusnäkymään, josta on mahdollista siirtyä muihin näkymiin hiirellä.

## Perusversion tarjoama toiminnallisuus

### Aloitusnäkyma

Pelaaja voi valita "Start game", "Credits", "Tutorial." tai "Exit".  

### Pelinäkymä

Pelaajalle näkyy hänen esineensä sekä tekstimuodossa kuvaus paikoista, joissa hän liikkuu. Lisäksi näkymässä on komentotulkki, johon pelaaja voi kirjoittaa käskyt, mitä tehdä seuraavaksi. Tässä näkymässä tapahtuu suurin osa ohjelman toiminnallisuudesta. 

### Tutoriaali

Pelissä on hyvin lyhyt tutoriaaliosa, jossa pelaaja voi kokeilla pelin neljää käskyä, eli GOTO, TAKE, INSPECT ja USE käskyjä. Tutoriaalin pääsee 
päävalikosta. 

### Credits

Tässä näkyy yksinkertaisesti tekijän tiedot sekä käytetty teknologia.

## Lopputekstit

Näkymä lopputeksteistä, kun pelin voitto on saavutettu. Lopputeksteissä on tarkoitus myös näyttää, kuinka moni pelaaja tällä tietokoneella on päässyt pelin läpi. Tappion kohdalla (25 vuoroa kuluu ja juna syöksyy alas) lopputekstien sijaan näytetään pelinäkymän oma tappioruutu.

## Jatkokehitysideoita

Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla

- Pelaajan tilanteen tallentaminen
- Grafiikan parantaminen
- Äänimaailman lisääminen
