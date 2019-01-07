package actions

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object ComputerDetailsRequest {
  def request: HttpRequestBuilder = {
    http("Display computer details")
      .get(session => "/computers/" + session("computerDetailId").as[String])
      .check(status.is(200))
  }
}
