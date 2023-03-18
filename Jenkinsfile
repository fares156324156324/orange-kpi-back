pipeline {
    agent any
     tools { 
        dockerTool 'docker'
        maven 'maven-3.6.3'
 environment {
  }        DOCKERHUB_CREDENTIALS = credentials('fares_Docker_hub')
    }
    
    
    stages {

      
            
        
    stage('Build') {
      steps {
        sh 'mvn clean package -DskipTests=true'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
    stage ('Login'){
        steps{

            sh'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password -stdin'
        }

    }
    stage('Dockerize') {
      steps {
        sh ' docker build -t fares123456/springbootapp:${BUILD_NUMBER} .'
        sh ' docker push fares123456/springbootapp:${BUILD_NUMBER}'
      }
    }
    
    stage('Deploy') {
      steps {
        sh 'docker-compose -f docker-compose.yml up -d'
      }
    }
  }
  
  post {
    always {
        sh'docker logout'
      cleanWs()
    }
  }

}
