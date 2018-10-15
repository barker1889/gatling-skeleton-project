package scenarios

import actions.SearchRequest
import io.gatling.core.Predef.{exec, scenario}
import io.gatling.core.structure.ScenarioBuilder

class SearchForSomethingScenario {
  def builder: ScenarioBuilder = scenario("Search for something")
    .exitBlockOnFail {
      exec(SearchRequest.request("Test"))
    }
}
