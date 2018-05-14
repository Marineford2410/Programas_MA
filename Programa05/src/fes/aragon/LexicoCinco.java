/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import javax.swing.JOptionPane;

/**
 * Program No. 5
 * Programarecursivo de la expreisión (a|b|c)*ac*
 * 
 * @author Marco Nava
 */
public class LexicoCinco {
    
    private String sCadena = "";
    private boolean aceptar = false;
    private int error = 0;              
    private int indice = 0;             // Posicion dentro de la cadena
    private int estado = 1;             // Estado Inicial
    private char simbolo;

    public LexicoCinco() {
    }
    
    public boolean analizar() {
        simbolo = siguienteCaracter();
        
        while (simbolo != ' ' || error != 0 ) {            
            switch(estado){
                case 1:
                    if (simbolo == 'a') {
                        estado = 2;
                        aceptar = true;
                    } 
                    else if(simbolo == 'b'){
                        estado = 3;
                    }
                    else if (simbolo == 'c'){
                        estado = 4;
                    }
                    else {
                        error = 0;
                        estado = 6;
                        aceptar = false;
                    }
                    break;
                
                case 2:
                    if (simbolo == 'a') {
                        estado = 2;
                        aceptar = true;
                    } 
                    else if(simbolo == 'b'){
                        estado = 3;
                    }
                    else if (simbolo == 'c'){
                        estado = 5;
                        aceptar = true;
                    }
                    else {
                        error = 0;
                        estado = 6;
                        aceptar = false;
                    }
                    break;
                
                case 3:
                    if (simbolo == 'a') {
                        estado = 2;
                        aceptar = true;
                    } 
                    else if(simbolo == 'b'){
                        estado = 3;
                    }
                    else if (simbolo == 'c'){
                        estado = 4;
                    }
                    else {
                        error = 0;
                        estado = 6;
                        aceptar = false;
                    }
                    break;
                
                case 4:
                    if (simbolo == 'a') {
                        estado = 2;
                        aceptar = true ;
                    } 
                    else if(simbolo == 'b'){
                        estado = 3;
                    }
                    else if (simbolo == 'c'){
                        estado = 4;
                    }
                    else {
                        error = 0;
                        estado = 6;
                        aceptar = false;
                    }
                    break;
                 
                case 5:
                    if (simbolo == 'a') {
                        estado = 2;
                        aceptar = true;
                    } 
                    else if(simbolo == 'b'){
                        estado = 3;
                    }
                    else if (simbolo == 'c'){
                        estado = 5;
                        aceptar = true;
                    }
                    else {
                        error = 0;
                        estado = 6;
                        aceptar = false;
                    }
                    break;
                
                default:
                    aceptar = false;
                    simbolo = ' ';
                    break;
            }
            simbolo = siguienteCaracter();
        }

        return aceptar;
        
    }
    
    // Funcion para comprobar y/u obtener un caracter siguiente en la cadena
    public char siguienteCaracter(){
        char c = ' ';
        // El indice debe ser menor al tamaño de la cadena 
        // de lo contrario ya no abria un caracter siguiente
        if (sCadena.length() > indice) {     
            c = sCadena.charAt(indice);      // Obtienen el siguiente caracter
            indice++;
        }
        return c;
    }

    public void setsCadena(String sCadena) {
        this.sCadena = sCadena;
    }
    
}
