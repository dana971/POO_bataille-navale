package com.bataille.navale;

import com.bataille.navale.BO.Bateau;
import com.bataille.navale.BO.Etat;
import com.bataille.navale.BO.Orientation;
import com.bataille.navale.BO.Plateau;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int colonnes;
        int lignes;

        //Saisie du nombre de colonnes

        Scanner scan = new Scanner(System.in);
        System.out.println("Saisissez le nombre de colonnes désirez");
        String nbString = scan.nextLine().strip();

        while (!isInteger(nbString) || Integer.parseInt(nbString) < 5) {

            System.out.println("Saisissez le nombre de colonnes désirez");
            nbString = scan.nextLine().strip();

        }
        colonnes = Integer.parseInt(nbString);

        //Saisie du nombre de lignes

        System.out.println("Saisissez le nombre de lignes désirez");
        nbString = scan.nextLine().strip();

        while (!isInteger(nbString) || Integer.parseInt(nbString) < 5){

            System.out.println("Saissiez le nombre de lignes désirez");
            nbString = scan.nextLine().strip();
        }
        lignes = Integer.parseInt(nbString);

        System.out.println("colonnes: " +colonnes+ " lignes: "+lignes);

        //Création du plateau
        List<Plateau> plateauList = new ArrayList<>();

        //Affichage du plateau
        plateauList.add(new Plateau());
        plateauList.add(new Plateau());

        int tours = 1;

        for (Plateau plateauJoueur:plateauList) {

            plateauJoueur.setColonnes(colonnes);
            plateauJoueur.setLignes(lignes);
            plateauJoueur.init();


            //Présentation des bateaux a placer

            List<Bateau> listeDeBateauxDisponibles = new ArrayList<>();

            listeDeBateauxDisponibles.add(new Bateau("Porte-avion",'P',5, Etat.I));
            listeDeBateauxDisponibles.add(new Bateau("Croiseur",'C',4, Etat.I));
            listeDeBateauxDisponibles.add(new Bateau("Contre-Torpilleur",'K',3, Etat.I));
            listeDeBateauxDisponibles.add(new Bateau("Sous-Marin",'S',3, Etat.I));
            listeDeBateauxDisponibles.add(new Bateau("Torpilleur",'T',2, Etat.I));

            while ( !listeDeBateauxDisponibles.isEmpty()) {

                listeDeBateauxDisponibles.forEach(b -> {
                    System.out.println(b);
                });


                //Choix du bateau avec le pion


                System.out.println("Choisissez un bateau selon son pion");
                String stringPion = scan.nextLine().strip();


                while (!listeDeBateauxDisponibles.stream().map(Bateau::getPion).toList().contains(stringPion.toUpperCase().charAt(0))) {

                    System.out.println("Choisissez un bateau selon les pions proposés !");
                    listeDeBateauxDisponibles.forEach(b -> {
                        System.out.println(b);
                    });
                    stringPion = scan.nextLine().strip();

                }


                String finalStringPion = stringPion;
                Bateau bateau = listeDeBateauxDisponibles.stream().filter(b -> b.getPion() == finalStringPion.toUpperCase().charAt(0)).findAny().orElse(null);
                listeDeBateauxDisponibles.remove(bateau);

                //Choix de l'Orientation du plateau

                System.out.println("Choissisez l'Orientation du plateau, Horizontale (H) ou Verticale (V)");
                String stringOrientation = scan.nextLine().strip();

                Orientation orientation;

                while (!Arrays.asList(new String[]{"H", "V"}).stream().anyMatch(stringOrientation::equalsIgnoreCase)) {

                    System.out.println("Choissisez une orientation valide, Horizontale (H) ou Verticale (V)");

                    stringOrientation = scan.nextLine().strip();
                }

                orientation = Orientation.valueOf(stringOrientation.toUpperCase());

                //Choix de l'emplacement du bateau


                System.out.println("Choissisez l'emplacement de votre bateau en colonne, plateau: "+tours);
                nbString = scan.nextLine().strip();

                int x;

                while (!isInteger(nbString) || Integer.parseInt(nbString) > colonnes || Integer.parseInt(nbString) < 0) {

                    System.out.println("Choissisez une colonne valide pour votre bateau, plateau: "+tours);
                    nbString = scan.nextLine().strip();
                }
                x = Integer.parseInt(nbString);


                //Choix du positionnement - lignes

                System.out.println("Choissisez l'emplacement de votre bateau en ligne, plateau: "+tours);
                nbString = scan.nextLine().strip();

                int y;

                while (!isInteger(nbString) || Integer.parseInt(nbString) > lignes || Integer.parseInt(nbString) < 0) {

                    System.out.println("Choissisez une ligne valide pour votre bateau, plateau: "+tours);
                    nbString = scan.nextLine().strip();
                }
                y = Integer.parseInt(nbString);


                plateauJoueur.addABateau(bateau, x, y, orientation);
                plateauJoueur.draw();

            } tours++;
        }

    }



    public static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


}