/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itson.mx.catrina.negocio;

import itson.mx.catrina.enumerador.Tipo;

/**
 *
 * @author carlo
 */
public class Operaciones {
    public double sumaDepositos(EstadoCuenta estadoCuenta){
        double suma = 0;
        for(Movimiento i : estadoCuenta.getMovimientos()){
            if(i.getTipo()==Tipo.DEPOSITO){
                suma+= i.getCantidad();
            }
        }
        return suma;
    }
   public double sumaRetiros(EstadoCuenta estadoCuenta){
        double suma = 0;
        for(Movimiento i : estadoCuenta.getMovimientos()){
            if(i.getTipo()==Tipo.RETIRO){
                suma+= i.getCantidad();
            }
        }
        return suma;
    }
   
}
