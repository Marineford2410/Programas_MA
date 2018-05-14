/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.implementacion;

import java.io.File;

/**
 *
 * @author makin
 */
public class Creador {
    
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"/src/fes/aragon/implementacion/Reglas.jflex";
        Creador app = new Creador();
        app.crear(path);
    }
    
    public void crear(String path){
        File file=new File(path);
        jflex.Main.generate(file);
}
    
}
