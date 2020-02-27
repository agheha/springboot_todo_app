package mini.mani.mo.MySpringApp;

import java.util.List;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public abstract class ApiResponse<T> {
	private T data;
	private List<String> errors;
	/*
	 * 모든 Response에 공통으로 에러메레지 리스트가 들어있어야한다.
	 * 때문에 위처럼 T data엔 어떠한 모델이던 들어올 수 있도록,
	 * 그리고 리스폰스마다 에러를 가지고 있을 수 있도록 한다.
	 */
	
}
