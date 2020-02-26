// ToDoItem을 ToDoItemResponse로 바꾸어 준다.
package mini.mani.mo.MySpringApp;

import java.util.List;

public class ToDoItemAdapter {
	public static ToDoItemResponse toDoItemResponse(final ToDoItem toDoItem, final List<String> errors) {
		return ToDoItemResponse.builder().toDoItem(toDoItem).errors(errors).build();
	}
	
	public static ToDoItem toDoItem(final ToDoItemRequest toDoItemRequest) {
		if (toDoItemRequest == null) {
			return null;
		}
		
		return ToDoItem.builder()
				.title(toDoItemRequest.getTitle())
				.done(toDoItemRequest.isDone())
				.build();
	}
}
