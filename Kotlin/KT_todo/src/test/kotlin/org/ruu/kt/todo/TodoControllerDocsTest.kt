package org.ruu.kt.todo

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.ruu.kt.todo.todos.controller.TodoController
import org.ruu.kt.todo.todos.dto.TodoDTO
import org.ruu.kt.todo.todos.enum.Priority
import org.ruu.kt.todo.todos.enum.TodoStatus
import org.ruu.kt.todo.todos.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.RestDocumentationContextProvider
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders
import org.springframework.restdocs.payload.PayloadDocumentation
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@WebMvcTest(TodoController::class)
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension::class, SpringExtension::class)
class TodoControllerDocsTest {    @Autowired

    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var todoService: TodoService

    @BeforeEach
    fun setUp(
        webApplicationContext: WebApplicationContext,
        restDocumentation: RestDocumentationContextProvider
    ) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply {
                MockMvcRestDocumentation.documentationConfiguration(restDocumentation)
            }
            .build()
    }

    @Test
    @WithMockUser(username = "testuser")
    fun `GET todos returns documented response`() {
        val mockTodos = listOf(
            TodoDTO(
                id = 1L,
                title = "테스트 작업1",
                content = "설명1",
                todoStatus = TodoStatus.PENDING,
                priority = Priority.HIGH
            ),
            TodoDTO(
                id = 2L,
                title = "테스트 작업2",
                content = "설명2",
                todoStatus = TodoStatus.COMPLETED,
                priority = Priority.LOW
            )
        )

        BDDMockito.given(todoService.getTodosByUserName("testuser")).willReturn(mockTodos)

        mockMvc.perform(RestDocumentationRequestBuilders.get("/todos?page=0&pageSize=10"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(
                MockMvcRestDocumentation.document(
                    "todos-list",
                    PayloadDocumentation.responseFields(
                        PayloadDocumentation.fieldWithPath("[].id").description("할 일 ID"),
                        PayloadDocumentation.fieldWithPath("[].title").description("할 일 제목"),
                        PayloadDocumentation.fieldWithPath("[].content").description("할 일 상세 내용")
                            .optional(),
                        PayloadDocumentation.fieldWithPath("[].todoStatus")
                            .description("할 일 상태 (TODO, IN_PROGRESS, DONE 등)"),
                        PayloadDocumentation.fieldWithPath("[].priority")
                            .description("우선순위 (LOW, MEDIUM, HIGH)")
                    )
                )
            )
    }
}