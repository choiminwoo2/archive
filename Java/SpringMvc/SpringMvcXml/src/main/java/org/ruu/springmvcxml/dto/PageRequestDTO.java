package org.ruu.springmvcxml.dto;


import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    private int skip ;

    private String link;

    private String[] types;

    private String keyword;

    private boolean finished;

    private LocalDate from;

    private LocalDate to;

    public int getSkip(){
        return (page - 1) * 10;
    }

    public String getLink(){
        if(link == null){
            StringBuilder sb = new StringBuilder();
            sb.append("page=" + this.page);
            sb.append("&size=" + this.size);
            link = sb.toString();
        }
        return link;
    }

}
