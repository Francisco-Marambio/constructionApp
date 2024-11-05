pipeline {
    agent any
    
    environment {
        ARTIFACTORY_URL = 'http://localhost:8082/artifactory'  // URL base de tu servidor Artifactory
        ARTIFACTORY_REPO = 'libs-release-local'  // El repositorio de Artifactory donde se almacenará el JAR
        ARTIFACTORY_CRED = 'jfrog-plugin'  // ID de credenciales configuradas en Jenkins
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                // Clona el repositorio desde GitHub
                git url: 'https://github.com/Francisco-Marambio/constructionApp.git'
            }
        }

        stage('Compilar Proyecto') {
            steps {
                // Compila el proyecto Maven para generar el archivo JAR
                bat 'mvn clean install'
            }
        }

        stage('Publicar en Artifactory') {
            steps {
                script {
                    // Configuración para Artifactory
                    def server = Artifactory.server(env.ARTIFACTORY_URL)
                    def uploadSpec = """{
                        "files": [{
                            "pattern": "target/constructionApp-1.0.0-SNAPSHOT.jar",  // Cambia esto si tu nombre JAR es diferente
                            "target": "${env.ARTIFACTORY_REPO}/com/mynewconstruction/constructionApp/1.0.0-SNAPSHOT/"
                        }]
                    }"""
                    server.upload(uploadSpec, env.ARTIFACTORY_CRED)
                }
            }
        }
    }

    post {
        success {
            echo 'Construcción y publicación completadas con éxito.'
        }
        failure {
            echo 'Error en la construcción o publicación.'
        }
    }
}
