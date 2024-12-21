pipeline {
    agent {
      label 'master'
    }
    stages {
        stage("build") {
            steps {
            bat 'mvn clean test'
            echo "works"
            }
        }
    }
}