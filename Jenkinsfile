pipeline {
    agent any
     tools { 
        dockerTool 'docker'
        maven 'maven-3.6.3'
     }
    environment {
       DOCKERHUB_CREDENTIALS = credentials('fares_Docker_hub')
        DOCKER_IMAGE_NAME = 'fares123456/springbootapp'
        DOCKER_IMAGE_TAG = 'latest'
    
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
        docker.withRegistry('https://registry.hub.docker.com', DOCKERHUB_CREDENTIALS) {
            def dockerImage = docker.build("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}", ".")
            dockerImage.push()
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

