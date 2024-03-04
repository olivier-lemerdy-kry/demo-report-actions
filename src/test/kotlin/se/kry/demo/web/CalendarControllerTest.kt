package se.kry.demo.web

import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import se.kry.demo.data.CalendarEventRepository

@WebMvcTest
class CalendarControllerTest(
    @Autowired private val client: MockMvc,
) {
    @MockBean
    private lateinit var repository: CalendarEventRepository

    @Test
    fun readEvents() {
        whenever(repository.findAll(any<Pageable>()))
            .thenReturn(Page.empty())

        client.get("/events") {
            contentType = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content {
                contentType(MediaType.APPLICATION_JSON)
                jsonPath("$.content") { isArray() }
            }
        }
    }
}
