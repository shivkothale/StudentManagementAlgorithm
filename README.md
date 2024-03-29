# CSX42: Assignment 1
## Name: Shivkumar Subhash Kothale

# No slack days used
-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesMgmt/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesMgmt/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesMgmt/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:  ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=coursePrefs.txt -Darg1=courseInfo.txt -Darg2=regResults.txt -Darg3=regConflicts.txt -Darg4=errorLog.txt

## Replace <fileName.txt> with real file names. For example, if the files are available in the path,
## you can run it in the following manner:

ant -buildfile studentCoursesMgmt/src/build.xml run -Darg0=input_file.txt -Darg1=delete_file.txt -Darg2=output1_file.txt -Darg3=output2_file.txt -Darg4=output3_file.txt

Note: Arguments accept the absolute path of the files.

-----------------------------------------------------------------------
## Description:
    # Justification of the Data Structures used 
        1. Map used for storing courses data 
            --key->Course Name/Character
            --Value->Array of capacity and timing

            Reason- 
            If I dont use the Map then->
                if we are reading the student pref file line by line and then processing the courses then 
                1. let number of courses be 'C'
                2. let number of lines in student pref file be 'N'
                3. let number of preferences be 'M'
                So the time complexity would be O(C*L*M).

            If I use the map then->
                Retrival and insertion would be in O(1)
                So the operation of assigning the course would be O(C*N*M)-->O(1*N*P)-->O(N*M).


        2. For storing each line of Student I have used a character array--> char[].
        3. Set->used to store the timings of the courses
            -it will be showing the time clashes for the courses.
        4. List->used to store the List of Student Objects and print them.
        
    # Brief Description of WorkFlow
        -Driver class will have the input and output files-
        -Driver will call the FileProcessor to get the courses
        -Driver will call the StudentManagement class that take filepath and courses
        -StudentManagement class will internally assign the courses by using a private method named manage
        -manage method will run through each preference and check for 3 conditions
            1. If the preference is present in the course map
                -if no then check for next course
            2. If yes, then is there capacity in the prefered course
                -if no then check for next preference and print the error in errorLog.txt file
            3. if yes, then check if the timing clashes with other assigned course timings.
                -if time clashes then check for another preference and print the conflict in regConflicts.txt file
        -Finally all the data of student will be mapped to the Student class [id, courses allocated, satisfaction rating]
        -add the student to result list from Results class
        -Print the Results.txt file
        -Print the regConflicts.txt file
        -Print the errLog.txt file

    # Citations of external code used 
        FileWriter writer=new FileWriter();
        Source-https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html





-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 28/09/2023 


