  package com.bataille.navale;

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
        String nbString = scan.nextLine();

        while (!isInteger(nbString) || Integer.parseInt(nbString) < 5) {

            System.out.println("Saisissez le nombre de colonnes désirez");
            nbString = scan.nextLine();

        }
         colonnes = Integer.parseInt(nbString);


        System.out.println("Saisissez le nombre de lignes désirez");
        nbString = scan.nextLine();

        while (!isInteger(nbString) || Integer.parseInt(nbString) < 5){

            System.out.println("Saissiez le nombre de lignes désirez");
            nbString = scan.nextLine();
        }
        lignes = Integer.parseInt(nbString);

        System.out.println("colonnes: " +colonnes+ " lignes: "+lignes);


        Plateau plateauJoueur1 = new Plateau(colonnes, lignes);
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