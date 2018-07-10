node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/zuhlkef10/f10api-demo.git'
      // Get the Maven tool.
      mvnHome = '/usr/share/maven'
   }
   stage('Build') {
      // Run the maven build
      sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
  stage('Docker Build') {
         sh 'sudo docker build -t zuhlke/f10api-demo:latest .'
   }
}