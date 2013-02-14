// Project info

name := "play-mongojack"

organization := "org.mongojack"

// The version comes from version.sbt, and is generated by the release plugin

scalaVersion := "2.10.0"

// Dependencies

libraryDependencies ++= Seq(
    "org.mongojack" % "mongojack" % "2.0.0-RC1",
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.1.3",
    "play" %% "play" % "2.1.0" % "provided"
)

// Test dependencies

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "1.13" % "test",
    "play" %% "play-test" % "2.1.0" % "test"
)

// Configuration required for deploying to sonatype

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

publishArtifact in Test := false

pomExtra := (
  <url>http://github.com/jroper/play-mongojack</url>
  <inceptionYear>2012</inceptionYear>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
      <comments>A business-friendly OSS license</comments>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:jroper/play-mongojack.git</url>
    <connection>scm:git:git@github.com:jroper/play-mongojack.git</connection>
  </scm>
  <developers>
    <developer>
      <name>James Roper</name>
      <email>james@jazzy.id.au</email>
      <url>http://jazzy.id.au</url>
      <roles>
        <role>Author</role>
      </roles>
      <organization>Typesafe</organization>
    </developer>
  </developers>)
