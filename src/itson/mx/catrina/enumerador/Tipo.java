/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itson.mx.catrina.enumerador;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author carlo
 */
public enum Tipo {
    @SerializedName ("1")
    DEPOSITO,
    @SerializedName ("2")
    RETIRO
}
