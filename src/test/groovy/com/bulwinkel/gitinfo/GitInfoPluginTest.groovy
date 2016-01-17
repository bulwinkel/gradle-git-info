package com.bulwinkel.gitinfo

import com.bulwinkel.gitinfo.internal.GitInfo
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.BeforeClass
import org.junit.Test
import static org.fest.assertions.api.Assertions.*;

class GitInfoPluginTest {

  static Project project;

  @BeforeClass static void setup() {
    project = ProjectBuilder.builder().build()
    project.pluginManager.apply 'com.bulwinkel.gradle-git-info'
  }

  @Test void gitInfoAvailableOnProject() {
    assertThat(project.gitInfo).isInstanceOf(GitInfo)
    assertThat(project.gitInfo.commitCount).is { it > 0 }
    assertThat(project.gitInfo.latestTag).isNotNull()
  }

  @Test void describeTaskAvailableOnProject() {
    def task = project.tasks.findByName('describeGit')
    assertThat(task).isNotNull()
  }
}
