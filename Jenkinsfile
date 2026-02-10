pipeline {
    agent {
        node {
            customWorkspace 'C:/jenkins/workspace/microservices'
        }
    }

    stages {

        stage('External Config Server') {
            steps {
                dir('BootMSProj04-ConfigServer-ExternalConfigServer') {
                    bat 'mvn clean package'
                    bat 'taskkill /F /IM java.exe /T || exit 0'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }

        stage('Config Server') {
            steps {
                dir('BootMSProj04-ConfigServer') {
                    bat 'mvn clean package'
                    bat 'taskkill /F /IM java.exe /T || exit 0'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }

        stage('Eureka Server') {
            steps {
                dir('BootMSProj04-EurekaServer') {
                    bat 'mvn clean package'
                    bat 'taskkill /F /IM java.exe /T || exit 0'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }

        stage('Billing Service') {
            steps {
                dir('BootMSProj04-ProviderMS-BillinServiceAPI') {
                    bat 'mvn clean package'
                    bat 'taskkill /F /IM java.exe /T || exit 0'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }

        stage('Shopping Service') {
            steps {
                dir('BootMSProj04-ConsumerMs-ShoppingAPI') {
                    bat 'mvn clean package'
                    bat 'taskkill /F /IM java.exe /T || exit 0'
                    bat 'start /B java -jar target\\*.jar'
                }
            }
        }
    }
}
