package dev.akanksha.surlizer.services;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UrlService {
    private final Map<String, String> map;
    private final Map<String, String> reverseMap;

    public UrlService() {
        this.map = new ConcurrentHashMap<>();
        this.reverseMap = new ConcurrentHashMap<>();
    }


    public Optional<String> retreiveUrl(String shortUrl) {
        return Optional.ofNullable(map.get(shortUrl));
    }

    public String createShortUrl(String url) {
        if(reverseMap.containsKey(url)) return reverseMap.get(url);
        String shortUrl = "surlized" + (map.size() + 1);
        map.put(shortUrl, url);
        reverseMap.put(url, shortUrl);
        return shortUrl;
    }
}
