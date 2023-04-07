pipeline {

    agent any
    tools {
    maven "M2_HOME"
          }

    environment {
            NEXUS_VERSION = "nexus3"
            NEXUS_PROTOCOL = "http"
            NEXUS_URL = "192.168.43.110:8081"
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
                    sh """mvn clean install"""
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
                                                       script{

                                                            pom = readMavenPom file: "pom.xml";
                                                           filesByGlob = findFiles(glob:"target/*.${pom.packaging}");
                                                           echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length}";
                                                           artifactPath = filesByGlob[0].path;
                                                           artifactExists = fileExists artifactPath;
                                                           if(artifactExists){
                                                                          echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging},version: ${pom.version}";
                                                                            nexusArtifactUploader(
                                                                                               nexusVersion:NEXUS_VERSION,
                                                                                               protocol:NEXUS_PROTOCOL,
                                                                                               nexusUrl:NEXUS_URL,
                                                                                               groupId: pom.groupId,
                                                                                               version:pom.version,
                                                                                               repository:NEXUS_REPOSITORY,
                                                                                               credentialsId:NEXUS_CREDENTIAL_ID,

                                                                                               artifacts :[
                                                                                                          [ artifactId: pom.artifactId,
                                                                                                            classifier: '',
                                                                                                            file: artifactPath,
                                                                                                            type: pom.packaging],
                                                                                                            [artifactId: pom.artifactId,
                                                                                                             classifier: '',
                                                                                                             file:"pom.xml",
                                                                                                             type: "pom"
                                                                                                             ]
                                                                                                           ]
                                                                                                           );
                                                                                                       }
                                                                                                       else{
                                                                                                       error "*** File: ${artifactPath},inexistant ";
                                                                                                       }

                                                          }
                                                   }

                                       }


                                stage('Build Docker image') {
                                    steps {
                                     sh 'docker build -t nadagharbi/devops-image .'
                                 }
                                }

                                 stage('Push image to hub'){
                                    steps{
                                        withCredentials([string(credentialsId:"dockerhub-pwd", variable: "dockerhubpwd")]){
                                            sh 'docker login -u nadagharbi -p ${dockerhubpwd}'
                                        }
                                        sh 'docker push nadagharbi/devops-image'
                                    }
                                 }

                                  stage('docker-compose'){
                                     steps {
                                        sh 'docker-compose up'
                                     }
                                  }






    }
}