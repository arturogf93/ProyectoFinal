/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectofinal;

/**
 *
 * @author Abraham
 */
public class Podrida extends Base{
    
    private final int menos;
    public Podrida(int posX, int posY, Animacion anim) {
        super(posX, posY, anim);
        menos = -1;
    }
    
    //@return    regresa menos de tipo <code>int</code>
    public int getMenos() {              //metodo para obtener menos
        return this.menos;
    }
}
