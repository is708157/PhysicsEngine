package Physics.Engine.Shapes;
import Physics.Engine.Engine;

public class Boundary{

    private static Boundary instance = new Boundary();

    /**constructor de clase
     * debe permanecer vacio
     */
    private Boundary(){

    }

    /**Detector de colisiones en su nivel mas basico
     * le indica a su particula como puede o no moverse
     * en relacion a los bordes
     * @param p particula rodeada por Boundary
     */
    public void proUpdate(Particula p){
        if(p instanceof Circle){
            Circle c = (Circle)p;
            if((c.getPosX()-c.getRadius())<=0){//izquierdo derecho, valores cambian por el zoom
                c.setVelX(-c.getVelX());
                c.move('r',.01,0);//Linea para evitar que se lo coma el borde
            }
            if((c.getPosX()+c.getRadius())>=800/ Engine.zoom){//izquierdo derecho, valores cambian por el zoom
                c.setVelX(-c.getVelX());
                c.move('r',-.01,.01);//Linea para evitar que se lo coma el borde
            }
            if((c.getPosY()-c.getRadius())<=0){
                c.setVelY(-c.getVelY());
                c.move('r',0,.01);//Linea para evitar que se lo coma el borde
            }
            if((c.getPosY()+c.getRadius())>=600/Engine.zoom){
                c.setVelY(-c.getVelY());
                c.move('r',0,-.01);//Linea para evitar que se lo coma el borde.01
            }
        }
    }

    public static Boundary getInstance(){
        return instance;
    }

}
