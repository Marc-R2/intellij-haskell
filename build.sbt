lazy val commonSettings = Seq(
  version := "1.1.0-beta1",
  scalaVersion := "2.13.12"
)

val scalaTest = "org.scalatest" %% "scalatest" % "3.2.17" % Test
val sprayJson = "io.spray" %% "spray-json" % "1.3.6"
val snakeYaml = "org.yaml" % "snakeyaml" % "1.30"
val scaffeine = "com.github.blemale" %% "scaffeine" % "5.1.2"
val directories = "io.github.soc" % "directories" % "12"
val fastparse = "com.lihaoyi" %% "fastparse" % "2.3.3"

(ThisBuild / intellijPluginName) := "IntelliJ-Haskell"

lazy val intellijHaskell = (project in file(".")).
  enablePlugins(SbtIdeaPlugin).
  settings(commonSettings: _*).
  settings(
    name := "IntelliJ Haskell",
    javacOptions in Global ++= Seq("-source", "17", "-target", "17"),
    scalacOptions in Global ++= Seq("-release:17", "-deprecation", "-feature", "-unchecked"),
    libraryDependencies += scalaTest,
    libraryDependencies += sprayJson,
    libraryDependencies += snakeYaml,
    libraryDependencies += scaffeine,
    libraryDependencies += directories,
    libraryDependencies += fastparse,
    (Compile / unmanagedSourceDirectories) += baseDirectory.value / "gen"
  )

(ThisBuild / intellijBuild) := "2023.2.2"

intellijPlugins += "com.intellij.java".toPlugin
