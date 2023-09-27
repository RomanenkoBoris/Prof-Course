package lesson26.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class XPathTester {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Document - дерево из элементов и атрибутов в памяти
        Document doc = builder.parse(new File("test.xml"));
        // корневой элемент документа
        Element root = doc.getDocumentElement();
        /*
            /CATALOG
            //LIGHT - все элементы LIGHT в любом месте документа
            /CATALOG/PLANT - все элементы PLANT дочерние для CATALOG
            //MOVIE/ACTOR - элементы ACTOR дочерние для MOVIE в любом месте документа
            //PLANT[@planid='456']/PRICE
         */
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expression = xPath.compile("//PLANT[@plantid='456']/PRICE");
        NodeList price = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
        for(int i = 0; i < price.getLength(); i++)
        {
            System.out.println("price: " + price.item(i).getFirstChild().getTextContent());
        }
    }
}
