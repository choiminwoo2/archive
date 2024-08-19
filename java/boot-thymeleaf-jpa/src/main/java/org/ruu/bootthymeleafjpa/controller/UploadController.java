package org.ruu.bootthymeleafjpa.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.ruu.bootthymeleafjpa.annotation.FilesParameter;
import org.ruu.bootthymeleafjpa.dto.file.UploadFileDTO;
import org.ruu.bootthymeleafjpa.dto.file.UploadResultDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UploadController {

    @Value("${org.ruu.bootthymeleafjpa.upload.path}")
    private String uploadPath;

    @Operation(summary = "파일 등록", description = "멀티파트로 전송")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<UploadResultDTO>> upload(@Valid @FilesParameter UploadFileDTO uploadFileDTO) {

        log.info(uploadFileDTO);

        if (uploadFileDTO.getFiles() != null) {

            final List<UploadResultDTO> list = new ArrayList<>();

            uploadFileDTO.getFiles().forEach(multipartFile -> {

                String originName = multipartFile.getOriginalFilename();
                log.info(originName);
                String uuid = UUID.randomUUID().toString();
                Path savePath = Paths.get(uploadPath, uuid + "_" + originName);

                boolean image = false;

                try {
                    multipartFile.transferTo(savePath);
                    if (Files.probeContentType(savePath).startsWith("image")) {

                        image = true;

                        File thumbFile = new File(uploadPath, "s_" + uuid + "_" + originName);

                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200, 200);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.add(UploadResultDTO.builder()
                    .uuid(uuid)
                    .fileName(originName)
                    .img(image)
                    .build());

            });//end each
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.internalServerError().build();
    }

    @Operation(summary = "썸네일 확인", description = "GET방식으로 첨부 파일 조회")
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGet(@PathVariable String fileName){
        String url = uploadPath+ File.separator + fileName;
        Resource resource = new FileSystemResource(url);
        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try{
            headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(resource.getFile().toPath()));
        }catch (IOException e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);

    }

    @Operation(summary = "파일 삭제", description = "Delete방식으로 첨부파일 삭제")
    @DeleteMapping("/remove/{fileName}")
    public Map<String, Boolean> removeFile(@PathVariable String fileName){
        Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);

        String resourceName = resource.getFilename();

        Map<String, Boolean> resultMap = new HashMap<>();
        boolean removed = false;

        try{
            String contentType = Files.probeContentType(resource.getFile().toPath());
            removed = resource.getFile().delete();

            if(contentType.startsWith("image")){
                File thumbnailFile = new File(uploadPath + File.separator +"s_" + fileName);
                removed = thumbnailFile.delete();
            }
        }catch (IOException e){
            log.error(e.getMessage());
        }
        resultMap.put("result", removed);

        return resultMap;
    }
}
