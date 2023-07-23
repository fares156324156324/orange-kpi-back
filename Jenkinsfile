pipeline {
    agent any
     tools { 
        maven 'maven-3.6.3'
     }
    
    
    stages {

                    
    stage('Clean install') {
      steps {
        sh 'mvn clean install -DskipTests=true'
    archive'target/*.jar'
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
        
    }
    
  post {
    always {
        sh'docker logout'
      cleanWs()
    }
  }

}
