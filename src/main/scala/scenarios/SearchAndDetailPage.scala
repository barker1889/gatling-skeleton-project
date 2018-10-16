package scenarios

import actions.{ComputerDetailsRequest, ComputersSearchRequest}
import io.gatling.core.Predef.{exec, scenario}
import io.gatling.core.structure.ScenarioBuilder

// Define what actions will run for each virtual user
class SearchAndDetailPage {

  // Expose a builder for the scenario + give the scenario a name
  def builder: ScenarioBuilder = scenario("Search for something")
    // If any of the assertions (checks) fail then end the scenario
    .exitBlockOnFail {
      // Execute the search request, specifying a search term, the load the details page details page
      exec(ComputersSearchRequest.request("Test"))
      .exec(ComputerDetailsRequest.request)
    }
}
