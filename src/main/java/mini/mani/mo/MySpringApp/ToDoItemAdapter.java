// ToDoItem을 ToDoItemResponse로 바꾸어 준다.
package mini.mani.mo.MySpringApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoItemAdapter {

    public static ToDoItem toToDoItem(final ToDoItemRequest toDoItemRequest) {
        if(toDoItemRequest == null) {
            return null;
        }
        return ToDoItem.builder()
                .title(toDoItemRequest.getTitle())
                .done(toDoItemRequest.isDone())
                .build();
    }

    public static ToDoItemResponse toToDoItemResponse(final ToDoItem toDoItem, final List<String> errors) {
        return ToDoItemResponse.builder()
                .toDoItem(toDoItem)
                .errors(Optional.ofNullable(errors).orElse(new ArrayList<>()))
                .build();
    }
}
