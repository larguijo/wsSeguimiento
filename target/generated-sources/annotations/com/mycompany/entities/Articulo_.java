package com.mycompany.entities;

import com.mycompany.entities.Inventario;
import com.mycompany.entities.MateriaPrimaOf;
import com.mycompany.entities.ProductoOf;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(Articulo.class)
public class Articulo_ { 

    public static volatile SingularAttribute<Articulo, Integer> idArticulo;
    public static volatile ListAttribute<Articulo, ProductoOf> productoOfList;
    public static volatile SingularAttribute<Articulo, String> unidadMedida;
    public static volatile SingularAttribute<Articulo, Date> fechaMod;
    public static volatile SingularAttribute<Articulo, String> presentacion;
    public static volatile SingularAttribute<Articulo, Double> alto;
    public static volatile SingularAttribute<Articulo, String> usuarioMod;
    public static volatile SingularAttribute<Articulo, String> nombre;
    public static volatile SingularAttribute<Articulo, Double> costoUnitario;
    public static volatile SingularAttribute<Articulo, String> banEstado;
    public static volatile SingularAttribute<Articulo, String> usuarioGra;
    public static volatile ListAttribute<Articulo, MateriaPrimaOf> materiaPrimaOfList;
    public static volatile SingularAttribute<Articulo, Double> ancho;
    public static volatile ListAttribute<Articulo, Inventario> inventarioList;
    public static volatile SingularAttribute<Articulo, Double> largo;
    public static volatile SingularAttribute<Articulo, Date> fechaGra;
    public static volatile SingularAttribute<Articulo, Double> precioVenta;

}