package fi.polarshift.confluence.themes;

import com.atlassian.confluence.themes.*;
import com.atlassian.confluence.plugin.descriptor.ThemeModuleDescriptor;
import com.google.common.collect.ImmutableList;
import com.opensymphony.util.TextUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlainTheme implements Theme {

    private String pluginKey;
    private String moduleKey;
    private ColourScheme colourScheme;
    private List<ThemedDecorator> decorators;
    private Collection<ThemeResource> stylesheets;
    private Collection<ThemeResource> javascript;
    private String bodyClass;
    private String topNavLocation;
    private boolean hasSpaceSideBar;
    public static final String DEFAULT_PLUGIN_KEY = "com.atlassian.confluence.themes.default";
    public static final String STYLESHEET_NAME = "default-theme.css";
    public static final String STYLESHEET_MODULE_KEY = DEFAULT_PLUGIN_KEY + ":styles";

    // Corresponds with the stylesheet declared in default-theme.xml.
    public static final String TOP_NAV_LOCATION = "";

    private static Theme instance = new PlainTheme();

    public ColourScheme getColourScheme() {
        return colourScheme;
    }

    public ThemedDecorator getDecorator(String path) {
        if (TextUtils.stringSet(path)) {
		for (ThemedDecorator decorator : decorators) {
			if (decorator.getName().equals(path))
			    return decorator;
		    }
	    }
        return null;
    }

    public Collection<? extends ThemeResource> getStylesheets() {
        return stylesheets;
    }

    public Collection<? extends ThemeResource> getJavascript() {
        return Collections.emptyList();
    }
    /*
    public Collection<? extends ThemeResource> getStylesheets()
    {
        return Collections.singletonList(new ClasspathThemeStylesheet(STYLESHEET_MODULE_KEY, STYLESHEET_NAME, "/includes/css/" + STYLESHEET_NAME));
    }

    public Collection<? extends ThemeResource> getJavascript()
    {
        return Collections.emptyList();
    }
    */
    public String getPluginKey() {
        return pluginKey;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public boolean isIncludeClassicStyles() {
        return false;
    }

    public static Theme getInstance() {
        return instance;
    }

    @Override
	public boolean isDisableSitemesh() {
        return false;
    }

    @Override
	public String getXworkVelocityPath(String packageName, String actionName, String result, String template) {
        return template;
    }

    public String getBodyClass() {
        return getModuleKey();
    }

    @Override
	public String getTopNavLocation() {
        return TOP_NAV_LOCATION;
    }

    @Override
	public boolean hasSpaceSideBar() {
        return true;
    }
    public void init(ThemeModuleDescriptor moduleDescriptor) {
        this.pluginKey = moduleDescriptor.getPluginKey();
        this.moduleKey = moduleDescriptor.getKey();
        this.colourScheme = moduleDescriptor.getColourScheme();
        this.decorators = moduleDescriptor.getLayouts();
        this.stylesheets = ImmutableList.copyOf(moduleDescriptor.getStylesheets());
        this.javascript = ImmutableList.copyOf(moduleDescriptor.getJavascript());
        this.bodyClass = moduleDescriptor.getBodyClass() != null ?
            moduleDescriptor.getBodyClass() : moduleKey;
        this.topNavLocation = moduleDescriptor.getTopNavLocation() != null ?
            moduleDescriptor.getTopNavLocation() : DefaultTheme.TOP_NAV_LOCATION;
        this.hasSpaceSideBar = moduleDescriptor.hasSpaceSideBar();
    }
}
