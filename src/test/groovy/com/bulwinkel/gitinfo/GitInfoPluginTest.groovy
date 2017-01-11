package com.bulwinkel.gitinfo

import com.bulwinkel.gitinfo.internal.GitInfo
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.BeforeClass
import org.junit.Test
import static org.fest.assertions.api.Assertions.*

class GitInfoPluginTest {

  static Project project

  @BeforeClass static void setup() {
    project = ProjectBuilder.builder().build()
    project.pluginManager.apply 'com.bulwinkel.gradle-git-info'
  }

  @Test void gitInfoAvailableOnProject() {
    final GitInfo gitInfo = project.gitInfo
    println("gitInfo = $gitInfo")
    assertThat(gitInfo).isInstanceOf(GitInfo)
    assertThat(gitInfo.commitCount).is { it > 0 }
    assertThat(gitInfo.latestTag).isNotNull()
  }

  @Test void describeTaskAvailableOnProject() {
    def task = project.tasks.findByName('describeGit')
    assertThat(task).isNotNull()
  }
}
