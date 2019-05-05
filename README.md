# Escape Train

Sovelluksen tarkoitus on olla pelattava seikkailupeli nimeltä "Escape Train." Pelissä on tarkoitus paeta liikkuvasta junasta, joka 25 vuoron jälkeen syöksyy alas kielekkeeltä. Pelissä ratkotaan ongelmia ja arvoituksia, joilla on tarkoitus saada auki veturin ovi ja pysäytettyä juna. Sovellus on toteutettu Java-ohjelmointikielellä. 

## Releaset

[Viimeinen julkaisu](https://github.com/Varjokorento/Ohjelmistotekniikka/releases/tag/1.2)

Peli on nyt valmis ja se toteuttaa määrittelydokumentin vaatimukset. 

[v.1.1](https://github.com/Varjokorento/Ohjelmistotekniikka/releases/tag/1.1)

Peli on nyt pelattava ja siinä on juoni. Lisäksi pelissä on credits-näkymä eikä pelin pitäisi kaatuilla niin paljoa. 

[v.1.0](https://github.com/Varjokorento/Ohjelmistotekniikka/releases/tag/v1.0)

Julkaisussa on mukana pelattava peli, jossa peliä ja sen tutoriaalia voi pelata.  Pelin lopullinen juoni ei ole vielä valmis, mutta perustoiminnallisuudet toimivat. Tosin virhesyötteet voivat vielä johtaa pelin kaatumiseen. 

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/kayttoohje.md)

[Testausdokumentti](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/testausdokumentti.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

### Checkstyle

Checkstyle-raportti luodaan komennolla


```
mvn jxr:jxr checkstyle:checkstyle
```

### Jar-tiedoston luonti

Jar-tiedosto luodaan komennolla. Ajaminen täytyy tehdä Java 8 -versiolla. 


```
mvn package
```

### Javadoc-generointi

Javadoc-dokumentin saa generoitua komennolla


```
mvn javadoc:javadoc
```

