package com.sadatmalik.educativeio.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author sm@creativefusion.net
 */
public class XmlTree {
    public static NodeXml createXmlTree(String xml) {

        //		XmlTokenizer tok = new XmlTokenizer(xml);
        XmlTokenizer tok = new XmlTokenizer(xml);

        //		XmlElement element = new XmlElement();
        XmlElement element = new XmlElement();

        //		if (!tok.getNextElement(element)) {

//			return null;
//		}
        if (!tok.getNextElement(element)) {
            return null;
        }

        //		List<NodeXml> st = new ArrayList<NodeXml>();
//
//		// set up the tree root
//		NodeXml root = new NodeXml(element.nodeName);
//
//		// push it on to the stack
//		st.add(root);

        // init stack
        List<NodeXml> xmlStack = new ArrayList<>();

        // tree root
        NodeXml root = new NodeXml(element.nodeName);
        xmlStack.add(root);

        //		while (tok.getNextElement(element)) {
//			NodeXml n = null;
        while (tok.getNextElement(element)) {
            NodeXml child = null;

            //			if (element.elementType == XmlElement.xmlElementType.get("ELEMENT_OPENING_TAG")
//					|| element.elementType == XmlElement.xmlElementType.get("ELEMENT_TEXT")) {
//				// set up a node for the tree and...
//				n = new NodeXml(element.nodeName);
//				// add it to the list of children of the node last pushed on the stack
//				st.get(st.size() - 1).children.add(n);
//			}
            // if it's an open tag or text add as a child of current top of stack
            if (element.elementType == XmlElement.xmlElementType.get("ELEMENT_OPENING_TAG") ||
                    element.elementType == XmlElement.xmlElementType.get("ELEMENT_TEXT")) {
                child = new NodeXml(element.nodeName);
                xmlStack.get(xmlStack.size()-1).children.add(child);
            }
            // if it's an open tag add to stack
            //			if (element.elementType == XmlElement.xmlElementType.get("ELEMENT_OPENING_TAG")) {
//				st.add(n);
            if (element.elementType == XmlElement.xmlElementType.get("ELEMENT_OPENING_TAG")) {
                xmlStack.add(child);
            }
            // if it's a close tag remove from stack
//			} else if (element.elementType == XmlElement.xmlElementType
//					.get("ELEMENT_CLOSING_TAG")) {
//				st.remove(st.size() - 1);
//			}
            else if (element.elementType == XmlElement.xmlElementType.get("ELEMENT_CLOSING_TAG")) {
                xmlStack.remove(xmlStack.size()-1);
            }
        }
//		}
//		return root;
        return root;
    }

}

class NodeXml {
    public String nodeName;
    public List<NodeXml> children;

    public NodeXml(String data) {
        this.nodeName = data;
        children = new ArrayList<NodeXml>();

    }
}

class XmlTokenizer {
    String xml;
    int currentIndex;

    XmlTokenizer(String xmlStr) {
        xml = xmlStr;
        currentIndex = 0;
    }

    Boolean getNextElement(XmlElement element) {
        int i = this.xml.substring(currentIndex).indexOf('<');
        if (i == -1) {
            return false;
        }
        i += currentIndex;

        String temp = this.xml.substring(currentIndex, i);
        temp = temp.trim();

        if (!temp.isEmpty()) {
            element.nodeName = temp;
            element.elementType = XmlElement.xmlElementType.get("ELEMENT_TEXT");
            currentIndex = i;
            return true;
        }

        int j = this.xml.substring(i).indexOf('>');
        if (j == -1) {
            return false;
        }

        j += i;
        if (this.xml.charAt(i + 1) == '/') {
            element.nodeName = this.xml.substring(i + 2, j);
            element.elementType = XmlElement.xmlElementType.get("ELEMENT_CLOSING_TAG");
        } else {
            element.nodeName = this.xml.substring(i + 1, j);
            element.elementType = XmlElement.xmlElementType.get("ELEMENT_OPENING_TAG");
        }

        this.currentIndex = j + 1;
        return true;
    }
}

class XmlElement {
    int elementType;
    String nodeName;
    public static HashMap<String, Integer> xmlElementType = new HashMap<String, Integer>() {
        {
            put("ELEMENT_UNKNOWN", 1);
            put("ELEMENT_OPENING_TAG", 2);
            put("ELEMENT_CLOSING_TAG", 3);
            put("ELEMENT_TEXT", 4);
        }
    };

    XmlElement() {
        elementType = xmlElementType.get("ELEMENT_UNKNOWN");
        nodeName = "";
    }
}