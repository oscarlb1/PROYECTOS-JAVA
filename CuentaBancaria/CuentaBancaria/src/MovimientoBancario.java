import java.util.Date;

public class MovimientoBancario {
    private String codigoMovimiento;
    private Date fecha;
    private String concepto;
    private String tipoMovimiento;
    private float importe;

    public MovimientoBancario(String codigoMovimiento, Date fecha, String concepto, String tipoMovimiento, float importe) {
        this.codigoMovimiento = codigoMovimiento;
        this.fecha = fecha;
        this.concepto = concepto;
        this.tipoMovimiento = tipoMovimiento;
        this.importe = importe;
    }
    public MovimientoBancario() {

    }
    public String getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public void setCodigoMovimiento(String codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
