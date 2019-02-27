package me.ianhe.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * xml解析
 *
 * @author iHelin
 * @since 2017/11/21 12:23
 */
public class XmlTest {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse("demo/books.xml");
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("书本数量：" + bookList.getLength());
            System.out.println();
            for (int i = 0; i < bookList.getLength(); i++) {
                Element book = (Element) bookList.item(i);
                String attr = book.getAttribute("id");
                System.out.println("-第" + attr + "本书");
                NodeList childList = book.getChildNodes();
                for (int j = 0; j < childList.getLength(); j++) {
                    if (childList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print("---" + childList.item(j).getNodeName() + ":");
                        System.out.println(childList.item(j).getTextContent());
                    }

                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e1) {
            e1.printStackTrace();
        }
    }

}
