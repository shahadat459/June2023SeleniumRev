pipeline{
    agent any 
    
    stages{
        
        stage("Build"){
            steps{
                echo("build the project")
            }
        }
        
         stage("Deploy to dev"){
            steps{
                echo("deploying on dev env")
            }
        }
         stage("run rgressin testcases"){
            steps{
                echo("run rgressin testcases")
            }
        }
         stage("Run UTs"){
            steps{
                echo("Running UTs")
            }
        }
         stage("stage env"){
            steps{
                echo("deploying to stage env")
            }
        }
         stage("Run sanity test cases"){
            steps{
                echo("Run sanity test cases")
            }
        }
         stage("Deploy to prod"){
            steps{
                echo("deploying to prod environment")
            }
        }
    }
    
    
        
}