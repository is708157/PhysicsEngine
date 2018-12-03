package Physics.Engine;

import Physics.Engine.Shapes.*;

public class Engine {

    private static int v_sim =1;
    public static int zoom=1;


    /**Detector de colisiones resive la unidad de tiempo el borde o caja 
     * y todas las particulas que participaran en la simulacion
     * @param t  	Representa la unidad de tiempo y la velocidad con la que se actualizara la simulacion.
     * Recomendado 8333.
     * @param borde Delimita la zona en que las particulas serian confinadas (una caja)
     * @param particulas Todos los objetos en movimiento dentro de la simulacion
     */
    private static void colision(int t,Boundary borde,Particula ...particulas) {
        for(int i=0;i<particulas.length;i++){
            borde.proUpdate(particulas[i]);
            for(int j=i+1;j<particulas.length;j++){
                if(particulas[i] instanceof Circle) {
                    Circle circulo = (Circle) particulas[i];
                    circulo.proUpdate(t, particulas[j]);
                    particulas[j].update(t);
                }
            }
        }
    }

    public static void main(String[] args) throws MasaNegativaEx, RadioNegativoEx{
        TestDibujo n=new TestDibujo();

        Boundary borde = Boundary.getInstance();
        Circle carro = new Circle(1,150,3,3);
        Circle carro2 = new Circle(4,150,23,5);
        Circle carro3 = new Circle(4,150,31,5);
        Circle carro4 = new Circle(10,150,31,40);


        carro.setVel(-20,0);
        carro.setColor(200,10,10);
        carro2.setVel(20,135);
        carro2.setColor(0,0,240);
        carro3.setVel(20, 90);
        carro3.setColor(50,0,50);

        v_sim=1;
        zoom=9;
        n.lienzo.agregar(carro,carro2,carro3,carro4);

        int tiempo = (1000_000_000/8333);//ultima parte son segundos
        Particula.busyWaitMicros(150_000);//Esperar a que cargue
        for(int i=0;i<tiempo;i=i+v_sim){
            Particula.busyWaitMicros(8333);//velocidad de simulacion tiempo real es 100 arriba de 1500 es aceptable, en 2500 ya es estable
            colision(8333,borde,carro,carro2,carro3,carro4);//Original 8333
            n.lienzo.repaint();
        }
    }
}