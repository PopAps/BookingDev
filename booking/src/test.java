import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class test {
	static ConnectMongoDB connect;
	static MongoDatabase database;
	static Document doc;
	static MongoCursor<Document> cursor;
//	public static void main(String[] args) {
//		
//		connect = new ConnectMongoDB();
//		database = connect.getMongoDatabase();
//		MongoCollection collection = database.getCollection("Booking");
//		ArrayList<Room> arr = new ArrayList<>();
//	
//		
//			
//			doc = new Document("size","50");
//			cursor = collection.find(doc).iterator();
//			try {
//				while (cursor.hasNext()) {
//					Document a = cursor.next();
//
//			System.out.println(a.get("size").toString());
//				}cursor.close();
//			} finally {
//				cursor.close();
//
//			}
//	}

}
