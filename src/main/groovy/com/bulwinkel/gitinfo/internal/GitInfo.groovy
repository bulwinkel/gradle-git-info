package com.bulwinkel.gitinfo.internal

final class GitInfo {

  @Lazy int commitCount = {
    final String branch = '${1:-\'master\'}'
    def p = Runtime.getRuntime().exec("expr \$(git rev-list $branch --count) - \$(git rev-list HEAD..$branch --count)")

    def result = p.waitFor()
    if (result != 0) {
      return 0 // no git revisions
    }
    return p.getInputStream().readLines().get(0).toInteger()
  }()

  @Lazy String latestTag = {
    def p = Runtime.getRuntime().exec("git describe --tags")

    def result = p.waitFor()
    if (result != 0) {
      println "WARNING: No git tags in current git project"
      return "" // no git tag
    }
    return p.getInputStream().readLines().get(0).toString().trim()
  }()

}
