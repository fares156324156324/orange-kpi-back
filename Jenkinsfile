pipeline {
    agent any
    tools { 
        maven 'maven-3.6.3'
    } 
    stages {
        
         stage('Maven Clean'){
            steps {
                sh " mvn clean  "
            }
        }
        
        

         stage("Maven Compile"){
            steps {
                sh " mvn compile -e "
                
            }
        }


        }
   }