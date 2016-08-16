package com.ihelin.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("demo/books.xml");
			NodeList bookList = doc.getElementsByTagName("book");
			System.out.println(bookList.getLength());
			for (int i=0;i<bookList.getLength();i++) {
				Element book = (Element) bookList.item(i);
				String attr = book.getAttribute("id");
				System.out.println("-第"+attr+"本书");
				NodeList childList = book.getChildNodes();
				for(int k=0;k<childList.getLength();k++){
					if(childList.item(k).getNodeType()==Node.ELEMENT_NODE){
						System.out.print("---"+childList.item(k).getNodeName()+":");
						//System.out.println(childList.item(k).getFirstChild().getNodeValue());
						System.out.println(childList.item(k).getTextContent());
					}
						
				}
				
				/*NamedNodeMap attrs = book.getAttributes();
				for(int j=0;j<attrs.getLength();j++){
					Node attr = attrs.item(j);
					System.out.print("属性名"+attr.getNodeName()+";");
					System.out.println("属性值"+attr.getNodeValue());
				}*/
			}
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
