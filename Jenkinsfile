pipeline {
    agent any
     tools { 
        maven 'maven-3.6.3'
     }
    
    
    stages {

                    
    stage('Clean') {
      steps {
        sh 'mvn clean -DskipTests=true'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

 stage('Build image') {
      steps {
        sh ' docker build -t fares123456/springbootapp:latest .'
      }
    }
    
    stage ('Login'){
        steps{
            script{
withCredentials([string(credentialsId: 'DOCKERHUB_JENKINS', variable: 'dockerpwd')]) {
       sh 'docker login -u fares123456 -p ${dockerpwd} '
    }
  }}
}
 stage('Push image') {
      steps {
        sh ' docker push fares123456/springbootapp:latest'
      }
    }
        
    
    
    stage('Deploy') {
      steps {
        sh 'export PATH=$PATH:/usr/local/bin/docker-compose'
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
