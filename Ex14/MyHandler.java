import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Scanner;

public class MyHandler extends DefaultHandler
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
