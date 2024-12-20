pipeline {
    agent any

    stages{
        stage('Build'){
            steps {
                bat 'mvn clean test -Drunner.include=%runner% -Denvironmentprofile=%environtment%'
                }
        }
    }
}