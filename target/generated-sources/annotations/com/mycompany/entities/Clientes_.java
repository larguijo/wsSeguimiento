package com.mycompany.entities;

import com.mycompany.entities.OrdenFabricacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> usuarioGra;
    public static volatile ListAttribute<Clientes, OrdenFabricacion> ordenFabricacionList;
    public static volatile SingularAttribute<Clientes, Integer> idCliente;
    public static volatile SingularAttribute<Clientes, Date> fechaMod;
    public static volatile SingularAttribute<Clientes, Date> fechaGra;
    public static volatile SingularAttribute<Clientes, String> usuarioMod;
    public static volatile SingularAttribute<Clientes, String> nombre;
    public static volatile SingularAttribute<Clientes, String> banEstado;

}