package fes.aragon;

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

    // Contructor
    public Gramatica(File archivo) throws FileNotFoundException, IOException{ 
            lector = new BufferedReader(new FileReader(archivo));
            lexico = new Lexico(lector);
    }
    
    public void programa() throws IOException{
        getToken();
            // System.out.println(token);
            if (token != null) {
                secuencia();
            }
    }
    
    public void secuencia() throws IOException{
        System.out.println("Sentencias...");
        do {            
            expresion();
            if (token != Tokens.PUNTOYCOMA) {
                errorSintactico();
            }
            else{
                resultados = resultados + "\n Linea " + linea + ": correcta.";
                linea++;
            }
            token = lexico.yylex();
        } while (token != null && correcto != false);
    }

    public void expresion() throws IOException{
        expSimple();
        if (token == Tokens.IGUAL || token == Tokens.ME || token == Tokens.MEI ||
                token == Tokens.DIST || token == Tokens.MAI || token == Tokens.MA) {
            getToken();
            expSimple();
        }
    }
    
    public void expSimple() throws IOException{
        if (token == Tokens.MAS || token == Tokens.MENOS) {
            getToken();
        }
        termino();
        while (token == Tokens.MAS || token == Tokens.MENOS || token == Tokens.OR) {            
            getToken();
            termino();
        }
    }
    
    public void termino() throws IOException{
        factor();
        while (token == Tokens.POR || token == Tokens.DIV || token == Tokens.DIVENT
                || token == Tokens.MOD || token == Tokens.AND) {            
            getToken();
            factor();
        }
    }
    
    public void factor() throws IOException{
        switch(token){
            case ID:
                getToken();
                break;
            
            case NUM:
                getToken();
                break;
                
            case NOT:
                getToken();
                factor();
                break;
            
            case PARENTIZQ:
                getToken();
                expresion();
                if (token != Tokens.PARENTDER) {
                    errorSintactico();
                }
                else{
                    getToken();
                }
            
            default:
                errorSintactico();
                break;
        }
    }
    
    private void errorSintactico() throws IOException {
        System.out.println("Hay un error...");
        /*while (token != Tokens.PUNTOCOMA) {   
            System.out.println(token);*/
            resultados = resultados + "\n Linea " + linea + ": incorrecta.";
            /*linea++;
            token = lexico.yylex();
        }*/
        correcto = false;
    }

    public String getResultados() {
        return resultados;
    }
    
    public void getToken() throws IOException{
        token = lexico.yylex();
    }
    
}
