package inventarioorganizaciondirecta.Controlador;
import inventarioorganizaciondirecta.Modelo.ArchivoInventario;
import inventarioorganizaciondirecta.Modelo.Producto;
import java.io.IOException;


public class ProductoControlador {

    ArchivoInventario archivo;

    public ProductoControlador() throws IOException {

        archivo = new ArchivoInventario("inventario.dat");
    }

    public ArchivoInventario getArchivo() {

        return archivo;
    }

    public boolean guardarProducto(Producto p)
            throws IOException {

        Producto existe = archivo.leer(p.id);

        if (existe != null && existe.estado) {

            return false;
        }

        archivo.guardar(p);

        return true;
    }

    public boolean eliminarProducto(int id)
            throws IOException {

        Producto p = archivo.leer(id);

        if (p == null || !p.estado) {

            return false;
        }

        p.estado = false;

        archivo.guardar(p);

        return true;
    }

    public boolean actualizarProducto(Producto p)
            throws IOException {

        Producto existe = archivo.leer(p.id);

        if (existe == null || !existe.estado) {

            return false;
        }

        archivo.guardar(p);

        return true;
    }
}