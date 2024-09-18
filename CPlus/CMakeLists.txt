cmake_minimum_required(VERSION 3.22)

project(CPlus)

set(CMAKE_CXX_STANDARD 14)

#查找当前目录下的所有源文件并保存到DIR_SRCS变量里面
aux_source_directory(. DIR_SRCS)

add_executable(CPlus
        #        main.cpp
        base/MyTeacher.cpp base/MyTeacher.h
        base/Student.cpp base/Student.h
        ptr/PtrTest.cpp ptr/PtrTest.h ptr/SmallSmartPtr.cpp ptr/SmallSmartPtr.h
        templates/TemplateTest.cpp templates/TemplateTest.h
        extendsPolymorphic/Base.cpp extendsPolymorphic/Base.h
        memory/main.cpp memory/main.h
        array/CintTest.cpp
        main.cpp
        datastruct/Solution.cpp
        datastruct/algotithm/Algorithm.cpp
        datastruct/algotithm/Algorithm.h
        datastruct/typeconversion/TypeConver.cpp
        datastruct/typeconversion/TypeConver.h
        thread/threadTest.cpp
        base/newbase.cpp
)
