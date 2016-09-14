node {
  stage 'Checkout'
  checkout scm
  
  stage 'Build'
  def mvnHome = tool 'M3'
  
  try {
    parallel (
        'build windows': {
            sh "${mvnHome}/bin/mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
            stage 'Archive'
            step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        },
        'build linux': {
            sh "${mvnHome}/bin/mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
            stage 'Archive'
            step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        },
        'build osx': {
            sh "${mvnHome}/bin/mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
            stage 'Archive'
            step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        }
    )
  } catch(err) {
    currentBuild.result = "FAILURE"
  }
}
