/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itson.mx.catrina.negocio;

import com.google.gson.Gson;
import java.util.List;


/**
 * Atributos de un Estado de cuenta y getters and setters.
 * @author Carlos Daniel Rebollo Toledo.
 */
public class EstadoCuenta {
    private String producto;
    private String cuenta;
    private String clabe;
    private String moneda;
    private Cliente cliente;
    private List<Movimiento> movimientos;
    
    public EstadoCuenta deserializar(String json){
        EstadoCuenta estadoCuenta = new EstadoCuenta();
        try{
            estadoCuenta = new Gson().fromJson(json, EstadoCuenta.class);
        }catch(Exception ex){
            System.err.print("Ocurrio un error" + ex.getMessage());
        }
        return estadoCuenta;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the clabe
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * @param clabe the clabe to set
     */
    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the movimientos
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    
}
