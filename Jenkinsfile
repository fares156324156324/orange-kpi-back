pipeline {
    agent any
    tools { 
        maven 'maven-3.6.3'
    } 
    stages {
        
        stage('Clean') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build'){
            steps{
                sh 'cd target '
                sh 'java -jar -Dserver.port=8090 demo-0.0.1-SNAPSHOT.jar'
            }

        }
    }
}