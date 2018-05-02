/*
 * Copyright (c) 2018 Dominik Jahn, Philipp Kalytta
 * All rights reserved. This program and the accompanying materials
 * are private property protected by law.
 * DO NOT DISTRIBUTE
 *            T E C H N I S C H E   H O C H S C H U L E   K O E L N
 */

import java.sql.Date;

/**
 * Klasse Lagerposition fuer die transiente Entitaetsklasse LagerA
 */

public class Lagerposition {

    private int menge;
    private int artikelnummer;
    private String artikelbezeichnung;
    private String mengeneinheit;
    private double preis;
    private int steuersatz;
    private Date einlieferungsdatum;

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(int artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getArtikelbezeichnung() {
        return artikelbezeichnung;
    }

    public void setArtikelbezeichnung(String artikelbezeichnung) {
        this.artikelbezeichnung = artikelbezeichnung;
    }

    public String getMengeneinheit() {
        return mengeneinheit;
    }

    public void setMengeneinheit(String mengeneinheit) {
        this.mengeneinheit = mengeneinheit;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getSteuersatz() {
        return steuersatz;
    }

    public void setSteuersatz(int steuersatz) {
        this.steuersatz = steuersatz;
    }

    public Date getEinlieferungsdatum() {
        return einlieferungsdatum;
    }

    public void setEinlieferungsdatum(Date einlieferungsdatum) {
        this.einlieferungsdatum = einlieferungsdatum;
    }
}
