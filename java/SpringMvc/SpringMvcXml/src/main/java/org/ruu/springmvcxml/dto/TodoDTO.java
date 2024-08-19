package org.ruu.springmvcxml.dto;


import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;
    @NotEmpty
    private String title;
    @Future
    private LocalDate dueDate;

    private boolean finished;
    @NotEmpty
    private String writer;
}
