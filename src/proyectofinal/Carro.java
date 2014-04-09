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
public class Carro extends Base {

    private int velY;
    private boolean suelo;

    public Carro(int posX, int posY, Animacion anim, int velY) {
        super(posX, posY, anim);
        this.velY = velY;
        suelo = true;
    }

    //@param  velY es la velocidad nueva de tipo <code>int</code>
    public void setVelY(int velY) {     //metodo para asignar valor a velY
        this.velY = velY;
    }

    //@return    regresa la velY de tipo <code>int</code>
    public int getVelY() {              //metodo para obtener velY
        return this.velY;
    }

    //@param  suelo es el nuevo valor de suelo tipo <code>boolean</code>
    public void setSuelo(boolean suelo) {     //metodo para asignar valor a suelo
        this.suelo = suelo;
    }

    //@return    regresa la suelo de tipo <code>boolean</code>
    public boolean getSuelo() {              //metodo para obtener suelo
        return this.suelo;
    }

}
