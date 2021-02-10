pipeline {

    agent any
    
    stages {
        stage('Build the App') {
            steps {
                sh 'mvn clean package'
            }

            post {
                success {
                    echo ' Now Archiving the project'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        
        }       
    }

