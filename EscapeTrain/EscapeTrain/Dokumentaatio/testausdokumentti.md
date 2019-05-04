# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla ja Mockito-testikirjastolla. Lisäksi peli on testattu manuaalisesti. Käyttöliittymää ei ole testattu muuten kuin manuaalisesti.
## Yksikkö- ja integraatiotestaus

### sovelluslogiikka

Molempien DAO-luokkien toiminnallisuus on testattu luomalla testeissä tilapäinen tiedosto hyödyntäen JUnitin [TemporaryFolder](https://junit.org/junit4/javadoc/4.12/org/junit/rules/TemporaryFolder.html)-ruleja.

### Testauskattavuus

Käyttöliittymää lukuunottamatta sovelluksen testauksen rivikattavuus on XX ja haarautumakattavuus XX.


## Järjestelmätestaus

Pelin järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/kayttoohje.md) kuvaamalla tavalla sekä Windows- että Linux-ympäristöön.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/vaatimusmaarittely.md) ja käyttöohjeessa olevat toiminnallisuudet on käyty läpi manuaalisesti. .

## Sovellukseen jääneet laatuongelmat

