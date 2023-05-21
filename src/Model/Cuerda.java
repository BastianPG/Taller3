package Model;

public final class   Cuerda extends Instrumento {
    /**
     * Material del instrumento
     */
    private final String material;
    /**
     * Material de cuerda que tiene el instrumento
     */
    private final String tipoCuerda;
    /**
     * Numero de cuerdas que tiene el instrumento
     */
    private final int numeroCuerdas;
    /**
     * Tipo de instrumento de cuerdas
     */
    private String tipoInstrumento;

    public Cuerda(String codigoInstrumento, int precioInstrumento,int stockTotal, String instrumento ,String tipoCuerda , int numeroCuerdas, String material, String tipoInstrumento ) {
        super(codigoInstrumento, precioInstrumento, instrumento, stockTotal);
        this.material = material;
        this.tipoCuerda = tipoCuerda;
        this.numeroCuerdas = numeroCuerdas;
        this.tipoInstrumento = tipoInstrumento;
    }

    /**
     *
     * @return Retorna el instrumento
     */
    public String getMaterial() {
        return material;
    }

    /**
     *
     * @return Retorna el tipo de cuerda
     */
    public String getTipoCuerda() {
        return tipoCuerda;
    }

    /**
     *
     * @return Retorna el numero de cuerdas
     */
    public int getNumeroCuerdas() {
        return numeroCuerdas;
    }

    /**
     *
     * @return Retorna el tipo de instrumento
     */
    public String getTipoInstrumento() {
        return tipoInstrumento;
    }

    /**
     *
     * @return Retorna los datos del instrumento
     */
    @Override
    public String toString() {
        String datosCuerda = this.getCodigoInstrumento()+" - "
                +this.getPrecioInstrumento()+" - "+this.getStockTotal()+" - "+this.getNombreInstrumento()+" - "+this.tipoCuerda+" - "+this.numeroCuerdas+" - "+this.material + " - "+this.tipoInstrumento;
        return datosCuerda;


    }
}
