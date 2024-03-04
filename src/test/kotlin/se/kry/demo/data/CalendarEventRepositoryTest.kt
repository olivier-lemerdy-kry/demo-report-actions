package se.kry.demo.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest

@DataJpaTest
class CalendarEventRepositoryTest(
    @Autowired private val repository: CalendarEventRepository,
) {
    @Test
    fun findAll() {
        val pageable = PageRequest.ofSize(10)
        val events = repository.findAll(pageable)
        assertThat(events).hasSize(0)
    }
}
