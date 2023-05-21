package Services;

import java.io.IOException;

public interface Sistema {

    /**
     * Este metodo desplegara el inventario completo
     */
    public void desplegarInventario();

    /**
     * Este metodo agregara el instrumetno al stock
     */
    public void agregarInstrumento();
    /**
     * Este metodo leera el archivo csv
     */
    public void leerArchivo() throws IOException;
    /**
     * Este metodo actualizara el archivo csv
     */
    public void actualizarArchivo() throws IOException;
    /**
     * Este metodo vendera y quitara el instrumento del csv
     */
    public void venderInstrumento();
    /**
     * Este metodo generara la bolata de compra
     */
    public void generarBoleta(String codigo, int posicion);



}
