package jSoupParser;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jSoupHTMLToString {
	public String ActivationURL(String HTMLEmailContent){
		//Jsoup to read html files and find elements of that HTML file (i.e Selenium Test Cases)
				//Reference: https://jsoup.org/cookbook/extracting-data/dom-navigation
				String activationURL = null;
				try{
						
						Document EMailContent = Jsoup.parse(HTMLEmailContent);//parse string to HTML
						Elements links = EMailContent.getElementsByTag("a");
											
						for (Element link : links) {
							String linkHref = link.attr("href");
							String linkText = link.text();
							  //System.out.println("linkHref:"+linkHref);
							  //System.out.println("linkText:"+linkText);
							  activationURL=linkHref;
							  
							}
						
						
				}
				catch(NullPointerException e){
					System.out.println("NO Data in HTML file!!!!!");
				}
				return activationURL;		
		
	}

}
