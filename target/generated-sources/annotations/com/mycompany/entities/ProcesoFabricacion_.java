package com.mycompany.entities;

import com.mycompany.entities.EstacionTrabajo;
import com.mycompany.entities.HojaRutaOf;
import com.mycompany.entities.LineaProductiva;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(ProcesoFabricacion.class)
public class ProcesoFabricacion_ { 

    public static volatile SingularAttribute<ProcesoFabricacion, String> usuarioGra;
    public static volatile ListAttribute<ProcesoFabricacion, HojaRutaOf> hojaRutaOfList;
    public static volatile ListAttribute<ProcesoFabricacion, EstacionTrabajo> estacionTrabajoList;
    public static volatile SingularAttribute<ProcesoFabricacion, Date> fechaMod;
    public static volatile SingularAttribute<ProcesoFabricacion, Integer> idSupervisor;
    public static volatile SingularAttribute<ProcesoFabricacion, Date> fechaGra;
    public static volatile SingularAttribute<ProcesoFabricacion, Integer> orden;
    public static volatile SingularAttribute<ProcesoFabricacion, String> usuarioMod;
    public static volatile SingularAttribute<ProcesoFabricacion, LineaProductiva> idLineaProductiva;
    public static volatile SingularAttribute<ProcesoFabricacion, String> nombre;
    public static volatile SingularAttribute<ProcesoFabricacion, Integer> idProcesoFabricacion;
    public static volatile SingularAttribute<ProcesoFabricacion, String> banEstado;

}