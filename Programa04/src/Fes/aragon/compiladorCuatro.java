package fes.aragon;

import fes.aragon.recursos.Rangos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class compiladorCuatro {

    private int indice = 0;
    private String cadena = "";
    private char simbolo;
    private boolean error = false;
    private String estado = "0";
    private boolean aceptar = false;

    public static void main(String[] args) {
        

    }
    
    public String analizar(String n){
        Scanner entrada = null;
        String cad = "";
        String re="";
        String[] matCad = null;
        String[][] matArch = null;
        FileReader fr = null;
        BufferedReader br = null;
        File archivo = new File("archivo.txt");
        int estados, transiciones, contador, contadorDos;
        try {
            contador = 0;
            contadorDos = 0;
            estados = 0;
            transiciones = 0;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((cad = br.readLine()) != null) {
                contador++;
                System.out.println(cad);
            }
            matCad = new String[contador];
            contador = 0;
            cad = null;
            entrada = new Scanner(archivo);
            while (entrada.hasNext()) {
                if (contador == 0) {
                    estados = entrada.nextInt();
                }
                if (contador == 1) {
                    transiciones = entrada.nextInt();
                }

                if (estados != 0 && transiciones != 0 && contador == 2) {
                    matArch = new String[estados][transiciones];
                }

                if (contador >= 3 && contadorDos < estados) {
                    cad = entrada.next();
                    matCad = cad.split(",");
                    for (int i = 0; i < matCad.length; i++) {
                        System.out.print(matCad[i] + "\t");
                    }
                    System.out.println();
                    for (int contadortres = 0; contadortres < matCad.length; contadortres++) {
                        matArch[contadorDos][contadortres] = matCad[contadortres];
                    }
                    contadorDos++;
                }
                contador++;
            }
            for (int q = 0; q < estados; q++) {
                for (int h = 0; h < transiciones; h++) {
                    System.out.print(matArch[q][h] + "\t");
                }
                System.out.println();
            }

            //analizador
            compiladorCuatro app = new compiladorCuatro();
            Rangos r = new Rangos();
            int letra = 0;
            int digito = 1;
            int finCadena = 2;
            int estadoT = 0;
            int entradaT = 0;
            app.cadena = n;
            app.simbolo = app.siguienteCaracter();
            while ((app.simbolo != ' ' || !app.estado.equals("aceptar")) && !app.aceptar && !app.error) {
                switch (app.estado) {
                    case "0":
                        if (r.rangoaz_AZ(app.simbolo)) {
                            estadoT = 2;
                            entradaT = letra;
                        } else if (r.rango09(app.simbolo)) {
                            entradaT = digito;
                        } else {
                            entradaT = finCadena;
                        }
                        break;
                    case "1":
                        estadoT = 1;
                        entradaT = digito;
                        app.error=true;
                        break;
                    case "2":
                        if (r.rangoaz_AZ(app.simbolo)) {
                            entradaT = letra;
                            estadoT = 2;
                        } else if (r.rango09(app.simbolo)) {
                            entradaT = digito;
                            estadoT = 2;
                        } else {
                            entradaT = finCadena;
                        }
                        break;
                }
                app.estado = matArch[(estadoT)][entradaT];
                app.simbolo = app.siguienteCaracter();
            }
            
            if (app.estado.equals("aceptar")) {
                app.aceptar=true;
            }
            
            if (!app.aceptar) {
                System.out.println("invalido");
                //JOptionPane.showMessageDialog(null, "invalido");
                re="Invalido";
            } else {
                System.out.println("valido");
                //JOptionPane.showMessageDialog(null, "valido");
                re="valido";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (null != fr) {
                fr.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return re;
    }
    
    private char siguienteCaracter() {
        char c = ' ';
        if (indice < cadena.length()) {
            c = cadena.charAt(indice);
            indice++;
        }
        return c;
    }

}
