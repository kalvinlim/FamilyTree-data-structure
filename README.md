# FamilyTree-data-structure
Coding exercise to implement a family tree data structure

### Components/Environment dependencies
* [Eclipse Luna](https://eclipse.org/luna/)
* [Gradle 2.5 (command line)](https://gradle.org/)
* [Git Bash](https://git-scm.com/)

### Eclipse Plugins Used
* [Gradle Integration for Eclipse](https://marketplace.eclipse.org/content/gradle-integration-eclipse-0)
* [Groovy Eclipse Plugin](https://docs.gradle.org/current/userguide/groovy_plugin.html)
* [EclEmma Java Code Coverage](http://marketplace.eclipse.org/content/eclemma-java-code-coverage)

### Gradle Dependencies
* [Junit](https://github.com/junit-team/junit/wiki/Use-with-Gradle)


### Installation
```
./gradlew build
./gradle run
```
See [[build.gradle]](https://github.com/kalvinlim/FamilyTree-data-structure/blob/master/build.gradle) for additional information

### Code coverage

See: [[Html results]](https://cdn.rawgit.com/kalvinlim/FamilyTree-data-structure/master/index.html)

[[EclEmma Eclipse Plugin]](http://marketplace.eclipse.org/content/eclemma-java-code-coverage) run against test suite [[com.FamilyTree.domain.AllTests.groovy]](https://github.com/kalvinlim/FamilyTree-data-structure/blob/master/src/test/java/com/FamilyTree/domain/AllTests.groovy) in the src/test/java folder.

**Note**: Exclude src/test/java in coverage configuration
