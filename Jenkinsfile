pipeline {
    agent any
    tools { 
        maven 'maven-3.6.3'
    } 
    stages {
        
         stage('Maven Package'){
            steps {
                sh " mvn -version "
                sh " java -version "
                sh " mvn package -e "
            }
        }
        
        stage("Maven Start"){
            steps {
                sh''
                sh "java -jar target/demo-0.0.1-SNAPSHOT.jar"
                
            }
        }

         stage("Maven Compile"){
            steps {
                sh " mvn compile -e "
                
            }
        }


        }
   }