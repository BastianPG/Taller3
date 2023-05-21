package Model;

public final class Percusion extends Instrumento {
    /**
     * Tipo de percusion
     */
    private String tipoPercusion;
    /**
     * Altura definida o indefinida del instrumento de percusion
     */
    private String altura;

    /**
     * Material del instrumento
     */
    private String material;
    public Percusion(String codigoInstrumento, int precioInstrumento, int stockTotal,  String instrumento, String tipoPercusion, String material,   String altura) {
        super(codigoInstrumento, precioInstrumento, instrumento, stockTotal);

        this.tipoPercusion = tipoPercusion;
        this.altura = altura;
        this.material = material;
    }

    /**
     *
     * @return Retorna el material del instrumento
     */
    public String getMaterial() {
        return material;
    }

    /**
     *
      * @return Retorna el tipo de percusion del instrumento
     */
    public String getTipoPercusion() {
        return tipoPercusion;
    }

    /**
     *
     * @return Retorna la altura del instrumento
     */

    public String getAltura() {
        return altura;
    }

    /**
     *
     * @return Retorna los datos del instrumento
     */
    @Override
    public String toString() {
        String datosPercusion = this.getCodigoInstrumento()+" - " +this.getPrecioInstrumento()+" - "+this.getStockTotal()+" - "+this.getNombreInstrumento()+" - "+this.tipoPercusion+" - "+this.material + " - "+this.altura;
        return datosPercusion;
    }
}

