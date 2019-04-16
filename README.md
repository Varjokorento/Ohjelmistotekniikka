# Escape Train

Sovelluksen tarkoitus on olla pelattava seikkailupeli nimeltä "Escape Train." Pelissä on tarkoitus paeta liikkuvasta junasta, joka 50 vuoron jälkeen syöksyy alas kielekkeeltä. Pelissä ratkotaan ongelmia ja arvoituksia, joilla on tarkoitus saada auki veturin ovi ja pysäytettyä juna. Sovellus on toteutettu Java-ohjelmointikielellä. 

## Releaset

[v.1.0](https://github.com/Varjokorento/Ohjelmistotekniikka/releases/tag/v1.0)

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/kayttoohje.md)

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
