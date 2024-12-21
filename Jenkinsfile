pipeline {
    agent {
      label 'master'
    }
    stages {
         stage('Setup') {
                    steps {
                        script {
                            sh 'google-chrome --version'
                            sh 'chromedriver --version'
                        }
                    }
                }
        stage("build") {
            steps {
            bat 'mvn clean test'
            echo "works"
            }
        }
    }
}