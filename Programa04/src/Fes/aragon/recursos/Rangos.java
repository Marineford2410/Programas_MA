/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.recursos;

/**
 *
 * @author PC6
 */
public class Rangos {

    public boolean rangoaz_AZ(char simbolo) {
        int ascii = (int) simbolo;
        boolean valido = false;
        if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)) {
            System.out.println("ES mayuscula o minuscula");
            valido = true;
        }
        return valido;
    }

    public boolean rangoAZ(char simbolo) {
        int ascii = (int) simbolo;
        boolean valido = false;
        if ((ascii >= 65 && ascii <= 90)) {
            System.out.println("es mayuscula");
            valido = true;
        }
        return valido;
    }

    public boolean rangoaz(char simbolo) {
        int ascii = (int) simbolo;
        boolean valido = false;
        if ((ascii >= 95 && ascii <= 122)) {
            System.out.println("es minuscula");
            valido = true;
        }
        return valido;
    }
    public boolean rango09(char simbolo) {
        int ascii = (int) simbolo;
        boolean valido = false;
        if ((ascii >= 48 && ascii <= 57)) {
            System.out.println("es un numero");
            valido = true;
        }
        return valido;
    }
    public boolean rangoaz_AZ_09(char simbolo) {
        int ascii = (int) simbolo;
        boolean valido = false;
        if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122)||(ascii >= 48 && ascii <= 57)) {
            System.out.println("es mayuscula o minuscula o numero");
            valido = true;
        }
        return valido;
    }
    
    public static void main(String[] args) {
        Rangos r = new Rangos();
        System.out.println(r.rangoaz_AZ_09('5'));
    }
    


}
