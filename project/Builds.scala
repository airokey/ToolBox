import sbt._
import Keys._
import sbtassembly.AssemblyKeys._

object Builds extends Build {
  val NamePrefix = "qht_"

  //----------------------------------------
  // modules in common
  //----------------------------------------
  lazy val hdfs_module = project.in(file("hdfs_module")).settings(name := NamePrefix + "hdfs_module").
    settings(Common.settings: _*).
    settings(libraryDependencies ++= Dependencies.hdfsDependencies).
    settings(assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false))

  //----------------------------------------------------------------
  // all modules
  // NOTE: MUST remember adding new module into the aggregate part
  // TODO: it would be better to make this automatically
  //----------------------------------------------------------------
  lazy val all = (project in file(".")).settings(name := NamePrefix + "app").
    settings(Common.settings: _*).
    aggregate(hdfs_module)

}