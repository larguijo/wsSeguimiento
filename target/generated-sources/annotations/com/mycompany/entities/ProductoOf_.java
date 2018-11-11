package com.mycompany.entities;

import com.mycompany.entities.Articulo;
import com.mycompany.entities.OrdenFabricacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(ProductoOf.class)
public class ProductoOf_ { 

    public static volatile SingularAttribute<ProductoOf, String> usuarioGra;
    public static volatile SingularAttribute<ProductoOf, Articulo> idArticulo;
    public static volatile SingularAttribute<ProductoOf, Integer> idProductoOf;
    public static volatile SingularAttribute<ProductoOf, Date> fechaMod;
    public static volatile SingularAttribute<ProductoOf, Double> cantidadSolicitada;
    public static volatile SingularAttribute<ProductoOf, Double> cantidadProducida;
    public static volatile SingularAttribute<ProductoOf, OrdenFabricacion> idOrdenFabricacion;
    public static volatile SingularAttribute<ProductoOf, Date> fechaGra;
    public static volatile SingularAttribute<ProductoOf, Double> precioVenta;
    public static volatile SingularAttribute<ProductoOf, String> usuarioMod;
    public static volatile SingularAttribute<ProductoOf, Double> costoUnitario;

}