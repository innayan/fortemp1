package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'ConfigFromTemplate'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("ConfigFromTemplate")) {
    expectSteps {
    }
    steps {
        insert(0) {
            script {
                name = "4"
                scriptContent = "4"
            }
        }
        insert(1) {
            script {
                name = "3 copy"
                scriptContent = "3"
            }
        }
        insert(2) {
            script {
                name = "2"
                scriptContent = "2"
            }
        }
        insert(3) {
            script {
                name = "1"
                scriptContent = "1"
            }
        }
        check(stepsOrder == arrayListOf<String>()) {
            "Unexpected build steps order: $stepsOrder"
        }
        stepsOrder = arrayListOf("RUNNER_4", "RUNNER_3", "RUNNER_2", "RUNNER_1")
    }
}
