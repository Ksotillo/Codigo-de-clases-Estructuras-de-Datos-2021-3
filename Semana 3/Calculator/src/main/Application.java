/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Ksotillo
 */
public class Application {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.println("-------------Bienvenido a mi Calculadora-------------");
        boolean runAgain;
        do {
            System.out.println("¿Qué operación deseas realizar?");
            System.out.println(
                        "1 - Suma \n"
                       + "2 - Resta \n"
                       + "3 - Multiplicación \n"
                       + "4 - División \n"
                       + "5 - Potencia\n"
                       + "6 - Valor Absoluto");
            String response = sc.nextLine();

            System.out.println("Ingrese el primer numero:");
            double num1 = sc.nextDouble();
            double num2 = 0;
            if (Integer.valueOf(response) < 6) {
                System.out.println("Ingrese el segundo numero:");
                num2 = sc.nextDouble();
            }
            sc.nextLine();
            double result = 0;
            String operation = "";
            
            switch(response) {
                case "1":
                    result = calc.sum(num1, num2);
                    operation = num1 + " + " + num2;
                    break;
                case "2":
                    result = calc.substraction(num1, num2);
                    operation = num1 + " - " + num2;
                    break;
                case "3":
                    result = calc.multi(num1, num2);
                    operation = num1 + " * " + num2;
                    break;
                case "4":
                    result = calc.division(num1, num2);
                    operation = num1 + " / " + num2;
                    break;
                case "5":
                    result = calc.pow(num1, num2);
                    operation = num1 + " ^ " + num2;
                    break;
                case "6":
                    result = calc.abs(num1);
                    operation = "Valor absoluto de " + num1;
                    break;
                default:
                    System.out.println("Ingresaste una opcion invalida");
                    break;

            }

            System.out.println("El resultado de la operación " + operation + " es " + result);
            System.out.println("¿Te gustaría hacer una nueva operación? (s/n)");
//            String wouldLikeToContinue = ;
            runAgain = sc.nextLine().equalsIgnoreCase("s");
        } while(runAgain);
        System.out.println("Gracias por usar mi calculadora :)");
        
        
    }
    
}
