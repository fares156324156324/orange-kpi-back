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
        
        stage("Maven Clean"){
            steps {
                sh " mvn clean -e "
                
            }
        }

         stage("Maven Compile"){
            steps {
                sh " mvn compile -e "
                
            }
        }

        stage("Maven Install"){
            steps {
                sh " mvn install "
                
            }
        }
        }
   }
