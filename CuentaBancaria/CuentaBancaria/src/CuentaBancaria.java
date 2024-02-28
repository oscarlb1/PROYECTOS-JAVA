import java.util.ArrayList;
import java.util.Date;

public class CuentaBancaria {
    private String codigo;
    private Titular titular;
    private Date fechaApertura;
    private String tipoCuenta;
    private float saldo;
    private ArrayList<MovimientoBancario> movimientos;



    public CuentaBancaria(String codigo, Titular titular, Date fechaApertura, String tipoCuenta, float saldo){
        this.codigo = codigo;
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        movimientos = new ArrayList<MovimientoBancario>();
    }


    public CuentaBancaria(){
        movimientos = new ArrayList<MovimientoBancario>();
    }

    public void verMovimientos(Date fechaInicio, Date fechaFin){
        for (MovimientoBancario mov:movimientos
             ) {
            if(mov.getFecha().after(fechaInicio) && mov.getFecha().before(fechaFin) ){
                System.out.println(mov.getConcepto() + " " + mov.getFecha() + " " + mov.getTipoMovimiento() + " " + mov.getImporte());
            }
        }
    }



    public void agregarMovimiento(MovimientoBancario miMovimiento){

        movimientos.add(miMovimiento);
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
