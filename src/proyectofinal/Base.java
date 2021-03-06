package proyectofinal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *  * @author Abraham Rodriguez, Dagoberto Gonzalez, Arturo Gonzalez, David
 * Valles  *
 */
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


 /**    
  * Metodo sirve como una clase abstracta para otras clases y asi poder
  * heredarla
   *@param  posX es para saber la posicion x que se asignara de tipo <code>int</code>
    */
public class Base extends Animacion {

    private int posX;                   //posicion de x del objeto
    private int posY;                   //posicion de y del objeto
    protected Animacion imagenes;       //Objeto de tipo animacion

    
     /**    
  * Metodo sirve como una clase abstracta para otras clases y asi poder
  * heredarla
  *@param  posX es para saber la posicion x de tipo <code>int</code>
  * @param  posY es para saber la posicion y de tipo <code>int</code>
  *@param  anim para asignarle una animacion al objeto de tipo <code>Animacion</code>
    */
    public Base(int posX, int posY, Animacion anim) { //constructor 
        this.posX = posX;
        this.posY = posY;
        imagenes = anim;

    }

    //@param  posX es para saber la posicion x que se asignara de tipo <code>int</code>
         /**    
  * Metodo sirve para modificar la posicion en x
  * @param  posX es para saber la posicion x que se asignara de tipo <code>int</code>
    */
    public void setPosX(int posX) {     //metodo para asignar valor a posX
        this.posX = posX;
    }

  /**    
  * Metodo sirve para modificar la posicion en y
  * @param  posY es para saber la posicion y que se asignara de tipo <code>int</code>
    */
    public void setPosY(int posY) {     //metodo para asignar valor a posY
        this.posY = posY;
    }

     /**    
  * Metodo sirve para saber la posicion en x
  * @param  posX es para saber la posicion x que se asignara de tipo <code>int</code>
  * @return   regresa posX de tipo <code>int</code>
    */
    public int getPosX() {              //metodo para obtener valor a posX
        return this.posX;
    }

    //@return    regresa posY de tipo <code>int</code>
         /**    
  * Metodo sirve para saber la posicion en y
  * @param  posX es para saber la posicion y que se asignara de tipo <code>int</code>
  * @return   regresa posY de tipo <code>int</code>
    */
    public int getPosY() {              //metodo para obtener valor a posy
        return this.posY;
    }

    /**
     * Metodo que regresa el ancho
     * @return regresa el ancho de tipo <code>int</code>
     */
    public int getWidth() {             //metodo para obtener valor a width
        return (new ImageIcon(imagenes.getImagen())).getIconWidth();
    }
/**
 * Metodo que regresa el alto
 * @return regresa el alto de tipo <code>int</code>
 */
    public int getHeight() {            //metodo para obtener valor a height
        return (new ImageIcon(imagenes.getImagen())).getIconHeight();
    }

    /**
     * Metodo que obtiene las animaciones
     * @return  regresa imagenes de tipo <code>Animacion</code> 
     */
    public Animacion getImagenes() {    //metodo para obtener la animacion del objeto
        return this.imagenes;
    }

    /**
     * Metodo para modificar la animacion de un objeto
     * @param anim es la animacion nueva <code>Animacion</code>
     */
    public void setImagenes(Animacion anim) {    //metodo para obtener la animacion del objeto
        this.imagenes = anim;
    }

    /**
     * Metodo que obtiene el perimetro del objeto
     * @return  regresa el area de la imagen de tipo <code>Rectangle</code> 
     */
    public Rectangle getPerimetro() {   //metodo para obtener un rectangulo de la imagen actual
        return new Rectangle(getPosX(), getPosY(), getWidth(), getHeight());
    }

    /**
     * Metodo para saber si dos objetos intersectan
     * @param obj es para conocer el objeto con el que se checara si se intersectade tipo <code>Base</code>
     * @return  regresa booleano de si choca o no de tipo <code>Boolean</code> 
     */
    public boolean intersecta(Base obj) {   //metodo para saber si chocaron dos objetos
        return getPerimetro().intersects(obj.getPerimetro());
    }

    /**
     * Metodo que regresa la imagen
     * @return regresa la imagen actual de la animacion  de tipo <code>Image</code> 
     */
    public Image getImagen() {              //metodo para obtener la imagen acutal
        return (this.getImagenes()).getImagen();
    }

    /**
     * metodo para saber si un punto esta dentro del objeto
     * @param x es para conocer la posicion d x del punto tipo <code>int</code>
     * @param y es para conocer la posicion d x del punto tipo <code>int</code>
     * @return regresa booleano de si esta dentro el punto o no <code>Boolean</code>
     */
    public boolean dentro(int x, int y) {
        return this.getPerimetro().contains(x, y);
    }
}
