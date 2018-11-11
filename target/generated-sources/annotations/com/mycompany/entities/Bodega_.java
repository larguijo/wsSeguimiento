package com.mycompany.entities;

import com.mycompany.entities.Inventario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(Bodega.class)
public class Bodega_ { 

    public static volatile SingularAttribute<Bodega, String> usuarioGra;
    public static volatile SingularAttribute<Bodega, Integer> idBodega;
    public static volatile SingularAttribute<Bodega, Date> fechaMod;
    public static volatile ListAttribute<Bodega, Inventario> inventarioList;
    public static volatile SingularAttribute<Bodega, Date> fechaGra;
    public static volatile SingularAttribute<Bodega, String> usuarioMod;
    public static volatile SingularAttribute<Bodega, String> nombre;
    public static volatile SingularAttribute<Bodega, String> banEstado;

}