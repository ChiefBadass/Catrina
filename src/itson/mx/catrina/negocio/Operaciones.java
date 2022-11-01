/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itson.mx.catrina.negocio;


import itson.mx.catrina.enumerador.Tipo;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Contiene diversas operaciones.
 * @author Carlos Daniel Rebollo Toledo
 */
public class Operaciones {
    /**
     * Muestra los datos filtrados en un JTable. 
     * @param movimientos Lista de movimientos que sera utilizada para recorrer.
     * @param formatoMoneda Formato representativo para las cantidades numericas.
     * @param tblRegistros La tabla donde seran despledados los valores.
     * @param saldoInicial Dato inicial para obtener el subtotal.
     */
   public void mostrarDatosFiltrados(List<Movimiento> movimientos,NumberFormat formatoMoneda, JTable tblRegistros, double saldoInicial){
       DefaultTableModel modelo = (DefaultTableModel) tblRegistros.getModel();
       modelo.setRowCount(0);              
       DateFormat formatoFecha = new SimpleDateFormat("dd/MMMM/yyyy");
       double suma = saldoInicial;
           for(Movimiento i : movimientos){                   
               if(i.getTipo()==Tipo.DEPOSITO){
                   suma+= i.getCantidad();
                   modelo.addRow(new Object[] { formatoFecha.format(i.getFecha()),i.getDescripcion(), formatoMoneda.format(i.getCantidad()), formatoMoneda.format(0), formatoMoneda.format(suma)});                        
                }else if(i.getTipo()==Tipo.RETIRO){
                       suma-= i.getCantidad();
                       modelo.addRow(new Object[] { formatoFecha.format(i.getFecha()),i.getDescripcion(), formatoMoneda.format(0), formatoMoneda.format(i.getCantidad()), formatoMoneda.format(suma)});
                    }
                }   
   }
   /**
    * Muestra los datos originales en un JTable.
    * @param estadoCuenta Sirve para obtener la lista de movimientos.
    * @param formatoMoneda Formato representativo para las cantidades numericas.
    * @param tblRegistros La tabla donde seran despledados los valores.
    */
   public void mostrarDatos(EstadoCuenta estadoCuenta,NumberFormat formatoMoneda, JTable tblRegistros){
       DefaultTableModel modelo = (DefaultTableModel) tblRegistros.getModel();
       modelo.setRowCount(0);              
       DateFormat formatoFecha = new SimpleDateFormat("dd/MMMM/yyyy");
       estadoCuenta.getMovimientos().sort((m1,m2)->m1.getFecha().compareTo(m2.getFecha()));
       double subTotal = 0;
           for(Movimiento i : estadoCuenta.getMovimientos()){                   
               if(i.getTipo()==Tipo.DEPOSITO){
                   subTotal += i.getCantidad();
                   modelo.addRow(new Object[] { formatoFecha.format(i.getFecha()),i.getDescripcion(), formatoMoneda.format(i.getCantidad()), formatoMoneda.format(0), formatoMoneda.format(subTotal)});                        
                }else if(i.getTipo()==Tipo.RETIRO){
                       subTotal -= i.getCantidad();
                       modelo.addRow(new Object[] { formatoFecha.format(i.getFecha()),i.getDescripcion(), formatoMoneda.format(0), formatoMoneda.format(i.getCantidad()), formatoMoneda.format(subTotal)});
                    }
                }   
   }
   /**
    * Realiza una suma de todos los depositos.
    * @param movimientos Lista de movimientos utilizada como referencia para recorrer datos.
    * @return La suma de todos los depositos.
    */
   public Double sumarDepositos(List<Movimiento> movimientos ){     
        double suma = 0;
        for(Movimiento m : movimientos){
            if(m.getTipo()==Tipo.DEPOSITO){
                suma+= m.getCantidad();
            }
        }
         return suma;       
    }
   /**
    * Realiza una suma de todos los retiros.
    * @param movimientos Lista de movimientos utilizada como referencia para recorrer datos.
    * @return La suma de todos los retiros.
    */
   public Double sumarRetiros(List<Movimiento> movimientos){
        double suma = 0;     
        for(Movimiento m : movimientos){
            if(m.getTipo()==Tipo.RETIRO){
                suma+= m.getCantidad();
            }
        }
         return suma;        
    }
   /**
    * Realiza el saldo final.
    * @param tblRegistros Tabla de datos que sera recorrida.
    * @return El saldo final en tipo String.
    */
   public String calcularSaldoFinal(JTable tblRegistros){
       String saldoFinal = null;
       if (tblRegistros.getRowCount()>0){
            for (int i = 0; i < tblRegistros.getRowCount(); i++) {
             String auxi = tblRegistros.getValueAt(i, 4).toString();            
                 saldoFinal = auxi;
  
         }
        }
       return saldoFinal;
   }
   /**
    * Realiza el saldo inicial.
    * @param mes Mes que sera utilizado como punto de referencia.
    * @param estadoCuenta Sirve para obtener la lista de movimientos.
    * @return Devuelve el saldo inicial en tipo double,
    */
   public Double calcularSaldoInicial(int mes, EstadoCuenta estadoCuenta){
       double saldoInicial = 0;
       for(Movimiento m : estadoCuenta.getMovimientos()){
           for(int i = 0; i<mes; i++){
               if(m.getFecha().getMonth()==i && m.getTipo() == Tipo.DEPOSITO){
                   saldoInicial += m.getCantidad();
               }else if(m.getFecha().getMonth()==1 && m.getTipo() == Tipo.RETIRO){
                   saldoInicial -= m.getCantidad();
               }
           }
       }
       return saldoInicial;
   } 
   /**
    * Organiza por mes una lista.
    * @param mes Mes seleccionado a mostrar.
    * @param estadoCuenta Sirve para obtener la lista de movimientos.
    * @return Devuelve una Lista ordenada por mes.
    */
   public List<Movimiento> ordenarLista(int mes, EstadoCuenta estadoCuenta){
       List<Movimiento> movimientos = new ArrayList<>();
                for(Movimiento m : estadoCuenta.getMovimientos() ){
                     if(m.getFecha().getMonth()==mes){
                        movimientos.add(m);
                    }
                }
                movimientos.sort((m1,m2)->m1.getFecha().compareTo(m2.getFecha()));
                return movimientos;
   }
   
}
