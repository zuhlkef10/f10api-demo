#!groovy

pipeline  {
   agent none
   stages {
     stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      steps{
        node('master'){
          git 'https://github.com/zuhlkef10/f10api-demo.git'
        }
      }
    }
    stage('Build') {
      // Run the maven build
      steps{
         node('master'){
          sh "'/usr/share/maven/bin/mvn' -Dmaven.test.failure.ignore clean install"
         }
      }
    }
    stage('Results') {
      steps{
          node('master'){
           junit '**/target/surefire-reports/TEST-*.xml'
          }
       }
   }
   stage('Docker Build') {
      agent any
        steps {
         node('master'){
           sh 'docker build -t zuhlke/f10api-demo:latest .'
          }
        }
   }
  }
}