import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlDump
{
	public List<Auction> parseHtmlDump(String sourceFile)
	{
		List<Auction> items = new ArrayList<Auction>();
		Path filePath = Paths.get(sourceFile);

		try
		{
			byte[] readFile = Files.readAllBytes(filePath);
			String htmlText = new String(readFile);
			htmlText.replaceAll("\n\r", "");
			
			Pattern pattern = Pattern.compile("id=\"item.*?(?=Item:)");
			Matcher match = pattern.matcher(htmlText);
			
			while (match.find())
			{
				items.add(auctionRegex(match.group(0)));
			}
		} 
		catch (IOException e)
		{
			System.err.println("File Not found!");
		}

		return items;
	}
	
	public Auction auctionRegex(String auctionItem)
	{
		String name;
		String description;
		int id;
		double currentBid;
		long endDate;
		int numberOfBids;
		
		//this is to get my item name.
		Pattern patternName = Pattern.compile("alt=\"(.+?)(?=\")");
		Matcher matchName = patternName.matcher(auctionItem);
		
		if(matchName.find())
		{
			name = matchName.group(1);
		}
		else 
		{
			name = "---";
		}
		
		//this is to get my item description.
		Pattern patternDescription = Pattern.compile("(.+?)(?=\")");
		Matcher matchDescription = patternDescription.matcher(auctionItem);
				
		if(matchDescription.find())
		{
			description = matchDescription.group(1);
		}
		else 
		{
			description = "---";
		}
		
		//this is to get my item id;
		Pattern patternId = Pattern.compile("listingid=\"(\\d+)");
		Matcher matchId = patternId.matcher(auctionItem);
		
		if (matchId.find())
		{
			id = Integer.parseInt(matchId.group(1));
		}
		else
		{
			id = 0;
		}
		
		//this is to get my item currentBid;
		Pattern patternCurrentBid = Pattern.compile("$(\\d+,?\\d+?\\.\\d{2})");
		Matcher matchCurrentBid = patternCurrentBid.matcher(auctionItem);
		
		if (matchCurrentBid.find())
		{
			//check if the "," in the current bid will cause trouble in the future.
			currentBid = Double.parseDouble(matchCurrentBid.group(1));
		}
		else
		{
			currentBid = 1;
		}
		
		//this is to get my item numberOfBids;
		Pattern patternNumberOfBids = Pattern.compile("(\\d+) bid");
		Matcher matchNumberOfBids = patternNumberOfBids.matcher(auctionItem);
		
		if (matchNumberOfBids.find())
		{
			numberOfBids = Integer.parseInt(matchNumberOfBids.group(1));
		}
		else
		{
			numberOfBids = 1;
		}
		
		//this is to get my item numberOfBids;
		Pattern patternEndDate = Pattern.compile("timems=\"(\\d+)");
		Matcher matchEndDate = patternEndDate.matcher(auctionItem);
		
		if (matchEndDate.find())
		{
			endDate = Long.parseLong(matchEndDate.group(1));
		}
		else
		{
			endDate = System.currentTimeMillis() + 605000000;
		}
		
		Auction item = new Auction(id, name, currentBid, description);
		item.setNumberofbids(numberOfBids);
		item.setEndDateInMills(endDate);
		
		return item;
	}
}
