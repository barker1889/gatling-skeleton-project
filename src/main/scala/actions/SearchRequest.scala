package actions

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

// An individual action the virtual user can perform
object SearchRequest {
  // We may want to make the request dynamic, here we pass in part of the request data
  def request(searchTerm: String): HttpRequestBuilder = {
    http("Search Query")
      .get("/search")
      .queryParam("q", searchTerm)
      // Assert the response status is 200, and save the response status to the session
      .check(status.is(200).saveAs("ResponseStatusCode"))
  }
}
