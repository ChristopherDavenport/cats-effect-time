package io.chrisdavenport.cats.effect.time

import org.specs2._
import cats.effect._

import cats.effect.testkit._
import java.time.{Clock => _, _}
import cats.effect.unsafe.implicits.global

object JavaTimeSpec extends mutable.Specification {

  // Additional Tests to Implement: 
  // def getLocalDateTime(zone: ZoneId): F[LocalDateTime]
  // def getLocalDateTimeUTC: F[LocalDateTime]

  // def getLocalTime(zone: ZoneId): F[LocalTime]
  // def getLocalTimeUTC: F[LocalTime]

  // def getYearMonth(zone: ZoneId): F[YearMonth]
  // def getYearMonthUTC: F[YearMonth]

  // def getZonedDateTime(zone: ZoneId): F[ZonedDateTime]
  // def getZonedDateTimeUTC: F[ZonedDateTime]

  "JavaTime" should {
    "getInstant the epoch in a test context" in {

      val test = JavaTime[TimeT[IO, *]].getInstant
      TimeT.run(test).unsafeRunSync must_=== Instant.EPOCH
    }

    "getLocalDate the epoch in a test context" in {
      val test = JavaTime[TimeT[IO, *]].getLocalDate(ZoneOffset.UTC)
      TimeT.run(test).unsafeRunSync() must_=== LocalDate.ofEpochDay(0)
    }

    "getLocalDateUTC the epoch in a test context" in {
      val test = JavaTime[TimeT[IO, *]].getLocalDateUTC
      TimeT.run(test).unsafeRunSync() must_=== LocalDate.ofEpochDay(0)
    }

    "get the epoch year from test context" in {
      val test = JavaTime[TimeT[IO, *]].getYearUTC
      TimeT.run(test).unsafeRunSync() must_=== Year.of(1970)
    }
  }

}