package com.bataille.navale.BO;

public class Plateau {
    private int colonnes;

    private int lignes;

    private  Case [] [] echiquier;


    public Plateau(int colonnes, int lignes){
        this.colonnes=colonnes;
        this.lignes=lignes;

        this.init();

    }

    public Plateau(){


    }

    public void init(){


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
            int nbBoucle = (colonnes - y);

            for(int i=0; i<nbBoucle; i++){

                if((this.echiquier[y+i][x]).getBateau() == null){

                    result++;

                }else{

                    return result;
                }
            }

        }else{

            int nbBoucle = (lignes - x );

            for(int i=0; i<nbBoucle; i++){

                if((this.getEchiquier()[y][x+i]).getBateau() == null){

                    result++;
                }else{

                    return result;
                }
            }

        }

        return result;
    }

    public boolean addABateau(Bateau bateau, int x, int y,Orientation o){

        x--;
        y--;

        int resultCaseDispo = nbCaseDispo( x, y, o);

        if(resultCaseDispo >= bateau.getTaille()){


            if( o == Orientation.H){

                for(int i=0; i< bateau.getTaille(); i++){

                    this.echiquier[y+i][x].setBateau(bateau);

                }

            }else{


                for(int i=0; i< bateau.getTaille(); i++){

                    this.getEchiquier()[y][x+i].setBateau(bateau);

                }

            }

        }else{
            System.out.println("Nombre de cases disponible insuffisant ("+resultCaseDispo+")");
            return false;

        }

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
