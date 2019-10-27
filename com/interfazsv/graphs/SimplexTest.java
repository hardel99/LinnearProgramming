package com.interfazsv.graphs;

import dataStructures.NuevaLista;
import dataStructures.Simplex;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hardel
 */
public class SimplexTest {
    private final List<NuevaLista> equations = new ArrayList<>();
    
    public SimplexTest() {
    }
    
    //llamar desde main()
    public void test() {
        boolean quit = false;
        
        /*Ejemplo:
          maximizar:  3x + 5y 
          condiciones: x +  y = 4
                       x + 3y = 6*/
//        float[][] standardized =  {
//                { 1,   1,    1,  0,   4},
//                { 1,   3,    0,  1,   6},
//                {-3,  -5,    0,  0,   0}
//        };

        prepareAll();
        int rows = equations.size();
        int columns = equations.get(0).getSize();
        int count = 0;
        
        float[][] standarized = new float[rows][columns];
        
        //filling the matrix
        for(NuevaLista nl : equations) {
            for(int j = 0; j < nl.getSize(); j++) {
                standarized[count][j] = nl.getElementAt(j);
            }
            count++;
        }
        
        count = 0;
        
        /*2 variables
          4 valores desconocidos*/
        Simplex simplex = new Simplex(rows - 1, columns - 1);   //Less 1 cause the Z function and the result values doesn't count
        
        simplex.fillTable(standarized);

        //Para debugging
        //Imprimir Matriz
        /*System.out.println("---Inicializando---");
        simplex.print();*/
        
        //Si la Matriz(tabla simplex) no es optima iterar hasta llegar a una solucion
        while(!quit){
            Simplex.ERROR err = simplex.compute();
            
            //se encontro la mejor solucion
            if(err == Simplex.ERROR.IS_OPTIMAL) {
                simplex.print();
                quit = true;
            } else if(err == Simplex.ERROR.UNBOUNDED) {
                //el problema no se puede solucionar por simplex
                System.out.println("---Solution Ambigua---");
                quit = true;
            }
        }
    }
    
    private void prepareAll() {
        NuevaLista zeta = new NuevaLista();
        NuevaLista s1 = new NuevaLista();
        NuevaLista s2 = new NuevaLista();

        zeta.addNodeZ(3);//variable con valor 
        zeta.addNodeZ(5);// variable con valor 
        zeta.addNodeZ(0); // variable artificial si es 0 
        zeta.addNodeZ(0);
        zeta.addNodeZ(-1); // criterio de z si es -1 el parametro 

        System.out.println("Funcion Z Valores:");
        zeta.showList(zeta);


        System.out.println("Funcion S1 Valores");

        s1.addNodeS(1, 'a');// Variable con valor
        s1.addNodeS(1, 'a');//variable con valor 
        s1.addNodeS(0, 'a'); // variable 0 holgura 
        s1.addNodeS(0, 's'); // variable s artificial 
        s1.addNodeS(4, 'a');// // criterio variable con valor 


        s1.showList(s1);

        System.out.println("Funcion S2 Valores");

        s2.addNodeS(1, 'a');
        s2.addNodeS(3, 'a');
        s2.addNodeS(0, 's');
        s2.addNodeS(0, 'a');
        s2.addNodeS(6, 'a');

        s2.showList(s2);
        
        equations.add(s1);
        equations.add(s2);
        equations.add(zeta);
    }
    
    public void fromString(String eq) {
        eq = eq.replaceAll("\\s+", "");
        String[] terminos = eq.split("(?=[+-])|=");
        for(String s: terminos) {
            Pattern p = Pattern.compile("\\p{Alpha}");
            Matcher m = p.matcher(s);
            if(m.find()) {
                String coef = s.substring(0, m.start());
                double cof = Double.parseDouble(coef);
                System.out.println(cof);
            } else{
                //a lo que esta igualado la funcion(si es que esta igualada a algo)
                System.out.println(s);
            }
        }
    }
}
