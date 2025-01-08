package todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruu.springmvcxml.domain.TodoEntity;
import org.ruu.springmvcxml.dto.PageRequestDTO;
import org.ruu.springmvcxml.dto.PageResponseDTO;
import org.ruu.springmvcxml.dto.TodoDTO;
import org.ruu.springmvcxml.mapper.TodoMapper;
import org.ruu.springmvcxml.service.TodoService;
import org.ruu.springmvcxml.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
@Log4j2
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
@ExtendWith(SpringExtension.class)
public class TodoServiceTest {

    @Autowired
    TodoService todoService;

    @Test
    void insert(){
        TodoDTO todoDTO = TodoDTO.builder()
            .title("test")
            .dueDate(LocalDate.of(2011,10,12))
            .writer("min")
            .build();

        todoService.register(todoDTO);
    }

    @Test
    void selectAll(){

        List<TodoDTO> list = todoService.getAll();

        assertNotNull(list);
    }

    @Test
    void selectOne(){
        TodoDTO dto = todoService.getTodoByTno(1L);
        assertNotNull(dto);
        assertEquals(dto.getTno(), 1L);
    }

    @Test
    void pagingTest(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page(1)
            .size(10)
            .build();
        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);

        log.info(responseDTO);

        responseDTO.getDtoList().forEach(todoDTO -> log.info(todoDTO));

    }

}
