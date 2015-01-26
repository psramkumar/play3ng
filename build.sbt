
name := """nexgeno"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(play.PlayJava)

scalaVersion := "2.11.1"

val springVersion = "4.1.0.RELEASE"

//http://www.webjars.org/

libraryDependencies ++= Seq(
  cache,
  javaWs,
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "jquery" % "2.1.1",
  //"org.webjars" % "momentjs" % "2.8.3",
  "org.webjars" % "angularjs" % "1.3.8",
  //"org.webjars" % "requirejs" % "2.1.11-1",
  "org.webjars" % "angular-ui-bootstrap" % "0.12.0",
  "org.webjars" % "angular-growl" % "0.4.0",
  "org.webjars" % "font-awesome" % "4.2.0",
  "org.webjars" % "bootstrap" % "3.3.1",
  //"org.webjars" % "bootstrap-modal" % "2.2.5",
  "org.webjars" % "angular-google-maps" % "1.2.2",
  "org.webjars" % "angular-ui-calendar" % "0.9.0-beta.1",
  "org.webjars" % "fullcalendar" % "2.1.0-beta2",
  "org.webjars" % "lodash" % "2.4.1-6",
  "org.springframework" % "spring-context" % "$springVersion",
  "org.springframework.data" % "spring-data-mongodb" % "1.6.0.RELEASE",
  "org.projectlombok" % "lombok" % "1.14.8" % "provided",
  "log4j" % "log4j" % "1.2.16",
  "org.springframework" % "spring-test" % "3.1.2.RELEASE" % "test"
)

pipelineStages := Seq(rjs, digest, gzip)
