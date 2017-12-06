package com.bulwinkel.gitinfo.internal

final class GitInfo {

  static final String versionExpression = 'git describe --tags'
  static final String revListHeadCount = "git rev-list HEAD --count"
  static final String revListHeadToMasterCount = "git rev-list HEAD..master --count"

  final String latestTag = evaluateExpression(versionExpression)
  final int commitCount = evaluateExpression(revListHeadCount).toInteger() - evaluateExpression(
      revListHeadToMasterCount).toInteger()

  @Override
  public String toString() {
    return "GitInfo{" + "commitCount=" + commitCount + ", latestTag='" + latestTag + '\'' + '}';
  }

  static String evaluateExpression(String expression) {
    def p = Runtime.getRuntime().exec(expression)

    def result = p.waitFor()
    if (result != 0) {
      return "0"
    }
    try {
      final String first = p.getInputStream().readLines().first()
      return first.isEmpty() ? "0" : first
    } catch (Exception e) {
      return "0"
    }
  }
}
