# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2020.2.4\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2020.2.4\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\XZQ\CLionProjects\CStudy

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\XZQ\CLionProjects\CStudy\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/CStudy.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/CStudy.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/CStudy.dir/flags.make

CMakeFiles/CStudy.dir/test1.c.obj: CMakeFiles/CStudy.dir/flags.make
CMakeFiles/CStudy.dir/test1.c.obj: ../test1.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\XZQ\CLionProjects\CStudy\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/CStudy.dir/test1.c.obj"
	C:\mingw64\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\CStudy.dir\test1.c.obj   -c C:\Users\XZQ\CLionProjects\CStudy\test1.c

CMakeFiles/CStudy.dir/test1.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/CStudy.dir/test1.c.i"
	C:\mingw64\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E C:\Users\XZQ\CLionProjects\CStudy\test1.c > CMakeFiles\CStudy.dir\test1.c.i

CMakeFiles/CStudy.dir/test1.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/CStudy.dir/test1.c.s"
	C:\mingw64\mingw64\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S C:\Users\XZQ\CLionProjects\CStudy\test1.c -o CMakeFiles\CStudy.dir\test1.c.s

# Object files for target CStudy
CStudy_OBJECTS = \
"CMakeFiles/CStudy.dir/test1.c.obj"

# External object files for target CStudy
CStudy_EXTERNAL_OBJECTS =

CStudy.exe: CMakeFiles/CStudy.dir/test1.c.obj
CStudy.exe: CMakeFiles/CStudy.dir/build.make
CStudy.exe: CMakeFiles/CStudy.dir/linklibs.rsp
CStudy.exe: CMakeFiles/CStudy.dir/objects1.rsp
CStudy.exe: CMakeFiles/CStudy.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\XZQ\CLionProjects\CStudy\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable CStudy.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\CStudy.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/CStudy.dir/build: CStudy.exe

.PHONY : CMakeFiles/CStudy.dir/build

CMakeFiles/CStudy.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\CStudy.dir\cmake_clean.cmake
.PHONY : CMakeFiles/CStudy.dir/clean

CMakeFiles/CStudy.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\XZQ\CLionProjects\CStudy C:\Users\XZQ\CLionProjects\CStudy C:\Users\XZQ\CLionProjects\CStudy\cmake-build-debug C:\Users\XZQ\CLionProjects\CStudy\cmake-build-debug C:\Users\XZQ\CLionProjects\CStudy\cmake-build-debug\CMakeFiles\CStudy.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/CStudy.dir/depend

