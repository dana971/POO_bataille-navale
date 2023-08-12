package com.bataille.navale.BO;

public class Plateau {
    private int colonnes;

    private int lignes;

    private  Case [] [] echiquier;


    public Plateau(int colonnes, int lignes){

        this.colonnes=colonnes;
        this.lignes=lignes;
        this.echiquier=new Case[colonnes][lignes];

        for(int i=0; i<colonnes; i++){

            for(int j=0; j<lignes; j++){

                 this.echiquier [i][j] = new Case();
            }

        }
    }



    public void draw(){

        for(int i=0; i<lignes; i++){

            for(int j=0; j<colonnes; j++){

            this.getEchiquier()[i][j].draw();

            }
            System.out.println("");
        }


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

    public Case[][] getEchiquier() {
        return echiquier;
    }

    public void  setEchiquier(Case [][] echiquier){
        this.echiquier=echiquier;
    }
}
