
package dao;

import java.util.Date;
import java.util.List;
import modelo.PuntoVenta;
import modelo.Sede;
import org.junit.Test;
import static org.junit.Assert.*;

public class PuntoVentaDAOTest {
    
    public PuntoVentaDAOTest() {
    }
/*
    @Test
    public void testListarPVenta() {        
        PuntoVentaDAO instance = new PuntoVentaDAO();
        
        List<PuntoVenta> result = instance.listar();
        
        if (result.size() < 1) {
            fail ("La lista no devuelve ningún elemento");
        }
    }

    @Test
    public void testInsertarPVenta_Normal() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("Nombre de prueba");
        puntoVenta.setEmpresa("Empresa de prueba");
        puntoVenta.setImagen("ImagenDePrueba.jpg");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
    }
    
    @Test
    public void testInsertarPVenta_NombreNull() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        //puntoVenta.setNombre("aaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos null");
        }
    }
    
    @Test
    public void testInsertarPVenta_EmpresaNull() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaa");
        //puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos null");
        }
    }
    
    @Test
    public void testInsertarPVenta_ImagenNull() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        //puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos null");
        }
    }
    
//    @Test //DUDA: BD permite espacios vacios, Pero la página no
//    public void testInsertarPVenta_NombreVacio() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("");
//        puntoVenta.setEmpresa("bbbbb");
//        puntoVenta.setImagen("aaaaaaa");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.insertar(puntoVenta);
//        
//        if (puntoVenta.getIdPuntoVenta()!=null) {
//            fail("No se deberian ingresar puntos de venta con campos vacios");
//        }
//    }
//    
//    @Test //DUDA: BD permite espacios vacios, Pero la página no
//    public void testInsertarPVenta_EmpresaVacia() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("aaaaaa");
//        puntoVenta.setEmpresa("");
//        puntoVenta.setImagen("aaaaaaa");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.insertar(puntoVenta);
//        
//        if (puntoVenta.getIdPuntoVenta()!=null) {
//            fail("No se deberian ingresar puntos de venta con campos vacios");
//        }
//    }
//    
//    @Test //DUDA: BD permite espacios vacios, Pero la página no
//    public void testInsertarPVenta_ImagenVacia() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("aaaaaaa");
//        puntoVenta.setEmpresa("bbbbb");
//        puntoVenta.setImagen("");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.insertar(puntoVenta);
//        
//        if (puntoVenta.getIdPuntoVenta()!=null) {
//            fail("No se deberian ingresar puntos de venta con campos vacios");
//        }
//    }
    
    @Test //fail############# BD y Página permite espacios en blanco
    public void testInsertarPVenta_NombreEspacio() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre(" ");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos en blanco");
        }
    }
    
    @Test //fail############# BD y Página permite espacios en blanco
    public void testInsertarPVenta_EmpresaEspacio() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaaa");
        puntoVenta.setEmpresa(" ");
        puntoVenta.setImagen("aaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos en blanco");
        }
    }
    
    @Test //fail############# BD y Página permite espacios en blanco
    public void testInsertarPVenta_ImagenEspacio() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen(" ");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos en blanco");
        }
    }
    
    @Test //ok
    public void testInsertarPVenta_NombreMaxLargo() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos de largo superior al maximo(nombre:100/empresa:100/imagen:200)");
        }
    }
    
    @Test //ok
    public void testInsertarPVenta_EmpresaMaxLargo() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaaa");
        puntoVenta.setEmpresa("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        puntoVenta.setImagen("aaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos de largo superior al maximo(nombre:100/empresa:100/imagen:200)");
        }
    }
    
    @Test //ok
    public void testInsertarPVenta_ImagenMaxLargo() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta();
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.insertar(puntoVenta);
        
        if (puntoVenta.getIdPuntoVenta()!=null) {
            fail("No se deberian ingresar puntos de venta con campos de largo superior al maximo(nombre:100/empresa:100/imagen:200)");
        }
    }
    
//    @Test //DUDA
//    public void testInsertarPVenta_NombreCaractEsp() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("!#$'%&/()=?¡");
//        puntoVenta.setEmpresa("bbbbb");
//        puntoVenta.setImagen("aaaaaa");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.insertar(puntoVenta);
//        
//        if (puntoVenta.getIdPuntoVenta()!=null) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }
//    
//    @Test //DUDA
//    public void testInsertarPVenta_EmpresaCaractEsp() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("aaaaaa");
//        puntoVenta.setEmpresa("!#$'%&/()=?¡");
//        puntoVenta.setImagen("aaaaaa");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.insertar(puntoVenta);
//        
//        if (puntoVenta.getIdPuntoVenta()!=null) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }
//    
//    @Test //DUDA
//    public void testInsertarPVenta_ImagenCaractEsp() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("aaaaaa");
//        puntoVenta.setEmpresa("bbbbb");
//        puntoVenta.setImagen("!#$'%&/()=?¡");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.insertar(puntoVenta);
//        
//        if (puntoVenta.getIdPuntoVenta()!=null) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }
    
    @Test //ok
    public void testActualizarPVenta_Normal() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
    }
    
    @Test //ok
    public void testActualizarPVenta_NombreNull() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        //puntoVenta.setNombre("aaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getNombre()==null) {
            fail("No debería dejar actualizar campos a null");
        }
    }
    
    @Test //ok
    public void testActualizarPVenta_EmpresaNull() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaa");
        //puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getEmpresa()==null) {
            fail("No debería dejar actualizar campos a null");
        }
    }
    
    @Test //ok
    public void testActualizarPVenta_ImagenNull() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        //puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getImagen()==null) {
            fail("No debería dejar actualizar campos a null");
        }
    }
    
//    @Test //DUDA BD permite vacios, Pero la página no
//    public void testActualizarPVenta_NombreVacio() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("");
//        puntoVenta.setEmpresa("bbbbb");
//        puntoVenta.setImagen("aaaaaaa");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.actualizar(puntoVenta);
//        
//        if (instance.buscarPuntoVentaPorId(puntoVenta).getNombre().equals("")) {
//            fail("No debería dejar actualizar campos a vacío");
//        }
//    }
//    
//    @Test //DUDA BD permite vacios, Pero la página no
//    public void testActualizarPVenta_EmpresaVacia() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("aaaaaa");
//        puntoVenta.setEmpresa("");
//        puntoVenta.setImagen("aaaaaaa");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.actualizar(puntoVenta);
//        
//        if (instance.buscarPuntoVentaPorId(puntoVenta).getEmpresa().equals("")) {
//            fail("No debería dejar actualizar campos a vacío");
//        }
//    }
//    
//    @Test //DUDA BD permite vacios, Pero la página no
//    public void testActualizarPVenta_ImagenVacia() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("aaaaaa");
//        puntoVenta.setEmpresa("bbbbb");
//        puntoVenta.setImagen("");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.actualizar(puntoVenta);
//        
//        if (instance.buscarPuntoVentaPorId(puntoVenta).getImagen().equals("")) {
//            fail("No debería dejar actualizar campos a vacío");
//        }
//    }
    
    @Test //fail############# Página permite espacios en blanco
    public void testActualizarPVenta_NombreEspacio() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre(" ");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getNombre().equals(" ")) {
            fail("No debería dejar actualizar campos a espacio");
        }
    }
    
    @Test //fail############# Página permite espacios en blanco
    public void testActualizarPVenta_EmpresaEspacio() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaa");
        puntoVenta.setEmpresa(" ");
        puntoVenta.setImagen("aaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getEmpresa().equals(" ")) {
            fail("No debería dejar actualizar campos a espacio");
        }
    }
    
    @Test //fail############# Página permite espacios en blanco
    public void testActualizarPVenta_IagenEspacio() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen(" ");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getImagen().equals(" ")) {
            fail("No debería dejar actualizar campos a espacio");
        }
    }
    
    @Test //ok
    public void testActualizarPVenta_NombreMaxLargo() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getNombre().equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) {
            fail("No debería dejar actualizar campos a espacio");
        }
    }
    
    @Test //ok
    public void testActualizarPVenta_EmpresaMaxLargo() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaaa");
        puntoVenta.setEmpresa("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        puntoVenta.setImagen("aaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getEmpresa().equals("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")) {
            fail("No debería dejar actualizar campos a espacio");
        }
    }
    
    @Test //ok
    public void testActualizarPVenta_ImagenMaxLargo() {
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta puntoVenta = new PuntoVenta(12);/////////////////////////// CAMBIAR ID
        Date horaInicio = new Date();
        Date horaFin = new Date();
        
        puntoVenta.setNombre("aaaaa");
        puntoVenta.setEmpresa("bbbbb");
        puntoVenta.setImagen("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        puntoVenta.setHoraInicio(horaInicio);
        puntoVenta.setHoraFin(horaFin);
        puntoVenta.setActivo(true);
        puntoVenta.setSede(new Sede(1));
        instance.actualizar(puntoVenta);
        
        if (instance.buscarPuntoVentaPorId(puntoVenta).getImagen().equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) {
            fail("No debería dejar actualizar campos a espacio");
        }
    }
    
//    @Test //DUDA
//    public void testActualizarPVenta_NombreCaractEsp() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("!#$'%&/()=?¡");
//        puntoVenta.setEmpresa("bbbbb");
//        puntoVenta.setImagen("aaaaaa");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.actualizar(puntoVenta);
//        
//        if (instance.buscarPuntoVentaPorId(puntoVenta).getNombre().equals("!#$'%&/()=?¡")) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }
//    
//    @Test //DUDA
//    public void testActualizarPVenta_EmpresaCaractEsp() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("aaaaa");
//        puntoVenta.setEmpresa("!#$'%&/()=?¡");
//        puntoVenta.setImagen("aaaaaa");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.actualizar(puntoVenta);
//        
//        if (instance.buscarPuntoVentaPorId(puntoVenta).getEmpresa().equals("!#$'%&/()=?¡")) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }
//    
//    @Test //DUDA
//    public void testActualizarPVenta_ImagenCaractEsp() {
//        PuntoVentaDAO instance = new PuntoVentaDAO();
//        PuntoVenta puntoVenta = new PuntoVenta();
//        Date horaInicio = new Date();
//        Date horaFin = new Date();
//        
//        puntoVenta.setNombre("aaaaaa");
//        puntoVenta.setEmpresa("bbbbb");
//        puntoVenta.setImagen("!#$'%&/()=?¡");
//        puntoVenta.setHoraInicio(horaInicio);
//        puntoVenta.setHoraFin(horaFin);
//        puntoVenta.setActivo(true);
//        puntoVenta.setSede(new Sede(1));
//        instance.actualizar(puntoVenta);
//        
//        if (instance.buscarPuntoVentaPorId(puntoVenta).getImagen().equals("!#$'%&/()=?¡")) {
//            fail("En los campos solo se deberían permitir los simbolos: # & ' . ,");
//        }
//    }
    
    @Test //ok     ////////////// en PuntoDeVentaDAO.eliminar() agregar al principio: em = getEntityManager();
    public void testEliminarPVenta_Existe() {
        PuntoVenta puntoVenta = new PuntoVenta(8);/////////////////////////// CAMBIAR ID
        PuntoVentaDAO instance = new PuntoVentaDAO();
        instance.eliminar(puntoVenta);
        if (instance.buscarPuntoVentaPorId(puntoVenta)!=null) {
            fail("No se pudo eliminar punto de venta");
        }
    }
    
    @Test //ok     ////////////// en PuntoDeVentaDAO.eliminar() agregar al principio: em = getEntityManager();
    public void testEliminarPVenta_NoExiste() {
        PuntoVenta puntoVenta = new PuntoVenta(9999);/////////////////////////// CAMBIAR ID
        PuntoVentaDAO instance = new PuntoVentaDAO();
        try{
            instance.eliminar(puntoVenta);
        }catch(Exception e){
            fail("Ocurrió un error al intentar eliminar un punto de venta inexistente");
        }  
    }
    
    @Test
    public void testBuscarPuntoVentaPorId_Encontrado() {
        PuntoVenta puntoVenta = new PuntoVenta(1);
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta result = instance.buscarPuntoVentaPorId(puntoVenta);
        assertEquals(puntoVenta.getIdPuntoVenta(), result.getIdPuntoVenta());
        if (!puntoVenta.getIdPuntoVenta().equals(result.getIdPuntoVenta())) {
            fail("No se ha encontrado punto de venta");
        }
    }

    @Test //ok
    public void testBuscarPuntoVentaPorId_NoEncontrado() {
        PuntoVenta puntoVenta = new PuntoVenta(99999);
        PuntoVentaDAO instance = new PuntoVentaDAO();
        PuntoVenta result = instance.buscarPuntoVentaPorId(puntoVenta);
        int r = 0;
        try{
            r = result.getIdPuntoVenta();
            assertNotEquals(puntoVenta.getIdPuntoVenta(), r, 0);
        }catch(Exception e){
            assertEquals(r, 0);
        }
    }
*/
}
