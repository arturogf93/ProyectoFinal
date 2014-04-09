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
public class Enemigo extends Base {

    private int id;
    private int velocidad;

    public Enemigo(int posX, int posY, Animacion anim, int id, int velocidad) {
        super(posX, posY, anim);
        this.id = id;
        this.velocidad = velocidad;
    }

    //@param  id es para dar diferentes id a cada objeto de tipo <code>int</code>
    public void setId(int id) {     //metodo para asignar valor a valor
        this.id = id;
    }

    //@return    regresa el id de tipo <code>int</code>
    public int getId() {              //metodo para obtener id
        return this.id;
    }

    //@param  velocidad es para saber la velocidad de tipo <code>int</code>
    public void setVelocidad(int velocidad) {     //metodo para asignar valor a velocidad
        this.velocidad = velocidad;
    }

    //@return    regresa velocidad de tipo <code>int</code>
    public int getVelocidad() {              //metodo para obtener velocidad
        return this.velocidad;
    }
}
