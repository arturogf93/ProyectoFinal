/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author Abraham Rodriguez, Dagoberto Gonzalez, Arturo Gonzalez, David Valles  *
 */
/**
 * La clase podrida es para manejar las comidas malas que te hacen perder vidas,
 * Mneja su posicion y su animacion
 */
public class Podrida extends Base {

    private final int menos;

    /**
     * Constructor de Podrida
     * @param posX es para saber la posicion x de tipo <code>int</code>
     * @param posY es para saber la posicion y de tipo <code>int</code>
     * @param anim para asignarle una animacion al objeto de tipo <code>Animacion</code>
     */
    public Podrida(int posX, int posY, Animacion anim) {
        super(posX, posY, anim);
        menos = -1;
    }

    /**
     * Metodo para obtener la variable menos
     * @return regresa menos de tipo <code>int</code> 
     */
    public int getMenos() {              //metodo para obtener menos
        return this.menos;
    }
}
