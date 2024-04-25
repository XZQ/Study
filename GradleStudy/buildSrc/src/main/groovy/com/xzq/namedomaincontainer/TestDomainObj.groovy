package com.xzq.namedomaincontainer

import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

/**
 * https://juejin.im/post/6844903838290296846
 */
class TestDomainObj {

    //必须定义一个 name 属性，并且这个属性值初始化以后不要修改
    String name

    String msg

    //构造函数必须有一个 name 参数
    public TestDomainObj(String name) {
        this.name = name
    }

    void msg(String msg) {
        this.msg = msg
    }

    String toString() {
        return "name = ${name}, msg = ${msg}"
    }
}


//创建一个扩展
class TestExtension {

    //定义一个 NamedDomainObjectContainer 属性
    NamedDomainObjectContainer<TestDomainObj> testDomains

    public TestExtension(Project project) {
        //通过 project.container(...) 方法创建 NamedDomainObjectContainer
        NamedDomainObjectContainer<TestDomainObj> domainObjs = project.container(TestDomainObj)
        testDomains = domainObjs
    }

    //让其支持 Gradle DSL 语法
    void testDomain(Action<NamedDomainObjectContainer<TestDomainObj>> action) {
        action.execute(testDomains)
    }

    void test() {
        //遍历命名领域对象容器，打印出所有的领域对象值
        testDomains.all { data ->
            println data
        }
    }
}
