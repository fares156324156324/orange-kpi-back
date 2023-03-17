pipeline {
    agent any
     tools { 
        docker 'Docker 20.10.9'
        maven 'maven-3.6.3'
    } 

    stages {

        stage('Build Docker Image') {
            steps {
                // Build the Docker image using the specified Docker executable
                withDockerTool('Docker 20.10.9') {
                    sh 'docker build -t my-docker-image .'
                }
            }
        }
    stage('Build') {
      steps {
        sh 'mvn clean package -DskipTests=true'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
    
    stage('Dockerize') {
      steps {
        sh 'docker build -t fares123456/springbootapp:${BUILD_NUMBER} .'
        sh 'docker push fares123456/springbootapp:${BUILD_NUMBER}'
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
      cleanWs()
    }
  }
}
