/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_backtracking;

import Vista.frm_Laberinto;
import javax.swing.JOptionPane;

/**
 *
 * @author EQUIPO
 */
public class Laberinto {

    public char[][] laberinto = {
        {'#', ' ', ' ', '#', ' ', ' ', '#', '#', '#'},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', '#', '#', '#', '#', ' ', ' ', '#', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
        {' ', ' ', '#', ' ', '#', '#', ' ', ' ', ' '},
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},};

    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Laberinto m = new Laberinto(); 												// construimos un objeto de la clase Laberinto por defecto
        frm_Laberinto vista = new frm_Laberinto();
        vista.setVisible(true);
        vista.lab00.setText("" + m.laberinto[0][0]);
        vista.lab01.setText("" + m.laberinto[0][1]);
        vista.lab02.setText("" + m.laberinto[0][2]);
        vista.lab03.setText("" + m.laberinto[0][3]);
        vista.lab04.setText("" + m.laberinto[0][4]);
        vista.lab05.setText("" + m.laberinto[0][5]);
        vista.lab10.setText("" + m.laberinto[1][0]);
        vista.lab11.setText("" + m.laberinto[1][1]);
        vista.lab12.setText("" + m.laberinto[1][2]);
        vista.lab13.setText("" + m.laberinto[1][3]);
        vista.lab14.setText("" + m.laberinto[1][4]);
        vista.lab15.setText("" + m.laberinto[1][5]);
        vista.lab20.setText("" + m.laberinto[2][0]);
        vista.lab21.setText("" + m.laberinto[2][1]);
        vista.lab22.setText("" + m.laberinto[2][2]);
        vista.lab23.setText("" + m.laberinto[2][3]);
        vista.lab24.setText("" + m.laberinto[2][4]);
        vista.lab25.setText("" + m.laberinto[2][5]);
        vista.lab30.setText("" + m.laberinto[3][0]);
        vista.lab31.setText("" + m.laberinto[3][1]);
        vista.lab32.setText("" + m.laberinto[3][2]);
        vista.lab33.setText("" + m.laberinto[3][3]);
        vista.lab34.setText("" + m.laberinto[3][4]);
        vista.lab35.setText("" + m.laberinto[3][5]);
        vista.lab40.setText("" + m.laberinto[4][0]);
        vista.lab41.setText("" + m.laberinto[4][1]);
        vista.lab42.setText("" + m.laberinto[4][2]);
        vista.lab43.setText("" + m.laberinto[4][3]);
        vista.lab44.setText("" + m.laberinto[4][4]);
        vista.lab45.setText("" + m.laberinto[4][5]);
        vista.lab50.setText("" + m.laberinto[5][0]);
        vista.lab51.setText("" + m.laberinto[5][1]);
        vista.lab52.setText("" + m.laberinto[5][2]);
        vista.lab53.setText("" + m.laberinto[5][3]);
        vista.lab54.setText("" + m.laberinto[5][4]);
        vista.lab55.setText("" + m.laberinto[5][5]);
        int finX = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el inicio en la cordenada X"));
        int finY = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el inicio en la cordenada Y"));
        int inicioX = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el final en la cordenada X"));
        int inicioY = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el final en la cordenada Y"));
        if (m.laberinto[inicioX][inicioY] == '#' || m.laberinto[finX][finY] == '#') {
            JOptionPane.showMessageDialog(null, "Error, seleccionó una pared"); //Si selecciona donde hay pared

        } else {
            m.laberinto[inicioX][inicioY] = 'X';
            // introducimos en este caso, la salida (X) en las coordenadas (1,1)
            m.mostrarAvance(vista, inicioX, inicioY, 'X');
            m.resuelve(vista, finX, finY); 															// ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
            System.out.println(m.imprimir()); 											// imprimimos el laberinto ya resuelto (si tiene solución)
        }

    }

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(frm_Laberinto vista, int x, int y) { 				// permite introducir unas coordenadas (x, y) 
        if (paso(vista, x, y)) { 								// intentará resolver el laberinto en estas coordenadas
            laberinto[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
            mostrarAvance(vista, x, y, 'S');
        }
    }

    private boolean paso(frm_Laberinto vista, int x, int y) {

        if (x == 9 || y == 9 || x == -1 || y == -1) {
            return false;
        } else {
            if (laberinto[x][y] == 'X') { // si hemos llegado a X quiere decir que hemos encontrado solución

                return true; // luego, el algoritmo termina
            }

            if (laberinto[x][y] == '#' || laberinto[x][y] == '*') { // si llegamos a una pared o al mismo punto,
                return false; // entonces el laberinto no puede resolverse y termina.
            }

            // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
            // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
            laberinto[x][y] = '*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y 
            // introduce en las coordenadas (x, y) la entrada
            mostrarAvance(vista, x, y, '*');
            boolean result; // se coloca S de START)

            result = paso(vista, x, y + 1); // intentamos ir hacia la DERECHA. Primera llamada recursiva

            if (result) {
                return true; // si el resultado es el final, entonces el algoritmo termina
            }
            result = paso(vista, x - 1, y); // intentamos ir hacia ARRIBA. Segunda llamada recursiva

            if (result) {
                return true; // si el resultado es el final, entonces el algoritmo termina
            }
            result = paso(vista, x, y - 1); // intentamos ir hacia la IZQUIERDA. Tercera llamada recursiva

            if (result) {
                return true; // si el resultado es el final, entonces el algoritmo termina
            }
            result = paso(vista, x + 1, y); // intentamos ir hacia ABAJO. Cuarta llamada recursiva

            if (result) {
                return true; // si el resultado es el final, entonces el algoritmo termina
            }    		    // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
            // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
            // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
            laberinto[x][y] = '+'; // en el caso de no ser el resultado, se marca con +. Ya fue pisado
            mostrarAvance(vista, x, y, '+');
            return false; // vuelta atrás si la solución no se encuentra aquí
        }
    }

    private String imprimir() { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        String salida = "";    // un método toString para arrays bidimensionales, lo programamos a mano
        for (int x = 0; x < laberinto.length; x++) { // recorremos filas
            for (int y = 0; y < laberinto[x].length; y++) { // recorremos columnas
                salida += laberinto[x][y] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de línea
        }
        return salida;
    }

    public void mostrarAvance(frm_Laberinto vista, int x, int y, char pos) {
        try {
            Thread.sleep(0); // Para que de una espera al mostrar
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error"+e);
        }
        if (x == 1 && y == 1) {
            vista.lab11.setText("" + laberinto[1][1]);
        } else if (x == 1 && y == 2) {
            vista.lab12.setText("" + laberinto[1][2]);
        } else if (x == 1 && y == 3) {
            vista.lab13.setText("" + laberinto[1][3]);
        } else if (x == 1 && y == 4) {
            vista.lab14.setText("" + laberinto[1][4]);
        } else if (x == 2 && y == 1) {
            vista.lab21.setText("" + laberinto[2][1]);
        } else if (x == 2 && y == 2) {
            vista.lab22.setText("" + laberinto[2][2]);
        } else if (x == 2 && y == 3) {
            vista.lab23.setText("" + laberinto[2][3]);
        } else if (x == 2 && y == 4) {
            vista.lab24.setText("" + laberinto[2][4]);
        } else if (x == 3 && y == 1) {
            vista.lab31.setText("" + laberinto[3][1]);
        } else if (x == 3 && y == 2) {
            vista.lab32.setText("" + laberinto[3][2]);
        } else if (x == 3 && y == 3) {
            vista.lab33.setText("" + laberinto[3][3]);
        } else if (x == 3 && y == 4) {
            vista.lab34.setText("" + laberinto[3][4]);
        } else if (x == 4 && y == 1) {
            vista.lab41.setText("" + laberinto[4][1]);
        } else if (x == 4 && y == 2) {
            vista.lab42.setText("" + laberinto[4][2]);
        } else if (x == 4 && y == 3) {
            vista.lab43.setText("" + laberinto[4][3]);
        } else if (x == 4 && y == 4) {
            vista.lab44.setText("" + laberinto[4][4]);
        }
    }

}
