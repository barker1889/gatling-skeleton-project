package actions

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object SearchRequest {
  def request(searchTerm: String): HttpRequestBuilder = {
    http("Search Query")
      .get("/search")
      .queryParam("q", searchTerm)
      .check(status.is(200).saveAs("ResponseStatusCode"))
  }
}
