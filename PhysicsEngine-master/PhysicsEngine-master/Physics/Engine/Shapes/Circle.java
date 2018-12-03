package Physics.Engine.Shapes;
import Physics.Engine.Vector;

public class Circle extends Particula implements Shape{
    private double radius = 1;

    /**
     * constructor vacio, valor default: radio = 1
     * @throws RadioNegativoEx	radio negativo no es permitido
     */
    public Circle() throws RadioNegativoEx{
        this(1);
    }

    /**
     * Constructor del circulo, genera una particula de la clase: Physics.Engine.Shapes.Particula.Particula()
     * con la forma de un circulo del radio indicado y masa default 1.
     * @param radius tamaño del circulo 
     * @throws RadioNegativoEx	radio negativo no es permitido
     */
    public Circle(double radius) throws RadioNegativoEx{
        super();
        setRadius(radius);
    }

    /**
     * Constructor de circulo, genera una particula de la clase: Physics.Engine.Shapes.Particula.Particula()
     * con la forma de un circulo del radio indicado y la masa indicada
     * @param radius	radio de la particula circular
     * @param masa		masa de la particula circular
     * @throws MasaNegativaEx	masa negativa no es permitida
     * @throws RadioNegativoEx	radio negativo no es permitido
     */
    public Circle(double radius, double masa) throws MasaNegativaEx, RadioNegativoEx {
        super(masa);
        setRadius(radius);
    }

    /**Constructor de circulo, genera una particula de la clase: Physics.Engine.Shapes.Particula.Particula()
     * con la forma de un circulo del radio indicado y la masa indicada
     * ademas se le inica la posicion inicial de la particula
     * @param radius	radio de la particula circular
     * @param masa		masa de la particula
     * @param x			coordenada de origen en X
     * @param y			coordenada de origen en Y
     * @throws MasaNegativaEx	masa negativa no es permitida
     * @throws RadioNegativoEx	radio negativo no es permitido
     */
    public Circle(double radius, double masa,double x, double y) throws MasaNegativaEx, RadioNegativoEx{
        super(x,y,masa);
        setRadius(radius);
    }

    /**
     * Cambia el radio de la particula circulo
     * @param r	nuevo radio
     * @throws RadioNegativoEx radio negativo no es permitido
     */
    public void setRadius(double r) throws RadioNegativoEx{
        if(r<=0)throw new RadioNegativoEx(r);
        this.radius = r;
    }

    /**
     * Devuelve el valor del radio de este circulo (double)
     */
    public double getRadius(){
        return this.radius;
    }

    /**Realiza los calculos vectoriales para detectar la colision de dos particulas y
     * alterar sus direciones y velocidades en caso de colision 
     * @param t	unidad de tiempo o velocidad de la simulacion
     * @param p	particula contra la que se revisa el caso de colision
     */
    public void proUpdate(int t, Particula p){
        double e = 1;
        this.update(t);
        if(p instanceof Circle){
            Circle c = (Circle)p;
            double dx = this.getPosX()-c.getPosX();
            double dy = this.getPosY()-c.getPosY();
            double dist = Math.sqrt(dx*dx+dy*dy);
            if(dist<=this.getRadius()+c.getRadius()){//.0241
                Vector nor = new Vector(this.getPosX(),this.getPosY());
                nor.restaV(c.getPos());
                nor.unitarioV();

                double vel1p = nor.pPoint(this.getVel());
                double vel2p = nor.pPoint(c.getVel());

                double velP1p = ((this.getMasa()-e*c.getMasa())*vel1p + (1+e)*c.getMasa()*vel2p)/(this.getMasa()+c.getMasa());
                double velP2p = ((c.getMasa()-e*this.getMasa())*vel2p + (1+e)*this.getMasa()*vel1p)/(this.getMasa()+c.getMasa());

                Vector velP1 = new Vector(this.getVelX(),this.getVelY());
                Vector velP2 = new Vector(c.getVelX(),c.getVelY());

                velP1.sumaV(new Vector((velP1p - vel1p)*nor.getX(),(velP1p - vel1p)*nor.getY()));
                velP2.sumaV(new Vector((velP2p - vel2p)*nor.getX(),(velP2p - vel2p)*nor.getY()));

                this.setVelX(velP1.getX());
                this.setVelY(velP1.getY());

                c.setVelX(velP2.getX());
                c.setVelY(velP2.getY());
            }
        }
    }
}
