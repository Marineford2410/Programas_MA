/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

/**
 *
 * @author pc13
 */
public class Rangos {
    /**
     *   Rangos Codigo ASCII
     *   Mayusculas     65 - 90
     *   Minusculas     97 - 122
     *   Numeros        48 - 57
     */
    
    // Mayusculas y minusculas
    public boolean rangoaz_AZ(char simbolo){
        int ascii = (int)simbolo;
        boolean valido = false;
        if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
            // System.out.println("Valido");
            valido = true;
        }
        return valido;
    }
    
    // Mayusculas
    public boolean rangoAZ(char simbolo){
        int ascii = (int)simbolo;
        boolean valido = false;
        if (ascii >= 65 && ascii <= 90) {
            // System.out.println("Valido");
            valido = true;
        }
        return valido;
    }
    
    // Minusculas
    public boolean rangoaz(char simbolo){
        int ascii = (int)simbolo;
        boolean valido = false;
        if (ascii >= 97 && ascii <= 122) {
            // System.out.println("Valido");
            valido = true;
        }
        return valido;
    }
    
    // Numeros
    public boolean rango09(char simbolo){
        int ascii = (int)simbolo;
        boolean valido = false;
        if (ascii >= 48 && ascii <= 57) {
            // System.out.println("Valido");
            valido = true;
        }
        return valido;
    }
    
    // Mayusculas, munisculas y numeros
    public boolean rangoaz_AZ_09(char simbolo){
        int ascii = (int)simbolo;
        boolean valido = false;
        if ((ascii >= 65 && ascii <= 90) || 
                (ascii >= 97 && ascii <= 122) || 
                    (ascii >= 48 && ascii <= 57)) {
            // System.out.println("Valido");
            valido = true;
        }
        return valido;
    }
    
    // Mayusculas y numeros
    public boolean rangoAZ_09(char simbolo){
        int ascii = (int)simbolo;
        boolean valido = false;
        if ((ascii >= 65 && ascii <= 90) || 
                (ascii >= 48 && ascii <= 57)) {
            // System.out.println("Valido");
            valido = true;
        }
        return valido;
    }
    
    // Munisculas y numeros
    public boolean rangoaz_09(char simbolo){
        int ascii = (int)simbolo;
        boolean valido = false;
        if ((ascii >= 97 && ascii <= 122) || 
                (ascii >= 48 && ascii <= 57)) {
            // System.out.println("Valido");
            valido = true;
        }
        return valido;
    }
    
}
