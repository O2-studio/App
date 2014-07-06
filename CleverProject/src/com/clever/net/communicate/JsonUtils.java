package com.clever.net.communicate;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.clever.module.Doc;

/*
 * Use this class to parse all json data from server.
 */
public class JsonUtils {

	public static List<Doc> parseDocs(String recentDocs) {
		// TODO Auto-generated method stub

		List<Doc> docs = new ArrayList<Doc>();
		try {
			JSONObject jsonObject = new JSONObject(recentDocs);
			JSONArray docArray = jsonObject.getJSONArray("docs");

			for (int i = 0; i < docArray.length(); i++) {
				Doc doc = new Doc();
				JSONObject oneDOC = docArray.getJSONObject(i);
				doc.setDocID(Integer.parseInt(oneDOC.getString("id")));
				doc.setContent(oneDOC.getString("content"));
				doc.setVoteDown(Integer.parseInt(oneDOC.getString("downvote")));
				doc.setVoteUp(Integer.parseInt(oneDOC.getString("upvote")));

				// JSONArray tags=oneDOC.getJSONArray("tag_id");
				ArrayList<Integer> tagIDs = new ArrayList<Integer>();
				tagIDs.add(Integer.parseInt(oneDOC.getString("tag_id")));
				doc.setTags(tagIDs);
				//
				// for(int j=0;j<tags.length();j++){
				// tagIDs.add(Integer.parseInt(tags.getJSONObject(j).getString("tag_id")));
				// }
				docs.add(doc);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return docs;
	}

}
