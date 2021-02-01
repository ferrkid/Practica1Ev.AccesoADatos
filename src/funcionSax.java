

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fptar
 */
class funcionSax extends DefaultHandler{
    
   
    String salida="";

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        for(int i = start;i<length+start;i++){
            salida=salida+ch[i];
        }
        salida=salida.trim()+"\n";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("TLFHouse")){
            salida=salida+"¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨";
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
         if(qName.equals("TLFHouse")){
            salida=salida+"**TLF House**" + "\n" + " ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"+"\n";
        }
         if(qName.equals("movil")){
            salida=salida+" ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨"+"\n";
        }
        if(qName.equals("movil")){
            salida=salida+"Sistema Operativo :  "+attributes.getValue(attributes.getQName(0).trim());
            salida=salida+" \n"+"Codigo IMEI : "+attributes.getValue(attributes.getQName(1).trim());
        }else if(qName.equals("marca")){
            salida=salida+"\n " + "Marca Terminal: ".trim();
        }else if(qName.equals("compania")){
            salida=salida+"Compañia : ";
        }else if(qName.equals("ram")){
            salida=salida+("RAM : ").trim();
        }else if(qName.equals("precio")){
            salida=salida+("Precio de Coste : ").trim();
        }else if(qName.equals("pantalla")){
            salida=salida+("Pulgadas : ").trim();
        }else if(qName.equals("procesador")){
            salida=salida+"Procesador : ";
        }else if(qName.equals("discoduro")){
            salida=salida+"Disco Duro : "+attributes.getValue(attributes.getQName(0).trim());
        }else if(qName.equals("camara")){
            salida=salida+"Camara : ".trim();
        }
    }
    
}
