package config

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object HttpConfig {
  val httpProtocol: HttpProtocolBuilder = http
    // If any request uses a relative URL then assume this to be the base
    .baseUrl("http://computer-database.gatling.io")
//    .proxy(Proxy("localhost", 8080))
}
