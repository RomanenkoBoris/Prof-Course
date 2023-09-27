package lesson26.xml.jaxb;

//import jakarta.xml.bind.JAXBContext;
//import jakarta.xml.bind.Marshaller;
//
//import java.io.File;
//import java.util.Arrays;
//
//public class JaxbSerializer {
//    public static void main(String[] args) throws Exception {
//        JAXBContext context = JAXBContext.newInstance(Catalog.class);
//
//        Plant p = new Plant();
//        p.setCommon("COMMON");
//        p.setZone("ZONE");
//        p.setAvailability("AVILABLE");
//        p.setPrice("$123");
//        p.setLight("LIGHT");
//        p.setBotanical("BOTANICAL");
//
//        Catalog c= new Catalog();
//        c.setSize("BIG");
//        c.setName("NAME");
//        c.setPlants(Arrays.asList(p));
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(c, new File("catalog.xml"));
//    }
//}
