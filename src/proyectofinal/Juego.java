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

    private int indicadorVestuario;
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
    private int x;
    private int y;

    private Carro carro;

    private LinkedList<Comida> comida;

    private LinkedList<Podrida> podrida;

    private LinkedList<Enemigo> enemigos;

    private LinkedList<Base> burbuja;

    private Image carrito;
    private Image fondo01;
    private Image fondo02;
    private Image fondo03;
    private Image fondo00;
    private Image menuPrincipal;

    private Image letreroBurbuja;
    private Image letreroCohete;

    private Image lock;
    private Image bubbleN;
    private Image coheteTienda;
    private Image check;

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
    private Image imagenpausa;
    private Image der;
    private Image izq;
    private Image huskyazul;
    private Image huskyrosa;
    private Image huskynegro;
    private Image huskycohete;
    private Image huskycafe;

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
    private Boton bubbleComprar;
    private Boton bCohete;
    private Boton vestuario;
    private Boton derecha;
    private Boton izquierda;

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
    private boolean crearBurbuja;
    private boolean burbujaActiva;
    
    private boolean seleccionado;
    private boolean comprado;

    private boolean coheteSeleccionado;

    private boolean bubbleSeleccionada;

    private boolean azul;
    private boolean rosa;
    private boolean cafe;
    private boolean negro;
    private boolean azulComprado;
    private boolean rosaComprado;
    private boolean cafeComprado;
    private boolean negroComprado;
    private boolean coheteComprado;
    private boolean coheteActivo;
    private boolean burbujaComprada;

    private Animacion animC1;
    private Animacion animC2;
    private Animacion animC3;
    private Animacion animA1;
    private Animacion animA2;
    private Animacion animA3;
    private Animacion animN1;
    private Animacion animN2;
    private Animacion animN3;
    private Animacion animR1;
    private Animacion animR2;
    private Animacion animR3;
    private Animacion animCa1;
    private Animacion animCa2;
    private Animacion animCa3;

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
    private Animacion escudo;

    private Animacion azulCoheteActual;
    private Animacion azulCoheteAireActual;
    private Animacion azulCoheteOnActual;
    private Animacion azulCohete;
    private Animacion azulCoheteAire;
    private Animacion azulCoheteOn;
    private Animacion azulCohetemedio;
    private Animacion azulCoheteAiremedio;
    private Animacion azulCoheteOnmedio;
    private Animacion azulCohetelleno;
    private Animacion azulCoheteAirelleno;
    private Animacion azulCoheteOnlleno;

    private String archivoSave;
    private String archivoHighscores;
    private String nombre;

    private String[] arr;
    private String[] arrsave;
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
    private SoundClip comprar;
    private SoundClip error;

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
        burbuja = new LinkedList();
        podrida = new LinkedList();
        comida = new LinkedList();
        enemigos = new LinkedList();
        this.setSize(1200, 600);
        addKeyListener(this);           //Uso de las teclas
        addMouseListener(this);          //Uso de las teclas
        addMouseMotionListener(this);      //Uso de las teclas

        der = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/derecha.png"));
        izq = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/izquierda.png"));
        carrito = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/Cart.png"));
        fondo01 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo01.jpg"));
        fondo02 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo02.png"));
        fondo03 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo03.png"));
        fondo00 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/fondo00.png"));
        menuPrincipal = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/MenuPrincipal.png"));
        lock = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/lock.png"));
        check = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/check.png"));
        imagenpausa = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/letreropausa.png"));

        coheteTienda = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/cohete.png"));
        letreroBurbuja = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/letreroburbuja.png"));
        letreroCohete = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/letreroCohete.png"));
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
        bubbleN = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/bubblebuton1.png"));

        home = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/casita.png"));
        flecha = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/restart.png"));
        cuadrillo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/gameover.png"));

        huskyazul = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky3_2.png"));
        huskynegro = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskynegro3_1.png"));
        huskyrosa = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyrosa3_1.png"));
        huskycohete = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetlleno.png"));
        huskycafe = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskycafe3_1.png"));

        bCreditos = new Boton(25, 250, creditosN);
        bTienda = new Boton(1000, 250, tiendaN);
        bPlay = new Boton(515, 350, playN);
        bInst = new Boton(460, 25, instN);
        bScore = new Boton(460, 460, scoreN);
        bAbajo = new Boton(1100, -115, abajoN);
        bArriba = new Boton(1100, 635, arribaN);
        bDer = new Boton(-120, 500, derN);
        bIzq = new Boton(1220, 500, izqN);
        bubbleComprar = new Boton(1460, 160, bubbleN);
        bCohete = new Boton(1495, 350, coheteTienda);
        derecha = new Boton(2095, 300, der);
        izquierda = new Boton(1795, 300, izq);
        vestuario = new Boton(1910, 280, huskyazul);

        casita = new Boton(600 - 160, 760, home);
        restart = new Boton(630, 760, flecha);
        cuadroOver = new Boton(600 - 300, 660, cuadrillo);

        azul = false;
        rosa = false;
        negro = false;
        cafe = false;
        crearBurbuja = false;
        burbujaActiva = false;
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
        bubbleSeleccionada = false;
        seleccionado = false;
        comprado = false;

        coheteSeleccionado = false;

        burbujaComprada = false;

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

        crearAnimaciones();

        carro = new Carro(50, 480, animA1, 0);

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
        comprar = new SoundClip("Sounds/Comprar.wav");
        error = new SoundClip("Sounds/error.wav");
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
            if (sound) {
                musicaMenu.stop();
                musicaMenu.restart();
                musicaJuego.play2();
            } else {
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
            if (carro.getSuelo()) {
                carro.setPosX(carro.getPosX() + mov);
            } else if (jump) {
                carro.setPosX(carro.getPosX() + ((int) (mov / 1.5)));
            } else if (doublejump) {
                carro.setPosX(carro.getPosX() + ((int) (mov / 2)));
            }
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

            if (score < 75) {
                if (coheteActivo) {
                    azulCoheteActual = azulCohete;
                    azulCoheteAireActual = azulCoheteAire;
                    azulCoheteOnActual = azulCoheteOn;
                    carro.setImagenes(azulCoheteActual);
                } else {
                    carro.setImagenes(animC1);
                }
            } else if (score >= 75 && score < 150) {
                if (coheteActivo) {
                    azulCoheteActual = azulCohetemedio;
                    azulCoheteAireActual = azulCoheteAiremedio;
                    azulCoheteOnActual = azulCoheteOnmedio;
                    carro.setImagenes(azulCoheteActual);
                } else {
                    carro.setImagenes(animC2);
                }
            } else if (score >= 150) {
                if (coheteActivo) {
                    azulCoheteActual = azulCohetelleno;
                    azulCoheteAireActual = azulCoheteAirelleno;
                    azulCoheteOnActual = azulCoheteOnlleno;
                    carro.setImagenes(azulCoheteActual);

                } else {
                    carro.setImagenes(animC3);
                }
            }

            //Saltos
            if ((jump || doublejump) && coheteActivo) {
                carro.setImagenes(azulCoheteAireActual);
                if (carro.getSuelo()) {
                    jump = false;
                    doublejump = false;
                }
                if (carro.getPosY() + carro.getVelY() >= 481) {

                    carro.setSuelo(true);
                    carro.setPosY(480);
                    carro.setVelY(0);
                } else if (carro.getPosY() + carro.getVelY() <= 20) {
                    carro.setPosY(20);
                    carro.setVelY(carro.getVelY() + gravedad);
                } else {
                    if (!suelta) {
                        if (carro.getVelY() < 0) {
                            carro.setPosY(carro.getPosY() + carro.getVelY());
                            carro.setVelY(carro.getVelY() + gravedad);
                            carro.setImagenes(azulCoheteAireActual);
                        } else {
                            carro.setPosY(carro.getPosY() + carro.getVelY());
                            carro.setVelY(3);
                            carro.setImagenes(azulCoheteOnActual);
                        }
                    } else {
                        carro.setPosY(carro.getPosY() + carro.getVelY());
                        carro.setVelY(carro.getVelY() + gravedad);
                    }
                }
            }

            if ((jump || doublejump) && !coheteActivo) {
                if (carro.getSuelo()) {
                    jump = false;
                    doublejump = false;
                }
                if (carro.getPosY() + carro.getVelY() >= 481) {
                    carro.setSuelo(true);
                    carro.setPosY(480);
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
                if (sound) {
                    musicaJuego.stop();
                    musicaJuego.restart();
                    musicaGameover.play2();
                } else {
                    musicaJuego.stop();
                    musicaJuego.restart();
                    musicaGameover.stop();
                }
                mov = 0;
                total += score;
                pausa = false;
                vidas = 3;
                carro.setPosX(50);
                carro.setPosY(480);
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

            crearBurbuja = burbujaComprada;
            if (crearBurbuja) {
                burbuja.add(new Base(carro.getPosX() - 6, carro.getPosY() - 10, escudo));
                crearBurbuja = false;
                burbujaActiva = true;
            }

            if (burbujaActiva) {
                Base bubble = burbuja.get(0);
                bubble.setPosX(carro.getPosX() - 6);
                bubble.setPosY(carro.getPosY() - 10);
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
            if (sound) {
                musicaMenu.play2();
            } else {
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
                    bubbleComprar.setPosX(bubbleComprar.getPosX() - velTransicionX);
                    bCohete.setPosX(bCohete.getPosX() - velTransicionX);
                    derecha.setPosX(derecha.getPosX() - velTransicionX);
                    izquierda.setPosX(izquierda.getPosX() - velTransicionX);
                    vestuario.setPosX(vestuario.getPosX() - velTransicionX);
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
                    bubbleComprar.setPosX(bubbleComprar.getPosX() + velTransicionX);
                    bCohete.setPosX(bCohete.getPosX() + velTransicionX);
                    derecha.setPosX(derecha.getPosX() + velTransicionX);
                    izquierda.setPosX(izquierda.getPosX() + velTransicionX);
                    vestuario.setPosX(vestuario.getPosX() + velTransicionX);
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
        if (tienda) {
            if (indicadorVestuario == 1) {
                seleccionado = azul;
                comprado = azulComprado;
                vestuario.setImagen(huskyazul);
            } else if (indicadorVestuario == 2) {
                seleccionado = rosa;
                comprado = rosaComprado;
                vestuario.setImagen(huskyrosa);
            } else if (indicadorVestuario == 3) {
                seleccionado = cafe;
                comprado = cafeComprado;
                vestuario.setImagen(huskycafe);
            } else if (indicadorVestuario == 4) {
                seleccionado = negro;
                comprado = negroComprado;
                vestuario.setImagen(huskynegro);
            } else if (indicadorVestuario == 5) {
                seleccionado = coheteActivo;
                comprado = coheteComprado;
                vestuario.setImagen(huskycohete);
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
                if (auxfood == 0 && sound) {
                    food1.play();
                    auxfood++;
                } else if (sound) {
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
            if (burbujaActiva) {
                Base bubble = burbuja.get(0);
                if (actual.intersecta(bubble)) {
                    burbuja.remove(0);
                    enemigos.remove(i);
                    burbujaActiva = false;
                    burbujaComprada = false;
                }
            }

        }
        for (int i = 0; i < podrida.size(); i++) {
            Podrida actual = podrida.get(i);
            if (actual.intersecta(carro)) {
                if (sound) {
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
                if (sound) {
                    brinco.play();
                }
                carro.setVelY(-30);
                jump = true;
                carro.setSuelo(false);
            } else if (jump && !carro.getSuelo() && !doublejump && suelta) {
                if (sound) {
                    brinco2.play();
                }
                carro.setVelY(-28);
                jump = false;
                doublejump = true;
            }
            suelta = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mov = velocidad;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mov = -(velocidad);
        }
        /*if (e.getKeyCode() == KeyEvent.VK_B) {
         if (!burbujaActiva){
         crearBurbuja = true;
         }
         }*/
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
            if (burbujaActiva) {
                Base bubble = burbuja.get(0);
                g.drawImage(bubble.getImagen(), bubble.getPosX(), bubble.getPosY(), this);
            }
            if (pausa) {
                g.drawImage(imagenpausa, this.getWidth() / 2 - imagenpausa.getWidth(this) / 2, this.getHeight() / 2 - imagenpausa.getHeight(this) / 2, this);
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
                g.setFont(new Font("TimesRoman", Font.BOLD, 20));
                g.setColor(Color.WHITE);
                g.drawImage(bIzq.getImagen(), bIzq.getPosX(), bIzq.getPosY(), this);
                g.drawImage(bubbleComprar.getImagen(), bubbleComprar.getPosX(), bubbleComprar.getPosY(), this);
                g.drawString("$500", bubbleComprar.getPosX() + 35, bubbleComprar.getPosY() + 125 + 21);
                g.drawImage(bCohete.getImagen(), bCohete.getPosX(), bCohete.getPosY(), this);
                g.drawImage(derecha.getImagen(), derecha.getPosX(), derecha.getPosY(), this);
                g.drawImage(vestuario.getImagen(), vestuario.getPosX(), vestuario.getPosY(), this);
                if (indicadorVestuario ==1){
                    g.drawString("Gratis", vestuario.getPosX()+30, vestuario.getPosY()+150);
                } else if (indicadorVestuario == 2){
                    g.drawString("$2000", vestuario.getPosX()+30, vestuario.getPosY()+150);
                } else if (indicadorVestuario == 3){
                    g.drawString("$2000", vestuario.getPosX()+30, vestuario.getPosY()+150);
                } else if (indicadorVestuario == 4){
                    g.drawString("$2000", vestuario.getPosX()+30, vestuario.getPosY()+150);
                } else if (indicadorVestuario == 5){
                    g.drawString("$10000", vestuario.getPosX()+25, vestuario.getPosY()+150);
                } 
                if (seleccionado){
                    g.drawImage(check, vestuario.getPosX()+vestuario.getWidth()-7, vestuario.getPosY()+vestuario.getHeight()-15, this);
                }
                if (!comprado){
                    g.drawImage(lock, vestuario.getPosX()+vestuario.getWidth()/2-20, vestuario.getPosY()+vestuario.getHeight()/2-20, this);
                }
                g.drawImage(izquierda.getImagen(), izquierda.getPosX(), izquierda.getPosY(), this);
                g.drawString("$10000", bCohete.getPosX() - 15, bCohete.getPosY() + bCohete.getHeight() + 21);
                if (!burbujaComprada) {
                    g.drawImage(lock, bubbleComprar.getPosX() + 38, bubbleComprar.getPosY() + 30, this);
                }
                if (!coheteComprado) {
                    g.drawImage(lock, bCohete.getPosX() + 1, bCohete.getPosY() + 50, this);
                }
                if (coheteComprado && coheteActivo) {
                    g.drawImage(check, bCohete.getPosX() + bCohete.getWidth() - 7, bCohete.getPosY() + bCohete.getHeight() - 15, this);
                }
                if (bubbleSeleccionada) {
                    g.drawImage(letreroBurbuja, x, y, this);
                }
                if (coheteSeleccionado) {
                    g.drawImage(letreroCohete, x, y, this);
                }
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
                if (bPlay.dentro(x, y)) {
                    inicio = true;
                    crearcomida = true;
                    jugar = true;
                    menu = false;
                    if (azul) {
                        animC1 = animA1;
                        animC2 = animA2;
                        animC3 = animA3;
                    } else if (rosa) {
                        animC1 = animR1;
                        animC2 = animR2;
                        animC3 = animR3;
                    } else if (cafe) {
                        animC1 = animCa1;
                        animC2 = animCa2;
                        animC3 = animCa3;
                    } else if (negro) {
                        animC1 = animN1;
                        animC2 = animN2;
                        animC3 = animN3;
                    }
                }
                if (bCreditos.dentro(x, y)) {
                    if (sound) {
                        ida.play();
                    }
                    transicion = true;
                    creditos = true;
                }
                if (bTienda.dentro(x, y)) {
                    if (sound) {
                        ida.play();
                    }
                    transicion = true;
                    tienda = true;
                    if (coheteActivo) {
                        indicadorVestuario = 5;
                    } else if (azul) {
                        indicadorVestuario = 1;
                    } else if (rosa) {
                        indicadorVestuario = 2;
                    } else if (cafe) {
                        indicadorVestuario = 3;
                    } else if (negro) {
                        indicadorVestuario = 4;
                    }
                }
                if (bInst.dentro(x, y)) {
                    if (sound) {
                        ida.play();
                    }
                    transicion = true;
                    instrucciones = true;
                }
                if (bScore.dentro(x, y)) {
                    if (sound) {
                        ida.play();
                    }
                    transicion = true;
                    highscores = true;
                }
            }
            if (creditos) {
                if (bDer.dentro(x, y)) {
                    if (sound) {
                        vuelta.play();
                    }
                    regreso = true;
                    principal = true;
                }
            }
            if (tienda) {
                if (vestuario.dentro(x, y)){
                    if (indicadorVestuario == 1) {
                        if (!azul&&azulComprado){
                            azul = true;
                            cafe = false;
                            rosa = false;
                            negro = false;
                            coheteActivo = false;
                            try {
                                grabaSave();
                            } catch (IOException ioe) {
                                System.out.println("Error en " + ioe.toString());
                            }
                        }
                        if (!azulComprado){
                            if (total >=0){
                                if (sound){
                                    comprar.play();
                                }
                                azulComprado = true;
                                total -= 0;
                                azul = true;
                                cafe = false;
                                rosa = false;
                                negro = false;
                                coheteActivo = false;
                                try {
                                    grabaSave();
                                } catch (IOException ioe) {
                                    System.out.println("Error en " + ioe.toString());
                                }
                            } else{
                                if (sound){
                                    error.play();
                                }
                            }
                        }
                    } else if (indicadorVestuario == 2) {
                        if (!rosa&&rosaComprado){
                            azul = false;
                            cafe = false;
                            rosa = true;
                            negro = false;
                            coheteActivo = false;
                            try {
                                grabaSave();
                            } catch (IOException ioe) {
                                System.out.println("Error en " + ioe.toString());
                            }
                        }
                        if (!rosaComprado){
                            if (total>=2000){
                                if (sound){
                                    comprar.play();
                                }
                                rosaComprado = true;
                                total -= 2000;
                                azul = false;
                                cafe = false;
                                rosa = true;
                                negro = false;
                                coheteActivo = false;
                                try {
                                    grabaSave();
                                } catch (IOException ioe) {
                                    System.out.println("Error en " + ioe.toString());
                                }
                            }else{
                                if (sound){
                                    error.play();
                                }
                            }
                        }
                    } else if (indicadorVestuario == 3) {
                        if (!cafe&&cafeComprado){
                            azul = false;
                            cafe = true;
                            rosa = false;
                            negro = false;
                            coheteActivo = false;
                            try {
                                grabaSave();
                            } catch (IOException ioe) {
                                System.out.println("Error en " + ioe.toString());
                            }
                        }
                        if (!cafeComprado){
                            if (total>=2000){
                                if (sound){
                                    comprar.play();
                                }
                                cafeComprado = true;
                                total -= 2000;
                                azul = false;
                                cafe = true;
                                rosa = false;
                                negro = false;
                                coheteActivo = false;
                                try {
                                    grabaSave();
                                } catch (IOException ioe) {
                                    System.out.println("Error en " + ioe.toString());
                                }
                            }else{
                                if (sound){
                                    error.play();
                                }
                            }
                        }
                    } else if (indicadorVestuario == 4) {
                        if (!negro&&negroComprado){
                            azul = false;
                            cafe = false;
                            rosa = false;
                            negro = true;
                            coheteActivo = false;
                            try {
                                grabaSave();
                            } catch (IOException ioe) {
                                System.out.println("Error en " + ioe.toString());
                            }
                        }
                        if (!negroComprado){
                            if (total>=2000){
                                if (sound){
                                    comprar.play();
                                }
                                negroComprado = true;
                                total -= 2000;
                                azul = false;
                                cafe = false;
                                rosa = false;
                                negro = true;
                                coheteActivo = false;
                                try {
                                    grabaSave();
                                } catch (IOException ioe) {
                                    System.out.println("Error en " + ioe.toString());
                                }
                            }else{
                                if (sound){
                                    error.play();
                                }
                            }
                        }
                    } else if (indicadorVestuario == 5) {
                        if (!coheteActivo&&coheteComprado){
                            azul = false;
                            cafe = false;
                            rosa = false;
                            negro = false;
                            coheteActivo = true;
                            try {
                                grabaSave();
                            } catch (IOException ioe) {
                                System.out.println("Error en " + ioe.toString());
                            }
                        }
                        if (!coheteComprado){
                            if (total>=10000){
                                if (sound){
                                    comprar.play();
                                }
                                coheteComprado = true;
                                total -= 10000;
                                azul = false;
                                cafe = false;
                                rosa = false;
                                negro = false;
                                coheteActivo = true;
                                try {
                                    grabaSave();
                                } catch (IOException ioe) {
                                    System.out.println("Error en " + ioe.toString());
                                }
                            }else{
                                if (sound){
                                    error.play();
                                }
                            }
                        }
                    }
                }
                if (bIzq.dentro(x, y)) {
                    if (sound) {
                        vuelta.play();
                    }
                    regreso = true;
                    principal = true;
                }
                if (derecha.dentro(x, y)){
                    indicadorVestuario++;
                    if (indicadorVestuario>5){
                        indicadorVestuario = 1;
                    }
                }
                if (izquierda.dentro(x, y)){
                    indicadorVestuario--;
                    if (indicadorVestuario<1){
                        indicadorVestuario = 5;
                    }
                }
                if (bubbleComprar.dentro(x, y) && bubbleSeleccionada && !burbujaComprada) {
                    if (total >= 500) {
                        if (sound) {
                            comprar.play();
                        }
                        burbujaComprada = true;
                        total -= 500;
                        bubbleSeleccionada = false;
                        try {
                            grabaSave();
                        } catch (IOException ioe) {
                            System.out.println("Error en " + ioe.toString());
                        }
                    } else {
                        if (sound) {
                            error.play();
                        }
                    }
                }
                if (bCohete.dentro(x, y) && coheteComprado) {
                    coheteActivo = !coheteActivo;
                    if (coheteActivo) {
                        indicadorVestuario = 5;
                        rosa = false;
                        cafe = false;
                        negro = false;
                        azul = false;
                    } else {
                        indicadorVestuario = 1;
                        rosa = false;
                        cafe = false;
                        negro = false;
                        azul = true;
                    }
                    try {
                        grabaSave();
                    } catch (IOException ioe) {
                        System.out.println("Error en " + ioe.toString());
                    }
                }
                if (bCohete.dentro(x, y) && coheteSeleccionado && !coheteComprado) {
                    if (total >= 10000) {
                        if (sound) {
                            comprar.play();
                        }
                        coheteComprado = true;
                        coheteActivo = true;
                        indicadorVestuario = 5;
                        rosa = false;
                        cafe = false;
                        negro = false;
                        azul = true;
                        total -= 10000;
                        coheteSeleccionado = false;
                        try {
                            grabaSave();
                        } catch (IOException ioe) {
                            System.out.println("Error en " + ioe.toString());
                        }
                    } else {
                        if (sound) {
                            error.play();
                        }
                    }
                }
            }
            if (instrucciones) {
                if (bAbajo.dentro(x, y)) {
                    if (sound) {
                        vuelta.play();
                    }
                    regreso = true;
                    principal = true;
                }
            }
            if (highscores) {
                if (bArriba.dentro(x, y)) {
                    if (sound) {
                        vuelta.play();
                    }
                    regreso = true;
                    principal = true;
                }
            }
        }
        if (gameover) {
            if (casita.dentro(x, y)) {
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

            if (restart.dentro(x, y)) {
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
        x = e.getX();
        y = e.getY();
        if (menu) {
            if (principal) {
                if (bCreditos.dentro(x, y)) {
                    bCreditos.setImagen(creditosS);
                } else {
                    bCreditos.setImagen(creditosN);
                }

                if (bTienda.dentro(x, y)) {
                    bTienda.setImagen(tiendaS);
                } else {
                    bTienda.setImagen(tiendaN);
                }

                if (bInst.dentro(x, y)) {
                    bInst.setImagen(instS);
                } else {
                    bInst.setImagen(instN);
                }

                if (bPlay.dentro(x, y)) {
                    bPlay.setImagen(playS);
                } else {
                    bPlay.setImagen(playN);
                }

                if (bScore.dentro(x, y)) {
                    bScore.setImagen(scoreS);
                } else {
                    bScore.setImagen(scoreN);
                }
            }
            if (creditos) {
                if (bDer.dentro(x, y)) {
                    bDer.setImagen(derS);
                } else {
                    bDer.setImagen(derN);
                }
            }
            if (tienda) {
                if (bIzq.dentro(x, y)) {
                    bIzq.setImagen(izqS);
                } else {
                    bIzq.setImagen(izqN);
                }
                if (bubbleComprar.dentro(x, y)) {
                    bubbleSeleccionada = true;
                } else {
                    bubbleSeleccionada = false;
                }
                if (bCohete.dentro(x, y)) {
                    coheteSeleccionado = true;
                } else {
                    coheteSeleccionado = false;
                }

            }
            if (instrucciones) {
                if (bAbajo.dentro(x, y)) {
                    bAbajo.setImagen(abajoS);
                } else {
                    bAbajo.setImagen(abajoN);
                }
            }
            if (highscores) {
                if (bArriba.dentro(x, y)) {
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
            fileOut.println("0,false,false,false,true,false,false,false,true,false,false,false");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(archivoSave));
        }
        String dato = fileIn.readLine();
        while (dato != null) {

            arrsave = dato.split(",");
            total = (Integer.parseInt(arrsave[0]));
            burbujaComprada = (Boolean.parseBoolean(arrsave[1]));
            coheteComprado = (Boolean.parseBoolean(arrsave[2]));
            coheteActivo = (Boolean.parseBoolean(arrsave[3]));
            azul = (Boolean.parseBoolean(arrsave[4]));
            rosa = (Boolean.parseBoolean(arrsave[5]));
            cafe = (Boolean.parseBoolean(arrsave[6]));
            negro = (Boolean.parseBoolean(arrsave[7]));
            azulComprado = (Boolean.parseBoolean(arrsave[8]));
            rosaComprado = (Boolean.parseBoolean(arrsave[9]));
            cafeComprado = (Boolean.parseBoolean(arrsave[10]));
            negroComprado = (Boolean.parseBoolean(arrsave[11]));
            dato = fileIn.readLine();
        }
        fileIn.close();
    }

    public void grabaSave() throws IOException {

        PrintWriter fileOut = new PrintWriter(new FileWriter(archivoSave));

        fileOut.print(total + "," + burbujaComprada + "," + coheteComprado + "," + coheteActivo + ",");
        fileOut.print(azul + "," + rosa + "," + cafe + "," + negro+",");
        fileOut.print(azulComprado + "," + rosaComprado + "," + cafeComprado + "," + negroComprado);
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
            aleatorioEnemigo = (int) (Math.random() * 60);
            if (aleatorioEnemigo == 0) {
                crearenemigo = true;
            }
        }
        if (crearenemigo) {
            aleatorioEnemigo = (int) (Math.random() * ((int) (3 + (2 - velocidad / 9))));
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

    public void crearAnimaciones() {
        azulCohete = new Animacion();
        azulCohete.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJet.png")), 100);
        azulCohete.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJet2.png")), 100);

        azulCoheteAire = new Animacion();
        azulCoheteAire.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetAire.png")), 100);

        azulCoheteOn = new Animacion();
        azulCoheteOn.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetOn.png")), 100);
        azulCoheteOn.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetOn2.png")), 100);

        azulCohetemedio = new Animacion();
        azulCohetemedio.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetmedio.png")), 100);
        azulCohetemedio.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetmedio2.png")), 100);

        azulCoheteAiremedio = new Animacion();
        azulCoheteAiremedio.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetAireMedio.png")), 100);

        azulCoheteOnmedio = new Animacion();
        azulCoheteOnmedio.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetOnMedio.png")), 100);
        azulCoheteOnmedio.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetOnMedio2.png")), 100);

        azulCohetelleno = new Animacion();
        azulCohetelleno.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetlleno.png")), 100);
        azulCohetelleno.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetlleno2.png")), 100);

        azulCoheteAirelleno = new Animacion();
        azulCoheteAirelleno.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetAireLleno.png")), 100);

        azulCoheteOnlleno = new Animacion();
        azulCoheteOnlleno.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetOnLleno.png")), 100);
        azulCoheteOnlleno.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyJetOnLleno.png")), 100);

        eleccion = new Animacion();
        enem = new Animacion();

        escudo = new Animacion();
        escudo.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/bubble.png")), 100);

        animA1 = new Animacion();                //crea animacion del carro
        animA1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky1_1.png")), 100);
        animA1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky1_2.png")), 100);

        animA2 = new Animacion();                //crea animacion del carro
        animA2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky2_1.png")), 100);
        animA2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky2_2.png")), 100);

        animA3 = new Animacion();                //crea animacion del carro
        animA3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky3_1.png")), 100);
        animA3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky3_2.png")), 100);

        animR1 = new Animacion();                //crea animacion del carro
        animR1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyrosa1_1.png")), 100);
        animR1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyrosa1_2.png")), 100);

        animR2 = new Animacion();                //crea animacion del carro
        animR2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyrosa2_1.png")), 100);
        animR2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyrosa2_2.png")), 100);

        animR3 = new Animacion();                //crea animacion del carro
        animR3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyrosa3_1.png")), 100);
        animR3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskyrosa3_2.png")), 100);
        
        animCa1 = new Animacion();                //crea animacion del carro
        animCa1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskycafe1_1.png")), 100);
        //animCa1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky1_2.png")), 100);

        animCa2 = new Animacion();                //crea animacion del carro
        animCa2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskycafe2_1.png")), 100);
        //animCa2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky2_2.png")), 100);

        animCa3 = new Animacion();                //crea animacion del carro
        animCa3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskycafe3_1.png")), 100);
        //nimCa3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/husky3_2.png")), 100);
        
        animN1 = new Animacion();                //crea animacion del carro
        animN1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskynegro1_1.png")), 100);
        animN1.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskynegro1_2.png")), 100);

        animN2 = new Animacion();                //crea animacion del carro
        animN2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskynegro2_1.png")), 100);
        animN2.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskynegro2_2.png")), 100);

        animN3 = new Animacion();                //crea animacion del carro
        animN3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskynegro3_1.png")), 100);
        animN3.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/huskynegro3_2.png")), 100);

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

    }
}
