package dev.akanksha.surlizer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "url_map")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UrlMap {
    @Id
    private String url;
    private String shortUrl;
}
