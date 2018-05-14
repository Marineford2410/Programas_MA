/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import javax.swing.JOptionPane;

/**
 * Programa No. 3
 * Analizador Lexico basado en una Tabla de Transicion (Estatico)
 * @author Marco Nava
 */
public class LexicoTres {

    private final String[][] tabla = {{"3",    "2",     "error"}, 
                                     {"error", "error", "error"}, 
                                     {"3",     "3",     "aceptar"}};
    
    private String valor = "";          // Cotendra el valor almacenado dentro de la tabla
    private String sCadena;             // Cadena a comprobar
    private boolean aceptar = false;
    private boolean error = false;              
    private int indice = 0;             // Posicion dentro de la cadena
    private int estado = 0;             // Indice de la fila de la tabla. Estado Inicial -> 0
    private char simbolo;
    private int columna;                // Indice para la columna de la tabla. 
                                        // Columna 0 -> Letraa
                                        // Columna 1 -> Digitos
                                        // Columna 2 -> Final de Cadena
    
    public LexicoTres() {
    }
    
    public boolean analizar() {
        Rangos rango = new Rangos();
        
        simbolo = siguienteCaracter();
        
        while (!valor.equals("aceptar") && error != true) {   
            if (rango.rangoaz_AZ(simbolo)) {
                columna = 0;
                siguienteEstado();
            }
            else if (rango.rango09(simbolo)) {
                columna = 1;
                siguienteEstado();
            } 
            else if (simbolo == ' ') {
                columna = 2;
                siguienteEstado();
            }
            else{
                error = true;
            }
            
            simbolo = siguienteCaracter();
        }
        
        return aceptar;
    }
    
    public void siguienteEstado(){
        valor = tabla[estado][columna];
              
        try {
            estado = Integer.parseInt(valor) - 1;           
        } catch (NumberFormatException e) {
            if (valor.equals("error")){
                error = true;
            }
            else if (valor.equals("aceptar")) {
                aceptar = true;
            }
            else{
                error = true;
            }
        }
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
