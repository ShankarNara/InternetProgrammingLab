import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class demoParser{

   public static void main(String argv[]) throws ParserConfigurationException, SAXException, IOException {
 
      try {
         File inputFile = new File("input.txt");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
	 String rno;
	 Scanner in = new Scanner(System.in);
         System.out.println("Enter the student roll no:");
	 rno = in.next();
         System.out.print("Root element: ");
         System.out.println(doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("student");
         
         for (int temp = 0; temp < nList.getLength(); temp++) 
         {
            Node nNode = nList.item(temp);
            Element eElement=(Element) nNode;
         
            if(rno.equals(eElement.getAttribute("rollno")))
            {
            System.out.println("\nCurrent Element :");
            System.out.println(nNode.getNodeName());
             if(nNode.getNodeType() == Node.ELEMENT_NODE)
             {
               System.out.println("Name:"+eElement.getElementsByTagName("name").item(0).getTextContent());
               System.out.println("Address:"+eElement.getElementsByTagName("address").item(0).getTextContent());
               System.out.println("Mobile:"+eElement.getElementsByTagName("mobile").item(0).getTextContent());
             }
            }           
         }
        }
       catch (Exception e) {
         e.printStackTrace();
      }
   }   
}
