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

 stage('Build image') {
      steps {
        sh ' docker build -t fares123456/springbootapp:${BUILD_NUMBER} .'
      }
    }
    
    stage ('Login'){
        steps{
            script{
withCredentials([string(credentialsId: 'DOCKERHUB_JENKINS', variable: 'dockerpwd')]) {
}         sh 'docker login -u fares123456 -p ${dockerpwd} '
  }}
}
 stage('Push image') {
      steps {
        sh ' docker push fares123456/springbootapp:${BUILD_NUMBER}'
      }
    }
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
