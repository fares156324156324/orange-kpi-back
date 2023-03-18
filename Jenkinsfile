pipeline {
    agent any
     tools { 
        dockerTool 'docker'
        maven 'maven-3.6.3'
     }
    environment {
       DOCKERHUB_CREDENTIALS = credentials('fares_Docker_hub')
    
    }
    
    
    stages {

                    
    stage('Build') {
      steps {
        sh 'mvn clean package -DskipTests=true'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Dockerize') {
      steps {
        script {
        docker.withRegistry('https://registry.hub.docker.com', 'fares_Docker_hub') {
  
        def image = docker.build('fares123456/springbootapp:latest', '.')
            image.push()
      }
    }
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

