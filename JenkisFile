pipeline {
    agent any
    tools {
    maven "M2_HOME"
    }

    stages {
        stage('Build') {
            steps {
                git branch: 'master',
                credentialsId: 'github',
                url: 'https://github.com/NadaGharbi/testProject.git'
            }
        }

        stage('MVN-CLEAN') {
                            steps {
                                sh """mvn clean"""
                            }
                        }

       stage('MVN-COMPILE') {
                  steps {
                                 sh """mvn compile"""
                                       }
                                       }

        stage('mvn-SONARQUBE') {
                    steps {
                    withSonarQubeEnv('sonarQube'){
                     sh """mvn sonar:sonar"""
                    }

                    }
                }

    }
}