package com.ute.shop.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class NewsDTO extends AbstracDTO<NewsDTO> {
    private String title;  
    private String shortDescription;  
    private String content;
    private String thumbnail;  
    private String categoryCode;  
}
