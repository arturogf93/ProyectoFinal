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
 * La clase Base maneja la posicion y las animaciones de cada tipo de enemigo,
 * ademas de su velocidad
 */
public class Enemigo extends Base {

    private int velocidad;

    /**
     * 
     * @param posX es para saber la posicion x de tipo <code>int</code>
     * @param posY es para saber la posicion y de tipo <code>int</code>
     * @param anim para asignarle una animacion al objeto de tipo <code>Animacion
     * @param velocidad es la velocidad nueva de tipo <code>int</code>
     */
    public Enemigo(int posX, int posY, Animacion anim, int velocidad) {
        super(posX, posY, anim);
        this.velocidad = velocidad;
    }

    /**
     * 
     * @param velocidad es para saber la velocidad de tipo <code>int</code>
     */
    public void setVelocidad(int velocidad) {     //metodo para asignar valor a velocidad
        this.velocidad = velocidad;
    }

    /**
     * 
     * @return regresa velocidad de tipo <code>int</code>
     */
    public int getVelocidad() {              //metodo para obtener velocidad
        return this.velocidad;
    }
}
