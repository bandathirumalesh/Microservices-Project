pipeline {
    agent any

    stages {

        stage('External Config Server') {
            steps {
                dir('BootMSProj04-ConfigServer-ExternalConfigServer') {
                    sh 'mvn clean package'
                    sh 'pkill -f ExternalConfig || true'
                    sh 'nohup java -jar target/*.jar > external-config.log 2>&1 &'
                }
            }
        }

        stage('Config Server') {
            steps {
                dir('BootMSProj04-ConfigServer') {
                    sh 'mvn clean package'
                    sh 'pkill -f ConfigServer || true'
                    sh 'nohup java -jar target/*.jar > config.log 2>&1 &'
                }
            }
        }

        stage('Eureka Server') {
            steps {
                dir('BootMSProj04-EurekaServer') {
                    sh 'mvn clean package'
                    sh 'pkill -f EurekaServer || true'
                    sh 'nohup java -jar target/*.jar > eureka.log 2>&1 &'
                }
            }
        }

        stage('Billing Service (Provider)') {
            steps {
                dir('BootMSProj04-ProviderMS-BillinServiceAPI') {
                    sh 'mvn clean package'
                    sh 'pkill -f BillinService || true'
                    sh 'nohup java -jar target/*.jar > billing.log 2>&1 &'
                }
            }
        }

        stage('Shopping Service (Consumer)') {
            steps {
                dir('BootMSProj04-ConsumerMs-ShoppingAPI') {
                    sh 'mvn clean package'
                    sh 'pkill -f Shopping || true'
                    sh 'nohup java -jar target/*.jar > shopping.log 2>&1 &'
                }
            }
        }
    }
}
