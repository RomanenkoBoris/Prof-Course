package lesson26.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

// Посчитайте сумму цен растений из файла test.xml - $2.44+$9.37 должно быть 11.81
public class CalculatePlantPrices {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // DOM parsing
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Document - дерево из элементов и атрибутов в памяти
        Document doc = builder.parse(new File("test.xml"));
        // корневой элемент документа
        Element root = doc.getDocumentElement();

        NodeList priceNodeList = root.getElementsByTagName("PRICE");
        float sum = 0;
        for(int i = 0; i < priceNodeList.getLength(); i++)
        {
            String price = priceNodeList.item(i).getFirstChild().getTextContent();
            price = price.replaceAll("\\$", ""); // "$1.33"
            sum += Float.parseFloat(price);
        }
        System.out.println(sum);

    }
}
