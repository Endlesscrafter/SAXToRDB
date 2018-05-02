/*
 * Copyright (c) 2018 Dominik Jahn, Philipp Kalytta
 * All rights reserved. This program and the accompanying materials
 * are private property protected by law.
 * DO NOT DISTRIBUTE
 *            T E C H N I S C H E   H O C H S C H U L E   K O E L N
 */

import java.util.List;

/**
 * Aufgabe 5b) Definition einer der ADT LAGERTA entsprechenden
 * transienten Entitaetsklasse LagerA
 */

public class LagerA {

    private int lagernummer;
    private String lagerort;
    private int lagerpostleitzahl;
    private List<Lagerposition> artikelliste;

    public int getLagernummer() {
        return lagernummer;
    }

    public void setLagernummer(int lagernummer) {
        this.lagernummer = lagernummer;
    }

    public String getLagerort() {
        return lagerort;
    }

    public void setLagerort(String lagerort) {
        this.lagerort = lagerort;
    }

    public int getLagerpostleitzahl() {
        return lagerpostleitzahl;
    }

    public void setLagerpostleitzahl(int lagerpostleitzahl) {
        this.lagerpostleitzahl = lagerpostleitzahl;
    }

    public List<Lagerposition> getArtikelliste() {
        return artikelliste;
    }

    public void setArtikelliste(List<Lagerposition> artikelliste) {
        this.artikelliste = artikelliste;
    }
}
