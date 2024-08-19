package com.example.restfulltutorial;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    EmployeeRepository repository;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    void setup() {
        repository.save(new Employee("test1", "test1"));
        repository.save(new Employee("test2", "test2"));
    }


    @Test
    @DisplayName("모든 직원 검색")
    void getList() throws Exception {
        String expectByName = "$.[?(@.name == '%s')]";
        String expectByRole = "$.[?(@.role == '%s')]";
        mvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath(expectByName, "test1").exists())
                .andExpect(jsonPath(expectByName, "test2").exists())
                .andExpect(jsonPath(expectByRole, "test1").exists())
                .andExpect(jsonPath(expectByRole, "test2").exists());

    }

    @Test
    @DisplayName("직원 검색")
    void getEmployeeById() throws Exception {
        mvc.perform(get("/employees/{id}", 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test1"))
                .andExpect(jsonPath("$.role").value("test1"));
    }

    @Test
    @DisplayName("직원 검색 요청에 대한 에러")
    void errorEmployeeById() throws Exception {
        mvc.perform(get("/employees/{id}", 99999999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> { result.getResolvedException()
                            .getClass()
                            .isAssignableFrom(EmployeeNotFoundException.class);
                });
    }

    @Test
    @DisplayName("직원 데이터를 수정.")
    void replaceEmployee() throws Exception {
        Map<String, String> data = new HashMap<>();

        data.put("role", "test4");
        data.put("name", "test4");

        mvc.perform(put("/employees/{id}", 4)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(data)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test4"))
                .andExpect(jsonPath("$.role").value("test4"));
    }

    @Test
    @DisplayName("직원 데이터가 존재하지 않는다면 저장")
    void notReplaceEmployeeIsAdd() throws Exception {
        Map<String, String> data = new HashMap<>();

        data.put("role", "test5");
        data.put("name", "test5");

        mvc.perform(put("/employees/{id}", 3000)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(data)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test5"))
                .andExpect(jsonPath("$.role").value("test5"));
    }


    @Test
    @DisplayName("직원 데이터 저장")
    void saveEmployee() throws Exception {
        Map<String, String> data = new HashMap<>();

        data.put("role", "test6");
        data.put("name", "test6");

        mvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(data)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test6"))
                .andExpect(jsonPath("$.role").value("test6"));
    }

    @Test
    @DisplayName("직원 데이터 삭제를 요청.")
    void removeEmployee() throws Exception {
        mvc.perform(delete("/employees/{id}", 4))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
