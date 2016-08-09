node {
  stage 'Checkout'
  checkout scm
  
  stage 'Build'
      echo "build"
  
      sh "mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
      stage 'Archive'
      step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
      
  stage "Failure stage"
      sh "it was the blurst of times"
}
