package Model;

public final class Viento extends Instrumento {
    /**
     * Material del instrumento
     */
    private final String material;

    /**
     *
     * @param codigoInstrumento
     * @param precioInstrumento
     * @param stockTotal
     * @param instrumento
     * @param material
     */
    public Viento(String codigoInstrumento, int precioInstrumento, int stockTotal, String instrumento, String material) {
        super(codigoInstrumento, precioInstrumento, instrumento, stockTotal);
        this.material = material;
    }

    /**
     *
     * @return Retorna el material del instrumento
     */
    public String getmaterial() {
        return material;
    }

    /**
     *
     * @return Retorna los datos del instrumento
     */
    @Override
    public String toString() {
        String datosViento = this.getCodigoInstrumento()+" - "+this.getPrecioInstrumento()+" - "+this.getStockTotal()+" - "+this.material+" - "+this.getNombreInstrumento();
        return datosViento;
    }
}
