package com.company;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.*;
import java.util.stream.*;

public class Menu {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

    }

    public void show(List<Films> films) throws InterruptedException, IOException, SAXException, ParserConfigurationException {
        Scanner opcions = new Scanner(System.in);
        System.out.println();
        System.out.println("--------------------------Cercador de pel·lícules---------------------------------------------");
        System.out.println("Escull una opció que vulguis cercar com: ");
        System.out.println("1. Per quin camp volem buscar, títol, director, any, etc...");
        System.out.println("2. Que doni la opció de saber quantes pel·lícules d’un determinat director hi apareixen.");
        System.out.println("3. Quants títols una determinada paraula hi apareix.");
        System.out.println("4. Quantes vegades un director i un intèrpret coincideixen");
        System.out.println("5. Pel·lícules on hi apareguin el intèrprets que selecciones");
        System.out.println("6. Cercar quants tipus diferents d’idiomes hi ha");
        System.out.println("7. Altres (etc.)");
        System.out.println("8. Torna enrere");
        System.out.println("9. Sortir");
        System.out.println("---------------------------------------------------------------------------------------------");

        System.out.print("Escriu el número que has decidit: ");

        int opcio = opcions.nextInt();
        opcions.nextLine();
        if (opcio != 0) {
            switch (opcio) {
                case 1:
                    System.out.println("\n1.¿Per quin camp vols buscar?");
                    System.out.println("1. Titol - 2. Director - 3.Interprets - 4. Any");
                    int cerca = opcions.nextInt();
                    opcions.nextLine();
                    System.out.print("Escriu aquí les dades relacionades amb al camp especific: ");
                    String text = opcions.nextLine();

                    System.out.println("\nAquestes són les pel·licules que coincideixen amb el seu criteri:");
                    films.stream()

                            .filter(filtra -> {
                                switch (cerca) {
                                    case 1:
                                        return filtra.getTitol().contains(text);
                                    case 2:
                                        return filtra.getDireccio().contains(text);
                                    case 3:
                                        return filtra.getInterprets().contains(text);
                                    case 4:
                                        return filtra.getAny().contains(text);
                                    default:
                                        System.out.println("Cap element existent coincideix amb el criteri de la seva la recerca.");}
                                return false;
                            })
                            .forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("\n2.Escriu el nom del Director: ");
                    String ndirector = opcions.nextLine();
                    long countD = films.stream()
                            .filter(filtra -> filtra.getDireccio().contains(ndirector)).count();
                    System.out.println("\nTotal de Pel·lícules que tenen el nom d'aquest Director: ");
                    System.out.println(countD);
                    break;

                case 3:
                    System.out.print("\n3.Escriu una paraula o el nom del títol de la pel·licula: ");

                    String titolp = opcions.nextLine();

                    long countT = films.stream()
                            .filter(filtra -> filtra.getTitol().contains(titolp)).count();
                    System.out.println("\nNº Total de Pel·lícules que coincideixen amb el nom o la paraula desitjada amb el títol de la Pel·licula: ");
                    System.out.println(countT);
                    break;

                case 4:
                    System.out.println("Escriu el nom del director: ");
                    String director = opcions.nextLine();

                    System.out.println("Escriu el nom del intèrpret: ");

                    String interpret = opcions.nextLine();
                    System.out.println("\nPel·lícules:");
                    films.stream()
                            .filter(filtra -> filtra.getDireccio().contains(director) && filtra.getInterprets().contains(interpret))
                            .forEach(System.out::println);

                    long contador = films.stream()
                            .filter(filtra -> filtra.getDireccio().contains(director) && filtra.getInterprets().contains(interpret)).count();
                    System.out.println("Nº Total de Pel·lícules que coincideixen Director i Interpret: " + contador);
                    break;

                case 5:
                    System.out.println("Escriu el nom del intèrprets (actors/actrius): ");
                    System.out.println("Elige interpretes");
                    String interprets = opcions.nextLine();
                    System.out.println("\nPel·lícules on el actor/actriu hi apareix:");
                    //Resultat menys adornat
//                    films.stream()
//                            .filter(f -> f.getInterprets().contains(interprets))
//                            .forEach(System.out::println);
                    List<Films> distinctElements = films.stream()
                            .filter( filtra -> filtra.getInterprets().contains(interprets))
                            .collect( Collectors.toList());
                    distinctElements.forEach((k)->System.out.println("Títol : " + k.getTitol()+ " Director : "+ k.getDireccio()+ " Interprets : "+ k.getInterprets()+ " Any : "+ k.getAny()));

                    break;

                case 6:
                    System.out.println("\nIdiomes que n'hi han disponible: ");
                    films.stream()
                            .distinct()
                            .forEach(f -> System.out.println(f.getIdioma()));

                    break;

                case 7:

                    System.out.println("\nEscull una opció que vulguis cercar com: ");
                    System.out.println("1. Ordenar pel·lícules per el id.");
                    System.out.println("2. Cerca pel·lícules per idiomes");
                    System.out.println("3. Torna enrere");
                    System.out.println("4. Sortir");
                    System.out.print("Escriu aquí: ");
                    int altres = opcions.nextInt();
                    opcions.nextLine();
                    switch(altres){
                        case 1:
                                    List<Films> sortedFilms = films.stream().sorted().collect(Collectors.toList());
                                    System.out.println("\nTotes les pel·lícules ordenades per el ID:");
                                    for (Films peliculatitol : sortedFilms){
                                        System.out.println(peliculatitol);
                                    }
                                    new Menu().show(films);
                                    break;
                        case 2:

                            System.out.println("\nEscull una opció que vulguis cercar com: ");
                            System.out.println("1. Cerca per un idioma concret.");
                            System.out.println("2. Cerca pel·lícules que tinguin 2 idiomes a més.");
                            System.out.println("3. Cerca pel·lícules que tinguin 3 idiomes a més.");
                            System.out.print("Escriu aquí: ");
                            int idioma = opcions.nextInt();
                            opcions.nextLine();
                            switch(idioma){
                                case 1:
                                    System.out.print("Escriu el idioma concret que et interessa: ");
                                    String peliculaidioma = opcions.nextLine();

                                    System.out.println("\nResultats de les pel·lícules amb aquest idioma específic:");
                                    films.stream()
                                            .filter(filtra -> filtra.getIdioma().contains(peliculaidioma))
                                            .forEach(System.out::println);
                                    new Menu().show(films);
                                    break;
                                case 2:
                                    System.out.println("\nResultats de les pel·lícules amb solament amb 2 idiomes:");
                                    films.stream()
                                            .filter(i -> {
                                                if (cercaI(i.getIdioma()) > 0) return true;
                                                return false;
                                            })
                                            .sorted().collect(Collectors.toList())
                                            .forEach(film -> System.out.println(film));
                                    new Menu().show(films);
                                    break;
                                case 3:
                                    System.out.println("\nResultats de les pel·lícules amb 3 idiomes o més:");
                                    films.stream()
                                            .filter(film -> {
                                                if (cercaComas(film.getIdioma()) > 0) return true;
                                                return false;
                                            })
                                            .sorted().collect(Collectors.toList())
                                            .forEach(film -> System.out.println(film));
                                    new Menu().show(films);
                                    break;


                                default:
                                    System.out.println("Opció incorrecta: Solament pots escriure números del 1-4");
                                    Thread.sleep(2000);
                                    new Menu().show(films);
                                    break;
                            }while (opcio!=3);

                           case 3:
                               Menu menu = new Menu();
                               menu.show(films);
                               break;

                           case 4:
                               System.out.println("Gràcies per utilitzar el nostre cercador. Adéu.");
                               System.exit(0);
                               return;

                        default:
                            System.out.println("Opció incorrecta: Solament pots escriure números del 1-4");
                            Thread.sleep(2000);
                            new Menu().show(films);
                            break;
                    }while (opcio!=4);

                case 8:
                    new Main().menu();
                    break;
                case 9:
                    System.out.println("Gràcies per utilitzar el nostre cercador. Adéu.");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Opció incorrecta: Solament pots escriure números del 1-9");
                    Thread.sleep(2000);
                    Menu menu = new Menu();
                    menu.show(films);
                    break;

            }
        }
    }

    public static int cercaI(String idioma){
        int count = 0;
        for(char i : idioma.toCharArray()){
            if (i == 'i') count++;
        }
        return count;
    }


    public static int cercaComas(String idioma){
        int count = 0;
        for(char c : idioma.toCharArray()){
            if (c == ',') count++;
        }
        return count;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

