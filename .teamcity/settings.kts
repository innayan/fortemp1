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

    template(TemplateForParent)

    subProject(Subproject2)
    subProject(Subproject1)
}

object ConfigFromTemplate : BuildType({
    templates(TemplateForParent)
    name = "config from template"
})

object TemplateForParent : Template({
    name = "template for parent"

    steps {
        script {
            name = "from template"
            id = "RUNNER_18"
            scriptContent = "echo template"
        }
    }
})


object Subproject1 : Project({
    name = "subproject1"

    buildType(Subproject1_Xxx)
})

object Subproject1_Xxx : BuildType({
    templates(TemplateForParent)
    name = "xxx"
})


object Subproject2 : Project({
    name = "subproject2"

    buildType(Subproject2_Yyy)
})

object Subproject2_Yyy : BuildType({
    templates(TemplateForParent)
    name = "yyy"
})
