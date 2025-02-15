/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_2.pkg3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Juan Carlos Huerta Llamas
 * @version Lab Algoritmos, 2019.09.17
 */
public class Practica_23 extends Canvas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Pila pila= new Pila();
        
        Scanner scanner= new Scanner(System.in);
        Scanner scannerletra= new Scanner(System.in);
        String color;
        int op,op2;
        do{
            System.out.println("1. Alta de colores");
            System.out.println("2. Bajas de colores");
            System.out.println("3. Mostrar");
            System.out.println("4. Salir");
            System.out.println("Ingresa opcion: ");
            op=scanner.nextInt();
            
            switch(op){
                case 1:
                    System.out.println("Escribe un color");
                    color=scannerletra.nextLine();
                    pila.Altas(color);
                    break;
                case 2:
                    System.out.println("Escribe el color a dar de baja");
                    color=scannerletra.nextLine();
                    pila.Bajas(color);
                    break;
                case 3:
                    System.out.println("1. Mostrar las altas");
                    System.out.println("2. Mostrar las pilas");
                    System.out.println("Ingresa opcion: ");
                    op2=scanner.nextInt();
                    switch(op2){
                        case 1:
                            pila.Mostrarlentamente();
                            pila.Regresarlentamente();
                            pila.Muestratodoelementos();
                            break;
                        case 2:
                            pila.Mostrarestable();
                            pila.Muestratodoelementos();
                            break;
                        default:
                            System.out.println("Opcion invalida");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (op!=4);
        
    }
    
}
