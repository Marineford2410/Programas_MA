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
public class DiagramaDiapositivas {

    public String cadena = JOptionPane.showInputDialog(null, "Insertar cadena", "Programa 14", JOptionPane.QUESTION_MESSAGE);
    private int indice = 0;
    private int indice1;
    private boolean err = false;
    char c;

    private final String[][] TABLA = {{"AB", "AB", "e", "e", "e"},
    {"a", "A", "e", "e", "e"},
    {"e", "bCd", "e ", "e", "e"},
    {"e", "e", "C", " ", "e"}};

    private final Object[] TERMINAL = {"a", "b", "c", "d", ";"};

    private final Object[] NO_TERMINAL = {"S", "A", "B", "C"};

    private Stack pilas = new Stack();
    private Object tmp;

    public void pila() {
        System.out.println(cadena);
        pilas.push(TERMINAL[TERMINAL.length - 1]);
        pilas.push(NO_TERMINAL[0]);
        c = siguienteCaracter();
        metodo_S(c);
        evaluar(c);
        err = true;
        int control = 0;
        Object tm, t;
        System.out.println(pilas);
        while (err == true) {
            switch (c) {
                case 'a':
                    tmp = TERMINAL[0];
                    if (pilas.peek() == tmp) {
                        pilas.pop();
                        c = siguienteCaracter();
                        err = true;
                    } else {
                        err = false;
                    }
                    break;
                case 'b':
                    tmp = 'A';
                    tm = 'B';
                    t = 'b';
                    if (pilas.peek() == tmp) {
                        evaluar(c);
                        err = true;
                        control++;
                        if (control == 2) {
                            err = false;
                        }
                    } else if (pilas.peek() == tm) {
                        //pilas.pop();
                        evaluar2(c);
                    } else if (pilas.peek() == t) {
                        pilas.pop();
                        c = siguienteCaracter();
                        err = true;
                    } else {
                        err = false;
                    }
                    break;
                case 'c':
                    control = 0;
                    tmp = 'C';
                    tm = 'B';
                    t = 'c';
                    if (pilas.peek() == tm) {
                        evaluar2(c);
                        err = false;
                    } else if (pilas.peek() == tmp) {
                        //pilas.pop();
                        evaluar3(c);
                        err = false;
                        rutinaError();
                    } else if (pilas.peek() == t) {
                        pilas.pop();
                        c = siguienteCaracter();
                        err = true;
                    } else {
                        err = false;
                    }

                    break;
                case 'd':
                    tmp = 'B';
                    tm = 'C';
                    t = 'd';
                    if (pilas.peek() == tmp) {
                        pilas.pop();
                        evaluar2(c);
                        err = false;
                    } else if (pilas.peek() == tm) {
                        evaluar3(c);
                        err = true;
                    } else if (pilas.peek() == t) {
                        pilas.pop();
                        c = siguienteCaracter();
                        err = true;
                    } else {
                        err = false;
                        rutinaError();
                    }
                    break;
                case ';':
                    t = ';';
                    if (pilas.peek() == TERMINAL[TERMINAL.length - 1]) {
                        pilas.pop();
                        JOptionPane.showMessageDialog(null, "Cadena correcta", "Programa 14", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        if (!pilas.empty()) {
                            rutinaError();
                        }
                    }
                    err = false;
                    break;
                default:

                    break;
            }
            System.out.println(pilas);
        }
    }

    public void metodo_S(char c) {
        indice = 1;
        switch (c) {
            case 'a': {
                pilas.pop();
                String cr = TABLA[0][0];
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
                String cr = TABLA[0][1];
                System.out.println(cr);
                for (int i = 0; i < cr.length(); i++) {
                    char[] t = cr.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;
                }
                break;
            }
            case 'c': {
                rutinaError();
                break;
            }
            case 'd': {
                rutinaError();
                break;
            }
            case ';':
                rutinaError();
                break;
            default:
                rutinaError();
                break;
        }
        System.out.println(pilas);
    }

    public void evaluar(char c) {
        Object ad;
        switch (c) {
            case 'a':
                ad = TERMINAL[0];
                pilas.pop();
                pilas.push(ad);
                break;
            case 'b':
                ad = NO_TERMINAL[1];
                pilas.pop();
                pilas.push(ad);
                break;
            case 'c':
                rutinaError();
                break;
            case 'd':
                rutinaError();
                break;
            case ';':
            //error();
            default:
                rutinaError();
        }
        System.out.println(pilas);
    }

    public void evaluar2(char c) {
        Object ad;
        String f;
        indice = 1;
        switch (c) {
            case 'a':
                rutinaError();
                break;
            case 'b':
                pilas.pop();
                ad = TABLA[2][1];
                System.out.println(ad);
                f = (String) ad;
                for (int i = 0; i < f.length(); i++) {
                    char[] t = f.toCharArray();
                    pilas.push(t[t.length - indice]);
                    indice++;
                }
                break;
            case 'c':
                rutinaError();
                break;
            case 'd':
                rutinaError();
                break;
            case ';':
                err = false;
                //error();
                break;
            default:
                rutinaError();
        }

    }

    public void evaluar3(char c) {
        Object ad;
        switch (c) {
            case 'a':
                rutinaError();
                break;
            case 'b':
                rutinaError();
                break;
            case 'c':
                ad = NO_TERMINAL[3];
                pilas.pop();
                pilas.push(ad);
                break;
            case 'd':
                pilas.pop();
                break;
            case ';':
                //error();
                break;
            default:
                rutinaError();
        }
    }

    public char siguienteCaracter() {
        char[] charCadena = cadena.toCharArray();
        char c = 0;
        if (indice1 < charCadena.length) {
            c = charCadena[indice1];
            indice1++;
        }
        return c;

    }

    public void rutinaError() {
        JOptionPane.showMessageDialog(null, "Error", "Programa 13", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        DiagramaDiapositivas app = new DiagramaDiapositivas();
        app.pila();
    }
}
