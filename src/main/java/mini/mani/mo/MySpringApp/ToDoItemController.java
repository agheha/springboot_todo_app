package mini.mani.mo.MySpringApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  // springboot에게 RESTful API임을 알려준다.
@RequestMapping("/todo") // 이 컨트롤러의 공통 url (+메서드)
public class ToDoItemController {

	@Autowired
	private ToDoItemService toDoItemService;
	
	 			/* RESTful API의 4가지 메서드 중 GET 선택 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")// 여기서id는 밑의 @PathVariable value와 같아야한다.
	public @ResponseBody ToDoItemResponse get(@PathVariable(value="id")String id) {
		List<String> errors = new ArrayList<>();
		ToDoItem toDoItem = null;
		try {
			toDoItem = toDoItemService.get(id);
		} catch (final Exception e) {
			errors.add(e.getMessage());
			
		}
		
		return ToDoItemAdapter.toDoItemResponse(toDoItem, errors);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ToDoItemResponse> getAll() {
		List<String> errors = new ArrayList<>();
		List<ToDoItem> toDoItems = toDoItemService.getAll();
		List<ToDoItemResponse> toDoItemResponses = new ArrayList<>();
		toDoItems.stream().forEach(toDoItem -> {
			
			toDoItemResponses.add(ToDoItemAdapter.toDoItemResponse(toDoItem, errors));
		});
		return toDoItemResponses;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ToDoItemResponse create(@RequestBody final ToDoItemRequest toDoItemRequest) {
		List<String> errors = new ArrayList<>();
		ToDoItem toDoItem = ToDoItemAdapter.toDoItem(toDoItemRequest);
		
		try {
			toDoItem = toDoItemService.create(toDoItem);
		
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		
		return ToDoItemAdapter.toDoItemResponse(toDoItem, errors);
	}
}
