pipeline {
    agent {
      label 'master'
    }
    stages {
        stage("build") {
            steps {
            bat 'mvn clean test -Drunner.include=%runner%'
            echo "works"
            }
        }
    }
}