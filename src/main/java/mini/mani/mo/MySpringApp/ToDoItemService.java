package mini.mani.mo.MySpringApp;

import mini.mani.mo.MySpringApp.ToDoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {
	public ToDoItem get(final String id) {
		
		return ToDoItem.builder()
				.title("Add an id validation")
				.build();
	}
}
