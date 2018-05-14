package fes.aragon;

import java.io.File;


public class Creador {
    
    public static void main(String[] args) {
        String ruta = System.getProperty("user.dir")+"/src/fes/aragon/Reglas.jflex";
        Creador app =  new Creador();
        app.crear(ruta);
    }
    
    private void crear(String ruta){
        File f = new File(ruta);
        jflex.Main.generate(f);
    }
}
