pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // To run Maven on a Windows agent, use
                echo "Hello cucumber"
                 bat "mvn clean test"
            }

        }
    }
}
