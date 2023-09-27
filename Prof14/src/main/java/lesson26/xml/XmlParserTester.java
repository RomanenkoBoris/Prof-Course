package lesson26.xml;
// parse - извлечь полезную информацию

// XML - eXtensible Markup Language

// SAX - потоковая библиотека - быстрая, не строит дерево документа, низкие требования к памяти

// DOM - Document Object Model, строится полное дерево документа, требует больше памяти

// XML Schema и XML DTD позволяют атоматически проверить соответствие XML документа заранее определенной структуре

// Xpath - позволяет выполнить запрос к документу
// XSLT - используется для трансформации XML документов к другому виду и формату
// JAXB и SimpleXML - самые распространенные библиотеки для
//      ORM - чтобы можно было сериализовать и десериализовать объект в XML
// ORM - Object Relation Mapping
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParserTester {
    public static void main(String[] args) throws Exception {
        // DOM parsing
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Document - дерево из элементов и атрибутов в памяти
        Document doc = builder.parse(new File("test.xml"));
        // корневой элемент документа

        Element root = doc.getDocumentElement();
        NodeList priceNodeList = root.getElementsByTagName("PRICE");
        for(int i = 0; i < priceNodeList.getLength(); i++){
            Node priceNode = priceNodeList.item(i);
            System.out.println(priceNode.getFirstChild().getTextContent());
        }
        // сложите текстовые значения всех элементов ZONE
        NodeList zoneNodeList = root.getElementsByTagName("ZONE");
        int sum = 0;
        for(int i = 0; i < zoneNodeList.getLength(); i++) {
            sum += Integer.parseInt(zoneNodeList.item(i).getFirstChild().getTextContent());
        }
        System.out.println("sum is: " + sum); // sum is: 7

        System.out.println(root.getAttribute("name"));

        System.out.println(root.getAttribute("size"));

        Element plant2 = (Element) root.getChildNodes().item(1);
        System.out.println(plant2.getAttribute("plantid"));

        NodeList childNodes = root.getChildNodes();
        for(int i = 0; i < childNodes.getLength(); i++){
            System.out.println(childNodes.item(i).getNodeType());
        }


    }
}
