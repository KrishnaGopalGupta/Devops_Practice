pipeline {
    agent any 
  parameters{
      strings(name:'tomcat_stag', defaultvalue:'13.232.101.112', description: 'Staging Server')
   }

triggers {
    pollSCM('* * * * *')
}

stages{
    stage('Build Application'){
        steps{
            sh 'mvn clean package'
        }

        post {
            success {
                echo 'Now Archiving Build'
                archiveArtifacts artifacts: '**/target/*.war'
            }
        }
    }

    stage('Deploy the Application') {
        stage{
            sh 'scp -i /home/ec2-user/k1/aws1.pem **/target/*.war ec2-user@{params.defaultvalue}:/opt/tomcat-8.5_Prod/webapps'
        }
    }
}

}
