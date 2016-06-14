node {
  checkout scm
  
  docker.image('cloudbees/java-build-tools').inside {
    sh "mvn clean install -B -DcleanNode"
  }
}
