

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javaTienda.TLFHouse;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fptar
 */
class gestorJAXB {
    
     //lista
    TLFHouse Movil;
    Unmarshaller u;
    JAXBContext contexto;

    public int abrirXML_JAXB() {
        try {
            contexto = JAXBContext.newInstance(TLFHouse.class);
            u = contexto.createUnmarshaller();

            Movil = (TLFHouse) u.unmarshal(new File("tiendaMoviles.xml"));
            File miFile = new File("tiendaMoviles.xml");
            System.out.println(miFile.getAbsolutePath());

            return 1;
        } catch (Exception e) {

            return -1;
        }

    }

    public int cerrarXML_JAXB() {
        try {
            Marshaller m = contexto.createMarshaller();
            m.marshal(Movil, new File("tiendaMoviles.xml"));
            return 1;
        } catch (Exception e) {
        }
        return -1;
    }

    public String recorrerJAXB() {
        String cadena_resultado = "";
        List<TLFHouse.Movil> miMovil = Movil.getMovil();

           for (int i = 0; i < miMovil.size(); i++) {
            TLFHouse.Movil movilAuxiliar = miMovil.get(i);

            cadena_resultado = cadena_resultado + "\nCliente nuevo\n" + "\nVehiculo: " + movilAuxiliar.getSistemaOperativo();
            cadena_resultado = cadena_resultado + "\nfecha de la entrada: " + movilAuxiliar.getCodigoIMEI();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getMarca();
            cadena_resultado = cadena_resultado + "\nCliente nuevo\n" + "\nVehiculo: " + movilAuxiliar.getCompania();
            cadena_resultado = cadena_resultado + "\nfecha de la entrada: " + movilAuxiliar.getRam();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getPrecio();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getPantalla();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getProcesador();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getDiscoduro()+ "\n¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n";
            
        }
        return cadena_resultado;
    }

    public String cambioValor(String campoAntiguo, String campoNuevo, String codigoIMEI_introducido) {
        String cadena_resultado = "";
        List<TLFHouse.Movil> miMovil = Movil.getMovil();
        for (int i = 0; i < miMovil.size(); i++) {
            TLFHouse.Movil movilAuxiliar = miMovil.get(i);
                if (movilAuxiliar.getCodigoIMEI().equals(codigoIMEI_introducido) && movilAuxiliar.getCompania().equals(campoAntiguo)) {
                    miMovil.get(i).setCompania(campoNuevo);
                }else if (movilAuxiliar.getCodigoIMEI().equals(codigoIMEI_introducido) && movilAuxiliar.getDiscoduro().equals(campoAntiguo)) {
                    miMovil.get(i).setDiscoduro(campoNuevo);
                }else if (movilAuxiliar.getCodigoIMEI().equals(codigoIMEI_introducido) && movilAuxiliar.getPrecio().equals(campoAntiguo)) {
                    miMovil.get(i).setPrecio(campoNuevo);
                }
        }
        
         for (int i = 0; i < miMovil.size(); i++) {
            TLFHouse.Movil movilAuxiliar = miMovil.get(i);

            cadena_resultado = cadena_resultado + "\nCliente nuevo\n" + "\nVehiculo: " + movilAuxiliar.getSistemaOperativo();
            cadena_resultado = cadena_resultado + "\nfecha de la entrada: " + movilAuxiliar.getCodigoIMEI();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getMarca();
            cadena_resultado = cadena_resultado + "\nCliente nuevo\n" + "\nVehiculo: " + movilAuxiliar.getCompania();
            cadena_resultado = cadena_resultado + "\nfecha de la entrada: " + movilAuxiliar.getRam();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getPrecio();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getPantalla();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getProcesador();
            cadena_resultado = cadena_resultado + "\nLa marca del vehiculo es: " + movilAuxiliar.getDiscoduro()+ "\n¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n";
            
        }
        System.out.println(cadena_resultado);
        return cadena_resultado;
    }
    
}
