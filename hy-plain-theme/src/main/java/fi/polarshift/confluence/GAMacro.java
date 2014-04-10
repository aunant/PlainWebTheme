package fi.polarshift.confluence;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.content.render.xhtml.XhtmlException;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.xhtml.api.MacroDefinition;
import com.atlassian.confluence.xhtml.api.MacroDefinitionHandler;
import com.atlassian.confluence.xhtml.api.XhtmlContent;
import com.atlassian.plugin.webresource.WebResourceManager;
import java.util.Map;

public class GAMacro implements Macro {

    private static final String UAID = "tracking-code";
    private final WebResourceManager webResourceManager;

    public GAMacro(WebResourceManager webResourceManager) {
        this.webResourceManager = webResourceManager;
    }
    @Override
    public String execute(Map<String, String> parameters, String bodyContent, 
                          ConversionContext conversionContext) throws MacroExecutionException {
	String uaid = null;
	if(isValidParam(parameters.get(UAID)))
	    uaid = parameters.get(UAID);
	else
	    return "";
	/*
	if ("mobile".equals(conversionContext.getPropertyAsString("output-device-type")))
	    webResourceManager.requireResourcesForContext("ga-resources-mobile");
	else
	    webResourceManager.requireResourcesForContext("ga-resources");
	*/
	return "<div id=\"tracking-code\" style=\"display: none;\">"+uaid+"</div>";	       
    }
    
    @Override
    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }

    private boolean isValidParam(String param) {
	if(param != null)
	    return param.startsWith("UA-");
	return false;
    }
}
