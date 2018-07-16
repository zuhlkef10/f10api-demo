#!groovy

node {
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
    stage('Docker Stop and Remove Containers') {
        sh "docker ps  | grep f10api-demo | awk '{print \$1}'  | xargs --no-run-if-empty docker stop"
        sh "docker ps -a | grep f10api-demo | awk '{print \$1}'  | xargs --no-run-if-empty docker rm"
    }
    stage('Docker Bank API Build') {
        sh 'docker build --tag=zuhlke/com.zuhlke.f10.bank-api:dev com.zuhlke.f10.bank'
    }
    stage('Docker Account API Build') {
        sh 'docker build --tag=zuhlke/com.zuhlke.f10.account-api:dev com.zuhlke.f10.account'
    }
    stage('Docker Transaction API Build') {
        sh 'docker build --tag=zuhlke/com.zuhlke.f10.transaction-api:dev com.zuhlke.f10.transaction'
    }
    stage('Docker Customer API Build') {
        sh 'docker build --tag=zuhlke/com.zuhlke.f10.customer-api:dev com.zuhlke.f10.customer'
    }
    stage('Docker Deploy') {
        sh 'docker-compose up -d'
    }
}