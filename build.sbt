name := "sparktest"

version := "0.0.1"

scalaVersion := "2.12.15"
val sparkVersion = "3.2.0"

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// test suite settings
fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
// Show runtime of tests
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

assemblyJarName in assembly := s"${name.value}_${scalaBinaryVersion.value}_${version.value}.jar"