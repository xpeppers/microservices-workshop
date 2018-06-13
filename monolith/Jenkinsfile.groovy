node {
    def mvnHome = tool "Maven"

    stage("Checkout") {
        checkout scm
    }
    dir("monolith") {
        stage("Unit tests") {
            echo "RUNNING UNIT TESTS"
        }
        stage("Integration tests") {
            echo "RUNNING UNIT TESTS"
        }
        stage("Build artifact") {
            sh "${mvnHome}/bin/mvn clean package"
            sh "docker build -t joebew42/commerce.monolith ."
        }
        stage("UAT") {
            echo "RUNNING UAT"
        }
        stage("Store Artifact") {
            archiveArtifacts artifacts: 'target/monolith-1.0-SNAPSHOT-jar-with-dependencies.jar', fingerprint: true
            echo "TODO: Push to Docker Registry ..."
        }
    }
}