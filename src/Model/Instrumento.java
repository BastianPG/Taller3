package Model;

public abstract class Instrumento {
    /**
     * codigo unico del instrumento
     */
    private final String codigoInstrumento;
    /**
     * Precio del instrumento
     */
    private final int precioInstrumento;
    /**
     * Nombre del instrumento
     */
    private final String instrumento;
    /**
     * Cantidad de existencias del instrumento
     */
    private int stockTotal;


    public Instrumento(String codigoInstrumento, int precioInstrumento, String instrumento, int stockTotal) {
        this.codigoInstrumento = codigoInstrumento;
        this.precioInstrumento = precioInstrumento;
        this.instrumento = instrumento;
        this.stockTotal = stockTotal;
    }

    /**
     *
     * @return Retorna el codigo del instrumento
     */
    public String getCodigoInstrumento() {
        return codigoInstrumento;
    }

    /**
     *
     * @return Retorna el precio del instrumento
     */

    public int getPrecioInstrumento() {
        return precioInstrumento;
    }

    /**
     *
     * @return Retorna el nombre del instrumento
     */

    public String getNombreInstrumento() {
        return instrumento;
    }

    /**
     *
     * @return Retorna el stock total de los instrumentos
     */

    public int getStockTotal() {
        return stockTotal;
    }

    /**
     * Este metodo cambia el stock total
     * @param stockTotal int stockTotal
     */

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    /**
     *
     * Despliega la lista de instrumentos
     */
    public abstract String toString();
}
