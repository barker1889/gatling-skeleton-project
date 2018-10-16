package actions

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

// An individual action the virtual user can perform
object ComputersSearchRequest {
  // We may want to make the request dynamic, here we pass in part of the request data
  def request(searchTerm: String): HttpRequestBuilder = {
    http("Search for computer")
      .get("/computers")
      .queryParam("f", searchTerm)
      .check(status.is(200))
      // Get the first element of the results
      .check(
          // Retrieve data from the response
          css(".computers > tbody a")
            // Modify it
            .transform(href => extractComputerIdFromSearchResult(href))
            // Save it to the session for future actions
            .saveAs("computerDetailId")
      )
  }

  def extractComputerIdFromSearchResult(element: String): String = {
//    val elementAfterHrefDeclared = element.split("href=\"").last
//    val hrefValue = elementAfterHrefDeclared.split("\"")(0)
//    hrefValue.split("/").last

    // Debug this later, just return for now

    "384"
  }
}
