package com.mycompany.entities;

import com.mycompany.entities.OrdenFabricacion;
import com.mycompany.entities.SeguimientoEmpleadoOf;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> apellidos;
    public static volatile SingularAttribute<Empleado, String> usuarioGra;
    public static volatile ListAttribute<Empleado, OrdenFabricacion> ordenFabricacionList;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile SingularAttribute<Empleado, Date> fechaMod;
    public static volatile SingularAttribute<Empleado, Date> fechaGra;
    public static volatile SingularAttribute<Empleado, String> usuarioMod;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile SingularAttribute<Empleado, String> banEstado;
    public static volatile ListAttribute<Empleado, SeguimientoEmpleadoOf> seguimientoEmpleadoOfList;

}