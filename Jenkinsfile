node {
  stage 'Checkout'
  checkout scm
  
  stage 'Build It Now!'
  def mvnHome = tool 'M3'
  
  try {
    sh "${mvnHome}/bin/mvn clean install -B -DcleanNode -Dmaven.test.failure.ignore"
    stage 'Archive'
    step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    step([$class: 'ArtifactArchiver', artifacts: '*/target/*.hpi'])
  } catch(err) {
    currentBuild.result = "FAILURE"
  }
}
