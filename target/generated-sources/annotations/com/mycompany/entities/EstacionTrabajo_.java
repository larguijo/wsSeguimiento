package com.mycompany.entities;

import com.mycompany.entities.ProcesoFabricacion;
import com.mycompany.entities.PuntoControl;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(EstacionTrabajo.class)
public class EstacionTrabajo_ { 

    public static volatile SingularAttribute<EstacionTrabajo, String> usuarioGra;
    public static volatile ListAttribute<EstacionTrabajo, PuntoControl> puntoControlList;
    public static volatile SingularAttribute<EstacionTrabajo, Date> fechaMod;
    public static volatile SingularAttribute<EstacionTrabajo, Date> fechaGra;
    public static volatile SingularAttribute<EstacionTrabajo, String> usuarioMod;
    public static volatile SingularAttribute<EstacionTrabajo, Integer> idEstacionTrabajo;
    public static volatile SingularAttribute<EstacionTrabajo, String> nombre;
    public static volatile SingularAttribute<EstacionTrabajo, String> banEstado;
    public static volatile SingularAttribute<EstacionTrabajo, ProcesoFabricacion> idProcesoFabricacion;

}