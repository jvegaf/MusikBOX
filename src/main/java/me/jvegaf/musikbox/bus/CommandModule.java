package me.jvegaf.musikbox.bus;

import com.google.inject.AbstractModule;
import me.jvegaf.musikbox.services.reporter.ReporterModule;
import me.jvegaf.musikbox.services.tagger.TaggerModule;

public final class CommandModule extends AbstractModule {
    @Override
    protected void configure() {
        install( new TaggerModule() );
        install( new ReporterModule() );
        bind(CommandBus.class).to(CommandHandler.class);
    }
}
