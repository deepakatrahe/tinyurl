package com.example.tinyurl.service;

import com.example.tinyurl.entities.UrlMapping;
import com.example.tinyurl.repo.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlMappingService {

    private static final String BASE_URL = "http://dee.com/";
    private static final int SHORT_URL_LENGTH = 6;
    @Autowired
    private UrlMappingRepository urlMappingRepository;

    public String shortenUrl(String longUrl) {
        UrlMapping urlMapping = urlMappingRepository.findByLongUrl(longUrl);
        if (urlMapping != null) {
            return BASE_URL + urlMapping.getShortUrl();
        } else {
            String shortUrl = generateShortUrl();
            urlMapping = new UrlMapping();
            urlMapping.setShortUrl(shortUrl);
            urlMapping.setLongUrl(longUrl);
            urlMappingRepository.save(urlMapping);
            return BASE_URL + shortUrl;
        }
    }

    private String generateShortUrl() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(characters.length());
            shortUrl.append(characters.charAt(index));
        }
        return shortUrl.toString();
    }

    public String getLongUrl(String shortUrl) {
        UrlMapping urlMapping = urlMappingRepository.findByShortUrl(shortUrl);
        if (urlMapping != null) {
            return urlMapping.getLongUrl();
        } else {
            return null;
        }
    }
}
