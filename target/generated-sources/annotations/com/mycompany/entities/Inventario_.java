package com.mycompany.entities;

import com.mycompany.entities.Articulo;
import com.mycompany.entities.Bodega;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, String> usuarioGra;
    public static volatile SingularAttribute<Inventario, Articulo> idArticulo;
    public static volatile SingularAttribute<Inventario, Integer> idCorrelativo;
    public static volatile SingularAttribute<Inventario, Date> fechaMod;
    public static volatile SingularAttribute<Inventario, Bodega> idBodega;
    public static volatile SingularAttribute<Inventario, Date> fechaGra;
    public static volatile SingularAttribute<Inventario, Double> cantidad;
    public static volatile SingularAttribute<Inventario, String> usuarioMod;

}