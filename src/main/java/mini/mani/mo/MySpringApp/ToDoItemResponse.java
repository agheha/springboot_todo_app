package mini.mani.mo.MySpringApp;

import mini.mani.mo.MySpringApp.ApiResponse;
import java.util.List;
import lombok.Builder;

public class ToDoItemResponse extends ApiResponse<ToDoItem> {

	@Builder
    public ToDoItemResponse(final ToDoItem toDoItem, final List<String> errors) {
		super(toDoItem);
		this.setErrors(errors);
    }

}


