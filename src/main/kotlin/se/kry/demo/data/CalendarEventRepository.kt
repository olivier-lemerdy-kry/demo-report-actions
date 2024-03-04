package se.kry.demo.data

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CalendarEventRepository : JpaRepository<CalendarEvent, UUID>
