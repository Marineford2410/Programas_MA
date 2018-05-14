/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

/**
 * Programa No, 2
 * Analizador Lexico que reconoce letras y digitos 
 * @author Marco Nava
 */
public class LexicoDos {
    
    private String cadena = "";     // Guardara la cadena ha comprobar
    private boolean aceptar = false;
    private int error = 0;
    private int indice = 0;         // Posicion dentro de la cadena
    private int estado = 1;
    private char simbolo;

    public LexicoDos() {
    }
    
    public boolean analizar() {
        Rangos rango = new Rangos();
        simbolo = siguienteCaracter();
        
        while (simbolo !=' ' || error != 0) {            
            switch(estado){
                case 1:
                    if (rango.rangoaz_AZ(simbolo)) {
                        estado = 3;
                    }
                    else if(rango.rango09(simbolo)){
                        estado = 2;
                    }
                    else {
                        error = 0;
                        estado = 4;
                    }
                    break;
                    
                case 2:
                    error = 0;
                    estado = 4;
                    break;
                    
                case 3:
                    if (rango.rangoaz_AZ(simbolo)) {
                        estado = 3;
                        aceptar = true;
                    }
                    else if(rango.rango09(simbolo)){
                        estado = 3;
                        aceptar = true;
                    }
                    else {
                        estado = 4;
                        error = 0;
                        aceptar = false;
                    }
                    break;
                    
                default:
                    error = 0;
                    aceptar = false;
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
        if (cadena.length() > indice) {     
            c = cadena.charAt(indice);      // Obtienen el siguiente caracter
            indice++;
        }
        return c;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
}
