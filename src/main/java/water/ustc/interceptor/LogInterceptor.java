package water.ustc.interceptor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import sc.ustc.bean.ActionBean;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class LogInterceptor extends HttpServlet {

    public  void preAction(HttpServletRequest request, HttpServletResponse response, ActionBean actionBean) throws ServletException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(false);

        try {
            System.out.println("Log_path开始获取");
            String path = request.getSession().getServletContext().getRealPath("WEB-INF/classes/Log.xml");
            System.out.println("Log_path:"+path);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmldoc = db.parse(path);

            Element Log = xmldoc.getDocumentElement();

            Element action = xmldoc.createElement("action");
            Log.appendChild(action);

            Element name = xmldoc.createElement("name");
            name.setTextContent(actionBean.getActionName());
            action.appendChild(name);

            Element stime = xmldoc.createElement("s-time");
            stime.setTextContent(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,   Locale.CHINESE).format(new java.util.Date()));
            action.appendChild(stime);

            //保存
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer former = factory.newTransformer();
           // former.setOutputProperty(OutputKeys.INDENT, "yes");
            former.transform(new DOMSource(xmldoc), new StreamResult(new File(path)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void afterAction(HttpServletRequest request, HttpServletResponse response, ActionBean actionBean,String result) throws ServletException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringElementContentWhitespace(false);

        try {
            System.out.println("Log_path开始获取");
            String path = request.getSession().getServletContext().getRealPath("WEB-INF/classes/Log.xml");
            System.out.println("Log_path:"+path);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document xmldoc = db.parse(path);

            Element Log = xmldoc.getDocumentElement();

            NodeList list = Log.getElementsByTagName("action");
            Element action = (Element)list.item(list.getLength()-1);

            Element etime = xmldoc.createElement("e-time");
            etime.setTextContent(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,   Locale.CHINESE).format(new java.util.Date()));
            action.appendChild(etime);

            Element resulte = xmldoc.createElement("result");
            resulte.setTextContent(result);
            action.appendChild(resulte);

            //保存
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer former = factory.newTransformer();
            //former.setOutputProperty(OutputKeys.INDENT, "yes");
            former.transform(new DOMSource(xmldoc), new StreamResult(new File(path)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
