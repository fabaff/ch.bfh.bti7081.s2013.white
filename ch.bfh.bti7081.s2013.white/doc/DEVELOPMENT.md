# Development

## Eclipse

### Java

The used version is **JRE 1.7**.

Check if you are used this version: *Project* -> *Properties* -> *Java Build Path* -> *Libraries* set JRE System Library to **JavaSE-1.7 (jre7)**

### Data Source Explorer 

Add a **Database Connection** to your local SQL Server instance.

- Drivers: Microsoft SQL Server 2008 JDBC Driver
- Database: mhcPms
- Host: localhost
- Port number: 55978
- User name: pkuser
- Password: soed2013
- Connection URI: jdbc:sqlserver://localhost:55978;databaseName=mhcPms

Check `Connect every time the workbench is started` if wished. 

## Libraries

This section covers special dependencies which are not tracked by maven.

### Persistence

The project uses the `Microsoft JDBC Driver 4.0 for SQL Server` as connector.

```bash
<dependency>
	<groupId>org.eclipse.persistence</groupId>
	<artifactId>eclipselink</artifactId>
	<version>2.5.0</version>
</dependency>
```

Make sure that maven is setup correctly and able to run from a given directory.

```bash
mvn install:install-file -Dfile=c:\path\to\sqljdbc4.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=3.0 -Dpackaging=jar
```

More details are available in the `persistence.xml` file.

- Connector URI: jdbc:sqlserver://localhost:55978;databaseName=mhcPms
- Driver: com.microsoft.sqlserver.jdbc.SQLServerDriver

## SQL Server

Default installation of a Microsoft SQL Server 2012 (2008 should work too). Please adjust the defaults to the values mentioned below: 

- Port: 55978
- User: pkuser (Additional Server role: dbcreator, User Mapping: mhcPms)
- Password: soed2013
- Database name: mhcPms (must exist)

Check if `SQL Server and Windows Authentication mode` is set for your SQL Server. 

## Documentation

The documentation is placed in the **javadoc** folder. Please make sure that you exclude this folder in your `.gitignore`.