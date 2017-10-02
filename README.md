# The Simplest Vert.x-web Server

This is a sample project to show the minimal deployment of a `vertx-web` based routing
HTTP server.

To run:

```
mvn org.codehaus.mojo:exec-maven-plugin:exec -Dexec.executable=java \
	-Dexec.args="-cp %classpath io.vertx.core.Launcher run test.project1.Server"
```

To test:

```
curl http://localhost:8080/
```
