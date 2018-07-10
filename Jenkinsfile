#!groovy

node  {
    stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
          git 'https://github.com/zuhlkef10/f10api-demo.git'
    }
    stage('Build') {
      // Run the maven build
          sh "'/usr/share/maven/bin/mvn' -Dmaven.test.failure.ignore clean install"
    }
    stage('Results') {
          junit '**/target/surefire-reports/TEST-*.xml'
   }
   stage('Docker Build') {
           sh 'docker build -t zuhlke/f10api-demo:latest .'
   }
   stage('Docker Deploy') {
           sh 'docker run -d -p 9090:9090  zuhlke/f10api-demo:latest'
   }
}