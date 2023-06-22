package juegogato;

/* Autor: Alejandro Pérez Durán.
 * Fecha de creación: 26 de Febrero de 2015.
 * Descripción del programa: Este programa realiza el juego del gato.
 */
public class JuegoGato {

    public static void main(String[] args) {
        VentanaGato v = new VentanaGato();
        v.setVisible(true);

        //new VentanaGato().setVisible(true);Esta línea hace lo mismo que el código anterior pero no se le
        //almacena a ningun objeto y por lo tanto no se almacena en memoria sino que usa la memoria Stock.
    }
}