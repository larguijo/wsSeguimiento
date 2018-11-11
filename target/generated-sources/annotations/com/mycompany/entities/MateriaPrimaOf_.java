package com.mycompany.entities;

import com.mycompany.entities.Articulo;
import com.mycompany.entities.OrdenFabricacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-07-26T20:49:59")
@StaticMetamodel(MateriaPrimaOf.class)
public class MateriaPrimaOf_ { 

    public static volatile SingularAttribute<MateriaPrimaOf, String> usuarioGra;
    public static volatile SingularAttribute<MateriaPrimaOf, Articulo> idArticulo;
    public static volatile SingularAttribute<MateriaPrimaOf, Integer> idMateriaPrimaOf;
    public static volatile SingularAttribute<MateriaPrimaOf, Date> fechaMod;
    public static volatile SingularAttribute<MateriaPrimaOf, Double> cantidadSolicitada;
    public static volatile SingularAttribute<MateriaPrimaOf, OrdenFabricacion> idOrdenFabricacion;
    public static volatile SingularAttribute<MateriaPrimaOf, Date> fechaGra;
    public static volatile SingularAttribute<MateriaPrimaOf, Double> cantidadUtilizada;
    public static volatile SingularAttribute<MateriaPrimaOf, String> usuarioMod;
    public static volatile SingularAttribute<MateriaPrimaOf, Double> costoUnitario;

}