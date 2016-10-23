node {
  stage('Checkout') {
      checkout scm    
  }

  
  stage('Build') {
      sh "mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
      stage 'Archive'
      step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])    
  }

}
