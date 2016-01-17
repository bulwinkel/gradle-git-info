package com.bulwinkel.gitinfo

import com.bulwinkel.gitinfo.internal.GitInfo
import org.gradle.api.Plugin
import org.gradle.api.Project

class GitInfoPlugin implements Plugin<Project> {

  @Override void apply(Project project) {
    project.ext.gitInfo = new GitInfo()

    project.task ("describeGit") << {
      println "*** Git Info Plugin ***"
      println "* Commit Count: \t${project.gitInfo.commitCount}"
      println "* Latest Tag: \t${project.gitInfo.latestTag}"
      println "***********************"
    }
  }
}
