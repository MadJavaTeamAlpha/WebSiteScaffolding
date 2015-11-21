
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


Resource Links:
http://commons.apache.org/proper/commons-io/download_io.cgi
http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/FileUtils.html#copyDirectory%28java.io.File,%20java.io.File%29
