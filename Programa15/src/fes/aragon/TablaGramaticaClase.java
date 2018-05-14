/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Dialid
 */
public class TablaGramaticaClase {

    public String cadena = JOptionPane.showInputDialog("Dame la cadena:");
    private int indice = 0;
    private int indice1;
    private boolean funciona = false;
    char c;
    private String[][] tabla = 
    {{"ABC", "ABC", "ABC", "ABC", "e"},
    {" ", "b", "c", " ", "e"},
    {"abC", "e", "e ", "  ", "e"},
    {"e", "e", "e", "d", "e"}};
    private Object[] terminal = {"a", "b", "c", "d", ";"};
    private Object[] noTerminal = {"S", "A", "B", "C"};
    private Stack pilas = new Stack();
    private Object tmp;

    public void pila() {
        System.out.println(cadena);
        pilas.push(terminal[terminal.length - 1]);
        pilas.push(noTerminal[0]);
        c = get_Char();
        S(c);
        evaluar(c);
        funciona = true;
        while (funciona == true) {
            switch (c) {
                case 'a':
                    evaluar2(c);
                    pilas.pop();
                    c = get_Char();
                    System.out.println(c);
                    funciona = true;
                    break;
                case 'b':
                    pilas.pop();
                    c = get_Char();
                    funciona = true;
                    break;
                case 'c':
                    tmp = terminal[2];
                    if (pilas.peek() == tmp) {
                        pilas.pop();
                        c = get_Char();
                        funciona = true;
                    } else {
                        funciona = false;
                        error();
                    }

                    break;
                case 'd':
                    System.out.println(pilas.peek());
                    Object h = 'B';
                    tmp = 'C';
                    if (pilas.peek() == terminal[3]) {
                        pilas.pop();
                        c = get_Char();
                        funciona = true;
                    } else if (pilas.peek() == h) {
                        pilas.pop();
                        evaluar3(c);
                        funciona = true;
                    } else if (pilas.peek() == tmp) {
                        evaluar3(c);
                        funciona = true;
                    } else {
                        funciona = false;
                    }

                    break;
                case ';':
                    if (pilas.peek() == terminal[terminal.length - 1]) {
                        pilas.pop();
                        JOptionPane.showMessageDialog(null, "Cadena correcta");

                    } else {
                        if (!pilas.empty()) {
                            error();
                        }
                    }
                    //error();
                    funciona = false;
                    break;
                default:
                    //error();
                    funciona = false;
                    break;
            }
            System.out.println(pilas);
        }

    }

    public void S(char c) {
        indice = 1;
        switch (c) {
            case 'a': {
                pilas.pop();
                String cr = tabla[0][0];
                System.out.println(cr);
                for (int i = 0; i < cr.length(); i++) {
                    char[] t = cr.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;

                }
                break;
            }
            case 'b': {
                pilas.pop();
                String cr = tabla[0][1];
                System.out.println(cr);
                for (int i = 0; i < cr.length(); i++) {
                    char[] t = cr.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;
                }
                break;
            }
            case 'c': {
                pilas.pop();
                String cr = tabla[0][2];
                System.out.println(cr);
                for (int i = 0; i < cr.length(); i++) {
                    char[] t = cr.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;
                }
                break;
            }
            case 'd': {
                pilas.pop();
                String cr = tabla[0][3];
                System.out.println(cr);
                for (int i = 0; i < cr.length(); i++) {
                    char[] t = cr.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;
                }
                break;
            }
            case ';':
                funciona = false;
                break;
            default:
                error();
                break;
        }
        System.out.println(pilas);
    }

    public void evaluar(char c) {
        Object ad;
        switch (c) {
            case 'a':
                pilas.pop();
                break;
            case 'b':
                ad = terminal[1];
                pilas.pop();
                pilas.push(ad);
                break;
            case 'c':
                ad = terminal[2];
                pilas.pop();
                pilas.push(ad);
                break;
            case 'd':
                pilas.pop();
                break;
            case ';':
            //error();
            default:
                error();
        }
        System.out.println(pilas);
    }

    public void evaluar2(char c) {
        Object ad;
        String f;
        indice = 1;
        switch (c) {
            case 'a':
                pilas.pop();
                ad = tabla[2][0];
                System.out.println(ad);
                f = (String) ad;
                for (int i = 0; i < f.length(); i++) {
                    char[] t = f.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;
                }
                System.out.println(pilas);
                break;
            case 'b':
                error();
                break;
            case 'c':
                error();
                break;
            case 'd':
                pilas.pop();
            case ';':
                funciona = false;
                //error();
                break;
            default:
                error();
        }

    }

    public void evaluar3(char c) {
        Object ad;
        switch (c) {
            case 'a':
                error();
                break;
            case 'b':
                error();
                break;
            case 'c':
                error();
                break;
            case 'd':
                pilas.pop();
                ad = terminal[3];
                pilas.push(ad);
            case ';':
                //error();
                break;
            default:
                error();
        }
    }

    public void error() {
        JOptionPane.showMessageDialog(null, "Error");
    }

    public char get_Char() {
        char[] charCadena = cadena.toCharArray();
        char c = 0;
        if (indice1 < charCadena.length) {
            c = charCadena[indice1];
            indice1++;
        }
        return c;

    }

    public static void main(String[] args) {
        TablaGramaticaClase apa = new TablaGramaticaClase();
        apa.pila();
    }

}
