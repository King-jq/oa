package com.jmsj.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlPaser {
	
	public static List<String> parserPackages(String path){
		List<String> paths = new ArrayList<String>(5);
		File file = new File(path);
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(file);
			Element root = doc.getRootElement();
			for(Iterator<?> i = root.elementIterator();i.hasNext();){
				Element e = (Element) i.next();
				paths.add(e.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		return paths;
	}
}
