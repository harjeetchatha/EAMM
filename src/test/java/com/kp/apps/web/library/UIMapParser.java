package com.kp.apps.web.library;

import java.io.File;
import java.net.URISyntaxException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * @author HariKrishna Pesala
 */

public class UIMapParser {

  final private String objectXml = "TestData/UIobj.xml";

  /*********************************************************************************************
   * public static Document getXMLPage Returns a DOM corresponding to File passed
   * 
   * @param fileToParse
   * @return
   * @throws Exception
   *********************************************************************************************/

  public Document getXMLPage(String fileToParse) throws Exception {
    File file = null;
    try {
      file = new File(this.getClass().getClassLoader().getResource(fileToParse).toURI());
    } catch (URISyntaxException e) {
      // TODO: error
    }
    Document document = null;
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    document = builder.parse(file);
    return document;
  }

  /*********************************************************************************************
   * getTarget(String pageName ,String uiElementName) returns translated 'target' element set by
   * objectXml and element uiobject
   * 
   * @param pageName
   * @param uiElementName
   * @return
   * @throws Exception
   **********************************************************************************************/
  public String getXpath(String uiElementName, String pageName) throws Exception {
    Document dom = getXMLPage(objectXml);
    Element racine = dom.getDocumentElement();

    NodeList pages = racine.getElementsByTagName("page");
    // System.out.println(pages.getLength());
    for (int i = 0; i < pages.getLength(); i++) {
      Element e = (Element) pages.item(i);
      String pageValue = e.getAttribute("name");
      // System.out.println("\nPage = " + pageValue);
      if (pageValue.equalsIgnoreCase(pageName)) {
        // System.out.println("\ninsidethis");
        NodeList uiElements = e.getElementsByTagName("uiobject");
        for (int j = 0; j < uiElements.getLength(); j++) {

          Element ui_e = (Element) uiElements.item(j);

          String UIObjectValue = ui_e.getAttribute("name");
          // System.out.println("\n UI ObjectName = " +
          // UIObjectValue);
          Node targetNode = ui_e.getElementsByTagName("locator").item(0);
          String targetValue = targetNode.getTextContent();
          // System.out.println("target value = " + targetValue);

          if (uiElementName.compareTo(UIObjectValue) == 0) {
            return targetValue.trim();
          }
        }
      }
    }
    return null;
  }

  public String getXpath(String uiElementName) throws Exception {

    Document dom = getXMLPage(objectXml);
    Element racine = dom.getDocumentElement();

    NodeList pages = racine.getElementsByTagName(uiElementName);
    // System.out.println(pages.getLength());
    for (int i = 0; i < pages.getLength(); i++) {
      Element e = (Element) pages.item(i);
      // String pageValue = e.getAttribute("name");

      // System.out.println("\nPage = " + pageValue);
      // if(pageValue.equalsIgnoreCase(pageName))
      {
        // System.out.println("\n insidethis");
        NodeList uiElements = e.getElementsByTagName("uiobject");
        for (int j = 0; j < uiElements.getLength(); j++) {

          Element ui_e = (Element) uiElements.item(j);

          String UIObjectValue = ui_e.getAttribute("name");
          // System.out.println("\n UI ObjectName = " +
          // UIObjectValue);
          Node targetNode = ui_e.getElementsByTagName("locator").item(0);
          String targetValue = targetNode.getTextContent();
          // System.out.println("target value = " + targetValue);

          if (uiElementName.compareTo(UIObjectValue) == 0) {
            return targetValue.trim();
          }
        }
      }
    }
    return null;
  }

}
