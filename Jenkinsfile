
pipeline {
  agent any

  environment {
    // SonarQube token from Jenkins credentials (secret text)
    SONAR_TOKEN = credentials('sonarqube')
  }

  tools {
    maven 'Maven'  // This should match the Maven tool name configured in Jenkins
  }

  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/Darshanm416/sonarqube-project.git'
      }
    }

    stage('Build & Test with Coverage') {
      steps {
        sh 'mvn clean verify'
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SonarQube') {
          sh """
            mvn sonar:sonar \
              -Dsonar.projectKey=sonarqube-project \
              -Dsonar.login=$SONAR_TOKEN
          """
        }
      }
    }

    stage('Quality Gate') {
      steps {
        timeout(time: 2, unit: 'MINUTES') {
          waitForQualityGate abortPipeline: true
        }
      }
    }
  }

  post {
    success {
      echo 'Pipeline completed successfully ✅'
    }
    failure {
      echo 'Pipeline failed ❌'
    }
  }
}
echo "my name is $name"
