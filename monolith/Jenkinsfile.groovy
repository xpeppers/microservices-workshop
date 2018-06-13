node {
    def mvnHome = tool "Maven"

    stage("Checkout") {
        checkout scm
        sh "cd monolith"
    }
    stage("Unit tests") {
        sh "pwd"
        echo "RUNNING UNIT TESTS"
    }
    stage("Integration tests") {
        echo "RUNNING UNIT TESTS"
    }
    stage("Build artifact") {
        echo "BUILD ARTIFACT"
    }
    stage("UAT") {
        echo "RUNNING UAT"
    }
    stage("Store Artifact") {
        echo "STORE ARTIFACT"
    }
}