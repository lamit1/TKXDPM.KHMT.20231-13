package org.example.models;

import java.util.Date;

public class CD extends Media {
    /**
     * Single responsibility:
     * CD have 1 responsiblity for book  is store data
     */
    private String id;
    private String artist;
    private Date releasedDate;
    private String recordLabel;
    private String musicType;

    public CD(String name, double price, boolean rushDelivery, double weight, int availabel, String imageUrl, String category, String id, String artist, Date releasedDate, String recordLabel, String musicType) {
        super(name, price, rushDelivery, weight, availabel, imageUrl, category);
        this.id = id;
        this.artist = artist;
        this.releasedDate = releasedDate;
        this.recordLabel = recordLabel;
        this.musicType = musicType;
    }
}
