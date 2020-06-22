package cursofullstack.modulo5.service;

import java.util.List;
import cursofullstack.modulo5.model.dto.NotasDto;;


public interface NotasService {
	
	public List<NotasDto> list();
	public NotasDto get(String alumno);
	public int insert(NotasDto notasDto);
	public int update(NotasDto notasDto);
	public int delete(String idNotas);

}
