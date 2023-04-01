pipeline {

    agent any
    tools {
    maven "M2_HOME"
          }

    environment {
            NEXUS_VERSION = "nexus3"
            NEXUS_PROTOCOL = "http"
            NEXUS_URL = "http://192.168.43.110:8081"
            NEXUS_REPOSITORY = "ProjetDevopsNexusRepo"
            NEXUS_CREDENTIAL_ID = "NEXUS_CRED"
                 }

    stages {

            stage('Clone') {
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

            stage('Mvn-Build') {
                steps {
                    script{
                        sh """mvn -Dmaven.test.failure.ignore=true clean package"""
                    }
                }
            }

            stage('mvn-SONARQUBE') {
                 steps {
                    withSonarQubeEnv('sonarQube'){
                        sh """mvn sonar:sonar"""
                    }

                 }
            }

                        stage('Upload Jar To NEXUS') {

                                     steps {
                                    sh"""mvn deploy:deploy-file \
                                           -Dfile=/path/to/a/file \
                                           -Dpackaging=jar -DgroupId=<aGroup> -DartifactId=<anArtifactId> -Dversion=x.y.z-SNAPSHOT \
                                           -DrepositoryId=<repoId> \
                                           -Durl==https://192.168.43.110:8081/content/repositories/ProjetDevopsNexusRepo/"""
                                           }}
    }
}