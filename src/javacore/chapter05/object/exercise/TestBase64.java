package javacore.chapter05.object.exercise;

import java.io.UnsupportedEncodingException;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.util.Base64;

@SuppressWarnings({ "deprecation", "restriction" })
public class TestBase64 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String testContent = "Du texte à encoder pour être envoyé.";

        String encodedContent = Base64.getEncoder().encodeToString(testContent.getBytes("UTF-8"));

        System.out.println("Contenu encodé : " + encodedContent);

    }

}

