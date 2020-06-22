package cursofullstack.modulo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cursofullstack.modulo5.model.dto.NotasDto;
import cursofullstack.modulo5.model.dao.*;


@Service
public class NotasServiceImpl implements NotasService {
	
	@Autowired
	NotasDao notasDao;

	@Override
	public List<NotasDto> list() {
		return notasDao.list();
	}

	@Override
	public NotasDto get(String alumno) {
		return notasDao.get(alumno);
	}

	@Override
	public int insert(NotasDto notasDto) {
		return notasDao.insert(notasDto);
	}

	@Override
	public int update(NotasDto notasDto) {
		return notasDao.update(notasDto);
	}

	@Override
	public int delete(String idNotas) {
		return notasDao.delete(idNotas);
	}

}
