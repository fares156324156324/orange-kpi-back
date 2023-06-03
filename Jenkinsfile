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
    
   stage('Login') {
    steps {
        withCredentials(usernamePassword(credentialsId: 'DOCKERHUB_JENKINS', usernameVariable: 'dockerUser', passwordVariable: 'dockerPwd')) {
            sh 'docker login -u $dockerUser -p $dockerPwd'
        }
    }
}

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
