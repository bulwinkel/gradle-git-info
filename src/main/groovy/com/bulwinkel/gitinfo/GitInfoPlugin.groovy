package com.bulwinkel.gitinfo

import com.bulwinkel.gitinfo.internal.GitInfo
import org.gradle.api.Plugin
import org.gradle.api.Project

class GitInfoPlugin implements Plugin<Project> {

  @Override void apply(Project project) {
    project.ext.gitInfo = new GitInfo()
  }
}
