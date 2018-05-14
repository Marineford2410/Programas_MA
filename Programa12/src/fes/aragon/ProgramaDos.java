/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import static fes.aragon.Tokens.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import jdk.nashorn.internal.parser.Scanner;

public class ProgramaDos {

    private String cadena = "";
    private Lexico l;
    private Tokens token;
    private int indice = 0;
    private boolean correcto = false;
    private boolean error = false;

    public void setL(Lexico l) {
        this.l = l;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ProgramaDos p = new ProgramaDos();
        String c = "num;,(num+num),(num*num)+((num)+((num+num*num)*num))+num;,(num);,num;,num*(num)+num;,num65;,minum";
        String[] cadAux = c.split(",");
        for (int i = 0; i < cadAux.length; i++) {
            System.out.print((i+1)+"\t");
            System.out.println(p.analizar(cadAux[i]));
        }
    }

    public String analizar(String n) throws FileNotFoundException, IOException {
        ProgramaDos p = new ProgramaDos();
        p.cadena=n;
        File fichero = new File("Fuente.txt");
        PrintWriter writer;
        writer = new PrintWriter(fichero);
        writer.write(p.cadena);
        writer.close();
        Reader leer = new BufferedReader(new FileReader("Fuente.txt"));
        p.setL(new Lexico(leer));
        p.metodo_S();
        String re="";
        if (p.error) {
            System.out.println("Error de sintasix");
            re = "Error de sintasix";
        } else {
            System.out.println("correcto");
            re="correcto";
        }
        return re;
    }

    private Tokens getToken() throws IOException {
        Tokens tok = l.yylex();
        return tok;
    }

    private void metodo_S() throws IOException {
        token = getToken();
        metodo_E();
        if (token != null && token.equals(PUNTOCOMA)) {
            correcto = true;
        } else {
            error = true;
        }
    }

    private void metodo_E() throws IOException {
        if (token != null && token.equals(PARENTIZQ)) {
            token = getToken();
            metodo_E();
            if (token != null && token.equals(PARENTDER)) {
                token = getToken();
                if (token != null && !token.equals(PUNTOCOMA)) {
                    metodo_X();
                } else if (token != null && !token.equals(PUNTOCOMA) && !error) {
                    error = false;
                }
            } else {
                error = true;
            }
        } else if (token != null && token.equals(NUM)) {
            token = getToken();
            if (token != null && !token.equals(PUNTOCOMA)) {
                metodo_X();
            }
        } else {
            error = true;
        }
    }

    private void metodo_X() throws IOException {
        if (token != null && token.equals(MULT)) {
            token = getToken();
            if (token != null) {
                if (!token.equals(SUMA) && !token.equals(MULT)) {
                    metodo_E();
                    if (token != null) {
                        metodo_X();
                    } else {
                        error = true;
                    }
                } else {
                    error = true;
                }
            } else {
                error = true;
            }
        } else if (token != null && token.equals(SUMA)) {
            token = getToken();
            if (token != null) {
                if (!token.equals(SUMA) && !token.equals(MULT)) {
                    metodo_E();
                    if (token != null) {
                        metodo_X();
                        indice--;
                    } else {
                        error = true;
                    }
                } else {
                    error = true;
                }
            } else {
                error = true;
            }
        }
    }
}
