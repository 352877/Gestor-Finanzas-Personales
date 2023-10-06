package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import modelos.DataManager;

public class EditarGastosIngresos {
    
    public DefaultTableModel cargarProductos() throws SQLException {
        String [] columnas = {
            "Id",
            "Fecha",
            "Ingresos", 
            "Gastos",

        };
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        DataManager manejador = new DataManager();
        ResultSet datos = manejador.obtenerDatos("SELECT * FROM departamentos");
        String[] registro = new String[8];
        while(datos.next()){
            registro[0] = datos.getString("id");
            registro[1] = datos.getString("fecha");
            registro[2] = datos.getString("ingresos");
            registro[3] = String.valueOf(datos.getDouble("gastos"));
            modelo.addRow(registro);
        }
        manejador.cerrar();
        return modelo;
    }
    
    public void actualizarProducto(int id, String... datos) throws SQLException{
        DataManager manejador = new DataManager();
        String sql = "UPDATE departamentos SET "
                + "id='"+datos[0]+"', "
                + "fecha='"+datos[1]+"', "
                + "ingresos='"+datos[2]+"', "
                + "gastos="+datos[3]+", ";
        manejador.ejecutarConsulta(sql);
    }
    
    public void eliminarProducto(int id) throws SQLException{
        DataManager manejador = new DataManager();
        String sql = "DELETE FROM departamentos WHERE id="+id;
        manejador.ejecutarConsulta(sql);
    }
}
