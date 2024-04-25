package com.xzq.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class TbKotlinPlugin : Plugin<Project> {

    override fun apply(project: Project?) {
        println("this is a kotlin plugin...")
    }
}
