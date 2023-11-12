pipeline {
    agent {
        label 'main'
    }

    options { 
        timestamps ()
    }

    stages {
        stage('Build and Test') {
            
            steps {
                git branch: 'main', url: 'https://github.com/shah-shivam-410/web-test-framework.git'
                bat '''
                    set JAVA_HOME=C:\\Program Files\\Java\\jdk-11.0.14
                    call ./mvnw.cmd -B clean compile test
                    '''
            }

            post {
                success {
                    testNG reportFilenamePattern: '**/target/surefire-reports/testng-results.xml'
                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'extent-reports', reportFiles: 'AutomationReport.html', reportName: 'HTML Report', reportTitles: 'AutomationReport', useWrapperFileDirectly: true])
                }
            }
        }
    }
}
