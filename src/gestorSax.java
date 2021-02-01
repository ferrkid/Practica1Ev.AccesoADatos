
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fptar
 */
class gestorSax {
    
    SAXParser parser;
    funcionSax sh;
    File miXML;

    public int abrirSAX(File fichero) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            sh = new funcionSax();
            miXML = fichero;

            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    public String recorreSAX() {
        try {
            sh.salida="";
            parser.parse(miXML,sh);
            return sh.salida;
        } catch (Exception e) {
            return "No se ha podido recorrer SAX, intentalo mas tarde";
        }
    }
    
    
}
