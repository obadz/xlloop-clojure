Sample server to call Clojure functions from Excel using the XLLoop library - http://xlloop.sourceforge.net/

To build or run, you must first install the xlloop jar file in your maven repository:

    mvn install:install-file -Durl=file:repo -DgroupId=local -DartifactId=xlloop -Dversion=0.3.2 -Dpackaging=jar -Dfile=/path/to/xlloop-0.3.2.jar

To run the server:

    lein run

To build:

    lein compile && lein uberjar

...then you can ship off the jar file and run it like this:

    java -jar target/xlloop-clojure-0.1.0-SNAPSHOT-standalone.jar

Add your own functions in src/xlloop_clojure/funs.clj. Don't forget to provide the typehints at the top (in :gen-class :methods)

To install the XLLoop client, load *xlloop-0.3.2.xll* in your Excel addins. Create an *xlloop-0.3.2.ini* file in the same directory where the xll is with a single line:

    server=IP_OF_YOUR_SERVER:5454

*Really annoying quirk:* your client must EITHER be able to reverse DNS your server, OR your server must run a NetBIOS service. If you run Excel in a Windows virtualbox on a Linux machine (and run your server on the Linux side), the simplest way to fix this is to add

    IP_OF_YOUR_SERVER SOME_HOSTNAME

to
    
    C:\Windows\System32\Drivers\etc\hosts

 Failure to address this will cause XLLoop to fail with

    #Cannot connect to server
