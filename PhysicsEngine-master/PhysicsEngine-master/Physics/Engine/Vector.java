package Physics.Engine;


public class Vector {//Clase para objetos que requieren un numero para cada dimension "Xi+Yj" contiene metodos para operaciones vectoriales.
    private double x;
    private double y;

    /**Contructor vacio de vector.
     * Valores iniciales 0,0.
     */
    public Vector() {
        this(0, 0);
    }

    /**Contructor de vector.
     * Recibe x,y.
     * @param x Elemento del par ordenado 1.
     * @param y Elemento del par ordenado 2.
     */
    public Vector(double x,double y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**Opercion vectorial.
     * Altera el valor del vector original (Xi+Yj) sumando: 
     * Xi+Yj + Ai+Bj = (X+A)i + (Y+B)j
     * @param y    segundo vector (Ai+Bj)
     */
    public void sumaV(Vector y) {//
        this.setX(this.x + y.getX());
        this.setY(this.y + y.getY());
    }

    /**Opercion vectorial.
     * Altera el valor del vector original (Xi+Yj) restando: 
     * Xi+Yj - Ai+Bj = (X-A)i + (Y-B)j
     * @param y    segundo vector (Ai+Bj)
     */
    public void restaV(Vector y) {
        this.setX(this.x - y.getX());
        this.setY(this.y - y.getY());
    }

    /**Opercion vectorial.
     * Altera el valor del vector multiplicando sus partes por un escalar
     * d(Xi+Yj) = (Xd)i + (Yd)j
     * @param d    escalar.
     */
    public void pEscalarYV(double d) {
        this.setX(this.x * d);
        this.setY(this.y * d);
    }

    /**Opercion vectorial.
     * Retorna el producto punto del vector original y el parametro
     * (Xi+Yj) o (Ai+Bj) = (X)(A)i + (Y)(B)j
     * @param v segundo vector.
     */
    public double pPoint(Vector v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    /**Opercion vectorial.
     * Retorna la magnitud del vector es decir 
     * la raiz de la suma de sus elementos elevados al cuadrado
     * ((X^2) + (Y^2))^(1/2)
     */
    public double magnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    /**Opercion vectorial.
     * Altera al vector cambiando sus datos a su valor unitario 
     * cada valor se divide entre la magnitud del vector
     * (X / ((X^2) + (Y^2))^(1/2))i + (Y / ((X^2) + (Y^2))^(1/2))j
     */
    public void unitarioV() {
        double mag = this.magnitude();
        this.setX(this.x / mag);
        this.setY(this.y / mag);
    }

    @Override
    public String toString() {
        return String.format("%f i , %f j", this.x, this.y);
    }
    
}
