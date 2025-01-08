package org.ruu.bootthymeleafjpa.dto.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UploadResultDTO {

    private String uuid;

    private String fileName;

    private boolean img;

    public String getLink(){
        if(img){
            return "s_" + uuid +"_" + fileName;
        }else{
            return uuid +"_" + fileName;
        }
    }
}
