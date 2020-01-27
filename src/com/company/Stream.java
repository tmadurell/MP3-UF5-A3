package com.company;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class Stream {
    static final String pathURL = "http://gencat.cat/llengua/cinema/provacin.xml";


    public ArrayList<Films> read() throws IOException, ParserConfigurationException, SAXException {

        URL url = new URL(pathURL);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url.openStream());

        ArrayList<Films> list = new ArrayList<>();

        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("FILM");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    try {
                        Element eElement = (Element) nNode;

                        String idfilm = eElement.getElementsByTagName("IDFILM").item(0).getTextContent();

                        String prioritat = eElement.getElementsByTagName("PRIORITAT").item(0).getTextContent();

                        String titol = eElement.getElementsByTagName("TITOL").item(0).getTextContent();

                        String situacio = eElement.getElementsByTagName("SITUACIO").item(0).getTextContent();

                        String any = eElement.getElementsByTagName("ANY").item(0).getTextContent();

                        String cartell = eElement.getElementsByTagName("CARTELL").item(0).getTextContent();

                        String original = eElement.getElementsByTagName("ORIGINAL").item(0).getTextContent();

                        String direccio = eElement.getElementsByTagName("DIRECCIO").item(0).getTextContent();

                        String interprets = eElement.getElementsByTagName("INTERPRETS").item(0).getTextContent();

                        String sinopsi = eElement.getElementsByTagName("SINOPSI").item(0).getTextContent();

                        String versio = eElement.getElementsByTagName("VERSIO").item(0).getTextContent();

                        String idioma = eElement.getElementsByTagName("IDIOMA_x0020_ORIGINAL").item(0).getTextContent();

                        String qualificacio = eElement.getElementsByTagName("QUALIFICACIO").item(0).getTextContent();

                        String trailer = eElement.getElementsByTagName("TRAILER").item(0).getTextContent();

                        String web = eElement.getElementsByTagName("WEB").item(0).getTextContent();

                        String estrena = eElement.getElementsByTagName("ESTRENA").item(0).getTextContent();


                        Films film = new Films(idfilm, prioritat, titol, situacio, any, cartell, original, direccio, interprets, sinopsi, versio, idioma, qualificacio, trailer, web, estrena);

                        list.add(film);

                    } catch (Exception e) {

                    }
                }
            }
            return list;
        }

    }
