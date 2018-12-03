package Physics.Engine.Shapes;
/**Excepcion que impide el uso de un radio negativo puesto que no es posible que exista objeto con tal caracteristica.
 *
 */
public class RadioNegativoEx extends Exception {
    private double radio;
    RadioNegativoEx(double radio){
        super("RadioNegativoEx");
        this.radio=radio;
    }
    public String toString(){
        return String.format("%s\nProblema de radio negativo o 0: %f",super.getMessage(),radio);
    }
}
