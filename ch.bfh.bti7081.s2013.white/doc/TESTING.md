# Testing

Please follow the [DEVELOPMENT](https://github.com/fabaff/ch.bfh.bti7081.s2013.white/blob/master/ch.bfh.bti7081.s2013.white/doc/DEVELOPMENT.md)
file for the general setup of your environment. This document only
covers the setup for testing.

## Database

Create two databases before you compile the application (do if your skip that task before): 

- mhcPms
- mhcPmsTest

Fill your database with some sample data from `sql-sample-data.sql`. This file is for 
Microsoft SQL Server 2012 and is not tested with Microsoft SQL Server 2008 or other
old releases. Be aware that those data can break the application and only manual 
removal from the databases can fix it. 

## Web server
Start your tomcat instance.

## Build
Depending on your own configuration or your perferred way do do this, compile
the application. E. g. `tomcat:redeploy` as target.

## Account
There are several user account presents after the data import mentioned
above. If you want to use the application with no data, a default user
is created automatically.

- Username: user
- Password: password

## Let's start

Launch your browser and point it to:

- [http://localhost:8080/mhc_pms/](http://localhost:8080/mhc_pms/) for normal usage
- [http://localhost:8080/mhc_pms/?debug](http://localhost:8080/mhc_pms/?debug) for the usage with debug information