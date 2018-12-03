package Physics.Engine.Shapes;


import Physics.Engine.R2_2D;
import Physics.Engine.Vector;

import java.awt.*;

public class Particula {
    private Vector pos = new Vector();
    private Vector vel = new Vector();
    private Vector acc = new Vector();
    private Vector forc= new Vector();
    private double masa = 1;
    private Color color = new Color(80, 80, 200);

    /**
     * Constructor vacio de particula
     * las coordenadas default se toman del origen de ambas dimensiones (double Physics.Engine.R1_1D.getxOrigin(), double Physics.Engine.R2_2D.getyOrigin())
     * y una masa default de 1
     */
    public Particula(){
        pos.setX(R2_2D.getxOrigin());
        pos.setY(R2_2D.getyOrigin());
    }

    /**
     * Constructor de particula; coloca la particula en el origen (double Physics.Engine.R1_1D.getxOrigin(), double Physics.Engine.R2_2D.getyOrigin())
     * y se le asigna masa a la particula
     * @param masa		masa de la particula
     * @throws MasaNegativaEx	masa negativa no es permitida
     */
    public Particula(double masa)throws MasaNegativaEx {
        this();
        setMasa(masa);
    }

    /**Constructor de particula; coloca la particula en las coordenadas indicadas y asigna la masa a la particula
     * @param posX	posicion en el eje X
     * @param posY	posicion en el eje Y
     * @param masa	masa de la particula
     */
    public Particula(double posX, double posY, double masa) throws MasaNegativaEx{
        this(masa);
        this.pos.setX(posX);
        this.pos.setY(posY);
    }

    /**Esta funcion actualiza la posicion de la partcula deacuerdo a su velocidad, peso, direccion y tamaño
     * deacuerdo a la unidad de tiempo de la simulacion
     * @param time unidad de tiempo o velocidad de la simulacion (se recomienda 8333)
     */
    public void update(int time){//funcion actualizar Particula
        //a=F/m
        this.acc.setX(this.forc.getX()/this.masa);
        this.acc.setY((this.forc.getY()/this.masa)-(9.81));//considerar gravedad como negativa, para abajo
        /*
        Y+
        ^
        |
        |
        |
        *----------->X+
         */

        //velocidad
        this.vel.setX(this.vel.getX()+this.acc.getX()*time/1000_000);
        this.vel.setY(this.vel.getY()+this.acc.getY()*time/1000_000);

        //posicion
        this.pos.setX(this.pos.getX()+this.vel.getX()*time/1000_000);
        this.pos.setY(this.pos.getY()+this.vel.getY()*time/1000_000);
    }
    /**
     * Funcion que permite el movimiento de la particula de manera relativa (r_a = 'r') o absoluta (r_a = 'a')
     * deacuerdo a los datos de desplasamiento otorgados
     * @param r_a	indica si el movimiento es relativo ('r') o absoluto ('a') 
     * relativo: "mover desde donde esta la particula". absoluto: "mover la particula a ..."
     * @param despX	variable del desplazamiento en el eje X
     * @param despY variable del desplazamiento en el eje Y
     */
    public void move(char r_a, double despX, double despY){//movimiento relativo o absoluto
        this.pos.setX((r_a=='r')?this.pos.getX()+despX:despX);
        this.pos.setY((r_a=='r')?this.pos.getY()+despY:despX);
    }

    public void sumForX(double forX){
        setForX(getForX()+forX);
    }

    public void sumForY(double forY){
        setForY(getForY()+forY);
    }

    public void sumFor(double mag, double dir){
        setForX(getForX()+(mag*Math.cos(dir)));
        setForY(getForY()+(mag*Math.sin(dir)));
    }

    public double getPosX(){
        return this.pos.getX();
    }

    public double getPosY(){
        return this.pos.getY();
    }

    public Vector getPos() {
        return new Vector(this.getPosX(),this.getPosY());
    }

    public double getMasa(){
        return masa;
    }

    public double getVelX(){
        return this.vel.getX();
    }

    public double getVelY(){
        return this.vel.getY();
    }

    public Vector getVel() {
        return new Vector(this.getVelX(),this.getVelY());
    }

    public double getAccX(){
        return this.acc.getX();
    }

    public double getAccY(){
        return this.acc.getY();
    }


    public double getForX(){
        return this.forc.getX();
    }

    public double getForY(){
        return this.forc.getY();
    }
    
    /**
     * Funcion que cambia la velocidad de la particula en el eje X
     * @param velX nuevo valor de velocidad en X
     */
    public void setVelX(double velX){//fuerza el cambio
        this.vel.setX(velX);
    }

    /**
     * Funcion que cambia la velocidad de la particula en el eje Y
     * @param velY nuevo valor de velocidad en Y
     */
    public void setVelY(double velY){//fuerza el cambio
        this.vel.setY(velY);
    }

    /**
     * Funcion que cambia el vector de velocidad
     * @param mag	magnitud o tamaño de la velocidad
     * @param dir	direccion de la velocidad, el angulo.
     */
    public void setVel(double mag, double dir){
        setVelX(mag*Math.cos(dir*Math.PI/180));
        setVelY(mag*Math.sin(dir*Math.PI/180));
    }

    /**
     * Funcion que cambia la aceleracion de la particula en el eje X
     * @param accX nuevo valor de aceleracion en X
     */
    public void setAccX(double accX){//fuerza cambio
        this.acc.setX(accX);
    }

    /**
     * Funcion que cambia la "fuerza" de la particula en el eje X
     * @param forX nuevo valor de aceleracion en X
     */
    public void setForX(double forX){//fuerza cambio
        this.forc.setX(forX);
    }

    /**
     * Funcion que cambia la aceleracion de la particula en el eje Y
     * @param accY nuevo valor de aceleracion en Y
     */
    public void setAccY(double accY){//fuerza cambio
        this.acc.setY(accY);
    }

    /**
     * Funcion que cambia la "fuerza" de la particula en el eje Y
     * @param forY nuevo valor de aceleracion en Y
     */
    public void setForY(double forY) {//fuerza cambio
        this.forc.setY(forY);
    }

    /**
     * Funcion que cambia la masa de la particula
     * @param masa	nueva masa de la particula
     * @throws MasaNegativaEx no se permite masa negativa
     */
    public void setMasa(double masa) throws MasaNegativaEx{
        if(masa<=0) throw new MasaNegativaEx(masa);
        this.masa=masa;
    }

    public static void busyWaitMicros(long micros){
        long waitUntil = System.nanoTime() + (micros * 1_000);
        while(waitUntil > System.nanoTime()){
        }//http://www.rationaljava.com/2015/10/measuring-microsecond-in-java.html
    }

    /**
     * Cambia el color de la particula en el formato RGB.
     * @param r	valor de 0 a 255 para rojo
     * @param g valor de 0 a 255 para verde
     * @param b valor de 0 a 255 para azul
     */
    public void setColor(int r, int g, int b){
        this.color = new Color(r,g,b);
    }

    public Color getColor(){
        return this.color;
    }

    @Override
    public String toString(){
        return String.format("Posicion: (%.2f, %.2f)\nVelocidad: (%.2f, %.2f)\nAceleracion: (%.2f, %.2f)\nFuerza: (%.2f, %.2f)\nMasa: %.2f",pos.getX(),pos.getY(),vel.getX(),vel.getY(),acc.getX(),acc.getY(),forc.getX(),forc.getY(),masa);
    }
}
