pipeline {
    agent any
    tools {
        maven 'Maven3'
    }
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        DOCKER_HUB_REPO = 'ayanpushp/scientific-calculator'
    }
    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'github-pat',
                url: 'https://github.com/ayan-pushp/ScientificCalculator.git',
                branch: 'main'
            }
        }

        stage('Build Code') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test Code') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE_NAME} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-cred', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                    sh "docker tag ${DOCKER_IMAGE_NAME} ${DOCKER_HUB_REPO}:latest"
                    sh "docker push ${DOCKER_HUB_REPO}:latest"
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    sh 'docker rm -f calculator-container || true'
                    sh "docker run -d --name calculator-container ${DOCKER_HUB_REPO}:latest"
                }
            }
        }
    }
    post {
        success {
            echo 'Build and tests passed!'
        }
        failure {
            echo 'Build failed! Check the logs.'
        }
    }
}
