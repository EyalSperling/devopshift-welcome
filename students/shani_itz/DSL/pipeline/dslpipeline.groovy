job('NodeJS example') { // Job NAME
    scm { // Configure Source control management 
        git('https://github.com/yanivomc/devopshift-welcome.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('shani')
            node / gitConfigEmail('shani@gmail.com')
        }
    }
    triggers { // Configure when to check for changes 
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps { // what steps to take 
        shell("npm install")
    }
}
pipelineJob('projectx') { // broken branch config
 def repo = 'https://github.com/yanivomc/devopshift-welcome.git'


 triggers {
   scm('H/5 * * * *')
 }
 description("My Pipeline 2")


 definition {
   cpsScm {
     scm {
       git {
         remote { url(repo) }
         branches('elbit/jenkinsdec26') // this is fine
         scriptPath('students/shani_itz/DSL/pipeline/JenkinsFile')
         extensions { }  // required as otherwise it may try to tag the repo, which you may not want
       }
     }
   }
 }
}