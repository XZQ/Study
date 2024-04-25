package com.xzq.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * https://www.jianshu.com/p/822e44a5ea97
 *
 * ASM https://mp.weixin.qq.com/s/2TTXt5virr2vMNZRlzIT3w
 *
 * */
class PersonPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.extensions.add("person", com.xzq.bean.Person)

        project.task('printPerson') {
            group 'XZQ'
            doLast {
                println project.person
            }
        }
    }
}