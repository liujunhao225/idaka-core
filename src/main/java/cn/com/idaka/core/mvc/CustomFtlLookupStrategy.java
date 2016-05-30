package cn.com.idaka.core.mvc;

import java.io.IOException;

import freemarker.cache.TemplateLookupContext;
import freemarker.cache.TemplateLookupResult;
import freemarker.cache.TemplateLookupStrategy;

public class CustomFtlLookupStrategy extends TemplateLookupStrategy {

	@Override
	public TemplateLookupResult lookup(TemplateLookupContext ctx) throws IOException {
		TemplateLookupResult result = ctx.lookupWithLocalizedThenAcquisitionStrategy(ctx.getTemplateName(), ctx.getTemplateLocale());
		if (result.isPositive())
			return result;

		String templateName = ctx.getTemplateName();
		if (templateName.startsWith("user/")){
			int i = templateName.indexOf("/", 5);
			if (i >= 0){
				templateName = templateName.substring(i+1);
				return ctx.lookupWithLocalizedThenAcquisitionStrategy(templateName, ctx.getTemplateLocale());
			}
		}
		
		return result;
	}

}