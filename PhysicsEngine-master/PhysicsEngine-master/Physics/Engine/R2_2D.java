package Physics.Engine;

public class R2_2D extends R1_1D {//la dimencson Y implementando la dimension X para tener 2D
    protected static double Y_ORIGIN = 0;//no final porque puede en algun momento requerir moverse el origen

    public static double getyOrigin(){
        return Y_ORIGIN;
    }
    public static void moveXOrigin(char r_a, double desp){//movimiento relativo o absoluto
        Y_ORIGIN=(r_a=='r')?Y_ORIGIN+desp:desp;
    }
}
