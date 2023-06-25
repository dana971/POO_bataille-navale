package com.bataille.navale.BO;

public class Plateau {
    private int colonnes;

    private int lignes;

    public Plateau(int colonnes, int lignes){

        this.colonnes=colonnes;
        this.lignes=lignes;
    }

    public int getColonnes(){
        return colonnes;
    }

    public void setColonnes(int colonnes){
        this.colonnes=colonnes;
    }

    public int getLignes(){
        return lignes;
    }

    public void setLignes( int lignes){
        this.lignes=lignes;
    }
}
