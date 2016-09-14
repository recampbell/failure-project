node {
  stage 'Checkout'
    checkout scm
  
  stage 'Build'
    def mvnHome = tool 'M3'

  parallel
    build_windows: {
        sh "${mvnHome}/bin/mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    },
    build_linux: {
        sh "${mvnHome}/bin/mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    },
    build_osx: {
        sh "${mvnHome}/bin/mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    }
}
