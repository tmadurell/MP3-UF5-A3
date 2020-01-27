package com.company;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParserConfigurationException, SAXException {
        Scanner scanner = new Scanner(System.in);
        int opcio;
        boolean res = true;

        do{

            System.out.println("");
            System.out.println("---------------------------------------------------------");
            System.out.println("MP3-UF5-A3 Streams-Lambdes i analitzadors de dades:");
            System.out.println("1. Cerca Pel·lícules");
            System.out.println("2. Més categories...");
            System.out.println("3. Sortir");
            System.out.println("---------------------------------------------------------");
            System.out.print("Escriu aquí: ");


            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    Stream stream = new Stream();
                    List<Films> films = stream.read();
                    Menu menu = new Menu();
                    menu.show(films);
                    while (res){
                        menu.show(films);
                    }
                    break;
                case 2:
                    System.out.println("Proximanent, tingueu paciencia <3");
                    break;
                case 3:
                    System.out.println("Gràcies per utilitzar el nostre cercador. Adéu.");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Opció no valida");
                    System.out.println("Solament pots escriure números del 1-3");
                    break;
            }
        } while (opcio!=3);
    }

//Menu redirigit de pas 8
    public void menu() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
        Scanner scanner = new Scanner(System.in);
        int opcio;
        boolean res = true;
        do{

            System.out.println("");
            System.out.println("---------------------------------------------------------");
            System.out.println("MP3-UF5-A3 Streams-Lambdes i analitzadors de dades:");
            System.out.println("1.Cerca Pel·lícules");
            System.out.println("2.Més categories...");
            System.out.println("3.Sortir");
            System.out.println("---------------------------------------------------------");
            System.out.print("Escriu aquí: ");


            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    Stream stream = new Stream();
                    List<Films> films = stream.read();
                    Menu menu = new Menu();
                    menu.show(films);
                    while (res){
                    menu.show(films);
                    }
                    break;
                case 2:
                    System.out.println("Proximanent, tingueu paciencia <3");
                    break;
                case 3:
                    System.out.println("Gràcies per utilitzar el nostre cercador. Adéu.");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Opció no valida");
                    System.out.println("Solament pots escriure números del 1-3");
                    break;
            }
        } while (opcio!=3);
    }

}

