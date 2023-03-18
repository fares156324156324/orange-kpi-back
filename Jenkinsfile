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


    
    stage ('Login'){
        steps{
    withCredentials([usernamePassword(credentialsId: 'fares_Docker_hub', 
    passwordVariable: 'DOCKERHUB_PASSWORD', 
    usernameVariable: 'DOCKERHUB_USERNAME')]) {
    withEnv(['DOCKERHUB_USERNAME=$DOCKERHUB_USERNAME',
     'DOCKERHUB_PASSWORD=$DOCKERHUB_PASSWORD', 
     'DOCKERHUB_TOKEN=dckr_pat_PftfNApFEtAaFB64QFQV2KtX1sY']) {
        sh'echo $DOCKERHUB_USERNAME'
        sh'echo $DOCKERHUB_PASSWORD'
         sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD "
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
