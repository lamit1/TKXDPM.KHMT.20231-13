package org.example.models;

import java.util.Date;

public class DVD extends Media {
    /**
     * Single responsibility:
     * Book have 1 responsiblity for book  is store data
     */
    private String id;
    private String discType;
    private String director;
    private String studio;
    private Date releasedDate;
    private String subtitle;
    private String runtime;

    public DVD(String name, double price, boolean rushDelivery, double weight, int availabel, String imageUrl, String category, String discType, String director, String studio, Date releasedDate, String subtitle, String runtime) {
        super(name, price, rushDelivery, weight, availabel, imageUrl, category);
        this.discType = discType;
        this.director = director;
        this.studio = studio;
        this.releasedDate = releasedDate;
        this.subtitle = subtitle;
        this.runtime = runtime;
    }
}
