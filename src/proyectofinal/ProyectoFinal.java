/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectofinal;

/**
 *
 * @author Gonzalez
 */

import java.io.IOException;
import javax.swing.JFrame;

public class ProyectoFinal {

    /**    hola
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws IOException {
        Juego variable;
        variable = new Juego();
        variable.setVisible(true);
        variable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
