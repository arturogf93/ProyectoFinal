/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 *@author Abraham Rodriguez, Dagoberto Gonzalez, Arturo Gonzalez, David Valles 

 */
public class Podrida extends Base {

    private final int menos;

    //@param  posX es para saber la posicion x de tipo <code>int</code>
    //@param  posY es para saber la posicion y de tipo <code>int</code>
    //@param  anim para asignarle una animacion al objeto de tipo <code>Animacion</code>
    public Podrida(int posX, int posY, Animacion anim) {
        super(posX, posY, anim);
        menos = -1;
    }

    //@return    regresa menos de tipo <code>int</code>
    public int getMenos() {              //metodo para obtener menos
        return this.menos;
    }
}
