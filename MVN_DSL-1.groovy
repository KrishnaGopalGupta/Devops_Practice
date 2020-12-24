job('MVN-DSL-1'){
    description("This is my first DSL script $(new Date()) to creating the Jobs")
    scm{

        git('https://github.com/KrishnaGopalGupta/Devops_Practice.git','MVN-1')
    }

    triggers{
        scm('* * * * *')
    }

    steps{

         maven('clean package','pom.xml')
    }

    publishers {
        archiveArtifacts('**/*.jar')
    }
}