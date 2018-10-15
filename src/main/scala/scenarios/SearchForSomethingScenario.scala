package scenarios

import actions.SearchRequest
import io.gatling.core.Predef.{exec, scenario}
import io.gatling.core.structure.ScenarioBuilder

// Define what actions will run for each virtual user
class SearchForSomethingScenario {

  // Expose a builder for the scenario + give the scenario a name
  def builder: ScenarioBuilder = scenario("Search for something")
    // If any of the assertions (checks) fail then end the scenario
    .exitBlockOnFail {
      // Execute the search request, specifying a search term
      exec(SearchRequest.request("Test"))
    }
}
