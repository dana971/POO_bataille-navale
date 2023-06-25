package com.bataille.navale.BO;

public class Case {

    private Etat etat;

    private Bateau bateau;


    public Case(){

        this.etat=Etat.I;
        this.bateau=null;

    }

    public Case(Bateau bateau){

        this.etat=Etat.I;
        this.bateau=bateau;
    }

    public Etat getEtat(){
        return etat;
    }

    public void setEtat(Etat etat){
        this.etat=etat;
    }

    public Bateau getBateau(){
        return bateau;
    }

    public void setBateau(Bateau bateau){
        this.bateau=bateau;
    }


}
