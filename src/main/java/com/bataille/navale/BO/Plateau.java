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

            this.getEchiquier()[j][i].draw();

            }
            System.out.println("\n");
        }


    }

    public int nbCaseDispo(int x, int y, Orientation o){

        int result = 0;

        if( o == Orientation.H){
            int nbBoucle = (colonnes - y)+1;

            for(int i=0; i<nbBoucle; i++){

                if(this.echiquier[y+i][x] == null){

                    result++;

                }
            }

        }else{

            int nbBoucle = (lignes - x )+1;

            for(int i=0; i<nbBoucle; i++){

                if(this.getEchiquier()[y][x+i] == null){

                    result++;
                }
            }

        }

        return result;
    }

    public boolean addABateau(Bateau bateau, int colonnes, int lignes,Orientation o){



        return true;
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
