package todo

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.ruu.kt.todo.todos.controller.TodoController
import org.ruu.kt.todo.todos.dto.TodoDTO
import org.ruu.kt.todo.todos.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcBuilderCustomizer
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.web.context.WebApplicationContext
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder

@WebMvcTest(TodoController::class)
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension::class, SpringExtension::class)
class TodoControllerDocsTest {    @Autowired

    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var todoService: TodoService

    @BeforeEach
    fun setUp(webApplicationContext: WebApplicationContext ,restDocumentation: RestDocumentationContextProvider) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply {
                documentationConfiguration(restDocumentation)
            }
            .build()

    }

    @Test
    @WithMockUser(username = "testuser")
    fun `GET todos returns documented response`() {
        val mockTodos = listOf(
            TodoDTO(id = 1, title = "테스트 작업1", completed = false),
            TodoDTO(id = 2, title = "테스트 작업2", completed = true)
        )

        given(todoService.getTodosByUserName("testuser")).willReturn(mockTodos)

        mockMvc.perform(get("/todos?page=0&pageSize=10"))
            .andExpect(status().isOk)
            .andDo(document("todos-list",
                responseFields(
                    fieldWithPath("[].id").description("할 일 ID"),
                    fieldWithPath("[].title").description("할 일 제목"),
                    fieldWithPath("[].completed").description("완료 여부")
                )
            ))
    }
}