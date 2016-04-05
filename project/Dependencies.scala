import sbt._


object Dependencies {

  val testDependencies: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % "2.1.0" % "test"
  )

  val hdfsDependencies: Seq[ModuleID] = Seq(
    "org.apache.hadoop" % "hadoop-hdfs" % "2.3.0"
  )

}
