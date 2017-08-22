package test.project1;

import io.vertx.core.*;
import io.vertx.core.http.*;
import io.vertx.ext.web.*;

public class Server extends AbstractVerticle {

	private Router router;

	@Override
	public void start(Future<Void> fut) throws Exception {
		router = Router.router(vertx);
		router.route("/").handler(routingContext -> {
			HttpServerResponse response = routingContext
				.response();
			response.putHeader("content-type", "text/html")
				.end("<h1>Hello universe</h1>");
		});

		vertx.createHttpServer().requestHandler(router::accept)
			.listen(
				config().getInteger("http.port", 8080),
				result -> {
					if (result.succeeded()) {
						fut.complete();
					} else {
						fut.fail(result.cause());
					}
				});
	}

}
