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
