val paradiseVersion = "2.1.0"

lazy val commonSettings = Seq(
  scalaVersion := "2.13.0-M5",
  scalacOptions ++= Seq("-Ymacro-annotations")
)

lazy val root = (project in file("."))
  .aggregate(core, macros)

lazy val macros = (project in file("macros"))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaVersion.value
    )
  )

lazy val core = (project in file("core"))
  .settings(commonSettings)
  .dependsOn(macros)
