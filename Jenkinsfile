pipeline{
    agent any
        stages{
            stage('Code Build'){
                steps{
                    sh 'mvn clean package'
                }

            post {
                success {
                    echo "Now Archiving the Artifacts...."
                    archiveArtifacts artifacts: '**/*.war'
					    
                }
            }

        }
            
     }
}
