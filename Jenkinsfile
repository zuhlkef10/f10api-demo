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
    stage('Docker Stop and Remove Containers') {
        sh "docker ps  | grep f10api-demo | awk '{print \$1}'  | xargs --no-run-if-empty docker stop"
        sh "docker ps -a | grep f10api-demo | awk '{print \$1}'  | xargs --no-run-if-empty docker rm"
        sh "docker ps  | grep mongo | awk '{print \$1}'  | xargs --no-run-if-empty docker stop"
        sh "docker ps -a | grep mongo | awk '{print \$1}'  | xargs --no-run-if-empty docker rm"
    }
    stage('Docker Core-Bank API Build') {
        sh 'docker build --tag=zuhlke/core-bank-api:dev core-bank'
    }
    stage('Docker Crowd-Funding API Build') {
        sh 'docker build --tag=zuhlke/crowd-funding-api:dev crowd-funding'
    }
    stage('Docker Robot-Advisor API Build') {
        sh 'docker build --tag=zuhlke/robot-advisor-api:dev robot-advisor'
    }
    stage('Docker Crowd Lending API Build') {
        sh 'docker build --tag=zuhlke/crowd-lending-api:dev crowd-lending'
    }
    stage('Docker Insurance API Build') {
        sh 'docker build --tag=zuhlke/insurance-api:dev insurance'
    }
    stage('Docker Deploy') {
        sh 'docker-compose up -d'
    }
}