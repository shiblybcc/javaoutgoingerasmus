package com.example.outgoing.Configuration;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

@RewriteConfiguration
public class FacesRewriteConfigurationProvider extends HttpConfigurationProvider {

    @Override
    public int priority()
    {
        return 10;
    }

    @Override
    public Configuration getConfiguration(final ServletContext context)
    {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/").to("/views/index.jsf"))
                .addRule(Join.path("/index").to("/views/index.jsf"))
                .addRule(Join.path("/index.xhtml").to("/views/index.jsf"))

                .addRule(Join.path("/stammdatens").to("/views/stammdaten/index.jsf"))
                .addRule(Join.path("/stammdatens/new").to("/views/stammdaten/new.jsf"))
                .addRule(Join.path("/stammdatens/test").to("/views/stammdaten/test.jsf"))
                .addRule(Join.path("/stammdatens/{id}").to("/views/stammdaten/show.jsf"))

                .addRule(Join.path("/languages").to("/views/language/index.jsf"))
                .addRule(Join.path("/languages/new").to("/views/language/new.jsf"))
                .addRule(Join.path("/languages/{id}").to("/views/language/show.jsf"))

                .addRule(Join.path("/languagelevels").to("/views/languagelevel/index.jsf"))
                .addRule(Join.path("/languagelevels/new").to("/views/languagelevel/new.jsf"))
                .addRule(Join.path("/languagelevels/{id}").to("/views/languagelevel/show.jsf"))

                .addRule(Join.path("/login").to("/views/login.jsf"))
                .addRule(Join.path("/logout").to("/views/logout.jsf"))
                .addRule(Join.path("/users").to("/views/user/users.jsf"))
                .addRule(Join.path("/users/changePassword").to("/views/user/changePassword.jsf"))
                .addRule(Join.path("/users/profile").to("/views/user/profile.jsf"))
                .addRule(Join.path("/register").to("/views/register.jsf"));
    }
}
