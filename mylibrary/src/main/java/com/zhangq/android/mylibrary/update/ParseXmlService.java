package com.zhangq.android.mylibrary.update;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ParseXmlService {
	public HashMap<String, String> parseXml(InputStream inStream)
			throws Exception {
		HashMap<String, String> hashMap = new HashMap<String, String>();

		// ?????????????????????
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// ???????????????????????????????
		DocumentBuilder builder = factory.newDocumentBuilder();
		// ???????????????????????????????
		Document document = builder.parse(inStream);
		// ???XML????????
		Element root = document.getDocumentElement();
		// ???????????
		NodeList childNodes = root.getChildNodes();
		for (int j = 0; j < childNodes.getLength(); j++) {
			// ????????
			Node childNode = (Node) childNodes.item(j);
			if (childNode.getNodeType() == Node.ELEMENT_NODE) {
				Element childElement = (Element) childNode;
				// ????
				if ("version".equals(childElement.getNodeName())) {
					hashMap.put("version", childElement.getFirstChild()
							.getNodeValue());
				}
				// ???????
				else if (("name".equals(childElement.getNodeName()))) {
					hashMap.put("name", childElement.getFirstChild()
							.getNodeValue());
				}
				// ??????
				else if (("url".equals(childElement.getNodeName()))) {
					hashMap.put("url", childElement.getFirstChild()
							.getNodeValue());
				}
				// ???
				else if (("info".equals(childElement.getNodeName()))) {
					hashMap.put("info", childElement.getFirstChild()
							.getNodeValue());
				}
			}
		}
		return hashMap;
	}
	// /*
	// * ??pull?????????????????????xml??? (xml????????)
	// */
	// public UpdataInfo getUpdataInfo(InputStream is) throws Exception {
	// XmlPullParser parser = Xml.newPullParser();
	// parser.setInput(is, "utf-8");// ??????????????
	// int type = parser.getEventType();
	// UpdataInfo info = new UpdataInfo();// ???
	// while (type != XmlPullParser.END_DOCUMENT) {
	// switch (type) {
	// case XmlPullParser.START_TAG:
	// if ("version".equals(parser.getName())) {
	// info.setVersion(parser.nextText()); // ???????
	// } else if ("url".equals(parser.getName())) {
	// info.setUrl(parser.nextText()); // ??????????APK???
	// } else if ("name".equals(parser.getName())) {
	// info.setName(parser.nextText()); // ?????????????
	// }
	// break;
	// }
	// type = parser.next();
	// }
	// return info;
	// }
}
