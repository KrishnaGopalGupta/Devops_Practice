pipeline{
    agent any
        stages{
            stage('Code Build'){
                steps{
                    sh 'mvn pom.xml clean package'
                }

                post{
                    success{
                        echo 'Now Archiving the project........'
                        archiveArtifacts artifacts '**/*.war'
                    }
                }
            }
            
        }
}
