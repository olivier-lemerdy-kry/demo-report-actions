package se.kry.demo.data

import jakarta.persistence.Entity
import org.springframework.data.jpa.domain.AbstractPersistable
import java.util.UUID

@Entity
class CalendarEvent : AbstractPersistable<UUID>()
