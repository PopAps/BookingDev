import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class RoomDao {
	ConnectMongoDB connect;
	MongoDatabase database;
	Document doc;
	MongoCursor<Document> cursor;

	RoomDao() {
		connect = new ConnectMongoDB();
		database = connect.getMongoDatabase();
	}

	ArrayList<Room> getRoomAll(ArrayList<Room> arr2) {
		System.out.println("Dao Process");
		MongoCollection collection = database.getCollection("Booking");
		ArrayList<Room> arr = new ArrayList<>();

		if (!arr2.get(0).size.equals("") && arr2.get(0).date != "" && arr2.get(0).timeEnd.equals("")
				&& arr2.get(0).timeStart.equals("")) {

			doc = new Document("size", arr2.get(0).size).append("date", "Nov 14, 2018");
			cursor = collection.find(doc).iterator();
			try {
				while (cursor.hasNext()) {
					Document a = cursor.next();

					arr.add(new Room((String) a.get("size"), (String) a.get("date"), (String) a.get("timeStart"),
							(String) a.get("timeEnd"), (String) a.get("room"), (String) a.get("status")));
				}
				cursor.close();
			} finally {
				cursor.close();

			}
		} else if (arr2.get(0).size.equals("") && arr2.get(0).date != "" && arr2.get(0).timeEnd.equals("")
				&& arr2.get(0).timeStart.equals("")) {

			doc = new Document("date", arr2.get(0).date);
			cursor = collection.find(doc).iterator();
			try {
				while (cursor.hasNext()) {
					Document a = cursor.next();

					arr.add(new Room((String) a.get("size"), (String) a.get("date"), (String) a.get("timeStart"),
							(String) a.get("timeEnd"), (String) a.get("room"), (String) a.get("status")));
				}
				cursor.close();
			} finally {
				cursor.close();

			}

		} else if (arr2.get(0).equals("") && arr2.get(0).date != "" && arr2.get(0).timeEnd.equals("")
				&& arr2.get(0).timeStart != "") {

			doc = new Document("timeStart", arr2.get(0).timeStart);
			cursor = collection.find(doc).iterator();
			try {
				while (cursor.hasNext()) {
					Document a = cursor.next();

					arr.add(new Room((String) a.get("size"), (String) a.get("date"), (String) a.get("timeStart"),
							(String) a.get("timeEnd"), (String) a.get("room"), (String) a.get("status")));
				}
				cursor.close();
			} finally {
				cursor.close();

			}
		} else if (arr2.get(0).equals("") && arr2.get(0).date != "" && arr2.get(0).timeEnd != ""
				&& arr2.get(0).timeStart.equals("")) {
			System.out.println(arr2.get(0).size);

			doc = new Document("timeEnd", arr2.get(0).timeEnd);
			cursor = collection.find(doc).iterator();
			try {
				while (cursor.hasNext()) {
					Document a = cursor.next();

					arr.add(new Room((String) a.get("size"), (String) a.get("date"), (String) a.get("timeStart"),
							(String) a.get("timeEnd"), (String) a.get("room"), (String) a.get("status")));

				}
				cursor.close();
			} finally {
				cursor.close();

			}

		} else if (arr2.get(0).equals("") && arr2.get(0).date != "" && arr2.get(0).timeEnd != ""
				&& arr2.get(0).timeStart != "") {

			doc = new Document("timeEnd", arr2.get(0).timeEnd).append("timeStart", arr2.get(0).timeStart);
			cursor = collection.find(doc).iterator();
			try {
				while (cursor.hasNext()) {
					Document a = cursor.next();

					arr.add(new Room((String) a.get("size"), (String) a.get("date"), (String) a.get("timeStart"),
							(String) a.get("timeEnd"), (String) a.get("room"), (String) a.get("status")));

				}
				cursor.close();
			} finally {
				cursor.close();

			}
		} else {

			doc = new Document("timeEnd", arr2.get(0).timeEnd).append("timeStart", arr2.get(0).timeStart)
					.append("size", arr2.get(0).size).append("date", arr2.get(0).date);
			cursor = collection.find(doc).iterator();
			try {
				while (cursor.hasNext()) {
					Document a = cursor.next();

					arr.add(new Room((String) a.get("size"), (String) a.get("date"), (String) a.get("timeStart"),
							(String) a.get("timeEnd"), (String) a.get("room"), (String) a.get("status")));

				}
				cursor.close();
			} finally {
				cursor.close();

			}

		}

		return arr;

	}

}