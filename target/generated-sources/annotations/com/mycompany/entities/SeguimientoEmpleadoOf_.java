package com.mycompany.entities;

import com.mycompany.entities.Empleado;
import com.mycompany.entities.HojaRutaOf;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(SeguimientoEmpleadoOf.class)
public class SeguimientoEmpleadoOf_ { 

    public static volatile SingularAttribute<SeguimientoEmpleadoOf, String> usuarioGra;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, Empleado> idEmpleado;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, Integer> idPuntoControl;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, Date> fechaMod;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, Integer> idSeguimiento;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, Date> fechaHoraInicio;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, Date> fechaGra;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, HojaRutaOf> idHojaRuta;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, String> usuarioMod;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, Date> fechaHoraFin;
    public static volatile SingularAttribute<SeguimientoEmpleadoOf, String> banEstado;

}