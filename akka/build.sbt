// set the name of the project
name := "My Project"

version := "1.0"

organization := "org.myproject"

scalaVersion := "2.9.0-1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases"

libraryDependencies += "se.scalablesolutions.akka" % "akka-actor" % "1.1.3"

libraryDependencies += "se.scalablesolutions.akka" % "akka-remote" % "1.1.3"
