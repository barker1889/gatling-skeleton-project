package config

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object HttpConfig {
  val httpProtocol: HttpProtocolBuilder = http
    .baseURL("https://www.example.com")
}
