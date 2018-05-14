/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import java.io.File;

/**
 *
 * @author pc13
 */
public class Creador {
    
    public static void main(String[] args) {
        String ruta = System.getProperty("user.dir")+"/src/fes/aragon/Reglas.jflex";
        Creador app =  new Creador();
        app.crear(ruta);
    }
    
    private void crear(String ruta){
        File file = new File(ruta);
        jflex.Main.generate(file);
    }
}
