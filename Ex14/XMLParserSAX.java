import java.io.File;
import java.io.IOException;
import java.util.List;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import java.util.Scanner;

public class XMLParserSAX {

	public static String rollno ;    	
    public static void main(String[] args) {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	Scanner scanner = new Scanner(System.in);
	rollno = scanner.next();  
	System.out.println("\nroll no : "+rollno);  
try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler(rollno);
        saxParser.parse(new File("employees.xml"), handler);
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    }

}

class MyHandler extends DefaultHandler
{
	boolean bAge = false;
	boolean bName = false;
	String roll;
	public MyHandler(String rollno){
		this.roll = rollno;
	}
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(attributes.getValue("id").equals(roll)){
			if (qName.equalsIgnoreCase("name")) {
				bName = true;
			} else if (qName.equalsIgnoreCase("age")) {
				bAge = true;
			}	
		}
}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bAge) {
			// age element, set Employee age
			bAge = false;
		} else if (bName) {
			bName = false;
		} 
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		//data.append(new String(ch, start, length));
		if(bName){
			System.out.println("Name : " + new String(ch, start, length));
		} else if (bAge){
			System.out.println("Age : " + new String(ch, start, length));
		}	
	}
}
