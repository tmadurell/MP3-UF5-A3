package com.company;

import java.util.Objects;

public class Films implements Comparable<Films> {

    String idfilm,prioritat,titol,situacio, any, cartell,original, direccio, interprets, sinopsi, versio,idioma,qualificacio,trailer,web,estrena;

    @Override
    public String toString() {
        return "Pelicula: {" +
                "idfilm: '" + idfilm + '\'' +
                ", Titol: '" + titol + '\'' +
                ", Títol Original: '" + original + '\'' +
                ", Direccio: '" + direccio + '\'' +
                ", Interprets: '" + interprets + '\'' +
                ", Idioma: '" + idioma + '\'' +
                ", Any: '" + any + '\'' +
                ", Qualificacio: '" + qualificacio + '\'' +
                ", Sinopsi: '" + sinopsi + '\'' +
                '}';
    }

    public Films(String idfilm, String prioritat, String titol, String situacio, String any, String cartell, String original, String direccio, String interprets, String sinopsi, String versio, String idioma, String qualificacio, String trailer, String web, String estrena) {
        this.idfilm = idfilm;
        this.prioritat = prioritat;
        this.titol = titol;
        this.situacio = situacio;
        this.any = any;
        this.cartell = cartell;
        this.original = original;
        this.direccio = direccio;
        this.interprets = interprets;
        this.sinopsi = sinopsi;
        this.versio = versio;
        this.idioma = idioma;
        this.qualificacio = qualificacio;
        this.trailer = trailer;
        this.web = web;
        this.estrena = estrena;
    }

    public String getIdfilm() {
        return idfilm;
    }
    public String getPrioritat() {
        return prioritat;
    }
    public String getTitol() {
        return titol;
    }
    public String getSituacio() {
        return situacio;
    }
    public String getAny() {return any;}
    public String getCartell() {
        return cartell;
    }
    public String getOriginal() {
        return original;
    }
    public String getDireccio() {return direccio;}
    public String getInterprets() {return interprets;}
    public String getSinopsi() {
        return sinopsi;
    }
    public String getVersio() {
        return versio;
    }
    public String getIdioma() {
        return idioma;
    }
    public String getQualificacio() {
        return qualificacio;
    }
    public String getTrailer() {
        return trailer;
    }
    public String getWeb() {
        return web;
    }
    public String getEstrena() {
        return estrena;
    }


    @Override
    public int compareTo(Films films) {return this.idfilm.compareTo(films.idfilm);}

    //@Override
    //public int compareTo(Films films) {return this.any.compareTo(films.any);}

    //@Override
    //public int compareTo(Films films) {return this.titol.compareTo(films.titol);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Films films = (Films) o;
        return idioma.equals(films.idioma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idioma);
    }


}