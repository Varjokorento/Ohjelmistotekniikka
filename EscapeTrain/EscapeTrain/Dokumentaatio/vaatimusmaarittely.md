# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on olla pelattava seikkailupeli nimeltä "Escape Train." Pelissä on tarkoitus paeta liikkuvasta junasta, joka 50 vuoron jälkeen syöksyy alas kielekkeeltä. Pelissä ratkotaan ongelmia ja arvoituksia, joilla on tarkoitus saada auki veturin ovi ja pysäytettyä juna. Sovellus toteutetaan Java-ohjelmointikielellä. 

## Käyttäjät

Sovelluksessa ei ole käyttäjätilejä, joten sovelluksen käyttäjä on tällä hetkellä sen avaaja, eli pelaaja. Jossain vaiheessa olisi tarkoitus pystyä tallentamaan käyttäjän pelitilanne, jolloin pelaaja olisi joku muu kuin Guest Player.

## Käyttöliittymä

Sovellus koostuu neljästä näkymästä: aloitusnäkymästä, Credits -näkymästä, tutoriaalinäkymästä (eli pelin ohjeista), pelinäkymästä ja lopputeksteistä. 

Sovellus aukeaa aloitusnäkymään, josta on mahdollista siirtyä muihin näkymiin hiirellä.

## Perusversion tarjoama toiminnallisuus

### Aloitusnäkyma

Pelaaja voi valita "Start game", "Credits" and "Tutorial." 

### Pelinäkymä

Pelaajalle näkyy hänen esineensä sekä tekstimuodossa kuvaus paikoista, joissa hän liikkuu. Lisäksi näkymässä on komentotulkki, johon pelaaja voi kirjoittaa käskyt, mitä tehdä seuraavaksi. Tässä näkymässä tapahtuu suurin osa ohjelman toiminnallisuudesta. Tavoitteena on, että perusversiossa on kokonainen peli. 

### Tutoriaali

Pelissä on hyvin lyhyt tutoriaaliosa, jossa pelaaja voi kokeilla pelin kolmea käskyä, eli GOTO, TAKE ja USE käskyjä. Tutoriaalin pääsee 
päävalikosta. 

### Credits

Tässä näkyy yksinkertaisesti tekijän tiedot sekä käytetty teknologia.

## Lopputekstit

Näkymä lopputeksteistä, kun pelin voitto on saavutettu. Lopputeksteissä on tarkoitus myös näyttää, kuinka moni pelaaja tällä tietokoneella on päässyt pelin läpi. Tappion kohdalla (juna syöksyy alas) lopputekstien sijaan näytetään pelinäkymän oma tappioruutu.

## Jatkokehitysideoita

Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla

- Pelaajan tilanteen tallentaminen
- Grafiikan parantaminen
- Äänimaailman lisääminen
