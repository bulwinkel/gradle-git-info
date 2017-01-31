package com.bulwinkel.gitinfo.internal

final class GitInfo {

  @Lazy int commitCount = {
    final int revListMasterCount = evaluateExpressionToInt("git rev-list master --count")
    final int revListHeadCount = evaluateExpressionToInt("git rev-list HEAD..master --count")
    return revListMasterCount - revListHeadCount
  }()

  @Lazy String latestTag = {
    final List<String> tags = evaluateExpression("git describe --tags")
    if (tags.size() == 0) {
      return "No Version Tag"
    } else {
      return tags.first().toString().trim()
    }
  }()

  private static int evaluateExpressionToInt(final String expression) {
    return evaluateExpression(expression).first().toInteger()
  }

  private static List<String> evaluateExpression(String expression) {
    def p = Runtime.getRuntime().exec(expression)

    def result = p.waitFor()
    if (result != 0) {
      return Collections.emptyList() // no git revisions
    }
    return p.getInputStream().readLines()
  }
}
