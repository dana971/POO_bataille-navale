package com.bataille.navale.BO;

public class Bateau {

    private String nom;

    private char pion;

    private int taille;

    private Etat etat;

    public static void maMethode(){

    }

    public static int maVariable = 32;

    public Bateau(String nom,char pion,int taille,Etat etat){

        this.nom=nom;
        this.pion=pion;
        this.taille=taille;
        this.etat=etat;

    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public char getPion(){
        return pion;
    }

    public void setPion(char pion){
        this.pion=pion;
    }

    public int getTaille(){
        return taille;
    }

    public void setTaille(int taille){
        this.taille=taille;
    }

    public Etat getEtat(){
        return etat;
    }

    public void setEtat(Etat etat){
        this.etat=etat;
    }
}
