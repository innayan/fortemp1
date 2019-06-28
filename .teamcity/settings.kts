import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.1"

project {

    buildType(ConfigFromTemplate)

    subProject(Subproject2)
    subProject(Subproject1)
}

object ConfigFromTemplate : BuildType({
    name = "config from template"

    steps {
        script {
            name = "2"
            scriptContent = "2"
        }
        script {
            name = "3 copy"
            scriptContent = "3"
        }
        script {
            name = "1"
            scriptContent = "1"
        }
        script {
            name = "4"
            scriptContent = "4"
        }
    }
})


object Subproject1 : Project({
    name = "subproject1"

    buildType(Subproject1_Subpro1config)
})

object Subproject1_Subpro1config : BuildType({
    name = "subpro1config"
})


object Subproject2 : Project({
    name = "subproject2"

    buildType(Subproject2_Subpro2config)
})

object Subproject2_Subpro2config : BuildType({
    name = "subpro2config"
})
