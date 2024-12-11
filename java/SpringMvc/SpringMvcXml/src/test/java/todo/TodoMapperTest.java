package todo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruu.springmvcxml.domain.TodoEntity;
import org.ruu.springmvcxml.dto.PageRequestDTO;
import org.ruu.springmvcxml.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
@ExtendWith(SpringExtension.class)
public class TodoMapperTest {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {

        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() {

        TodoEntity todoEntity = TodoEntity.builder()
            .title("스프링테스트")
            .dueDate(LocalDate.of(2022, 10, 10))
            .writer("user00")
            .build();

        todoMapper.insert(todoEntity);
    }

    @Test
    public void getSelectAll() {

        List<TodoEntity> todoEntityList = todoMapper.selectAll();

        assertNotNull(todoEntityList);
    }

    @Test
    public void getSelectOne() {

        TodoEntity todoEntity = todoMapper.selectOne(1L);

        assertNotNull(todoEntity);
    }

    @Test
    public void getSelectListByPagination() {

        PageRequestDTO requestDTO = PageRequestDTO.builder()
            .page(1)
            .size(10)
            .build();

        List<TodoEntity> todoEntityList = todoMapper.selectList(requestDTO);

        todoEntityList.forEach(todoEntity -> log.info(todoEntity));


    }

    @Test
    public void getCount() {

        PageRequestDTO requestDTO = PageRequestDTO.builder()
            .page(1)
            .size(10)
            .build();
        int count = todoMapper.getCount(requestDTO);
        log.info(count);
    }

    @Test
    void selectSearchByType() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .page(1)
            .size(10)
            .types(new String[]{"t","w"})
            .keyword("test")
            .finished(true)
            .from(LocalDate.of(2020,10,12))
            .to(LocalDate.of(2022,10,12))
            .build();
        List<TodoEntity> todoList = todoMapper.selectList(pageRequestDTO);

        todoList.forEach(todoEntity -> log.info(todoEntity));
    }

}
