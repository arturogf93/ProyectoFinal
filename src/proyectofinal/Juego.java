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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    private int total;
    private int menuX;
    private int menuY;
    private int velTransicionX;
    private int velTransicionY;
    private int auxfood;

    private Carro carro;

    private LinkedList<Comida> comida;

    private LinkedList<Podrida> podrida;

    private LinkedList<Enemigo> enemigos;

    private Image carrito;
    private Image fondo01;
    private Image fondo02;
    private Image fondo03;
    private Image fondo00;
    private Image menuPrincipal;

    private Image creditosN;
    private Image creditosS;
    private Image instN;
    private Image instS;
    private Image tiendaN;
    private Image tiendaS;
    private Image scoreN;
    private Image scoreS;
    private Image playN;
    private Image playS;
    private Image abajoN;
    private Image abajoS;
    private Image arribaN;
    private Image arribaS;
    private Image derN;
    private Image derS;
    private Image izqN;
    private Image izqS;
    private Image corazon;
    private Image home;
    private Image flecha;
    private Image cuadrillo;

    private Boton bCreditos;
    private Boton bInst;
    private Boton bTienda;
    private Boton bScore;
    private Boton bPlay;
    private Boton bArriba;
    private Boton bAbajo;
    private Boton bDer;
    private Boton bIzq;
    private Boton casita;
    private Boton restart;
    private Boton cuadroOver;

    private boolean pausa;              //Booleando para pausa
    private boolean jump;
    private boolean doublejump;
    private boolean inicio;
    private boolean gameover;
    private boolean sound;
    private boolean suelta;
    private boolean crearcomida;
    private boolean crearenemigo;
    private boolean menu;
    private boolean principal;
    private boolean instrucciones;
    private boolean creditos;
    private boolean tienda;
    private boolean highscores;
    private boolean jugar;
    private boolean transicion;
    private boolean regreso;

    private Animacion animC1;
    private Animacion animC2;
    private Animacion animC3;
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
    private Animacion animLamp;

    private String archivoSave;
    private String archivoHighscores;
    private String nombre;

    private String[] arr;
    private String[] arrNombres;
    private int[] arrScores;
    
    private SoundClip musicaMenu;
    private SoundClip musicaJuego;
    private SoundClip musicaGameover;
    private SoundClip food1;
    private SoundClip food2;
    private SoundClip badFood;
    private SoundClip ida;
    private SoundClip vuelta;
    private SoundClip brinco;
    private SoundClip brinco2;

    /**
     * Metodo <I>init</I> sobrescrito de la clase <code>JFrame</code>.<P>
     * En este metodo se inizializan las variables o se crean los objetos a
     * usarse en el <code>Jframe</code> y se definen funcionalidades.
     *
     * @throws java.io.IOException
     */
    public void init() throws IOException {
        auxfood = 0;
        arrNombres = new String[10];
        arrScores = new int[10];
        arr = new String[20];
        archivoSave = "Save.txt";
        archivoHighscores = "Highscores.txt";
        total = 0;
        podrida = new LinkedList();
        comida = new LinkedList();
        enemigos = new LinkedList();
        this.setSize(1200, 600);
        addKeyListener(this);           //Uso de las teclas
        addMouseListener(this);          //Uso de las teclas
        addMouseMotionListener(this);      //Uso de las teclas
        carrito = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Cart.png"));
        fondo01 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo01.jpg"));
        fondo02 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo02.png"));
        fondo03 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo03.png"));
        fondo00 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo00.png"));
        menuPrincipal = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/MenuPrincipal.png"));

        creditosN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/creditos.png"));
        creditosS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/creditosSel.png"));
        tiendaN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/tienda.png"));
        tiendaS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/tiendaSel.png"));
        playN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/jugar.png"));
        playS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/jugarSel.png"));
        instN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/instrucciones.png"));
        instS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/instruccionesSel.png"));
        scoreN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/puntuaciones.png"));
        scoreS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/puntuacionesSel.png"));

        abajoN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/menuabajo1.png"));
        abajoS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Menuabajo2.png"));
        arribaN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/menuarriba1.png"));
        arribaS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Menuarriba2.png"));
        derN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/menuder1.png"));
        derS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Menuder2.png"));
        izqN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/menuizq1.png"));
        izqS = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Menuizq2.png"));
        corazon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Corazon.png"));

        home = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/casita.png"));
        flecha = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/restart.png"));
        cuadrillo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/gameover.png"));

        bCreditos = new Boton(25, 250, creditosN);
        bTienda = new Boton(1000, 250, tiendaN);
        bPlay = new Boton(515, 350, playN);
        bInst = new Boton(460, 25, instN);
        bScore = new Boton(460, 460, scoreN);
        bAbajo = new Boton(1100, -115, abajoN);
        bArriba = new Boton(1100, 635, arribaN);
        bDer = new Boton(-120, 500, derN);
        bIzq = new Boton(1220, 500, izqN);

        casita = new Boton(600 - 160, 760, home);
        restart = new Boton(630, 760, flecha);
        cuadroOver = new Boton(600 - 300, 660, cuadrillo);

        regreso = false;
        transicion = false;
        pausa = false;
        gameover = false;
        sound = true;
        jump = false;
        doublejump = false;
        suelta = true;
        inicio = false;
        crearenemigo = false;
        crearcomida = false;
        menu = true;
        principal = true;
        creditos = false;
        highscores = false;
        instrucciones = false;
        tienda = false;

        aleatorioEnemigo = 0;
        vidas = 3;
        fondo1 = 0;
        fondo2 = 1200;
        fondo3 = 2400;
        velocidad = 3;
        gravedad = 2;
        score = 0;
        contvel = 0;
        puntos = 1;
        aleatorioPodrido = 0;
        menuX = -1200;
        menuY = -600;
        velTransicionY = 20;
        velTransicionX = 40;

        eleccion = new Animacion();
        enem = new Animacion();

        animC1 = new Animacion();                //crea animacion del carro
        animC1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky1_1.png")), 100);
        animC1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky1_2.png")), 100);
        carro = new Carro(50, 490, animC1, 0);

        animC2 = new Animacion();                //crea animacion del carro
        animC2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky2_1.png")), 100);
        animC2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky2_2.png")), 100);

        animC3 = new Animacion();                //crea animacion del carro
        animC3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky3_1.png")), 100);
        animC3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky3_2.png")), 100);

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

        animLamp = new Animacion();                //crea animacion del carro
        animLamp.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/lampara.png")), 80);
        
        musicaMenu = new SoundClip("Sounds/Menu.wav");
        musicaJuego = new SoundClip("Sounds/Juego.wav");
        musicaGameover = new SoundClip("Sounds/GameOver.wav");
        food1 = new SoundClip("Sounds/coin1.wav");
        food2 = new SoundClip("Sounds/coin2.wav");
        badFood = new SoundClip("Sounds/mala.wav");
        ida = new SoundClip("Sounds/ida.wav");
        vuelta = new SoundClip("Sounds/vuelta.wav");
        brinco = new SoundClip("Sounds/brinco.wav");
        brinco2 = new SoundClip("Sounds/brinco.wav");
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
        try {
            leerSave();
        } catch (IOException ioe) {
            System.out.println("Error en " + ioe.toString());
        }
        try {
            leerHighscores();
        } catch (IOException ioe) {
            System.out.println("Error en " + ioe.toString());
        }
        while (true) {
            if (!pausa) {
                try {
                    actualiza();
                } catch (IOException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    checaColision();
                } catch (IOException ioe) {
                    System.out.println("Error en " + ioe.toString());
                }
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
            if (sound){
                musicaMenu.stop();
                musicaMenu.restart();
                musicaJuego.play2();
            }else{
                musicaJuego.stop();
                musicaMenu.stop();
                musicaMenu.restart();
            }

            // ACTUALIZA VELOCIDAD
            if (velocidad < 18) {
                contvel++;
                if (contvel > 350) {
                    velocidad++;
                    contvel = 0;
                    for (int i = 0; i < enemigos.size(); i++) {
                        Enemigo actual = enemigos.get(i);
                        actual.setVelocidad(actual.getVelocidad() + 1);
                    }
                }
            }

            //Crear comida
            CrearComida();

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
            CrearEnemigos();

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
                if (sound){
                    musicaJuego.stop();
                    musicaJuego.restart();
                    musicaGameover.play2();
                }else{
                    musicaJuego.stop();
                    musicaJuego.restart();
                    musicaGameover.stop();
                }
                mov = 0;
                total += score;
                pausa = false;
                vidas = 3;
                carro.setPosX(50);
                carro.setPosY(490);
                comida.clear();
                podrida.clear();
                enemigos.clear();
                velocidad = 3;
                menu = false;
                if (score > arrScores[9]) {
                    do {
                        nombre = JOptionPane.showInputDialog("Entraste entre los mejores 10...Cual es tu nombre?");
                    } while (nombre == null);
                    JOptionPane.showMessageDialog(null,
                            "El puntaje de " + nombre + " es: " + score, "PUNTAJE",
                            JOptionPane.PLAIN_MESSAGE);
                    grabaHighscores();
                }
                score = 0;
                grabaSave();
                gameover = true;
                inicio = false;
            }
            if (score < 75) {
                carro.setImagenes(animC1);
            } else if (score >= 75 && score < 150) {
                carro.setImagenes(animC2);
            } else if (score >= 150) {
                carro.setImagenes(animC3);
            }
        }

        if (gameover) {
            if (cuadroOver.getPosY() >= (300 - (cuadroOver.getHeight() / 2))) {
                casita.setPosY(casita.getPosY() - velTransicionY);
                restart.setPosY(restart.getPosY() - velTransicionY);
                cuadroOver.setPosY(cuadroOver.getPosY() - velTransicionY);
            }
        }

        //MANEJO DEL MENU
        if (menu) {
            if (sound){
                musicaMenu.play2();
            }else{
                musicaMenu.stop();
            }
            if (principal && transicion) {
                if (creditos) {
                    menuX += velTransicionX;
                    bPlay.setPosX(bPlay.getPosX() + velTransicionX);
                    bCreditos.setPosX(bCreditos.getPosX() + velTransicionX);
                    bInst.setPosX(bInst.getPosX() + velTransicionX);
                    bTienda.setPosX(bTienda.getPosX() + velTransicionX);
                    bScore.setPosX(bScore.getPosX() + velTransicionX);
                    bDer.setPosX(bDer.getPosX() + velTransicionX);
                    if (menuX >= 0) {
                        transicion = false;
                        principal = false;
                    }
                }
                if (tienda) {
                    menuX -= velTransicionX;
                    bPlay.setPosX(bPlay.getPosX() - velTransicionX);
                    bCreditos.setPosX(bCreditos.getPosX() - velTransicionX);
                    bInst.setPosX(bInst.getPosX() - velTransicionX);
                    bTienda.setPosX(bTienda.getPosX() - velTransicionX);
                    bScore.setPosX(bScore.getPosX() - velTransicionX);
                    bIzq.setPosX(bIzq.getPosX() - velTransicionX);
                    if (menuX <= -2400) {
                        transicion = false;
                        principal = false;
                    }
                }
                if (instrucciones) {
                    menuY += velTransicionY;
                    bPlay.setPosY(bPlay.getPosY() + velTransicionY);
                    bCreditos.setPosY(bCreditos.getPosY() + velTransicionY);
                    bInst.setPosY(bInst.getPosY() + velTransicionY);
                    bTienda.setPosY(bTienda.getPosY() + velTransicionY);
                    bScore.setPosY(bScore.getPosY() + velTransicionY);
                    bAbajo.setPosY(bAbajo.getPosY() + velTransicionY);
                    if (menuY >= 0) {
                        transicion = false;
                        principal = false;
                    }
                }
                if (highscores) {
                    menuY -= velTransicionY;
                    bPlay.setPosY(bPlay.getPosY() - velTransicionY);
                    bCreditos.setPosY(bCreditos.getPosY() - velTransicionY);
                    bInst.setPosY(bInst.getPosY() - velTransicionY);
                    bTienda.setPosY(bTienda.getPosY() - velTransicionY);
                    bScore.setPosY(bScore.getPosY() - velTransicionY);
                    bArriba.setPosY(bArriba.getPosY() - velTransicionY);
                    if (menuY <= -1200) {
                        transicion = false;
                        principal = false;
                    }
                }
            }
            if (principal && regreso) {
                if (creditos) {
                    menuX -= velTransicionX;
                    bPlay.setPosX(bPlay.getPosX() - velTransicionX);
                    bCreditos.setPosX(bCreditos.getPosX() - velTransicionX);
                    bInst.setPosX(bInst.getPosX() - velTransicionX);
                    bTienda.setPosX(bTienda.getPosX() - velTransicionX);
                    bScore.setPosX(bScore.getPosX() - velTransicionX);
                    bDer.setPosX(bDer.getPosX() - velTransicionX);
                    if (menuX <= -1200) {
                        regreso = false;
                        creditos = false;
                    }
                }
                if (tienda) {
                    menuX += velTransicionX;
                    bPlay.setPosX(bPlay.getPosX() + velTransicionX);
                    bCreditos.setPosX(bCreditos.getPosX() + velTransicionX);
                    bInst.setPosX(bInst.getPosX() + velTransicionX);
                    bTienda.setPosX(bTienda.getPosX() + velTransicionX);
                    bScore.setPosX(bScore.getPosX() + velTransicionX);
                    bIzq.setPosX(bIzq.getPosX() + velTransicionX);
                    if (menuX >= -1200) {
                        regreso = false;
                        tienda = false;
                    }
                }
                if (instrucciones) {
                    menuY -= velTransicionY;
                    bPlay.setPosY(bPlay.getPosY() - velTransicionY);
                    bCreditos.setPosY(bCreditos.getPosY() - velTransicionY);
                    bInst.setPosY(bInst.getPosY() - velTransicionY);
                    bTienda.setPosY(bTienda.getPosY() - velTransicionY);
                    bScore.setPosY(bScore.getPosY() - velTransicionY);
                    bAbajo.setPosY(bAbajo.getPosY() - velTransicionY);
                    if (menuY <= -600) {
                        regreso = false;
                        instrucciones = false;
                    }
                }
                if (highscores) {
                    menuY += velTransicionY;
                    bPlay.setPosY(bPlay.getPosY() + velTransicionY);
                    bCreditos.setPosY(bCreditos.getPosY() + velTransicionY);
                    bInst.setPosY(bInst.getPosY() + velTransicionY);
                    bTienda.setPosY(bTienda.getPosY() + velTransicionY);
                    bScore.setPosY(bScore.getPosY() + velTransicionY);
                    bArriba.setPosY(bArriba.getPosY() + velTransicionY);
                    if (menuY >= -600) {
                        regreso = false;
                        highscores = false;
                    }
                }
            }
        }
    }

    /**
     * Metodo usado para checar las colisiones del objeto elefante y raton con
     * las orillas del <code>Applet</code>.
     */
    public void checaColision() throws IOException {
        for (int i = 0; i < comida.size(); i++) {
            Comida actual = comida.get(i);
            if (actual.intersecta(carro)) {
                if (auxfood==0&&sound){
                    food1.play();
                    auxfood++;
                }
                else if (sound){
                    food2.play();
                    auxfood = 0;
                }
                score += actual.getValor();
                comida.remove(i);
            }
        }
        for (int i = 0; i < enemigos.size(); i++) {
            Enemigo actual = enemigos.get(i);
            if (actual.intersecta(carro)) {
                vidas = 0;
            }
        }
        for (int i = 0; i < podrida.size(); i++) {
            Podrida actual = podrida.get(i);
            if (actual.intersecta(carro)) {
                if (sound){
                    badFood.play();
                }
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
                if (sound){
                    brinco.play();
                }
                carro.setVelY(-33);
                jump = true;
                carro.setSuelo(false);
            } else if (jump && !carro.getSuelo() && !doublejump) {
                if (sound){
                    brinco2.play();
                }
                carro.setVelY(-24);
                jump = false;
                doublejump = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mov = velocidad;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mov = -(velocidad);
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
        if (e.getKeyCode() == KeyEvent.VK_P && jugar) {
            pausa = !pausa;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            sound = !sound;
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
        if (jugar) {
            //Fondo
            g.drawImage(fondo00, 0, 0, this);
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
            g.drawImage(corazon, this.getWidth() - 106, 40, this);
            g.drawString("" + vidas, this.getWidth() - 80, 87);
            if (gameover) {
                g.drawImage(cuadroOver.getImagen(), cuadroOver.getPosX(), cuadroOver.getPosY(), this);
                g.drawImage(casita.getImagen(), casita.getPosX(), casita.getPosY(), this);
                g.drawImage(restart.getImagen(), restart.getPosX(), restart.getPosY(), this);
            }
        } else if (menu) {
            g.drawImage(menuPrincipal, menuX, menuY, this);
            if (principal) {
                g.drawImage(bCreditos.getImagen(), bCreditos.getPosX(), bCreditos.getPosY(), this);
                g.drawImage(bTienda.getImagen(), bTienda.getPosX(), bTienda.getPosY(), this);
                g.drawImage(bPlay.getImagen(), bPlay.getPosX(), bPlay.getPosY(), this);
                g.drawImage(bInst.getImagen(), bInst.getPosX(), bInst.getPosY(), this);
                g.drawImage(bScore.getImagen(), bScore.getPosX(), bScore.getPosY(), this);
            }
            if (creditos) {
                g.drawImage(bDer.getImagen(), bDer.getPosX(), bDer.getPosY(), this);
            }
            if (tienda) {
                g.drawImage(bIzq.getImagen(), bIzq.getPosX(), bIzq.getPosY(), this);
                if (!transicion && !regreso) {
                    g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                    g.setColor(Color.WHITE);
                    g.drawString("" + total, 250, 85);
                }
            }
            if (instrucciones) {
                g.drawImage(bAbajo.getImagen(), bAbajo.getPosX(), bAbajo.getPosY(), this);
            }
            if (highscores) {
                g.setFont(new Font("TimesRoman", Font.BOLD, 30));
                g.setColor(Color.WHITE);
                g.drawImage(bArriba.getImagen(), bArriba.getPosX(), bArriba.getPosY(), this);
                if (!transicion && !regreso) {
                    for (int i = 0; i < 10; i++) {
                        g.drawString(arrNombres[i], 200, 180 + (i * 35));
                        for (int j = 20 + (arrNombres[i].length() * 20); j < 760; j += 20) {
                            g.drawString(".", 200 + j, 180 + (i * 35));
                        }
                        g.drawString("" + arrScores[i], 960, 180 + (i * 35));
                    }
                }
            }
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
        if (menu) {
            if (principal) {
                if (bPlay.dentro(e.getX(), e.getY())) {
                    inicio = true;
                    crearcomida = true;
                    jugar = true;
                    menu = false;
                }
                if (bCreditos.dentro(e.getX(), e.getY())) {
                    if (sound){
                        ida.play();
                    }
                    transicion = true;
                    creditos = true;
                }
                if (bTienda.dentro(e.getX(), e.getY())) {
                    if (sound){
                        ida.play();
                    }
                    transicion = true;
                    tienda = true;
                }
                if (bInst.dentro(e.getX(), e.getY())) {
                    if (sound){
                        ida.play();
                    }
                    transicion = true;
                    instrucciones = true;
                }
                if (bScore.dentro(e.getX(), e.getY())) {
                    if (sound){
                        ida.play();
                    }
                    transicion = true;
                    highscores = true;
                }
            }
            if (creditos) {
                if (bDer.dentro(e.getX(), e.getY())) {
                    if (sound){
                        vuelta.play();
                    }
                    regreso = true;
                    principal = true;
                }
            }
            if (tienda) {
                if (bIzq.dentro(e.getX(), e.getY())) {
                    if (sound){
                        vuelta.play();
                    }
                    regreso = true;
                    principal = true;
                }
            }
            if (instrucciones) {
                if (bAbajo.dentro(e.getX(), e.getY())) {
                    if (sound){
                        vuelta.play();
                    }
                    regreso = true;
                    principal = true;
                }
            }
            if (highscores) {
                if (bArriba.dentro(e.getX(), e.getY())) {
                    if (sound){
                        vuelta.play();
                    }
                    regreso = true;
                    principal = true;
                }
            }
        }
        if (gameover) {
            if (casita.dentro(e.getX(), e.getY())) {
                menu = true;
                principal = true;
                jugar = false;
                inicio = false;
                casita.setPosY(760);
                restart.setPosY(760);
                cuadroOver.setPosY(660);
                gameover = false;
                musicaJuego.stop();
                musicaJuego.restart();
                musicaMenu.stop();
                musicaMenu.restart();
                musicaGameover.stop();
                musicaGameover.restart();
            }

            if (restart.dentro(e.getX(), e.getY())) {
                inicio = true;
                jugar = true;
                casita.setPosY(760);
                restart.setPosY(760);
                cuadroOver.setPosY(660);
                gameover = false;
                musicaJuego.stop();
                musicaJuego.restart();
                musicaMenu.stop();
                musicaMenu.restart();
                musicaGameover.stop();
                musicaGameover.restart();
            }
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
        if (menu) {
            if (principal) {
                if (bCreditos.dentro(e.getX(), e.getY())) {
                    bCreditos.setImagen(creditosS);
                } else {
                    bCreditos.setImagen(creditosN);
                }

                if (bTienda.dentro(e.getX(), e.getY())) {
                    bTienda.setImagen(tiendaS);
                } else {
                    bTienda.setImagen(tiendaN);
                }

                if (bInst.dentro(e.getX(), e.getY())) {
                    bInst.setImagen(instS);
                } else {
                    bInst.setImagen(instN);
                }

                if (bPlay.dentro(e.getX(), e.getY())) {
                    bPlay.setImagen(playS);
                } else {
                    bPlay.setImagen(playN);
                }

                if (bScore.dentro(e.getX(), e.getY())) {
                    bScore.setImagen(scoreS);
                } else {
                    bScore.setImagen(scoreN);
                }
            }
            if (creditos) {
                if (bDer.dentro(e.getX(), e.getY())) {
                    bDer.setImagen(derS);
                } else {
                    bDer.setImagen(derN);
                }
            }
            if (tienda) {
                if (bIzq.dentro(e.getX(), e.getY())) {
                    bIzq.setImagen(izqS);
                } else {
                    bIzq.setImagen(izqN);
                }
            }
            if (instrucciones) {
                if (bAbajo.dentro(e.getX(), e.getY())) {
                    bAbajo.setImagen(abajoS);
                } else {
                    bAbajo.setImagen(abajoN);
                }
            }
            if (highscores) {
                if (bArriba.dentro(e.getX(), e.getY())) {
                    bArriba.setImagen(arribaS);
                } else {
                    bArriba.setImagen(arribaN);
                }
            }
        }
    }

    public void leerSave() throws IOException {

        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(archivoSave));
        } catch (FileNotFoundException e) {
            File save = new File(archivoSave);
            PrintWriter fileOut = new PrintWriter(save);
            fileOut.println("0");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(archivoSave));
        }
        String dato = fileIn.readLine();
        while (dato != null) {

            //arr = dato.split(",");
            total = (Integer.parseInt(dato));
            dato = fileIn.readLine();
        }
        fileIn.close();
    }

    public void grabaSave() throws IOException {

        PrintWriter fileOut = new PrintWriter(new FileWriter(archivoSave));
        fileOut.println(total);
        fileOut.close();
    }

    public void leerHighscores() throws IOException {

        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(archivoHighscores));
        } catch (FileNotFoundException e) {
            File save = new File(archivoHighscores);
            PrintWriter fileOut = new PrintWriter(save);
            fileOut.println("Demo,10,Demo,9,Demo,8,Demo,7,Demo,6,Demo,5,Demo,4,Demo,3,Demo,2,Demo,1");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(archivoHighscores));
        }
        String dato = fileIn.readLine();
        while (dato != null) {
            arr = dato.split(",");
            for (int i = 0, j = 0; j < 20; i++, j += 2) {
                arrNombres[i] = arr[j];
            }
            for (int i = 0, j = 1; j < 20; i++, j += 2) {
                arrScores[i] = (Integer.parseInt(arr[j]));
            }
            dato = fileIn.readLine();
        }
        fileIn.close();
    }

    public void grabaHighscores() throws IOException {
        PrintWriter fileOut = new PrintWriter(new FileWriter(archivoHighscores));
        String[] auxNombres = new String[10];
        int[] auxScores = new int[10];
        boolean acabo = false;
        for (int i = 0, a = 0; i < 10; i++) {
            if (!acabo) {
                if (score >= arrScores[i]) {
                    auxScores[i] = score;
                    auxNombres[i] = nombre;
                    acabo = true;
                } else {
                    auxScores[i] = arrScores[a];
                    auxNombres[i] = arrNombres[a];
                    a++;
                }
            } else {
                auxScores[i] = arrScores[a];
                auxNombres[i] = arrNombres[a];
                a++;
            }
        }
        for (int i = 0; i < 10; i++) {
            arrScores[i] = auxScores[i];
            arrNombres[i] = auxNombres[i];
        }
        fileOut.println(arrNombres[0] + "," + arrScores[0] + "," + arrNombres[1] + "," + arrScores[1] + "," + arrNombres[2] + "," + arrScores[2] + "," + arrNombres[3] + "," + arrScores[3] + "," + arrNombres[4] + "," + arrScores[4] + "," + arrNombres[5] + "," + arrScores[5] + "," + arrNombres[6] + "," + arrScores[6] + "," + arrNombres[7] + "," + arrScores[7] + "," + arrNombres[8] + "," + arrScores[8] + "," + arrNombres[9] + "," + arrScores[9]);
        fileOut.close();
        nombre = null;
    }

    public void CrearComida() {
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
                    for (int i = 0; i < 20; i++) {
                        if ((int) (Math.random() * 60) == 0) {
                            aleatorioPodrido = (int) (Math.random() * 3);
                            switch (aleatorioPodrido) {
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
                            podrida.add(new Podrida(patron0[0][i], patron0[1][i], enem));
                        } else {
                            comida.add(new Comida(patron0[0][i], patron0[1][i], eleccion, puntos));
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 13; i++) {
                        if ((int) (Math.random() * 60) == 0) {
                            aleatorioPodrido = (int) (Math.random() * 3);
                            switch (aleatorioPodrido) {
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
                            podrida.add(new Podrida(patron1[0][i], patron1[1][i], animP));
                        } else {
                            comida.add(new Comida(patron1[0][i], patron1[1][i], eleccion, puntos));
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 13; i++) {
                        if ((int) (Math.random() * 60) == 0) {
                            aleatorioPodrido = (int) (Math.random() * 3);
                            switch (aleatorioPodrido) {
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
                            podrida.add(new Podrida(patron2[0][i], patron2[1][i], animP));
                        } else {
                            comida.add(new Comida(patron2[0][i], patron2[1][i], eleccion, puntos));
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 12; i++) {
                        if ((int) (Math.random() * 60) == 0) {
                            aleatorioPodrido = (int) (Math.random() * 3);
                            switch (aleatorioPodrido) {
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
                            podrida.add(new Podrida(patron3[0][i], patron3[1][i], animP));
                        } else {
                            comida.add(new Comida(patron3[0][i], patron3[1][i], eleccion, puntos));
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < 12; i++) {
                        if ((int) (Math.random() * 60) == 0) {
                            aleatorioPodrido = (int) (Math.random() * 3);
                            switch (aleatorioPodrido) {
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
                            podrida.add(new Podrida(patron4[0][i], patron4[1][i], animP));
                        } else {
                            comida.add(new Comida(patron4[0][i], patron4[1][i], eleccion, puntos));
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < 12; i++) {
                        if ((int) (Math.random() * 60) == 0) {
                            aleatorioPodrido = (int) (Math.random() * 3);
                            switch (aleatorioPodrido) {
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
                            podrida.add(new Podrida(patron5[0][i], patron5[1][i], animP));
                        } else {
                            comida.add(new Comida(patron5[0][i], patron5[1][i], eleccion, puntos));
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < 12; i++) {
                        if ((int) (Math.random() * 60) == 0) {
                            aleatorioPodrido = (int) (Math.random() * 3);
                            switch (aleatorioPodrido) {
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
                            podrida.add(new Podrida(patron6[0][i], patron6[1][i], animP));
                        } else {
                            comida.add(new Comida(patron6[0][i], patron6[1][i], eleccion, puntos));
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < 12; i++) {
                        if ((int) (Math.random() * 60) == 0) {
                            aleatorioPodrido = (int) (Math.random() * 3);
                            switch (aleatorioPodrido) {
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
                            podrida.add(new Podrida(patron7[0][i], patron7[1][i], animP));
                        } else {
                            comida.add(new Comida(patron7[0][i], patron7[1][i], eleccion, puntos));
                        }
                    }
                    break;
            }
            crearcomida = false;
        }
    }

    public void CrearEnemigos() {
        if (!crearenemigo && enemigos.size() < 2) {
            aleatorioEnemigo = (int) (Math.random() * 80);
            if (aleatorioEnemigo == 0) {
                crearenemigo = true;
            }
        }
        if (crearenemigo) {
            aleatorioEnemigo = (int) (Math.random() * ((int) (3 + (4 - velocidad / 4))));
            if (aleatorioEnemigo == 0 && score > 25) {
                enemigos.add(new Enemigo(1200, 460, animV, velocidad + 1));
            } else if (aleatorioEnemigo == 1 && score > 25) {
                enemigos.add(new Enemigo(1200, 480, animN, velocidad + 3));
            } else if (aleatorioEnemigo == 2 && score > 200) {
                enemigos.add(new Enemigo(1200, 30, animLamp, velocidad));
            }
            crearenemigo = false;
        }
    }
}
