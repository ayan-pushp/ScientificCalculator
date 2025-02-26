pipeline {
    agent any
    tools {
            maven 'Maven3' // Ensure this matches the name in Jenkins Maven settings
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
                        sh 'docker build -t scientific-calculator .'
                    }
                }

                stage('Run Docker Container') {
                    steps {
                        script {
                            sh 'docker rm -f calculator-container || true'
                            sh 'docker run -d --name calculator-container scientific-calculator'
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
