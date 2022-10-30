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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Operaciones {
    
   public void mostrarDatos(DefaultTableModel modelo, EstadoCuenta estadoCuenta,NumberFormat formatoMoneda, JTable tblRegistros){
       
       DateFormat formatoFecha = new SimpleDateFormat("dd/MMMM/yyyy");
       double suma = 0;
                for(Movimiento i : estadoCuenta.getMovimientos()){
                    
                    if(i.getTipo()==Tipo.DEPOSITO){
                        suma+= i.getCantidad();
                        modelo.addRow(new Object[] { formatoFecha.format(i.getFecha()),
                            i.getDescripcion(), i.getCantidad(), 0, suma});
                        
                    }else if(i.getTipo()==Tipo.RETIRO){
                        suma-= i.getCantidad();
                        modelo.addRow(new Object[] { formatoFecha.format(i.getFecha()),
                            i.getDescripcion(), 0, i.getCantidad(), suma});
                    }
                
                }
   }
   public Double sumaDepositos(JTable tblRegistros){
        
        double suma = 0;
        if (tblRegistros.getRowCount()>0){
            for (int i = 0; i < tblRegistros.getRowCount(); i++) {
             String auxi = tblRegistros.getValueAt(i, 2).toString();
             
                 suma += Double.parseDouble(auxi);
             
             
         }
        }
         return suma;
        
    }
   public Double sumaRetiros(JTable tblRegistros){
        
        double suma = 0;
        if (tblRegistros.getRowCount()>0){
            for (int i = 0; i < tblRegistros.getRowCount(); i++) {
             String auxi = tblRegistros.getValueAt(i, 3).toString();
             
                 suma += Double.parseDouble(auxi);
             
             
         }
        }
         return suma;
        
    }
   
   public double saldoFinal(JTable tblRegistros){
       double suma = 0;
       if (tblRegistros.getRowCount()>0){
            for (int i = 0; i < tblRegistros.getRowCount(); i++) {
             String auxi = tblRegistros.getValueAt(i, 4).toString();
             
                 suma = Double.parseDouble(auxi);
             
             
         }
        }
       return suma;
   }
       
       
   
     
}
