package Services;

import Model.Cuerda;
import Model.Instrumento;
import Model.Percusion;
import Model.Viento;
import Utils.ListaIntrumentos;
import ucn.*;

import java.io.IOException;
import java.text.Normalizer;


public class SistemaImpl implements Sistema{
    ListaIntrumentos listaIntrumentos;
    public SistemaImpl() throws IOException {
        listaIntrumentos = new ListaIntrumentos(999);
        this.leerArchivo();

    }


    /**
     * Este metodo va a desplegar el inventario completo
     */
    @Override
    public void desplegarInventario() {
        StdOut.println("\n"+"Inventario Rhythm");
        listaIntrumentos.desplegarInformacion();

        StdOut.println("¿Desea buscar un instrumento ingresando su codigo?");
        StdOut.println("[1] Si");
        StdOut.println("[2] No");
        int opcion = StdIn.readInt();
        switch (opcion){
            case 1  ->{
                StdOut.println("Ingrese el codigo del instrumento que desea buscar: ");
                String codigoInstrumento = StdIn.readString();

                int pos = listaIntrumentos.buscarInstrumento(codigoInstrumento);
                StdOut.println(listaIntrumentos.obtenerInstrumento(pos).toString());

            }
            case 2 ->{
                break;
            }
        }

    }
    /**
     * Este metodo agregara el instrumento al stock
     */
    @Override
    public void agregarInstrumento() {
        int opcion = 0;

        StdOut.println("Elija el tipo instrumento que desea agregar");
        StdOut.println("");
        StdOut.println("[1] Cuerda");
        StdOut.println("[2] Percusion");
        StdOut.println("[3] Viento");
        opcion = StdIn.readInt();


        switch (opcion) {
            case 1 -> {

                StdOut.println("Ingrese el codigo del instrumento: ");
                String codigo = StdIn.readString();
                StdOut.println("Ingrese el precio del instrumento: ");
                int precio = StdIn.readInt();
                StdOut.println("Ingrese el stock del instrumento: ");
                int stock = StdIn.readInt();
                StdOut.println("Ingrese el nombre del instrumento (Guitarra, Bajo, Violín, Arpa): ");
                String nombre = StdIn.readString();
                StdOut.println("Ingrese el tipo de cuerdas del instrumento (Nylon, Acero, Tripa):");
                String tipoCuerda = StdIn.readString();
                StdOut.println("Ingrese el numero de cuerdas del instrumento: ");
                int nroCuerdas = StdIn.readInt();
                StdOut.println("Ingrese el material del instrumento (Madera, Metal): ");
                String material = StdIn.readString();
                StdOut.println("Ingrese el tipo del instrumento (Acústico, Eléctrico): ");
                String tipoInstruemento = StdIn.readString();

                Instrumento agregarCuerda = new Cuerda(codigo, precio, stock, nombre, tipoCuerda, nroCuerdas, material, tipoInstruemento);
                listaIntrumentos.agregarIntrumento(agregarCuerda);
                break;
            }
            case 2 -> {

                StdOut.println("Ingrese el codigo del instrumento");
                String codigo = StdIn.readString();
                StdOut.println("Ingrese el precio del instrumento");
                int precio = StdIn.readInt();
                StdOut.println("Ingrese el stock del instrumento");
                int stock = StdIn.readInt();
                StdOut.println("Ingrese el nombre del instrumento (Bongó, Cajón, Campanas Tubulares,Bombo): ");
                String nombre = StdIn.readString();
                StdOut.println("Ingrese el tipo de percusion del instrumento (Membranófono, idiófono): ");
                String tipoPercusion = StdIn.readString();
                StdOut.println("Ingrese el material del instrumento (Madera, Metal, Piel): ");
                String material = StdIn.readString();
                StdOut.println("Ingrese el tipo de altura del instrumento (Definida, Indefinida): ");
                String altura = StdIn.readString();

                Instrumento agregarPercusion = new Percusion(codigo, precio, stock, nombre, tipoPercusion, material, altura);
                listaIntrumentos.agregarIntrumento(agregarPercusion);
                break;

            }
            case 3 -> {

                StdOut.println("Ingrese el codigo del instrumento");
                String codigo = StdIn.readString();
                StdOut.println("Ingrese el precio del instrumento");
                int precio = StdIn.readInt();
                StdOut.println("Ingrese el stock del instrumento");
                int stock = StdIn.readInt();
                StdOut.println("Ingrese el nombre del instrumento (Trompeta, Saxofón, Clarinete, Flauta, Traversa): ");
                String nombre = StdIn.readString();
                StdOut.println("Ingrese el material del instrumento (Madera, Metal): ");
                String material = StdIn.readString();

                Instrumento agregarViento = new Viento(codigo, precio, stock, nombre, material);
                listaIntrumentos.agregarIntrumento(agregarViento);
                break;
            }
            default -> {
                StdOut.println("opcion no valida");
                break;
            }
        }
    }
    /**
     * Este metodo leera el archivo csv
     */
    @Override
    public void leerArchivo() throws IOException {


        ArchivoEntrada arch1 = new ArchivoEntrada("C:\\Users\\bpere\\IdeaProjects\\taller 3\\csv_prueba.csv");
        while (!arch1.isEndFile()){
            Instrumento instrumento;

            Registro regEnt = arch1.getRegistro();
            String codigo = regEnt.getString();
            int precio = regEnt.getInt();
            int stock = regEnt.getInt();
            String nombreInstrumento = regEnt.getString();

            nombreInstrumento = Normalizer.normalize(nombreInstrumento , Normalizer.Form.NFD);
            nombreInstrumento = nombreInstrumento.replaceAll("[^\\p{ASCII}]", "");
            String convertir = nombreInstrumento.toLowerCase();

            switch (convertir) {
                case "guitarra", "bajo", "violin", "arpa" -> {
                    String tipoCuerda = regEnt.getString();
                    int numeroCuerdas = regEnt.getInt();
                    String materialCuerda = regEnt.getString();
                    String tipoInstrumento = regEnt.getString();
                    Instrumento agregarCuerda = new Cuerda(codigo, precio, stock, nombreInstrumento, tipoCuerda, numeroCuerdas, materialCuerda, tipoInstrumento);
                    listaIntrumentos.agregarIntrumento(agregarCuerda);
                }
                case "bongo", "cajon", "campanas tubulares", "bombo" -> {
                    String tipoPercusion = regEnt.getString();
                    String materialPercusion = regEnt.getString();
                    String altura = regEnt.getString();
                    Instrumento agregarPercusion = new Percusion(codigo, precio, stock, nombreInstrumento, tipoPercusion, materialPercusion, altura);
                    listaIntrumentos.agregarIntrumento(agregarPercusion);
                }
                case "trompeta", "saxofon", "clarinete", "flauta traversa" -> {
                    String materialViento = regEnt.getString();
                    Instrumento agregarViento = new Viento(codigo, precio, stock, nombreInstrumento, materialViento);
                    listaIntrumentos.agregarIntrumento(agregarViento);
                }
            }
        }
        listaIntrumentos.sumarStockRepetidos();
    }

