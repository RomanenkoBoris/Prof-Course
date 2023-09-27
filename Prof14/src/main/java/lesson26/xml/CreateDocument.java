package lesson26.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
 /* <test hello="123">
        <world ig="456"/>
    </test>   */
public class CreateDocument {
    public static void main(String[] args) throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("test"); // - создаем корневой элемент
        root.setAttribute("hello", "123");  // - добавляем в него атрибут
        doc.appendChild(root);  // добавляем корневой элемент в наш документ

        Element world = doc.createElement("world"); // создаем еще один элемент (дочерний)
        world.setAttribute("id", "456"); // - добавляем в него атрибут
        root.appendChild(world); // добавляем дочерний элемент в наш корень root - соблюдаем структуру и иерархию

        // Сохранение полученного XML документа (в каком-либо виде)
        FileOutputStream fos = new FileOutputStream("result.xml"); // вывод информации в файл
        DOMSource source = new DOMSource(doc); // ДОМ дерево - источник для вывода инф-ии (XML документа)
        StreamResult result = new StreamResult(fos);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }
}