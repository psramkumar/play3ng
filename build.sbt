
name := """play3ng"""

version := "1.0-SNAPSHOT"

lazy val play3ng = (project in file(".")).enablePlugins(play.PlayJava)

scalaVersion := "2.11.1"

val springVersion = "4.1.7.RELEASE"

//http://www.webjars.org/

libraryDependencies ++= Seq(
  cache,
  javaWs,
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "jquery" % "2.1.4",
  //"org.webjars" % "momentjs" % "2.8.3",
  "org.webjars" % "angularjs" % "1.4.3",
  //"org.webjars" % "requirejs" % "2.1.11-1",
  "org.webjars" % "angular-ui-bootstrap" % "0.13.0",
  "org.webjars" % "angular-growl" % "0.4.0",
  "org.webjars" % "font-awesome" % "4.3.0-3",
  "org.webjars" % "bootstrap" % "3.3.5",
  //"org.webjars" % "bootstrap-modal" % "2.2.5",
  "org.webjars" % "angular-google-maps" % "1.2.2",
  "org.webjars" % "angular-ui-calendar" % "0.9.0-beta.1",
  "org.webjars" % "trNgGrid" % "3.1.2",
  "org.webjars" % "fullcalendar" % "2.1.0-beta2",
  "org.webjars" % "lodash" % "2.4.1-6",
  "org.springframework" % "spring-context" % "$springVersion",
  "org.springframework.data" % "spring-data-mongodb" % "1.7.1.RELEASE",
  "org.projectlombok" % "lombok" % "1.16.2" % "provided",
  "log4j" % "log4j" % "1.2.16",
  "org.springframework" % "spring-test" % "4.1.7.RELEASE" % "test"
)

pipelineStages := Seq(rjs, digest, gzip)
