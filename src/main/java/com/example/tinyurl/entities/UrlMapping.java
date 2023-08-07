package com.example.tinyurl.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortUrl;
    private String longUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public UrlMapping() {
    }

    public UrlMapping(Long id, String shortUrl, String longUrl) {
        this.id = id;
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
    }
// Constructors, getters, and setters
}

