package foo.example;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.struts2.Struts2GuicePluginModule;

public class ExampleListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new Struts2GuicePluginModule(),
				new ServletModule() {
					@Override
					protected void configureServlets() {
						bind(StrutsPrepareAndExecuteFilter.class).in(
								Singleton.class);
						filter("/*").through(
								StrutsPrepareAndExecuteFilter.class);
						//bind(Service.class).to(ServiceImpl.class);
					}
				});

	}

}
