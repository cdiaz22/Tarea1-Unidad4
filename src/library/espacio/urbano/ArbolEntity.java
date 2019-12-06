package library.espacio.urbano;

import library.espacio.espaciofisico.Lugar;
import library.espacio.espaciofisico.Objeto;
import library.espacio.espaciofisico.Posicion;

public class ArbolEntity extends Objeto {

    public ArbolEntity(String nombre, Posicion laPosicion, Lugar elLugar) {
        super(nombre, laPosicion, elLugar);
    }
}
