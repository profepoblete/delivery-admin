
package dao;

import java.util.List;
import modelo.PuntoVenta;
import modelo.Sede;
import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class SedeDAOTest {
    public SedeDAOTest() {
    }
    /*
    static int editTest = 51;
    static int eliminarSede = 50;
    
    @BeforeClass
    public static void crearSedeTesting(){
//        //SEDE PARA EDITAR
//        Sede s1 = new Sede();
//        s1.setNombreSede("Valparaiso");
//        s1.setDireccion("Abcd 123, Valparaiso");
//        SedeDAO i1 = new SedeDAO();
//        i1.insertar(s1);
//        editTest = s1.getIdSede();
//        //SEDE PARA ELIMINAR
//        Sede s2 = new Sede();
//        s2.setNombreSede("Eliminar");
//        s2.setDireccion("Eliminar 123, Eliminar");
//        SedeDAO i2 = new SedeDAO();
//        i2.insertar(s2);
//        eliminarSede = s2.getIdSede();
    }
    
    
    @Test //ok
    public void testListarSede() {
        SedeDAO instance = new SedeDAO();
        
        List<Sede> result = instance.listar();
        
        if (result.size() < 1) {
            fail ("La lista no devuelve ningún elemento");
        }
    }
    
    @Test //ok
    public void testInsertarSede_Normal() {
        Sede sedeSinRelacion = new Sede();
        
        sedeSinRelacion.setNombreSede("Sede de prueba");
        sedeSinRelacion.setDireccion("Dirección de prueba");
        SedeDAO instance = new SedeDAO();
        instance.insertar(sedeSinRelacion);
    }
    
    @Test //ok
    public void testInsertarSede_NombreNull() {
        Sede sede = new Sede();
        SedeDAO instance = new SedeDAO();
        
        sede.setDireccion("abc 123");
        instance.insertar(sede);
        
        if (sede.getIdSede()!=null) {
            fail("No se deberian ingresar sedes con campos null");
        }
    }
    
    @Test //ok
    public void testInsertarSede_DireccionNull() {
        Sede sede = new Sede();
        SedeDAO instance = new SedeDAO();
        
        sede.setNombreSede("Valparaiso");
        instance.insertar(sede);
        
        if (sede.getIdSede()!=null) {
            fail("No se deberian ingresar sedes con campos null");
        }
    }

//    @Test //DUDA: BD permite espacios vacios, Pero la página no
//    public void testInsertarSede_NombreVacio() {
//        Sede sede = new Sede();
//        SedeDAO instance = new SedeDAO();
//        
//        sede.setNombreSede("");
//        sede.setDireccion("abc 123");
//        
//        instance.insertar(sede);
//        if (sede.getIdSede()!=null) {
//            fail("No se deberian ingresar sedes con campos vacíos");
//        }
//    }
//    
//    @Test //DUDA: BD permite espacios vacios, Pero la página no
//    public void testInsertarSede_DireccionVacia() {
//        Sede sede = new Sede();
//        SedeDAO instance = new SedeDAO();
//        
//        sede.setNombreSede("Valparaiso");
//        sede.setDireccion("");
//        
//        instance.insertar(sede);
//        if (sede.getIdSede()!=null) {
//            fail("No se deberian ingresar sedes con campos vacíos");
//        }
//    }

    @Test //fail############# BD y Página permite espacios en blanco
    public void testInsertarSede_NombreEspacio() {
        Sede sede = new Sede();
        SedeDAO instance = new SedeDAO();

        sede.setNombreSede(" ");
        sede.setDireccion("abc 123");
        instance.insertar(sede);
        
        if (sede.getIdSede()!=null) {
            fail("No se deberian ingresar sedes con campos en blanco");
        }
    }
    
    @Test //fail############# BD y Página permite espacios en blanco
    public void testInsertarSede_DireccionEspacio() {
        Sede sede = new Sede();
        SedeDAO instance = new SedeDAO();
        
        sede.setNombreSede("Valparaiso");
        sede.setDireccion(" ");
        instance.insertar(sede);
        
        if (sede.getIdSede()!=null) {
            fail("No se deberian ingresar sedes con campos en blanco");
        }
    }
    
    @Test //ok
    public void testInsertarSede_NombreMaxLargo() {
        Sede sede = new Sede();
        SedeDAO instance = new SedeDAO();
        
        sede.setNombreSede("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        sede.setDireccion("abc 123");
        instance.insertar(sede);
        
        if (sede.getIdSede()!=null) {
            fail("No se deberian ingresar sedes con campos de largo superior al maximo(nombre:50/direccion:100)");
        }
    }
    
    @Test //ok
    public void testInsertarSede_DireccionMaxLargo() {
        Sede sede = new Sede();
        SedeDAO instance = new SedeDAO();
        
        sede.setNombreSede("Valparaiso");
        sede.setDireccion("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        instance.insertar(sede);
        
        if (sede.getIdSede()!=null) {
            fail("No se deberian ingresar sedes con campos de largo superior al maximo(nombre:50/direccion:100)");
        }
    }

//    @Test //DUDA
//    public void testInsertarSede_NombreCaractEsp() {
//        Sede sede = new Sede();
//        sede.setNombreSede("!#$'%&/()=?¡");
//        sede.setDireccion("abc 123");
//        SedeDAO instance = new SedeDAO();
//        instance.insertar(sede);
//        if (sede.getIdSede()!=null) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }
//    
//    @Test //DUDA
//    public void testInsertarSede_DireccionCaractEsp() {
//        Sede sede = new Sede();
//        sede.setNombreSede("Valparaiso");
//        sede.setDireccion("!#$'%&/()=?¡");
//        SedeDAO instance = new SedeDAO();
//        instance.insertar(sede);
//        if (sede.getIdSede()!=null) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }

    @Test //ok
    public void testActualizarSede_Normal() {
        SedeDAO instance = new SedeDAO();
        Sede sede = new Sede(editTest);
        
        sede.setNombreSede("Renca");
        sede.setDireccion("abc 123, Renca");
        
        instance.actualizar(sede);
    }
   
    @Test //ok
    public void testActualizarSede_NombreNull() {
        Sede sede = new Sede(editTest);
        SedeDAO instance = new SedeDAO();
        
        sede.setDireccion("abc 123, Renca");
        instance.actualizar(sede);
        
        if (instance.buscarSedePorId(sede).getNombreSede()==null) {
            fail("No debería dejar actualizar campos a null");
        }
    }
    
    @Test //ok
    public void testActualizarSede_DireccionNull() {
        Sede sede = new Sede(editTest);
        SedeDAO instance = new SedeDAO();
        
        sede.setNombreSede("Renca");
        instance.actualizar(sede);
        
        if (instance.buscarSedePorId(sede).getDireccion()==null) {
            fail("No debería dejar actualizar campos a null");
        }
    }
     
//    @Test //DUDA BD permite vacios, Pero la página no
//    public void testActualizarSede_NombreVacio() {
//        Sede sede = new Sede(editTest);
//        SedeDAO instance = new SedeDAO();
//        sede.setNombreSede("");
//        sede.setDireccion("abc 123, Renca");
//        instance.actualizar(sede);
//        if (instance.buscarSedePorId(sede).getNombreSede().compareTo("")==0) {
//            fail("No debería dejar actualizar campos a vacío");
//        }
//    }
//    
//    @Test //DUDA BD permite vacios, Pero la página no
//    public void testActualizarSede_DireccionVacia() {
//        Sede sede = new Sede(editTest);
//        SedeDAO instance = new SedeDAO();
//        sede.setNombreSede("Renca");
//        sede.setDireccion("");
//        instance.actualizar(sede);
//        if (instance.buscarSedePorId(sede).getDireccion().compareTo("")==0) {
//            fail("No debería dejar actualizar campos a vacío");
//        }
//    }
    
    @Test //fail############# Página permite espacios en blanco
    public void testActualizarSede_NombreEspacio() {
        Sede sede = new Sede(editTest);
        SedeDAO instance = new SedeDAO();
        sede.setNombreSede(" ");
        sede.setDireccion("abc 123, Renca");
        instance.actualizar(sede);
        if (instance.buscarSedePorId(sede).getNombreSede().compareTo(" ")==0) {
            fail("No debería dejar actualizar campos a espacio");
        }
    }
    
    @Test
        public void testActualizarSede_DireccionEspacio() {
        Sede sede = new Sede(editTest);
        SedeDAO instance = new SedeDAO();
        sede.setNombreSede("Renca");
        sede.setDireccion(" ");
        instance.actualizar(sede);
        if (instance.buscarSedePorId(sede).getDireccion().compareTo(" ")==0) {
            fail("No debería dejar actualizar campos a espacio");
        }
    }
      
    @Test //ok
    public void testActualizarSede_NombreMaxLargo() {
        Sede sede = new Sede(editTest);
        SedeDAO instance = new SedeDAO();
        sede.setNombreSede("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        sede.setDireccion("abc 123");
        instance.actualizar(sede);
        if (instance.buscarSedePorId(sede).getNombreSede().compareTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")==0) {
            fail("No debería dejar actualizar campos de largo superior al maximo(nombre:50/direccion:100)");
        }
    }  
    
    @Test //ok
    public void testActualizarSede_DireccionMaxLargo() {
        Sede sede = new Sede(editTest);
        SedeDAO instance = new SedeDAO();
        sede.setNombreSede("Valparaiso");
        sede.setDireccion("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        instance.actualizar(sede);
        if (instance.buscarSedePorId(sede).getDireccion().compareTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")==0) {
            fail("No debería dejar actualizar campos de largo superior al maximo(nombre:50/direccion:100)");
        }
    }
     
//    @Test //DUDA
//    public void testActualizarSede_NombreCaracEsp() {
//        Sede sede = new Sede(editTest);
//        SedeDAO instance = new SedeDAO();
//        sede.setNombreSede("!#$%&/()=?¡");
//        instance.actualizar(sede);
//        if (instance.buscarSedePorId(sede).getNombreSede().compareTo("!#$%&/()=?¡")==0) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }
//    
//    @Test //DUDA
//    public void testActualizarSede_DireccionCaracEsp() {
//        Sede sede = new Sede(editTest);
//        SedeDAO instance = new SedeDAO();
//        sede.setDireccion("!#$%&/()=?¡");
//        instance.actualizar(sede);
//        if (instance.buscarSedePorId(sede).getNombreSede().compareTo("!#$%&/()=?¡")==0) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    } 
    @Test //ok     ////////////// en SedeDAO.eliminar() agregar al principio: em = getEntityManager();
    public void testEliminarSede_Existe() {
        Sede sede = new Sede();
        sede.setIdSede(eliminarSede);
        SedeDAO instance = new SedeDAO();
        instance.eliminar(sede);
        if (instance.buscarSedePorId(sede)!=null) {
            fail("No se pudo eliminar sede ID: "+sede.getIdSede());
        }
    }
    
    @Test //ok     ////////////// en SedeDAO.eliminar() agregar al principio: em = getEntityManager();
    public void testEliminarSede_NoExiste() {
        Sede sede = new Sede(999999);
        SedeDAO instance = new SedeDAO();
        try{
            instance.eliminar(sede);
        }catch(Exception e){
            fail("Ocurrió un error al intentar eliminar una sede inexistente");
        }  
    }
    
    @Test //ok
    public void testBuscarSedePorId_Encontrado() {
        Sede s = new Sede(editTest);
        SedeDAO instance = new SedeDAO();
        Sede result = instance.buscarSedePorId(s);
        assertEquals(s.getIdSede(), result.getIdSede());
        if (!s.getIdSede().equals(result.getIdSede())) {
            fail("No se ha encontrado sede");
        }
    }
    
    @Test //ok
    public void testBuscarSedePorId_NoEncontrado() {
        Sede s = new Sede(999999);
        SedeDAO instance = new SedeDAO();
        
        Sede result = instance.buscarSedePorId(s);
        int r = 0;
        
        try{
            r = result.getIdSede();
            assertNotEquals(s.getIdSede(), r, 0);
        }catch(Exception e){
            assertEquals(r, 0);
        }
    }
   
    @Test //ok
    public void testExisteIdSede_Encontrado() {
        Integer id = editTest;
        SedeDAO instance = new SedeDAO();
        
        boolean expResult = true;
        boolean result = instance.existeIdSede(id);
        
        assertEquals(expResult, result);
    }
    
    @Test //ok
    public void testExisteIdSede_NoEncontrado() {
        Integer id = 99999;
        SedeDAO instance = new SedeDAO();
        
        boolean expResult = false;
        boolean result = instance.existeIdSede(id);
        
        assertEquals(expResult, result);
    }
    
    
*/
}

// ID  Descripcion  Metodo/Referencia  ResultadoEsperado  ResultadoGenerado  Estado  Explicación  EstadoFinal
// Normal###, nula###, vacia###, espacios###, maxLargo###, caracteresEspeciales###

