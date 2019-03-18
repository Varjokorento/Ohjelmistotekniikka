/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class KassapaateTest {
    
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
    public void kassapaateAlustettuOikeinAlkuKassanSuhteen() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kassapaateAlustettuOikeinMyytyjenLounaidenSuhteen() {
        int maukkaatLounaat = kassapaate.maukkaitaLounaitaMyyty();
        int edullisetLounaat = kassapaate.edullisiaLounaitaMyyty();
        int kokonaisuus = maukkaatLounaat + edullisetLounaat;
        assertEquals(0, kokonaisuus);
    }
    
    @Test
    public void maukasLounasKasvattaaKassaaKateisella() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void edullinenLounasKasvattaaKassaaKateisella() {
        kassapaate.syoEdullisesti(240);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void maukasLounasPalauttaaLiianPienenSumman() {
        assertEquals(100, kassapaate.syoMaukkaasti(100));
        
    }
    
    @Test
    public void edullinenLounasPalauttaaLiianPienenSumman() {
        assertEquals(100, kassapaate.syoEdullisesti(100));;
    }
    
    @Test
    public void maukasLounasKasvattaaMyytyjaKateisella() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenLounasKasvattaaMyytyjaKateisella() {
        kassapaate.syoEdullisesti(240);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukasLounasKasvattaaMyytyjaKortilla() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenLounasKasvattaaMyytyjaKortilla() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void lataaRahaaKortilleLisaaRahaaKassaan() {
        kassapaate.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, kassapaate.kassassaRahaa());
    }
    
     @Test
    public void lataaRahaaKortilleLisaaRahaaKortille() {
        kassapaate.lataaRahaaKortille(kortti, 1000);
        assertEquals("saldo: 20.0", kortti.toString());
    }
    @Test
    public void negatiivinenLatausEiMuutaSaldoa() {
        kassapaate.lataaRahaaKortille(kortti, -1000);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void syoMaukkaastiEiMyyJosEiSaldoa() {
        kassapaate.syoMaukkaasti(halpaKortti);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiEiMyyJosEiSaldoa() {
        kassapaate.syoEdullisesti(halpaKortti);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    } 
    
    
}
