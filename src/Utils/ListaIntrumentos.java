package Utils;

import Model.Instrumento;
import ucn.StdOut;

import java.util.Objects;

public class ListaIntrumentos {

    /**
     * Arreglo que guardara los instrumentos
     */
    private Instrumento[] arreglo;
    /**
     * Cantidad actual de instrumentos
     */
    private int cantidadInstrumento;
    /**
     * Capacidad maxima del arreglo
     */
    private int capacidadMaxima;
    /**
     * Contructor de la lista Instrumentos
     */
    public ListaIntrumentos (int tamanio){
        arreglo = new Instrumento[tamanio];
        capacidadMaxima = tamanio;
        cantidadInstrumento = 0;
    }

    /**
     *
     * @param codigoInstrumento
     * @return Retorna la posicion del instrumento buscado, si no lo encuentra, retorna -1
     */
    public int buscarInstrumento(String codigoInstrumento){

        for (int i = 0; i < this.capacidadMaxima; i++) {
            if (this.arreglo[i] != null && this.arreglo[i].getCodigoInstrumento().equals(codigoInstrumento)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param posicion
     * @return Retorna el arreglo en la posicion ingresada
     */
    public Instrumento obtenerInstrumento(int posicion){
        if (posicion < 0 || posicion > this.capacidadMaxima){
            throw new IllegalArgumentException("posicion no valida");
        }
        return this.arreglo[posicion];
    }
    /**
     *
     * @param instrumento
     * Agrega el instrumento si no existe
     */
    public void agregarIntrumento(Instrumento instrumento){
        // si se repite
        if (this.buscarInstrumento(instrumento.getCodigoInstrumento()) != -1){
        }
        //verificar capaciadad
        if (this.cantidadInstrumento == this.capacidadMaxima){
            throw new IllegalArgumentException("capacidad maxima ya utilizada");
        }
        // pos
        for (int i = 0; i < this.capacidadMaxima; i++) {

            if (this.arreglo[i]==null){
                this.arreglo[i] = instrumento;
                this.cantidadInstrumento++;

                return;

            }
        }
    }

    /**
     *
     * @param codigoInstrumento
     * Elimina el instrumento buscandolo por codigo
     */
    public void eliminarInstrumento(String codigoInstrumento) {

        int posicion = this.buscarInstrumento(codigoInstrumento);
        //no encontrado
        if (arreglo[posicion].getStockTotal() == 1){
            for (int i = posicion; i < cantidadInstrumento; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            cantidadInstrumento--;
        } else {
            arreglo[posicion].setStockTotal(arreglo[posicion].getStockTotal()-1);
        }
    }

    /**
     *
     * @param posicionEliminar
     * Elimina los instrumentos repetidos, los cuales ya se sumaron al stock
     */

    public void eliminarRepetidos(int posicionEliminar){
        for (int i = posicionEliminar; i < cantidadInstrumento; i++) {
            arreglo[i] = arreglo[i + 1];
        }
        cantidadInstrumento--;
    }

    /**
     * Suma el stock de los instrumentos con el mismo codigo
     */
    public void sumarStockRepetidos(){

        for (int i = 0; i < cantidadInstrumento; i++) {
            for (int j = i+1; j < cantidadInstrumento; j++) {

                 if (Objects.equals(arreglo[i].getCodigoInstrumento(),arreglo[j].getCodigoInstrumento())){
                     int aux = arreglo[i].getStockTotal();
                     int aux2 = arreglo[j].getStockTotal();
                     int stockTotal = aux2+aux;
                     arreglo[i].setStockTotal(stockTotal);
                     eliminarRepetidos(j);
                 }
            }
        }


    }

    /**
     * Despliega la informacion del inventario
     */
    public void desplegarInformacion(){
        for (int i =0; i < this.cantidadInstrumento; i++){
            Instrumento instrumento = this.obtenerInstrumento(i);
            System.out.println(instrumento.toString());
        }
    }

    /**
     *
     * @return Retorna la catidad de instrumentos actuales
     */
    public int getCantidadInstrumento() {
        return cantidadInstrumento;
    }

    /**
     *
     * @return Retorna la capacidad maxia del arreglo
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
