package fes.aragon;

import javax.swing.JOptionPane;

/**
 * Programa No. 1
 * Programa con recursividad de la expresión (a|b)*abb 
 * @author Marco Nava
 * 
 */
public class LexicoUno {
    
    private String cadena = "";
    private int indice = 0;
    private final int aceptar = 1;
    private final int error = -1;

    public LexicoUno() {
    }

    public boolean analizar(){
        int valor = estado_A();
        if (valor == aceptar) {
            return true;
        } else {
            return  false;
        }
    }
    
    private char siguienteCaracter(){
        char caracter = ' ';
        if (indice < cadena.length()){
            caracter = cadena.charAt(indice);
            indice++;
        }
        return caracter;
    }

    private int estado_A() {
        char c = siguienteCaracter();
        switch(c){
            case 'a': return estado_B();
            case 'b': return estado_C();
            default: return error;
        }
    }

    private int estado_B() {
        char c = siguienteCaracter();
        switch(c){
            case 'a': return estado_B();
            case 'b': return estado_D();
            default: return error;
        }
    }

    private int estado_C() {
        char c = siguienteCaracter();
        switch(c){
            case 'a': return estado_B();
            case 'b': return estado_C();
            default: return error;
        }
    }

    private int estado_D() {
        char c = siguienteCaracter();
        switch(c){
            case 'a': return estado_B();
            case 'b': return estado_E();
            default: return error;
        }
    }

    private int estado_E() {
        char c = siguienteCaracter();
        switch(c){
            case 'a': return estado_B();
            case 'b': return estado_C();
            case ' ': return aceptar;
            default: return error;
        }
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
}
