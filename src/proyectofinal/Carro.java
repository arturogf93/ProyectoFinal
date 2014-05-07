/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 * La clase Carro nos sirve para controlar individualmente al personaje
 * principal. Maneja su posicion, su velocidad de salto y si animacion
 */
public class Carro extends Base {

    private int velY;
    private boolean suelo;

    /**
     * Constructor del objeto tipo carro
    * @param  posX es para saber la posicion x de tipo <code>int</code>
    *@param  posY es para saber la posicion y de tipo <code>int</code>
    *@param  anim para asignarle una animacion al objeto de tipo <code>Animacion</code>
    *@param  velY es la velocidad nueva de tipo <code>int</code>
    */
    public Carro(int posX, int posY, Animacion anim, int velY) {
        super(posX, posY, anim);
        this.velY = velY;
        suelo = true;
    }

    /**
     * Metodo para modificar la velocidad en Y
     * @param  velY es la velocidad nueva de tipo <code>int</code>
     */
    public void setVelY(int velY) {     //metodo para asignar valor a velY
        this.velY = velY;
    }

    /**
     * Metodo para saber la velocidad en Y
     * @return    regresa la velY de tipo <code>int</code>
     */
    public int getVelY() {              //metodo para obtener velY
        return this.velY;
    }

    /**
     * Metodo para modificar la variable suelo
     * @param  suelo es el nuevo valor de suelo tipo <code>boolean</code>
     */
    public void setSuelo(boolean suelo) {     //metodo para asignar valor a suelo
        this.suelo = suelo;
    }

    /**
     * Metodo para obtener suelo 
     * @return    regresa la suelo de tipo <code>boolean</code>
     */
    public boolean getSuelo() {              //metodo para obtener suelo
        return this.suelo;
    }
}
