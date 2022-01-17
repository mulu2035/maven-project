package com.java.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class SampleForDomParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        DocumentBuilder biulder =factory.newDocumentBuilder();
         Document doc=biulder.parse(ClassLoader.getSystemResourceAsStream("sample1.xml"));
        NodeList numberList = doc.getElementsByTagName("person");
        for (int i=0;i<numberList.getLength();i++){

            Node p = numberList.item(i);
            if (p.getNodeType()==Node.ELEMENT_NODE){
                Element person =(Element)p;
                String id =person.getAttribute("id");
                NodeList nameList = person.getChildNodes();
                for (int j=0;j<nameList.getLength();j++){
                    Node n= nameList.item(j);
                    if (n.getNodeType()==Node.ELEMENT_NODE){
                        Element name = (Element) n;
                        //NodeList addressList = doc.getElementsByTagName("address");

                        System.out.println(id  +" " + name.getTagName() + name.getTextContent());

                    }

                }


            }
        }




    }
}
