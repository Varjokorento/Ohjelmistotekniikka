# Testausdokumentti

Ohjelmaa on testattu yksikkötestein JUnitilla ja Mockito-testikirjastolla. Lisäksi peli on testattu manuaalisesti. 

Käyttöliittymää ei ole testattu muuten kuin manuaalisesti.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

### Testauskattavuus

Testauksen rivikattavuus on 80 % ja haarautumakattavuus 71 %. Testikattavuusraportissa ei ole mukana käyttöliittymän koodia.

<img src="https://raw.githubusercontent.com/Varjokorento/Ohjelmistotekniikka/master/EscapeTrain/EscapeTrain/Dokumentaatio/testresults.PNG">

## Järjestelmätestaus

Pelin järjestelmätestaus on suoritettu manuaalisesti. Peli on pelattu läpi sekä niin, että se voitetaan, että niin, että pelaaja häviää. Virhesyötteitä (numeroita, tyhjiä arvoja, sekasotkuisia viestejä) on yritty kirjoittaa. Nämä eivät ole johtaneet kaatumisiin manuaalisissa testeissä. 

### Asennus ja konfigurointi

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/kayttoohje.md) kuvaamalla tavalla sekä Windows- että Linux-ympäristöön.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/Varjokorento/Ohjelmistotekniikka/blob/master/EscapeTrain/EscapeTrain/Dokumentaatio/vaatimusmaarittely.md) ja käyttöohjeessa olevat toiminnallisuudet on käyty läpi manuaalisesti sekä Linux- että Windows-ympäristössä. 

### Laatuongelmat

Tilanteet, joissa oikeissa käyttötilanteissa peli kaatuisi, ei tullut vastaan manuaalisessa testauksessa. Tiedossa on kuitenkin se, että ohjelmiston properties-tiedostojen muuttaminen käsin tulee johtamaan pelin kaatumiseen. Näistä kaatumisista ei kuitenkaan tule käyttäjälle viestiä, ohjelma vain jäätyy. 



