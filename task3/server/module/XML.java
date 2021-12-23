package by.epam.tasks.task3.server.module;

import by.epam.tasks.task3.server.Student;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XML {
    
    public static Student ReadXml(String xmlFile) {
        
        String[] val = new String[6];
        Student student = new Student();
        
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            File file = new File(xmlFile);
            
            if (file.exists()) {

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                DocumentBuilder builder = factory.newDocumentBuilder();
                org.w3c.dom.Document doc = builder.parse(xmlFile);

                NodeList list = doc.getElementsByTagName("*");
                
                for (int i = 0; i < list.getLength(); i++) {
                    Node nt = list.item(i);
                    if (nt.getFirstChild() != null) {
                        val[i] = nt.getFirstChild().getNodeValue();
                    }
                }
                
                student = new Student(val[2], Integer.parseInt(val[3]), val[4], Integer.parseInt(val[5]));
                
            } 
            else {
                    System.out.print("File not found!");
            }
        }
        catch (Exception e) {
            System.exit(1);
        }
        
        return student;
        
    }
    
    public static void WriteXml(Student student) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElementNS("https://javadevblog.com/language", "Languages");
            doc.appendChild(rootElement);
            rootElement.appendChild(getLanguage(doc, student.getName(), "" + student.getAge(), student.getAdress(), "" + student.getGroupNumber()));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult file = new StreamResult(new File("archive/" + student.getId() + ".xml"));
            transformer.transform(source, file);
        } catch (Exception e) {
            System.exit(1);
        }        
    }
    
    private static Node getLanguage(Document doc, String name, String age, String adress, String groupNumber) {
        Element language = doc.createElement("Student");
        language.appendChild(getLanguageElements(doc, language, "name", name));
        language.appendChild(getLanguageElements(doc, language, "age", age));
        language.appendChild(getLanguageElements(doc, language, "adress", adress));
        language.appendChild(getLanguageElements(doc, language, "groupNumber", groupNumber));
        return language;
    }
    
    private static Node getLanguageElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    
}