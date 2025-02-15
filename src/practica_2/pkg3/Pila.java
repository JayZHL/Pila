/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_2.pkg3;

import java.util.Stack;


/**
 *
* @author Juan Carlos Huerta Llamas
 *@version Lab Algoritmos, 2019.09.17
 */
public class Pila {
    Stack<Square> pila= new Stack();
    Stack<Square> pila2= new Stack();
    Square cuadrado;

    public Pila() {
        
    }
    
    
    /**
     * Aqui se empiezan a dar las altas de los colores, se verifica que si la pila
     * ya tiene valores y comprueba que los colores sean validos y ningun color
     * se repita
     * @param color 
     */
    public void Altas(String color){
        boolean bandera=Compruebacolores(color);
        boolean bandera2=Compruebaelemento(color);
        if(bandera){
            if(pila.isEmpty()){
                cuadrado= new Square(60,200,500,color,true);
                cuadrado.makeInvisible();
                pila.push(cuadrado);
                
            }else{
                if(!bandera2){
                int posx= pila.peek().getxPosition();
                int posy=pila.peek().getyPosition();
                int posn= (int) (Math.sqrt((posx * posx) + (posy * posy)));
                cuadrado= new Square(60,200,posn-105,color,true);
                cuadrado.makeInvisible();
                pila.push(cuadrado);
                }else{
                    System.out.println("El color ya esta dado de alta");
                }
            }
        }else{
            System.out.println("No existe el color");
        }
    }
    
    
    /**
     *Aqui es donde se dan de baja los colores de la pila, se verifica que la
     * pila no este vacia y los colores sean validos y no se repitan, cuando se
     * da de baja un color se muestra y se quita su representancion graficamente
     * y en el stack
     * @param color 
     */
    public void Bajas(String color){
        boolean bandera=false;
        boolean bandera2=false;
        if(pila.isEmpty()){
            System.out.println("Vacio");
        }else{
        
            bandera=Compruebacolores(color);
            if(bandera){
                bandera2=Compruebaelemento(color);
                if(bandera2){
            Mostrarlentamente();
            for(int i=pila.size()-1; i>=0;i--){
                 if(pila.get(i).color.equalsIgnoreCase(color)){
                     pila.get(i).slowMoveHorizontal(-100);
                     pila.get(i).erase();
                     pila.pop();
                     break;
                 }else{
                     pila.get(i).slowMoveHorizontal(-100);
                     pila.get(i).erase();
                     pila2.push(pila.pop());
                 }
                 
                }
            
           for(int k=-1; k<=pila2.size()+1;k++){
                if(!pila.isEmpty()&&!pila2.isEmpty()){
                int posx=pila.peek().getxPosition();
                int posy=pila.peek().getyPosition();
                int posn=(int) (Math.sqrt((posx * posx) + (posy * posy)));
                cuadrado= new Square(60,200,posn-105,pila2.peek().getColor(),true);
                cuadrado.makeVisible();
                cuadrado.slowMoveHorizontal(100);
                pila.push(cuadrado);
                pila2.pop();
                }else if(pila2.isEmpty()){
                    //k--;
                    break;
                }
              
                else if(pila.isEmpty()){
                   cuadrado= new Square(60,200,500,pila2.peek().getColor(),true);
                   cuadrado.makeVisible();
                   cuadrado.slowMoveHorizontal(100);
                   pila.push(cuadrado);
                   pila2.pop();
                   k--;
                }

            }
            Regresarlentamente();
                }else{
                    System.out.println("El color no se ha dado de alta");
                }
            }else{
                System.out.println("Color invalido");
            }
        }
    }
    /**
     * Muestra lentamente las pilas
     */
    public void Mostrarlentamente(){
        if(pila.isEmpty()){
            System.out.println("Pila Vacia");
        }else{
        for(int a=0;a<=pila.size()-1;a++){
            pila.get(a).makeVisible();
            pila.get(a).slowMoveHorizontal(100);
        }
        }

    }
    /**
     * Regresa lentamente las pilas
     */
    public void Regresarlentamente(){
        if(pila.isEmpty()){
            System.out.println("Pila Vacia");
        }else{
        for(int a=0;a<=pila.size()-1;a++){
            pila.get(a).slowMoveHorizontal(-100);
            pila.get(a).makeInvisible();
        }
        }
    }
    
    /**
     * Muestra la pila actual
     */
    public void Mostrarestable(){
        if(pila.isEmpty()){
            System.out.println("Pila Vacia");
        }else{
         for(int a=0;a<=pila.size()-1;a++){
            pila.get(a).makeVisible();
        }
        }
    }
    
    /**
     * Muestra el elemento que hasta arriba en la pila
     * @return 
     */
    public String Peek(){
        return pila.peek().toString();
    }
 
    
    /**
     * Aqui se comprueba que los colores sean validos, retorna falso si no
     * @param color
     * @return 
     */
    public boolean Compruebacolores(String color){
        if(color.equalsIgnoreCase("rojo")||color.equalsIgnoreCase("verde")
                ||color.equalsIgnoreCase("amarillo")||color.equalsIgnoreCase("azul")
            ||color.equalsIgnoreCase("negro")||color.equalsIgnoreCase("blanco")||
                color.equalsIgnoreCase("magenta")|| color.equalsIgnoreCase("naranja")
                || color.equalsIgnoreCase("rosa")||color.equalsIgnoreCase("gris")
                ||color.equalsIgnoreCase("cian")||color.equalsIgnoreCase("cafe")){
                return true;
            }else{
            return false;
        }
    }
    /**
     * Aqui se comprueba si el color ya existe en la pila
     * @param color
     * @return 
     */
    public boolean Compruebaelemento(String color){
        boolean bandera=false;
        for(int i=0; i<pila.size();i++){
            if(pila.get(i).color.equalsIgnoreCase(color)){
                bandera=true;
            }
        }
        if(bandera){
            return true;
        }else{
            return false;
        }
    }
    
    
    /**
     * Imprime todos los elementos de la pila 
     */
    public void Muestratodoelementos(){
        if(pila.isEmpty()){
            System.out.println("Pila Vacia");
        }else{
        for(int i=0; i<pila.size();i++){
            System.out.println(pila.get(i));
        }
        }
    }
    

}
