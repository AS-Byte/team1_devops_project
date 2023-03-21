pipeline {
    agent any
    tools {
    maven "M2_HOME"
    }

    environment {
            NEXUS_VERSION = "nexus3"
            NEXUS_PROTOCOL = "http"
            NEXUS_URL = "http://192.168.43.110/:8081"
            NEXUS_REPOSITORY = "ProjetDevops_NexusRepo"
            NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
        }

    stages {
        stage('Build') {
            steps {
                git branch: 'nada_branch',
                credentialsId: 'github',
                url: 'https://github.com/AS-Byte/team1_devops_project.git'
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

                stage('mvn-DEPLOY') {
                                    steps {

                                     sh """mvn deploy"""

                                    }
                                }

    }
}