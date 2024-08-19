package org.ruu.bootthymeleafjpa.dto.file;

import jakarta.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileDTO {

    @NotNull
    private List<MultipartFile> files;


//    @Builder(builderMethodName = "withFiles")
//    public UploadFileDTO(MultipartFile[] files){
//        this.files = multipartToFiles(files);
//    }
//
//    private List<MultipartFile> multipartToFiles(MultipartFile[] multipartFiles){
//        return Arrays.stream(multipartFiles).toList();
//    }


}
