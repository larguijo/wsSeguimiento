package com.mycompany.entities;

import com.mycompany.entities.OrdenFabricacion;
import com.mycompany.entities.ProcesoFabricacion;
import com.mycompany.entities.SeguimientoEmpleadoOf;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(HojaRutaOf.class)
public class HojaRutaOf_ { 

    public static volatile SingularAttribute<HojaRutaOf, String> usuarioGra;
    public static volatile SingularAttribute<HojaRutaOf, Date> fechaMod;
    public static volatile SingularAttribute<HojaRutaOf, Date> fechaHoraIni;
    public static volatile SingularAttribute<HojaRutaOf, String> banOfNotificada;
    public static volatile SingularAttribute<HojaRutaOf, OrdenFabricacion> idOrdenFabricacion;
    public static volatile SingularAttribute<HojaRutaOf, Date> fechaGra;
    public static volatile SingularAttribute<HojaRutaOf, Integer> idHojaRuta;
    public static volatile SingularAttribute<HojaRutaOf, String> usuarioMod;
    public static volatile SingularAttribute<HojaRutaOf, String> banEstado;
    public static volatile SingularAttribute<HojaRutaOf, ProcesoFabricacion> idProcesoFabricacion;
    public static volatile SingularAttribute<HojaRutaOf, Date> fechaHoraFin;
    public static volatile ListAttribute<HojaRutaOf, SeguimientoEmpleadoOf> seguimientoEmpleadoOfList;

}