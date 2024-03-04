package se.kry.demo.web

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import se.kry.demo.data.CalendarEvent
import se.kry.demo.data.CalendarEventRepository
import java.util.UUID

@RestController
@RequestMapping("/events")
class CalendarController(
    private val repository: CalendarEventRepository,
) {
    @GetMapping
    fun readEvents(pageable: Pageable): Page<CalendarEvent> = repository.findAll(pageable)

    @GetMapping("{id}")
    fun readEvent(
        @PathVariable id: UUID,
    ) = repository.findById(id)
}
