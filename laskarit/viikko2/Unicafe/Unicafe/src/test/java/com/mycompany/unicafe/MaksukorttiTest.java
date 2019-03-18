package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Maksukortti halpaKortti;
    Kassapaate kassapaate;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
        halpaKortti = new Maksukortti(0);
        kassapaate = new Kassapaate();
    }
    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        String vastaus = kortti.toString(); 
        assertEquals("saldo: 10.0", vastaus);
    }
  
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 11.0", kortti.toString());
    }
    
    @Test
    public void otaRahaaOttaaRahaa() {
        kortti.otaRahaa(100);
        assertEquals("saldo: 9.0", kortti.toString());
    }
    
    @Test
    public void syoEdullisestiVahentaaSaldoa() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals("saldo: 7.60", kortti.toString());
    }
    
    @Test
    public void syoMaukkaastiVahentaaSaldoa() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals("saldo: 6.0", kortti.toString());
    }
    
    @Test
    public void syoEdullisestiPalauttaaTottaKunRahatRiittavat() {
        assertTrue(kassapaate.syoEdullisesti(kortti));
    }
    
    @Test
    public void syoMaukkastiPalauttaaTottaKunRahatRiittavat() {
        assertTrue(kassapaate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void syoEdullisestiPalauttaaFalseKunRahatEivatRiita() {
        assertFalse(kassapaate.syoEdullisesti(halpaKortti));
    }
    
    @Test
    public void syoMaukkastiPalauttaaFalseKunRahatEivatRiita() {
        assertFalse(kassapaate.syoMaukkaasti(halpaKortti));
    }
    
    @Test
    public void otaRahaaFalseKunEiRahaa() {
        assertFalse(halpaKortti.otaRahaa(100));
    }
    
    
}
