package org.ruu.bootthymeleafjpa.annotation;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.http.MediaType;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Parameter(
    description = "file List",
    content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
)
public @interface FilesParameter {

}
