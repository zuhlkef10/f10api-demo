#!groovy

pipeline  {
   stages('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      steps{
        git 'https://github.com/zuhlkef10/f10api-demo.git'
      }
   }
   stages('Build') {
      // Run the maven build
      steps{
        mvnHome = '/usr/share/maven'
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean install"
      }
   }
   stages('Results') {
      steps{
        junit '**/target/surefire-reports/TEST-*.xml'
        archive 'target/*.jar'
       }
   }
  stages('Docker Build') {
      agent any
        steps {
         sh 'docker build -t zuhlke/f10api-demo:latest .'
        }
   }
}