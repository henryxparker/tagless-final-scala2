libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.6.1",
  "org.typelevel" %% "cats-effect" % "3.1.1",
  "dev.zio" %% "zio" % "1.0.9",
  "dev.zio" %% "zio-interop-cats" % "3.1.1.0"
)

addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.0" cross CrossVersion.full)

ThisBuild / scalacOptions += "-P:kind-projector:underscore-placeholders"