/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月26日 上午11:18:28
 */
public class XMLUtil {

    private static Logger logger = LoggerFactory.getLogger(XMLUtil.class);

    public static String getXmlBody(Map<String, String> map) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("xml");
            document.appendChild(root);
            for (Map.Entry<String, String> entry : map.entrySet()) {

                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                value = value.trim();
                Element filed = document.createElement(entry.getKey());
                filed.appendChild(document.createTextNode(value));
                root.appendChild(filed);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            String output = writer.getBuffer().toString(); // .replaceAll("\n|\r", "");

            writer.close();

            return output;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }

    }

    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     *
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map<String, String> doXMLParse(String strxml) {
        try {
            Map<String, String> data = new HashMap<String, String>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            stream.close();
            return data;
        } catch (Exception e) {
            logger.error(e.toString());
            return null;
        }

    }

    /**
     * @param strxml
     * @return
     * @Description 处理国都短信返回结果
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static Map<String, String> doGuoduXMLParse(String strxml) {
        try {
            Map<String, String> data = new HashMap<String, String>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nodeName = element.getNodeName();
                    if (nodeName.equals("message")) {
                        String desmobile = "";
                        NodeList nodeListMessage = element.getChildNodes();
                        for (int idxMessage = 0; idxMessage < nodeListMessage.getLength(); ++idxMessage) {

                            Node nodeMessage = nodeListMessage.item(idxMessage);
                            if (nodeMessage.getNodeType() == Node.ELEMENT_NODE) {
                                Element elementMessage = (Element) nodeMessage;
                                String key = elementMessage.getNodeName();

                                if (key.equals("desmobile")) {
                                    desmobile = elementMessage.getTextContent();
                                }
                                data.put(key + desmobile, elementMessage.getTextContent());
                            }
                        }
                    } else {
                        data.put(element.getNodeName(), element.getTextContent());
                    }

                }
            }
            stream.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return null;
        }
    }

    // public static void main(String[] args) {
    // String str = "<?xml version=\"1.0\" encoding=\"gbk\"?>\r\n" +
    // "<response>\r\n" + "<code>00</code>\r\n"
    // + "<message>\r\n" + " <desmobile>13900000000</desmobile>\r\n"
    // + " <msgid>200811041234253654785</msgid>\r\n" + "</message>\r\n" +
    // "<message>\r\n"
    // + " <desmobile>13400000000</desmobile>\r\n" +
    // "<msgid>200811041234253654786</msgid>\r\n"
    // + "</message>\r\n" + "<message>\r\n" +
    // "<desmobile>13500000000</desmobile>\r\n"
    // + " <msgid>200811041234253654787</msgid>\r\n" + "</message>\r\n" +
    // "<message>\r\n"
    // + " <desmobile>13600000000</desmobile>\r\n" +
    // "<msgid>200811041234253654788</msgid>\r\n"
    // + "</message>\r\n" + "</response>\r\n" + "";
    //
    // XMLUtil.doGuoduXMLParse(str);
    // }
}
