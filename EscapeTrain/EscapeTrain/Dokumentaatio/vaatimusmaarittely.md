# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on olla pelattava seikkailupeli nimeltä "Escape Train." Pelissä on tarkoitus paeta liikkuvasta junasta, joka 50 vuoron jälkeen syöksyy alas kielekkeeltä. Pelissä ratkotaan ongelmia ja arvoituksia, joilla on tarkoitus saada auki veturin ovi ja pysäytettyä juna. Sovellus toteutetaan Java-ohjelmointikielellä. 

## Käyttäjät

Sovelluksen käyttäjä on tällä hetkellä Guest Player (myöhemmin tässä "Pelaaja"). Jossain vaiheessa olisi tarkoitus pystyä tallentamaan käyttäjän pelitilanne. 

## Käyttöliittymäluonnos

Sovellus koostuu neljästä näkymästä: aloitusnäkymästä, Credits -näkymästä, tutoriaalinäkymästä (eli pelin ohjeista), pelinäkymästä ja lopputeksteistä. 

Sovellus aukeaa aloitusnäkymään, josta on mahdollista siirtyä muihin näkymiin hiirellä.

## Perusversion tarjoama toiminnallisuus

### Aloitusnäkyma

Pelaaja voi valita "Start game", "Credits" and "Tutorial." 

### Pelinäkymä

Pelaajalle näkyy hänen esineensä, yksinkertainen kuva sekä kartta, missä pelaaja liikkuu. Lisäksi näkymässä on komentotulkki, johon pelaaja voi kirjoittaa käskyt, mitä tehdä seuraavaksi.

### Tutoriaali

Tässä vaiheessa tarkoitus on luoda vain näkymä, jossa on pelin ohjeet. Myöhemmässä vaiheessa tarkoitus olisi saada kokeilutaso pelille.

### Credits

Tässä näkyy yksinkertaisesti tekijän tiedot sekä käytetty teknologia.

## Lopputekstit

Näkymä lopputeksteistä, kun pelin voitto on saavutettu. Lopputeksteissä on tarkoitus myös näyttää, kuinka moni pelaaja on päässyt pelin läpi. Tämä tieto haetaan internetissä olevasta tietokannasta. Tappion kohdalla (juna syöksyy alas) lopputekstien sijaan näytetään pelinäkymän oma tappioruutu.

## Jatkokehitysideoita

Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla

- Pelaajan tilanteen tallentaminen
- Tutoriaalitason luominen
- Äänimaailman lisääminen
