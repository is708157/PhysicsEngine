package Physics.Engine.Shapes;
/**
 * Excepcion que impide el uso de masa negativa puesto que no es posible que exista objeto con tal caracteristica.
 *
 */
public class MasaNegativaEx extends Exception {
    private double masa;
    
    MasaNegativaEx (double masa){
        super("MasaNegativaEx");
        this.masa=masa;
    }
    public String toString(){
        return String.format("%s\nProblema de masa negativa o 0: %f",super.getMessage(),masa);
    }
}
