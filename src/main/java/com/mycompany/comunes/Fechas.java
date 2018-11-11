/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comunes;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author LAPTOP
 */
public class Fechas {

    public static Timestamp getTimestamp() {
        return new Timestamp((new Date()).getTime());
    }

}
