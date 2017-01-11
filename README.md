Gradle Git Info
===============

Plugin which exposes the commit count and latest tag to your gradle build for use as the build
number and version code respectively.

Usage
-----
Apply the plugin in your `build.gradle` file:

```groovy
buildscript {
  repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
  }
  dependencies {
    classpath 'com.github.bulwinkel:gradle-git-info:1.0.1'
  }
}

apply plugin: 'com.bulwinkel.gradle-git-info'
```

The git info is then exposed via the `gitInfo` extension property on your project instance:

```groovy
println "commitCount: ${project.gitInfo.commitCount}"
println "latestTag: ${project.gitInfo.latestTag}"
```

Credits
-------
There is nothing original here, rather just the packaging of other (much smarter) peoples ideas 
into an easy to apply plugin.

- [Automatic Versioning With Git and Gradle](http://ryanharter.com/blog/2013/07/30/automatic-versioning-with-git-and-gradle/)
- [Smart versionName and versionCode for android Gradle build evaluation](https://gist.github.com/tprochazka/36517db854f9046f0b9c)


Licence
-------

    Copyright 2016 Kelvin Bulwinkel

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.