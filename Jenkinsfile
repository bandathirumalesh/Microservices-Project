pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages {

        stage('Checkout') {
            steps {
                dir('C:/jenkins/workspace/microservices') {
                    checkout scm
                }
            }
        }

        stage('External Config Server') {
            steps {
                dir('C:/jenkins/workspace/microservices/BootMSProj04-ConfigServer-ExternalConfigServer') {
                    bat 'mvn clean package'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }

        stage('Config Server') {
            steps {
                dir('C:/jenkins/workspace/microservices/BootMSProj04-ConfigServer') {
                    bat 'mvn clean package'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }

        stage('Eureka Server') {
            steps {
                dir('C:/jenkins/workspace/microservices/BootMSProj04-EurekaServer') {
                    bat 'mvn clean package'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }

        stage('Billing Service') {
            steps {
                dir('C:/jenkins/workspace/microservices/BootMSProj04-ProviderMS-BillinServiceAPI') {
                    bat 'mvn clean package'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }

        stage('Shopping Service') {
            steps {
                dir('C:/jenkins/workspace/microservices/BootMSProj04-ConsumerMs-ShoppingAPI') {
                    bat 'mvn clean package'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }
    }
}
