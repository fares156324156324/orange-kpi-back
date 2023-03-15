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
            
                sh 'java -jar -Dserver.port=8090 target/demo-0.0.1-SNAPSHOT.jar'
            }
        stage ('test')
            steps {
                sh'echo tesssssssssssssssst'

        }

        }
    }
}