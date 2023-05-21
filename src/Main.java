import Model.Instrumento;
import Services.Sistema;
import Services.SistemaImpl;
import Utils.ListaIntrumentos;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SistemaImpl sistema = new SistemaImpl();
        menuPrincipal(sistema);
    }

    /**
     *
     * @param sistema
     * @throws IOException
     * Muestra le menu principal
     */

    private static void menuPrincipal(SistemaImpl sistema) throws IOException {
        int opcion = 0;
        while (opcion != 4) {

            StdOut.println("Elija la opcion del menu que desea desplegar");
            StdOut.println("");
            StdOut.println("[1] Agregar Instrumento");
            StdOut.println("[2] Vender Instrumento");
            StdOut.println("[3] Consultar Inventario");
            StdOut.println("[4] Salir");

            opcion = StdIn.readInt();

            switch (opcion) {
                case 1 -> sistema.agregarInstrumento();
                case 2 -> sistema.venderInstrumento();
                case 3 -> sistema.desplegarInventario();
                case 4 -> sistema.actualizarArchivo();
                default -> StdOut.println("opcion no valida");
            }
        }
    }

}


