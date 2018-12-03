package Physics.Engine;

import Physics.Engine.Shapes.Circle;
import Physics.Engine.Shapes.Particula;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;


public class Lienzo extends JPanel {
    private ArrayList<Particula> Particulas = new ArrayList<>() ;

    private static void drawShape(Particula p, Graphics g){
        g.setColor(p.getColor());
        if(p instanceof Circle){
            Circle circle = (Circle)p;
            //el primer 2 es por ser el radio y el segundo es el factor de escala de pixeles a metros
            //se le resta a la posicion porque la coordenada no es el centro del circulo, es una esquina
            g.fillOval((int)((circle.getPosX()-circle.getRadius())*Engine.zoom),600-(int)((circle.getPosY()+circle.getRadius())*Engine.zoom),(int)circle.getRadius()*Engine.zoom*2,(int)circle.getRadius()*Engine.zoom*2);
        }
    }
    public void agregar(Particula...p){
        Particulas.addAll(Arrays.asList(p));
    }

    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i< Particulas.size(); i++){
            drawShape(Particulas.get(i),g);
        }
    }

}
