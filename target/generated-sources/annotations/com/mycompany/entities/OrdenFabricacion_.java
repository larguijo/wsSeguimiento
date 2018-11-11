package com.mycompany.entities;

import com.mycompany.entities.Clientes;
import com.mycompany.entities.Empleado;
import com.mycompany.entities.HojaRutaOf;
import com.mycompany.entities.LineaProductiva;
import com.mycompany.entities.MateriaPrimaOf;
import com.mycompany.entities.ProductoOf;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(OrdenFabricacion.class)
public class OrdenFabricacion_ { 

    public static volatile ListAttribute<OrdenFabricacion, HojaRutaOf> hojaRutaOfList;
    public static volatile ListAttribute<OrdenFabricacion, ProductoOf> productoOfList;
    public static volatile SingularAttribute<OrdenFabricacion, Date> fechaMod;
    public static volatile SingularAttribute<OrdenFabricacion, Date> fechaEmision;
    public static volatile SingularAttribute<OrdenFabricacion, String> usuarioMod;
    public static volatile SingularAttribute<OrdenFabricacion, LineaProductiva> idLineaProductiva;
    public static volatile SingularAttribute<OrdenFabricacion, String> banEstado;
    public static volatile SingularAttribute<OrdenFabricacion, String> usuarioGra;
    public static volatile ListAttribute<OrdenFabricacion, MateriaPrimaOf> materiaPrimaOfList;
    public static volatile SingularAttribute<OrdenFabricacion, Clientes> idCliente;
    public static volatile SingularAttribute<OrdenFabricacion, Date> fechaInicio;
    public static volatile SingularAttribute<OrdenFabricacion, Date> fechaEntrega;
    public static volatile SingularAttribute<OrdenFabricacion, String> observaciones;
    public static volatile SingularAttribute<OrdenFabricacion, Integer> idOrdenFabricacion;
    public static volatile SingularAttribute<OrdenFabricacion, Empleado> idSupervisor;
    public static volatile SingularAttribute<OrdenFabricacion, Date> fechaGra;
    public static volatile SingularAttribute<OrdenFabricacion, Date> fechaEstimadaTerminacion;
    public static volatile SingularAttribute<OrdenFabricacion, Date> fechaTerminacion;
    public static volatile SingularAttribute<OrdenFabricacion, String> banTipo;

}