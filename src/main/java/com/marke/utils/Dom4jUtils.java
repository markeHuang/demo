package com.marke.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * DOM4J解析
 *
 * @author marke.huang
 * @date 2018/10/9 0009 下午 2:20
 */
public class Dom4jUtils {

    /**
     * DOM4J解析
     *
     * @param inputStream
     * @return java.util.Map<java.lang.String , java.lang.String>
     * @author marke.huang
     * @date 2018/10/9 0009 下午 2:21
     */
    public static Map<String, String> parseInput(InputStream inputStream) {

        Map<String, String> map = new LinkedHashMap<String, String>();
        try {
            // 创建SAX解析构造器对象
            final SAXReader reader = new SAXReader();
            // 通过读取流的对象，获取文档对象
            final Document document = reader.read(inputStream);
            // 获取跟节点:<xml> 这个是就更节点
            final Element root = document.getRootElement();
            // 获取跟节点下的子节点
            final List<Element> elements = root.elements();
            // 遍历解析
            for (Element element : elements) {
                // 节点名称和节点的值
                map.put(element.getName(), element.getText());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * DOM4J解析request
     *
     * @param request
     * @return java.util.Map<java.lang.String , java.lang.String>
     * @author marke.huang
     * @date 2018/10/9 0009 下午 2:30
     */
    public static Map<String, String> parseRequst(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        // 根据请求request对象获取流对象
        try {
            final InputStream inputStream = request.getInputStream();
            map = parseInput(inputStream);

            // 关闭流
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * DOM4J解析XML
     *
     * @param xmlPath
     * @return java.util.Map<java.lang.String , java.lang.String>
     * @author marke.huang
     * @date 2018/10/9 0009 下午 2:33
     */
    public static Map<String, String> parseXml(String xmlPath) {
        Map<String, String> map = new LinkedHashMap<>();
        // 根据请求request对象获取流对象
        try {
            final InputStream inputStream = new FileInputStream(xmlPath);
            map = parseInput(inputStream);

            // 关闭流
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
