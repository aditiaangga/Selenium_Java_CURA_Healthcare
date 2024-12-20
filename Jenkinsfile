pipeline {
    agent {
        label 'master'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean test -Drunner.include=%runner%'
            }

           post {
           		always {
           		   archiveArtifacts artifacts: 'target/cucumber-result/**', fingerprint: true
                   cucumber (  buildStatus: 'UNSTABLE',
                               reportTitle: 'Cucumber Report Before Rerun',
                               fileIncludePattern: 'target/cucumber-result/json/*.json',
                               mergeFeaturesWithRetest: true,
                               skipEmptyJSONFiles: true
                               )
                   cucumber (  buildStatus: 'FAILURE',
                               reportTitle: 'Cucumber Report',
                               fileIncludePattern: 'target/cucumber-result/*/*.json',
                               mergeFeaturesWithRetest: true,
                               skipEmptyJSONFiles: true
                               )


                    emailext attachLog: false, attachmentsPattern: '',
                            to: 'aditia.anggaperdana@gmail.com',
                            body: "Report automation ${env.JOB_URL}${currentBuild.number}/cucumber-html-reports_dad8a364-7c27-3bb2-b027-77615703b17f/overview-features.html",
                            subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME} ${currentBuild.number}"
				}
            }
        }
    }
}