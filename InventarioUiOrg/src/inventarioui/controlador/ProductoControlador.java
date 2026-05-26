package inventarioui.controlador;

import inventarioui.modelo.ArchivoInventario;
import inventarioui.modelo.Producto;
import java.io.IOException;

public class ProductoControlador {

    ArchivoInventario archivo;

    public ProductoControlador() throws IOException {

        archivo = new ArchivoInventario("inventario.dat");
    }

    public ArchivoInventario getArchivo() {

        return archivo;
    }

    // GUARDAR
    public boolean guardarProducto(Producto p) throws IOException {

        int existe = archivo.buscarPorId(p.id);

        if (existe != -1) {

            return false;
        }

        int pos = archivo.totalRegistros();

        archivo.guardar(p, pos);

        return true;
    }

    // ELIMINAR
    public boolean eliminarProducto(int id) throws IOException {

        int pos = archivo.buscarPorId(id);

        if (pos == -1) {

            return false;
        }

        Producto p = archivo.leer(pos);

        p.estado = false;

        archivo.guardar(p, pos);

        return true;
    }

    // ACTUALIZAR
    public boolean actualizarProducto(Producto p) throws IOException {

        int pos = archivo.buscarPorId(p.id);

        if (pos == -1) {

            return false;
        }

        archivo.guardar(p, pos);

        return true;
    }
}