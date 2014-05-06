/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author Abraham Rodriguez, Dagoberto Gonzalez, Arturo Gonzalez, David Valles 

 */


public class Comida extends Base {

    private int valor;

    //@param  posX es para saber la posicion x de tipo <code>int</code>
    //@param  posY es para saber la posicion y de tipo <code>int</code>
    //@param  anim para asignarle una animacion al objeto de tipo <code>Animacion</code>
    //@param  valor es la valor nueva de tipo <code>int</code>
    public Comida(int posX, int posY, Animacion anim, int valor) {
        super(posX, posY, anim);
        this.valor = valor;
    }

    //@param  valor es para saber cuantos puntos dara de tipo <code>int</code>
    public void setValor(int valor) {     //metodo para asignar valor a valor
        this.valor = valor;
    }

    //@return    regresa valor de tipo <code>int</code>
    public int getValor() {              //metodo para obtener valor
        return this.valor;
    }
}
