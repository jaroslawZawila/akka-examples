name := "akka-examples"

version := "1.0"

scalaVersion := "2.11.8"

val akkaVersion = "2.4.11"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion
)

//TEST
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-testkit"   % akkaVersion,
  "org.scalatest"     %% "scalatest"      % "2.2.6"       % "test",
  "junit"             % "junit"           % "4.12"        % "test",
  "com.novocode"      % "junit-interface" % "0.11"        % "test"
)