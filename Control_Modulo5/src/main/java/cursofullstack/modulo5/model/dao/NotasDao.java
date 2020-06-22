package cursofullstack.modulo5.model.dao;

import java.util.List;

import cursofullstack.modulo5.model.dto.*;

public interface NotasDao {
	
	public List<NotasDto> list();
	public NotasDto get(String idNota);
	public NotasDto getPromedio(String curso);
	public int insert(NotasDto notasDto);
	public int update(NotasDto notasDto);
	public int delete(String idNota);

}
