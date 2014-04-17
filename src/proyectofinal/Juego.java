package proyectofinal;

/**
 *
 * @author Oscar Abraham Rodriguez Quintanilla, Arturo Armando Gonzalez
 * Fernandez, David Valles Canedo
 */
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.net.URL;
import java.util.LinkedList;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juego extends JFrame implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    public Juego() throws IOException {
        init();
        start();
    }

    private Graphics dbg;               //Objeto tipo Graphics
    private Image dbImage;              //Imagen para el doblebuffer 
    private long tiempoActual;          //Long para el tiempo del applet

    private final int[][] patron0 = {{1250, 1300, 1350, 1400, 1450, 1500, 1550, 1600, 1650, 1700, 1250, 1300, 1350, 1400, 1450, 1500, 1550, 1600, 1650, 1700}, {400, 400, 400, 400, 400, 400, 400, 400, 400, 400, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200}};
    private final int[][] patron1 = {{1250, 1300, 1350, 1400, 1450, 1500, 1550, 1600, 1650, 1700, 1750, 1800, 1850}, {400, 380, 360, 340, 320, 300, 320, 340, 280, 260, 240, 220, 200}};
    private final int[][] patron2 = {{1250, 1290, 1330, 1370, 1410, 1450, 1490, 1530, 1570, 1610, 1650, 1690, 1730}, {100, 130, 160, 190, 220, 250, 280, 310, 340, 370, 400, 430, 460}};
    private final int[][] patron3 = {{1250, 1300, 1300, 1350, 1350, 1400, 1400, 1450, 1450, 1500, 1500, 1550}, {300, 350, 250, 400, 200, 450, 150, 400, 200, 350, 250, 300}};
    private final int[][] patron4 = {{1250, 1300, 1350, 1400, 1450, 1500, 1550, 1600, 1650, 1700, 1750, 1800}, {400, 360, 320, 280, 240, 200, 400, 360, 320, 280, 240, 200}};
    private final int[][] patron5 = {{1250, 1300, 1350, 1400, 1450, 1500, 1550, 1600, 1650, 1700, 1750, 1800}, {400, 400, 400, 400, 400, 400, 200, 200, 200, 200, 200, 200}};
    private final int[][] patron6 = {{1250, 1300, 1350, 1400, 1450, 1500, 1550, 1600, 1650, 1700, 1750, 1800}, {70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70}};
    private final int[][] patron7 = {{1250, 1300, 1350, 1400, 1450, 1500, 1550, 1600, 1650, 1700, 1750, 1800}, {520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520, 520}};
    
    private int fondo1;
    private int fondo2;
    private int fondo3;
    private int velocidad;
    private int gravedad;
    private int score;
    private int vidas;
    private int contvel;
    private int mov;
    private int aleatorioEnemigo;
    private int puntos;
    private int aleatorioPodrido;

    private Carro carro;

    private LinkedList<Comida> comida;

    private LinkedList<Podrida> podrida;

    private LinkedList<Enemigo> enemigos;

    private Image carrito;
    private Image fondo01;
    private Image fondo02;
    private Image fondo03;

    private boolean pausa;              //Booleando para pausa
    private boolean jump;
    private boolean doublejump;
    private boolean inicio;
    private boolean gameover;
    private boolean choquesonido;
    private boolean suelta;
    private boolean crearcomida;
    private boolean crearenemigo;

    private Animacion animC;            // animacion del carro
    private Animacion animH;
    private Animacion animCan;
    private Animacion animZ;
    private Animacion animIce;
    private Animacion animCoo;
    private Animacion animQ;
    private Animacion animF;
    private Animacion animP;
    private Animacion animV;
    private Animacion animN;
    private Animacion eleccion;
    private Animacion enem;

    /**
     * Metodo <I>init</I> sobrescrito de la clase <code>JFrame</code>.<P>
     * En este metodo se inizializan las variables o se crean los objetos a
     * usarse en el <code>Jframe</code> y se definen funcionalidades.
     *
     * @throws java.io.IOException
     */
    public void init() throws IOException {
        podrida = new LinkedList();
        comida = new LinkedList();
        enemigos = new LinkedList();
        this.setSize(1200, 600);
        addKeyListener(this);           //Uso de las teclas
        addMouseListener(this);          //Uso de las teclas
        addMouseMotionListener(this);      //Uso de las teclas
        carrito = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Cart.png"));
        fondo01 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo01.jpg"));
        fondo02 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo02.jpg"));
        fondo03 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo03.jpg"));
        pausa = false;
        gameover = false;
        choquesonido = false;
        jump = false;
        doublejump = false;
        suelta = true;
        inicio = false;
        crearenemigo = false;
        crearcomida = false;

        aleatorioEnemigo = 0;
        vidas = 3;
        fondo1 = 0;
        fondo2 = 1200;
        fondo3 = 2400;
        velocidad = 2;
        gravedad = 3;
        score = 0;
        contvel = 0;
        puntos = 1;
        aleatorioPodrido = 0;
        
        eleccion = new Animacion();
        enem = new Animacion();

        animC = new Animacion();                //crea animacion del carro
        animC.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Carrito1.png")), 80);
        animC.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Carrito2.png")), 80);
        animC.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Carrito3.png")), 80);
        animC.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Carrito4.png")), 80);
        animC.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Carrito5.png")), 80);
        animC.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Carrito6.png")), 80);
        carro = new Carro(50, 490, animC, 0);

        animH = new Animacion();
        animH.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/hamburguer1.png")), 50);
        animH.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/hamburguer2.png")), 50);
        animH.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/hamburguer3.png")), 50);
        animH.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/hamburguer2.png")), 50);

        animCan = new Animacion();
        animCan.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/can1.png")), 50);
        animCan.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/can2.png")), 50);
        animCan.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/can3.png")), 50);
        animCan.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/can2.png")), 50);

        animZ = new Animacion();
        animZ.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/carrot1.png")), 50);
        animZ.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/carrot2.png")), 50);
        animZ.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/carrot3.png")), 50);
        animZ.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/carrot2.png")), 50);

        animIce = new Animacion();
        animIce.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/ice1.png")), 50);
        animIce.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/ice2.png")), 50);
        animIce.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/ice3.png")), 50);
        animIce.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/ice2.png")), 50);

        animCoo = new Animacion();
        animCoo.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cookie1.png")), 50);
        animCoo.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cookie2.png")), 50);
        animCoo.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cookie3.png")), 50);
        animCoo.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cookie2.png")), 50);

        animQ = new Animacion();
        animQ.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cheese1.png")), 50);
        animQ.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cheese2.png")), 50);
        animQ.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cheese3.png")), 50);
        animQ.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cheese2.png")), 50);

        animF = new Animacion();
        animF.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fish1.png")), 50);
        animF.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fish2.png")), 50);
        animF.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fish3.png")), 50);
        animF.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fish2.png")), 50);

        animP = new Animacion();
        animP.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/pizza1.png")), 50);
        animP.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/pizza2.png")), 50);
        animP.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/pizza3.png")), 50);
        animP.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/pizza2.png")), 50);

        animV = new Animacion();
        animV.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/viejita1.png")), 80);
        animV.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/viejita2.png")), 80);
        animV.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/viejita3.png")), 80);
        animV.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/viejita2.png")), 80);

        animN = new Animacion();
        animN.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/niño0.png")), 80);
        animN.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/niño1.png")), 80);
        animN.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/niño2.png")), 80);
        animN.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/niño3.png")), 80);
        animN.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/niño4.png")), 80);
        animN.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/niño5.png")), 80);
        animN.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/niño6.png")), 80);
        animN.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/niño7.png")), 80);

    }

    /**
     * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo para la animacion este metodo
     * es llamado despues del init o cuando el usuario visita otra pagina y
     * luego regresa a la pagina en donde esta este <code>Applet</code>
     *
     */
    public void start() {
        // Declaras un hilo
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
    }

    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {
        while (true) {
            if (!pausa) {
                try {
                    actualiza();
                } catch (IOException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
                checaColision();
            }
            repaint();    // Se actualiza el <code>Applet</code> repintando el contenido.
            try {
                // El thread se duerme.
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }
    }

    /**
     * Metodo usado para actualizar la posicion de objetos elefante y raton.
     *
     */
    public void actualiza() throws IOException {
        //if(movimiento){
        long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;

        //Guarda el tiempo actual
        tiempoActual += tiempoTranscurrido;

        if (!pausa && inicio) {
            // ACTUALIZA VELOCIDAD
            if (velocidad < 10) {
                contvel++;
                if (contvel > 350) {
                    velocidad++;
                    contvel = 0;
                }
            }

            //Crear comida
            if (crearcomida) {
                int tipo = (int) (Math.random() * 25);
                if (tipo >= 0 && tipo <= 11) {
                    eleccion = animH;
                    puntos = 1;
                } else if (tipo >= 12 && tipo <= 17) {
                    eleccion = animCan;
                    puntos = 2;
                } else if (tipo >= 18 && tipo <= 21) {
                    eleccion = animZ;
                    puntos = 3;
                } else if (tipo == 22 || tipo == 23) {
                    eleccion = animIce;
                    puntos = 5;
                } else if (tipo == 24) {
                    eleccion = animCoo;
                    puntos = 7;
                }
                tipo = (int) (Math.random() * 8);
                switch (tipo) {
                    case 0:
                        for (int i = 0; i < 20; i++){
                            if ((int)(Math.random()*60)==0){
                                aleatorioPodrido = (int)(Math.random()*3);
                                switch (aleatorioPodrido){
                                    case 0:
                                        enem = animP;
                                        break;
                                    case 1:
                                        enem = animQ;
                                        break;
                                    case 2:
                                        enem = animF;
                                        break;
                                }
                                podrida.add(new Podrida(patron0[0][i],patron0[1][i],enem));
                            }
                            else{
                                comida.add(new Comida(patron0[0][i],patron0[1][i],eleccion,puntos));
                            }
                        }
                        break;
                    case 1:
                        for (int i = 0; i < 13; i++){
                            if ((int)(Math.random()*60)==0){
                                aleatorioPodrido = (int)(Math.random()*3);
                                switch (aleatorioPodrido){
                                    case 0:
                                        enem = animP;
                                        break;
                                    case 1:
                                        enem = animQ;
                                        break;
                                    case 2:
                                        enem = animF;
                                        break;
                                }
                                podrida.add(new Podrida(patron1[0][i],patron1[1][i],animP));
                            }
                            else{
                                comida.add(new Comida(patron1[0][i],patron1[1][i],eleccion,puntos));
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 13; i++){
                            if ((int)(Math.random()*60)==0){
                                aleatorioPodrido = (int)(Math.random()*3);
                                switch (aleatorioPodrido){
                                    case 0:
                                        enem = animP;
                                        break;
                                    case 1:
                                        enem = animQ;
                                        break;
                                    case 2:
                                        enem = animF;
                                        break;
                                }
                                podrida.add(new Podrida(patron2[0][i],patron2[1][i],animP));
                            }
                            else{
                                comida.add(new Comida(patron2[0][i],patron2[1][i],eleccion,puntos));
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < 12; i++){
                            if ((int)(Math.random()*60)==0){
                                aleatorioPodrido = (int)(Math.random()*3);
                                switch (aleatorioPodrido){
                                    case 0:
                                        enem = animP;
                                        break;
                                    case 1:
                                        enem = animQ;
                                        break;
                                    case 2:
                                        enem = animF;
                                        break;
                                }
                                podrida.add(new Podrida(patron3[0][i],patron3[1][i],animP));
                            }
                            else{
                                comida.add(new Comida(patron3[0][i],patron3[1][i],eleccion,puntos));
                            }
                        }
                        break;
                    case 4:
                        for (int i = 0; i < 12; i++){
                            if ((int)(Math.random()*60)==0){
                                aleatorioPodrido = (int)(Math.random()*3);
                                switch (aleatorioPodrido){
                                    case 0:
                                        enem = animP;
                                        break;
                                    case 1:
                                        enem = animQ;
                                        break;
                                    case 2:
                                        enem = animF;
                                        break;
                                }
                                podrida.add(new Podrida(patron4[0][i],patron4[1][i],animP));
                            }
                            else{
                                comida.add(new Comida(patron4[0][i],patron4[1][i],eleccion,puntos));
                            }
                        }
                        break;
                    case 5:
                        for (int i = 0; i < 12; i++){
                            if ((int)(Math.random()*60)==0){
                                aleatorioPodrido = (int)(Math.random()*3);
                                switch (aleatorioPodrido){
                                    case 0:
                                        enem = animP;
                                        break;
                                    case 1:
                                        enem = animQ;
                                        break;
                                    case 2:
                                        enem = animF;
                                        break;
                                }
                                podrida.add(new Podrida(patron5[0][i],patron5[1][i],animP));
                            }
                            else{
                                comida.add(new Comida(patron5[0][i],patron5[1][i],eleccion,puntos));
                            }
                        }
                        break;
                    case 6:
                        for (int i = 0; i < 12; i++){
                            if ((int)(Math.random()*60)==0){
                                aleatorioPodrido = (int)(Math.random()*3);
                                switch (aleatorioPodrido){
                                    case 0:
                                        enem = animP;
                                        break;
                                    case 1:
                                        enem = animQ;
                                        break;
                                    case 2:
                                        enem = animF;
                                        break;
                                }
                                podrida.add(new Podrida(patron6[0][i],patron6[1][i],animP));
                            }
                            else{
                                comida.add(new Comida(patron6[0][i],patron6[1][i],eleccion,puntos));
                            }
                        }
                        break;
                    case 7:
                        for (int i = 0; i < 12; i++){
                            if ((int)(Math.random()*60)==0){
                                aleatorioPodrido = (int)(Math.random()*3);
                                switch (aleatorioPodrido){
                                    case 0:
                                        enem = animP;
                                        break;
                                    case 1:
                                        enem = animQ;
                                        break;
                                    case 2:
                                        enem = animF;
                                        break;
                                }
                                podrida.add(new Podrida(patron7[0][i],patron7[1][i],animP));
                            }
                            else{
                                comida.add(new Comida(patron7[0][i],patron7[1][i],eleccion,puntos));
                            }
                        }
                        break;
                }
                crearcomida = false;
            }

            //Actualizar comida
            for (int i = 0; i < comida.size(); i++) {
                Comida actual = comida.get(i);
                actual.setPosX(actual.getPosX() - velocidad);
                (actual.getImagenes()).actualiza(tiempoActual);
                if (actual.getPosX() + actual.getWidth() < 0) {
                    comida.remove(i);
                }
            }

            for (int i = 0; i < podrida.size(); i++) {
                Podrida actual = podrida.get(i);
                actual.setPosX(actual.getPosX() - velocidad);
                (actual.getImagenes()).actualiza(tiempoActual);
                if (actual.getPosX() + actual.getWidth() < 0) {
                    podrida.remove(i);
                }
            }

            if (comida.isEmpty()) {
                crearcomida = true;
            }

            //Actualiza Carro
            (carro.getImagenes()).actualiza(tiempoActual);
            carro.setPosX(carro.getPosX() + mov);
            if (carro.getPosX() < 0) {
                carro.setPosX(0);
            }
            if (carro.getPosX() + carro.getWidth() > 1200) {
                carro.setPosX(1200 - carro.getWidth());
            }

            //Crear enemigos
            if (!crearenemigo && enemigos.size() < 2) {
                aleatorioEnemigo = (int) (Math.random() * 80);
                if (aleatorioEnemigo == 0) {
                    crearenemigo = true;
                }
            }
            if (crearenemigo) {
                aleatorioEnemigo = (int) (Math.random() * 2);
                if (aleatorioEnemigo == 0) {
                    enemigos.add(new Enemigo(1200, 460, animV, velocidad + 1));
                } else if (aleatorioEnemigo == 1) {
                    enemigos.add(new Enemigo(1200, 480, animN, velocidad + 3));
                }
                crearenemigo = false;
            }
            //Actualiza enemigos
            for (int i = 0; i < enemigos.size(); i++) {
                Enemigo actual = enemigos.get(i);
                actual.setPosX(actual.getPosX() - actual.getVelocidad());
                (actual.getImagenes()).actualiza(tiempoActual);
                if (actual.getPosX() + actual.getWidth() < 0) {
                    enemigos.remove(i);
                }
            }

            //Actualizar fondo
            fondo1 -= velocidad;
            fondo2 -= velocidad;
            fondo3 -= velocidad;
            if (fondo1 <= -2400) {
                fondo1 = 1200 - velocidad;
            }
            if (fondo2 <= -2400) {
                fondo2 = 1200 - velocidad;
            }
            if (fondo3 <= -2400) {
                fondo3 = 1200 - velocidad;
            }

            //Saltos
            if (jump || doublejump) {
                if (carro.getSuelo()) {
                    jump = false;
                    doublejump = false;
                }
                if (carro.getPosY() + carro.getVelY() >= 490) {
                    carro.setSuelo(true);
                    carro.setPosY(489);
                    carro.setVelY(0);
                } else if (carro.getPosY() + carro.getVelY() <= 20) {
                    carro.setPosY(20);
                    carro.setVelY(carro.getVelY() + gravedad);
                } else {
                    carro.setPosY(carro.getPosY() + carro.getVelY());
                    carro.setVelY(carro.getVelY() + gravedad);
                }
            }

            //Se acaban las vidas
            if (vidas == 0) {
                score = 0;
                inicio = false;
                pausa = false;
                score = 0;
                vidas = 3;
                carro.setPosX(50);
                carro.setPosY(490);
                comida.clear();
                podrida.clear();
                enemigos.clear();
                velocidad = 2;
            }
        }
    }

    /**
     * Metodo usado para checar las colisiones del objeto elefante y raton con
     * las orillas del <code>Applet</code>.
     */
    public void checaColision() {
        for (int i = 0; i < comida.size(); i++) {
            Comida actual = comida.get(i);
            if (actual.intersecta(carro)) {
                score += actual.getValor();
                comida.remove(i);
            }
        }
        for (int i = 0; i < enemigos.size(); i++) {
            Enemigo actual = enemigos.get(i);
            if (actual.intersecta(carro)) {
                enemigos.remove(i);
                inicio = false;
                pausa = false;
                score = 0;
                vidas = 3;
                carro.setPosX(50);
                carro.setPosY(490);
                comida.clear();
                podrida.clear();
                enemigos.clear();
                velocidad = 2;
            }
        }
        for (int i = 0; i < podrida.size(); i++) {
            Podrida actual = podrida.get(i);
            if (actual.intersecta(carro)) {
                vidas--;
                podrida.remove(i);
            }
        }
    }

    /**
     * Metodo <I>update</I> sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        paint1(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);
    }

    /**
     * Metodo <I>keyPressed</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar cualquier la
     * tecla.
     *
     * @param e es el <code>evento</code> generado al presionar las teclas.
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!jump && !doublejump && carro.getSuelo()) {
                carro.setVelY(-36);
                jump = true;
                carro.setSuelo(false);
            } else if (jump && !carro.getSuelo() && !doublejump) {
                carro.setVelY(-36);
                jump = false;
                doublejump = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mov = velocidad;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mov = -velocidad;
        }
    }

    /**
     * Metodo <I>keyTyped</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una tecla que
     * no es de accion.
     *
     * @param e es el <code>evento</code> que se genera en al presionar las
     * teclas.
     */
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Metodo <I>keyReleased</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla
     * presionada.
     *
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P) {
            pausa = !pausa;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            suelta = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mov = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mov = 0;
        }

    }

    /**
     * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>, heredado
     * de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia.
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint1(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.setColor(Color.RED);
        if (carrito != null) {
            //Fondo
            g.drawImage(fondo01, fondo1, 0, this);
            g.drawImage(fondo02, fondo2, 0, this);
            g.drawImage(fondo03, fondo3, 0, this);
            //Objetos
            g.drawImage(carro.getImagen(), carro.getPosX(), carro.getPosY(), this);
            for (int i = 0; i < comida.size(); i++) {
                Comida actual = comida.get(i);
                g.drawImage(actual.getImagen(), actual.getPosX(), actual.getPosY(), this);
            }

            for (int i = 0; i < podrida.size(); i++) {
                Podrida actual = podrida.get(i);
                g.drawImage(actual.getImagen(), actual.getPosX(), actual.getPosY(), this);
            }

            for (int i = 0; i < enemigos.size(); i++) {
                Enemigo actual = enemigos.get(i);
                g.drawImage(actual.getImagen(), actual.getPosX(), actual.getPosY(), this);
            }

            //Score
            g.drawImage(carrito, 20, 40, this);
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.setColor(Color.BLACK);
            g.drawString("" + score, 25 + carrito.getWidth(this), 87);

            //vidas
            g.drawString("" + vidas, this.getWidth() - 80, 87);
        } else {
            //Da un mensaje mientras se carga el dibujo	
            g.drawString("No se cargo la imagen..", 20, 20);
        }
    }

    /**
     * Metodo mouseClicked sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al hacer click con el mouse sobre
     * algun componente. e es el evento generado al hacer click con el mouse.
     */
    public void mouseClicked(MouseEvent e) {
        if (carro.dentro(e.getX(), e.getY())) {
            inicio = true;
            crearcomida = true;
        }
    }

    /**
     * Metodo mouseEntered sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera cuando el mouse entra en algun
     * componente. e es el evento generado cuando el mouse entra en algun
     * componente.
     */
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Metodo mouseExited sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera cuando el mouse sale de algun
     * componente. e es el evento generado cuando el mouse sale de algun
     * componente.
     */
    public void mouseExited(MouseEvent e) {
    }

    /**
     * Metodo mousePressed sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al presionar un botÃ³n del mouse
     * sobre algun componente. e es el evento generado al presionar un botÃ³n
     * del mouse sobre algun componente.
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Metodo mouseReleased sobrescrito de la interface MouseListener. En este
     * metodo maneja el evento que se genera al soltar un botÃ³n del mouse sobre
     * algun componente. e es el evento generado al soltar un botÃ³n del mouse
     * sobre algun componente.
     */
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Metodo mouseDragged sobrescrito de la interface MouseMotionListener. En
     * este metodo maneja el evento que se genera al mover un el mouse despues
     * de dar clic y no soltarlo
     */
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Metodo mouseMoved sobrescrito de la interface MouseMotionListener. En
     * este metodo maneja el evento que se genera al mover el mouse
     */
    public void mouseMoved(MouseEvent e) {

    }

}
