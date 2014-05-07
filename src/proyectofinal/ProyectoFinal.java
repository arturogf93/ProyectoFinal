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

/**
 * Sirve para crear el juego en forma de Jframe
 */
public class ProyectoFinal {

    /**
     *
     * Metodo que sivre para el main
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Juego variable;
        variable = new Juego();
        variable.setVisible(true);
        variable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
