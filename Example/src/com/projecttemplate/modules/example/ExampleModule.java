package com.projecttemplate.modules.example;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.projecttemplate.daos.ExampleDAO;
import com.projecttemplate.model.Goal;
import com.projecttemplate.repository.GoalRepositoryClient;

import se.unlogic.hierarchy.core.annotations.WebPublic;
import se.unlogic.hierarchy.core.beans.SimpleForegroundModuleResponse;
import se.unlogic.hierarchy.core.beans.User;
import se.unlogic.hierarchy.core.interfaces.ForegroundModuleResponse;
import se.unlogic.hierarchy.foregroundmodules.AnnotatedForegroundModule;
import se.unlogic.standardutils.json.JsonArray;
import se.unlogic.standardutils.json.JsonObject;
import se.unlogic.standardutils.xml.XMLUtils;
import se.unlogic.webutils.http.HTTPUtils;
import se.unlogic.webutils.http.RequestUtils;
import se.unlogic.webutils.http.URIParser;

/**
 * Example module to demonstrate the OpenHierarchy ORM. Spring JPA and some ajax requests.
 * 
 * Authored: 2015-07-18
 * @author icytin
 */
public class ExampleModule extends AnnotatedForegroundModule
{
	// TODO: Use this to something.. OH-ish..
	private ExampleDAO ExampleDAO = new ExampleDAO(this.dataSource);
  
	@Override
	public SimpleForegroundModuleResponse defaultMethod(HttpServletRequest req, HttpServletResponse res, User user, URIParser uriParser) throws Exception
	{
		Document doc = XMLUtils.createDomDocument();
		
		Element document = doc.createElement("document");
		doc.appendChild(document);
		document.appendChild(RequestUtils.getRequestInfoAsXML(doc, req, uriParser));
		document.appendChild(moduleDescriptor.toXML(doc));
		document.appendChild(user.toXML(doc));
		return new SimpleForegroundModuleResponse(doc, this.moduleDescriptor.getName(), this.getDefaultBreadcrumb());
	}
	
	@WebPublic
	public ForegroundModuleResponse getSomeData(HttpServletRequest req, HttpServletResponse res, User user, URIParser uriParser) throws IOException {
		
		JsonObject result = new JsonObject();
		StringBuilder stringBuilder = new StringBuilder();

		try {
			
			// Get parameter
			String queryId = req.getParameter("queryId");
			
			// Just an example of using a Spring JPA CRUD..
			String goalType = "3km";
			GoalRepositoryClient client = new GoalRepositoryClient();
			client.initContext();
			Goal g = client.findByType(goalType);
			if(g == null) {
				client.createGoal(goalType, 10);
				g = client.findByType(goalType);
			}
			client.closeContext();

			// Some example result
			JsonArray parametersJsonArray = new JsonArray();
			result.putField("parameters", parametersJsonArray);
			result.putField("success", "1");
			result.putField("queryId", queryId);
			result.putField("goalType", g.getType());
			result.toJson(stringBuilder);
			HTTPUtils.sendReponse(stringBuilder.toString(), "application/json", res);
			
		} catch (Exception ex) {
			// TODO log error
			result.putField("message", "An error occured!");
			result.putField("success", "0");
			result.toJson(stringBuilder);
			HTTPUtils.sendReponse(stringBuilder.toString(), "application/json", res);
		}
		
		return null;
	}
}