package com.mycompany.entities;

import com.mycompany.entities.OrdenFabricacion;
import com.mycompany.entities.ProcesoFabricacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(LineaProductiva.class)
public class LineaProductiva_ { 

    public static volatile SingularAttribute<LineaProductiva, String> usuarioGra;
    public static volatile ListAttribute<LineaProductiva, OrdenFabricacion> ordenFabricacionList;
    public static volatile SingularAttribute<LineaProductiva, Date> fechaMod;
    public static volatile SingularAttribute<LineaProductiva, Date> fechaGra;
    public static volatile SingularAttribute<LineaProductiva, Integer> idLineaProductiva;
    public static volatile SingularAttribute<LineaProductiva, String> usuarioMod;
    public static volatile ListAttribute<LineaProductiva, ProcesoFabricacion> procesoFabricacionList;
    public static volatile SingularAttribute<LineaProductiva, String> nombre;
    public static volatile SingularAttribute<LineaProductiva, String> banEstado;

}