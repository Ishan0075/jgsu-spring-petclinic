pipeline {
    agent any
stages {
       stage('checkout') {
            steps {
                git url: 'https://github.com/Ishan0075/jgsu-spring-petclinic.git', branch: 'main' 
            }
       }
    
     stage('Build') {
            steps {
                // build the code
                  bat "mvnw clean package"
                }
    post {
     always {
         junit '**/target/surefire-reports/TEST-*.xml'
         archiveAtifacts 'target/*.jar'
              }
           }
        }
    }
}