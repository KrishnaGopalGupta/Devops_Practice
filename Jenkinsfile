pipeline {
    agent any 
  parameters{
      string(name:'tomcat_stag', defaultValue:'13.232.101.112', description: 'Staging Server')
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
        steps{
            sh 'scp -i /home/ec2-user/k1/aws1.pem **/target/*.war -o StrictHostKeyChecking=no ec2-user@13.232.101.112:/opt/tomcat-8.5_Prod/webapps'
        }
    }
}

}
