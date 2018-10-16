package simulations

import config.HttpConfig
import io.gatling.core.Predef._
import scenarios._

import scala.concurrent.duration._
import scala.language.postfixOps

class SimpleSimulation extends Simulation {

  // Create the scenario we will be running
  private val searchScenario = new SearchAndDetailPage()

  before {
    println("starting")

    // Add any pre-test setup here
  }

  setUp(
    // Get a builder for the scenario
    searchScenario.builder
      // Specify the load profile (number of virtual users and rate they are added)
      .inject(
        atOnceUsers(1),
        // constantUsersPerSec(2) during(10 seconds)
      )
      // Specify a globally configured HTTP protocol
      .protocols(HttpConfig.httpProtocol),
  ).assertions(
    // After the test has completed, check that all request succeeded and are under 500ms
    global.failedRequests.count.is(0),
    global.responseTime.mean.lt(500)
  )

  after {
    println("completed")

    // Add any post-test cleanup/actions here
  }
}
