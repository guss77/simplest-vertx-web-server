package test.project1;

import io.vertx.core.*;
import io.vertx.core.http.*;
import io.vertx.ext.web.*;

public class Server extends AbstractVerticle {

	private Router router;

	@Override
	public void start(Promise<Void> fut) throws Exception {
		router = Router.router(vertx);
		router.route("/").handler(routingContext -> {
			HttpServerResponse response = routingContext
				.response();
			response.putHeader("content-type", "text/html")
				.end("<h1>Hello world</h1>");
		});

		vertx.createHttpServer().requestHandler(router)
			.listen(
				config().getInteger("http.port", 8080), result -> fut.handle(result.mapEmpty()));
	}

}
