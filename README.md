In order to run this program you must install wget.


After running the application in intelliJ, enter the following on the command line:

* wget -r --no-parent "http://localhost:9998/css/framework/script" -O outputFile.zip

* Where css is the parameter for whether or not you'd like a basic css file with your scaffold.
** choose 'Y' or 'N' or leave blank
* Where framework is which reponsive framework you like included with your scaffold
** choose 'bootstrap' or 'foundation' or leave blank
* Where script is any scripting files you'd like with your scaffold,
** choose 'js', 'jQuery', 'jForm', or leave blank
* Where outputFile.zip is the name you'd like to give to your zipped folder
** choose anything you'd like.

example:  wget -r --no-parent "http://localhost:9998/Y/bootstrap/jForm" -O myFolder.zip


It's working now.  
Run the main method of scaffolding.java and try this url in the browser:

http://localhost:9998/y/bootstrap/jform

Give scaffolding.java a while to get going... like 45sec or so.

* I added in the apache commons-io-2.4.jar into the lib folder. You may have to add it in to the Libraries as well.
	--File, Project Structure, Libraries, in the "Classes" area, click Plus sign, select the commons-io-2.4.jar to add it to the list



11/10
Group meeting
* initial project logic, design diagrams, maps of possible file structures
* initial template files created
* java restful web service project created in IntelliJ
* Bootstrap and Foundation files researched and incorporated into file structure
* some beer drinking also incorporated into file structure

11/16
Group work time in class
* worked on logic translation into java
* worked on website files and blocks of code for client template
* wrote up user manual for utilizing the web service

11/17
* worked on logic in the FileCreator class
* successfully copying files and directories from the webSiteTemplateBoiler
 into a webSiteTemplateProduct folder (created at runtime)
* TODO: see comments in the FileCreator class; need to add to the queues 
 and read/write the index.html as based on the request options
	--index.html is already being created in the code, but not modified yet
* added in the apache commons-io-2.4.jar



Future group work
11/20 @ 8pm Skypen' it up
* TODO: 
	--index.html configuration
	--Replace template files with most recent files
	--incorporate the zip file process
	--decide on delivery method of zip file
	--javadoc
	--clean up/modularize code

Resource Links:
http://commons.apache.org/proper/commons-io/download_io.cgi
http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/FileUtils.html#copyDirectory%28java.io.File,%20java.io.File%29


* Index Output
    * open_head.txt
    * {{ css queue }}
    * close_head_open_body.txt
    * a) foundation_open_html.txt
    * b) bootstrap_open_html.txt
    * hello_world_html.txt
    * c) jform_html.txt
    * a) foundation_close_html.txt
    * b) bootstrap_close_html.html
    * {{ js queue }}
    * close_body.txt
    
11/22 
* Added Two ArrayLists
	* styleQueue
	* scriptQueue
	
* Added addToQueue method
	* pass method a file and an ArrayList - first the read file, second the queue ArrayList
	* addToQueue(File read, ArrayList<String> queue)
	
* Added printToFile method
	* pass method two files - first the read file, second the write file
	* printToFile(File read, File write)

11/28
* Added method to output index.html

11/29
* Added test files

11/30
* Added javadoc

12/12
* Refactored most of it and troubleshooting multiple lib/pkg/permission problems

12/13
* Finished refactoring pushed working code