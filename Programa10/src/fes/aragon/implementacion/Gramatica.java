package fes.aragon.implementacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Gramatica {

    private Lexico lexico;
    private Tokens token;
    private Reader lector;
    private String resultados = "";
    private int linea = 1;
    private boolean correcto = true;

    public Gramatica(File archivo) throws FileNotFoundException, IOException {
        lector = new BufferedReader(new FileReader(archivo));
        lexico = new Lexico(lector);
    }

    public void metodo_S() throws IOException {

        token = lexico.yylex();
        do {
            //token = lexico.yylex();
            if (token != null && token == Tokens.A) {

                token = lexico.yylex();
                metodo_A();
                if (correcto == true) {
                    resultados = resultados + "\n Linea " + linea + ": correcta.";
                    //linea++;
                }

            } else {

                errorSintactico();
            }
            linea++;
            token = lexico.yylex();
        } while (token != null && correcto != false);
    }

    private void metodo_A() throws IOException {
        if (token != null && token == Tokens.C) {
            token = lexico.yylex();
            metodo_B();

        } else {
            errorSintactico();
        }

    }

    private void metodo_B() throws IOException {
        if (token != null && token == Tokens.B) {
            token = lexico.yylex();
            if (token != null && token == Tokens.PUNTOYCOMA) {
                correcto = true;
            } else {
                errorSintactico();
            }
        } else {
            errorSintactico();
        }
    }

    private void errorSintactico() throws IOException {
        System.out.println("Hay un error...");

        resultados = resultados + "\n Linea " + linea + ": incorrecta.";

        correcto = false;

    }

    public String getResultados() {
        return resultados;
    }
}
