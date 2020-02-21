package mini.mani.mo.MySpringApp;

import org.springframework.data.mongodb.repository.MongoRepository;

															/* <Model, ID> 레파지토리가 표현해야하는 모델, 이 모델을 구별할 수 있는 ID*/
public interface ToDoItemRepository extends MongoRepository<ToDoItem, String> {
	
}