    /**
     * Este metodo actualizara el archivo csv
     */
    @Override
    public void actualizarArchivo() throws IOException {

        ArchivoSalida arch2 = new ArchivoSalida("csv_prueba.csv");

        for (int i = 0; i < listaIntrumentos.getCantidadInstrumento() ; i++) {

            //Registro archsal = new Registro()
        }
    }

    /**
     * Este metodo vendera y quitara el instrumento del csv
     */
    @Override
    public void venderInstrumento() {
        StdOut.println("\n"+"Inventario Rhythm");
        listaIntrumentos.desplegarInformacion();

        StdOut.println("Ingrese el codigo del instrumento que desea comprar: ");
        String codigo = StdIn.readString();

       int posicion = listaIntrumentos.buscarInstrumento(codigo);
       if (posicion != -1){
           StdOut.println("Usted ha comprado "+listaIntrumentos.obtenerInstrumento(posicion));
           StdOut.println(" ");
       } else {
           StdOut.println("Nos se ha encontrado el instrumento, intente nuevamente");
           venderInstrumento();
       }
       generarBoleta(codigo,posicion);

    }

    /**
     * Este metodo generara la boleta de compra
     */
    @Override
    public void generarBoleta(String codigo, int posicion) {

        Instrumento instrumento;

        StdOut.println("Su boleta es: ");
        StdOut.print("Instrumento: ");
        StdOut.println(listaIntrumentos.obtenerInstrumento(posicion).getNombreInstrumento());
        StdOut.print("Precio: ");
        StdOut.println(listaIntrumentos.obtenerInstrumento(posicion).getPrecioInstrumento());
        StdOut.println("");


         listaIntrumentos.eliminarInstrumento(codigo);
    }
}