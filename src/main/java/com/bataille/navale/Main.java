  package com.bataille.navale;

  import com.bataille.navale.BO.Bateau;
  import com.bataille.navale.BO.Etat;
  import com.bataille.navale.BO.Plateau;

  import java.util.Scanner;

  // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int colonnes;
        int lignes;

        Scanner scan = new Scanner(System.in);
        System.out.println("Saisissez le nombre de colonnes désirez");
        String nbString = scan.nextLine().strip();

        while (!isInteger(nbString) || Integer.parseInt(nbString) < 5) {

            System.out.println("Saisissez le nombre de colonnes désirez");
            nbString = scan.nextLine().strip();

        }
         colonnes = Integer.parseInt(nbString);


        System.out.println("Saisissez le nombre de lignes désirez");
        nbString = scan.nextLine().strip();

        while (!isInteger(nbString) || Integer.parseInt(nbString) < 5){

            System.out.println("Saissiez le nombre de lignes désirez");
            nbString = scan.nextLine().strip();
        }
        lignes = Integer.parseInt(nbString);

        System.out.println("colonnes: " +colonnes+ " lignes: "+lignes);


        Plateau plateauJoueur1 = new Plateau(colonnes, lignes);
        Bateau porteAvion = new Bateau("Porte-avion",'P',5, Etat.I);
        Bateau croiseur = new Bateau("Croiseur",'C',4, Etat.I);
        Bateau contreTorpilleur = new Bateau("Contre-Torpilleur",'K',3, Etat.I);
        Bateau sousMarin = new Bateau("Sous-Marin",'S',3, Etat.I);
        Bateau torpilleur = new Bateau("Torpilleur",'T',2, Etat.I);
        plateauJoueur1.addABateau(porteAvion);
        plateauJoueur1.draw();





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