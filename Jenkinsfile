#!groovy

pipeline  {
   agent none
   stages {
     stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      steps{
        node('git command'){
          git 'https://github.com/zuhlkef10/f10api-demo.git'
        }
      }
    }
    stage('Build') {
      // Run the maven build
      steps{
        sh "'/usr/share/maven/bin/mvn' -Dmaven.test.failure.ignore clean install"
      }
    }
    stage('Results') {
      steps{
        junit '**/target/surefire-reports/TEST-*.xml'
       }
   }
   stage('Docker Build') {
      agent any
        steps {
         sh 'docker build -t zuhlke/f10api-demo:latest .'
        }
   }
  }
}