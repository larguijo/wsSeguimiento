package com.mycompany.entities;

import com.mycompany.entities.EstacionTrabajo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(PuntoControl.class)
public class PuntoControl_ { 

    public static volatile SingularAttribute<PuntoControl, String> usuarioGra;
    public static volatile SingularAttribute<PuntoControl, Integer> idPuntoControl;
    public static volatile SingularAttribute<PuntoControl, Date> fechaMod;
    public static volatile SingularAttribute<PuntoControl, Date> fechaGra;
    public static volatile SingularAttribute<PuntoControl, String> usuarioMod;
    public static volatile SingularAttribute<PuntoControl, String> nombre;
    public static volatile SingularAttribute<PuntoControl, EstacionTrabajo> idEstacionTrabajo;
    public static volatile SingularAttribute<PuntoControl, String> banEstado;

}