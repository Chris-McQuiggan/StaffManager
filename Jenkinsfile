pipeline{
        agent any
        stages{
		stage('---setup---'){
                        steps{
                                sh "sudo rm -rf /var/lib/wildfly-10.1.0.Final/standalone/deployments/*"
                        }
                }				
                stage('---clean---'){
                        steps{
                                sh "mvn clean"
                        }
                }
                stage('--test--'){
                        steps{
                                sh "mvn test"
                        }
                }
                stage('--package--'){
                        steps{
                                sh "mvn package"
                        }
                }
		stage('--sonar--'){
                        steps{
                                sh "mvn sonar:sonar"
                        }
                }
		stage('--verify--'){
                        steps{
                                sh "mvn verify"
                        }
                }
		stage('--surefire--'){
                        steps{
                                sh "mvn surefire-report:report"
				
                        }
                }
		stage('--deploy--'){
                        steps{
                                sh "cd /"
				sh "pwd"
				sh "sudo cp /var/lib/jenkins/workspace/${JOB_NAME}/target/StaffManager.war /var/lib/wildfly-10.1.0.Final/standalone/deployments/"
                        }
		}
		stage('--email--'){
                        steps{
                                emailext attachLog: true, attachmentsPattern: 'target/site/jacoco/index.html, target/site/surefire-report.html', body: '', subject: '', to: 'jenkins.server.project@gmail.com'
                	}
        	}
	}
}
