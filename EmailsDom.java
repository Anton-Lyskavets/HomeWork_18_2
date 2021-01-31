package JavaPVT.HW_18_2;

import org.xml.sax.SAXException;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
С помощью DOM считать список email-ов из файла emails.xml,
создать список соответствующих объектов Java и вывести его на консоль.
 */
public class EmailsDom {
    private int id;
    private String to, from, heading, body;

    public EmailsDom(int id, String to, String from, String heading, String body) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.heading = heading;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", heading='" + heading + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File("emails.xml"));
        List<EmailsDom> emails = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("email");
//        String titleEl = doc.getDocumentElement().getNodeName();
//        System.out.println("titleEl = " + titleEl);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            emails.add(new EmailsDom
                    (Integer.parseInt(element.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue()),
                            element.getElementsByTagName("to").item(0).getChildNodes().item(0).getNodeValue(),
                            element.getElementsByTagName("from").item(0).getChildNodes().item(0).getNodeValue(),
                            element.getElementsByTagName("heading").item(0).getChildNodes().item(0).getNodeValue(),
                            element.getElementsByTagName("body").item(0).getChildNodes().item(0).getNodeValue()));
        }
        System.out.println(emails);
    }
}
