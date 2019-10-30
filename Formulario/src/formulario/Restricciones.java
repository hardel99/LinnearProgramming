/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

/**
 *
 * @author Rosalio Monterrosa
 */
public class Restricciones {
    //Varibles
    int X;//Coeficiente de X
    int Y;//Coeficiente de Y
    int W;//Coeficiente de W
    int N;//Numero
    String discriminante;
    //Variables

    public Restricciones() {
    }
    
    public Restricciones(int X, int Y, int W, String discriminante, int N) {
        this.X = X;
        this.Y = Y;
        this.W = W;
        this.N = N;
        this.discriminante = discriminante;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getW() {
        return W;
    }

    public void setW(int W) {
        this.W = W;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public String getDiscriminante() {
        return discriminante;
    }

    public void setDiscriminante(String discriminante) {
        this.discriminante = discriminante;
    }

    @Override
    public String toString() {
        return W+"W + "+X+"X + "+Y+"Y "+discriminante+" "+N;
    }
    
    
}
